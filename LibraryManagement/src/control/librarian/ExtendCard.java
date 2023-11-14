/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.librarian;

import java.sql.Connection;
import model.database.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ExtendCard {
    public static ExtendCard Instance = new ExtendCard();
    
	private String getCurrentDate() {
		// Lấy ngày hiện tại
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(calendar.getTime());
	}
	
    private String generateNewExID(int nextNumber) {
		nextNumber++;
        // Ghép phần số vào mã mới
		String s = view.login.LoginFrame.branch_id + "E";
        return s + String.format("%03d", nextNumber);
    }
	
    private String getCurrentID_extension(Connection connection) throws SQLException {
        // Truy vấn cơ sở dữ liệu để lấy mã tăng dần hiện tại
        String query = "SELECT MAX(id) AS maxID FROM extension WHERE branch_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, view.login.LoginFrame.branch_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        String currentID = view.login.LoginFrame.branch_id + "E000"; // Giá trị mặc định nếu chưa có dữ liệu trong bảng
        
        while (resultSet.next()) {
            String maxID = resultSet.getString("maxID");
            if (maxID != null) {
                currentID = maxID;
            }
        }
        
        preparedStatement.close();
        resultSet.close();
        
        return currentID;
    }
	
    String getID(String name){  
        Connection ketNoi= Connect.GetConnect();
        try {
            PreparedStatement ps=ketNoi.prepareStatement("select id from account where account_username = ?");
            ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
            while(rs.next()){
				return rs.getString(1);
            }
            ps.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException ex) {
            System.out.println("loi lay account_id");
        }
		return "";
    }
	
    private int getNumber(String currentID) {
        // Tách phần số từ mã hiện tại
        String numberPart = currentID.substring(currentID.length() - 3);
        return Integer.parseInt(numberPart);
    }
		

    public boolean ExtendByMonth (String username, int month)
    {
        Connection conn = Connect.GetConnect();
        PreparedStatement ps;
        ResultSet rs;
		
		
		String branch_id = view.login.LoginFrame.branch_id;
		String account_id = getID(username);
		String extension_id = "";
		try {
			extension_id = getCurrentID_extension(conn);
		} catch (SQLException ex) {
			Logger.getLogger(ExtendCard.class.getName()).log(Level.SEVERE, null, ex);
		}
		int new_num = getNumber(extension_id);
		String new_ex_id = generateNewExID(new_num);
		System.out.println("New extension_id: " + new_ex_id);		
		
        String expirationDate;
		Date expiration_date = null;
        int amountMoney;
        String query1 = "EXEC SP_GetExpirationDate " + account_id + ", null, " + view.login.LoginFrame.branch_id;
        String query2 = "EXEC SP_GetAmountMoneyByMonth " + month;
        String dateCheck = getCurrentDate();
		
        //get the expiration month of that user
        try {
            ps = conn.prepareStatement(query1);
            rs =ps.executeQuery();
            rs.next();
            expirationDate = rs.getString(1);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
			try {
				expiration_date = sdf.parse(expirationDate);
				Date date_check = sdf.parse(dateCheck);
				if(expiration_date.before(date_check)){
					expiration_date = date_check;
					expirationDate = sdf.format(date_check);
				}
			} catch (ParseException ex) {
				Logger.getLogger(ExtendCard.class.getName()).log(Level.SEVERE, null, ex);
			}
            
			System.out.println("ExpirationDate: " + expirationDate);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hãy kiểm tra lại tài khoản", "Lỗi username", JOptionPane.WARNING_MESSAGE);
            System.out.println("Username not correct 1: " + e.getMessage());
            return false;
        }
        
        //caculate the Amount of money
        try {
            ps = conn.prepareStatement(query2);
            rs =ps.executeQuery();
            rs.next();
            amountMoney = rs.getInt(1);
			System.out.println("AmountMoney: " + amountMoney);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hãy kiểm tra lại số lượng tháng", "Lỗi tháng", JOptionPane.WARNING_MESSAGE);
            System.out.println("month amount not correct" + e.getMessage());
            return false;
        }
        
        
//        if (username == "" || amountMoney == "") 
//        {
//            System.out.println("null");
//            return false;
//        }
        
        //create a extension of that user
		
        try {
			String query3 = "EXEC SP_AddExtension ?, ?, ?, null, ?, null, ?";
            CallableStatement stmt = conn.prepareCall(query3);
			stmt.setString(1, new_ex_id);
			stmt.setString(2, branch_id);
			stmt.setString(3, account_id);
			stmt.setInt(4, amountMoney);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(expiration_date);
			calendar.add(Calendar.MONTH, month);		
			java.sql.Date sqlDate = java.sql.Date.valueOf(calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			
			stmt.setDate(5, (java.sql.Date) sqlDate);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hãy thử lại sau một lúc", "Gia hạn thất bại", JOptionPane.WARNING_MESSAGE);
            System.out.println("something wrong in insert period: " + e.getMessage());
            return false;
        }
        
        try {
            String query4 = "EXEC SP_GetExpirationDate " + account_id + ", null, " + view.login.LoginFrame.branch_id;
            ps = conn.prepareStatement(query4);
            rs =ps.executeQuery();
            rs.next();
            expirationDate = rs.getString(1);
            
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hãy thử lại sau một lúc", "Thất bại", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
            return false;
        }
        
        JOptionPane.showMessageDialog(null, "Gia hạn đến " + expirationDate + " thành công", "Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public int CurrentPrice()
    {
        int price = 0;
        String query = "select top(1) per_month from extension_price order by date_start desc";
        
        Connection conn = Connect.GetConnect();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            rs.next();
            price = Integer.parseInt(rs.getString(1));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Giá vé hiện tại chưa có", "Lỗi lấy giá vé", JOptionPane.WARNING_MESSAGE);
            System.out.println("Username not correct 2: " + e.getMessage());
            return 0;
        }
        
        return price;
    }
	
    public Date GetExpirationDate (String id, String extension_id, String branch_id)
    {
        Date expirationDate;
        String query = "EXEC SP_GetExpirationDate ?, ?, ?";
        
        Connection conn = Connect.GetConnect();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, extension_id);
			ps.setString(3, branch_id);
            rs = ps.executeQuery();
            rs.next();
            expirationDate = rs.getDate(1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hãy kiểm tra lại tài khoản", "Lỗi username", JOptionPane.WARNING_MESSAGE);
            System.out.println("Username not correct 3: " + e.getMessage());
            return null;
        }
        System.out.println(expirationDate);
        return expirationDate;
    }
}
