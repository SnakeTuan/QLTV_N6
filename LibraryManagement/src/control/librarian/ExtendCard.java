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
	
    public boolean ExtendByMonth (String username, int month)
    {
        String expirationDate;
        String amountMoney;
        String query1 = "EXEC SP_GetExpirationDate " + username + ", null, " + view.login.LoginFrame.branch_id;
        String query2 = "EXEC SP_GetAmountMoneyByMonth " + month;
        String dateCheck = getCurrentDate();
		
        Connection conn = Connect.GetConnect();
        PreparedStatement ps;
        ResultSet rs;
        //get the expiration month of that user
        try {
            ps = conn.prepareStatement(query1);
            rs =ps.executeQuery();
            rs.next();
            expirationDate = rs.getString(1);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
			try {
				Date expiration_date = sdf.parse(expirationDate);
				Date date_check = sdf.parse(dateCheck);
				if(expiration_date.before(date_check)){
					expiration_date = date_check;
					expirationDate = expiration_date.toString();
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
            amountMoney = rs.getString(1);
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
            String query3 = "EXEC SP_AddExtension " + amountMoney + ", '" + expirationDate + "', " + username + ", null";
            CallableStatement stmt = conn.prepareCall(query3);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hãy thử lại sau một lúc", "Gia hạn thất bại", JOptionPane.WARNING_MESSAGE);
            System.out.println("something wrong in insert period" + e.getMessage());
            return false;
        }
        
        try {
            String query4 = "EXEC SP_GetExpirationDate " + username + ", null, " + view.login.LoginFrame.branch_id;
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
