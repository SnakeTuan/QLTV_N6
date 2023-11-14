/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control.librarian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.database.Connect;
import model.database.Reader;
import model.database.Rule;

/**
 *
 * @author TRINH
 */
public class BookLoan {
    
    public void loadReader(DefaultTableModel model){
        
        model.setNumRows(0);
        Connection ketNoi= Connect.GetConnect();
        Vector vt;
        try {
            PreparedStatement ps = ketNoi.prepareStatement("select id, account_name, gender, date_of_birth, account_address, phone, email, registered_date from account where account_role_id = 1 and account_status = 1 and branch_id = ?");
            ps.setString(1, view.login.LoginFrame.branch_id);
			ResultSet rs=ps.executeQuery();
            while(rs.next()){
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(rs.getDate(4));
                vt.add(rs.getString(5));
                vt.add(rs.getString(6));
                vt.add(rs.getString(7));
                vt.add(rs.getString(8));
                model.addRow(vt);
            }
            ps.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException ex) {
            System.out.println("Lỗi load reader");
        }   
    }    
    
    public void loadBookList(DefaultTableModel model){
        
        model.setNumRows(0);
        Connection ketNoi= Connect.GetConnect();
        Vector vt;
        try {
	
            PreparedStatement ps = ketNoi.prepareStatement("select b.id, b.title, b.Author, b.published_year, c.category_name, b.current_copies from book b inner join category c on b.category_id = c.id where branch_id = ?");
            ps.setString(1, view.login.LoginFrame.branch_id);
			ResultSet rs=ps.executeQuery();
            while(rs.next()){
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(rs.getString(4));
                vt.add(rs.getString(5));
                vt.add(rs.getString(6));
                model.addRow(vt);
            }
            ps.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException ex) {
            System.out.println("Lỗi load reader");
        }   
    }    
    
    public void loadBookBorrowed(Map<String, Vector> mapBookBorrewed, DefaultTableModel model, String username){
        
        model.setNumRows(0);
        Connection ketNoi= Connect.GetConnect();
        Vector vt;
        try {
            PreparedStatement ps = ketNoi.prepareStatement("select b.id, b.title, b.Author, c.category_name, l.date_start from loan l inner join loan_detail ld on l.id = ld.loan_id inner join book b on b.id = ld.book_id inner join category c on b.category_id = c.id where ld.detail_status = 0 and l.account_id = ?");
            ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			int cnt = 1;
            while(rs.next()){
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(rs.getString(4));
                vt.add(rs.getString(5));
                model.addRow(vt);
                mapBookBorrewed.put(rs.getString(1), vt);
				System.out.println("load xong sach " + rs.getString(1));
				cnt++;
            }
            ps.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException ex) {
            System.out.println("Lỗi load Book Borrowed");
        } 
    }    
    
    public void loadLoanList(DefaultTableModel model){
        
        model.setNumRows(0);
        Connection ketNoi= Connect.GetConnect();
        Vector vt;
        try {
            PreparedStatement ps = ketNoi.prepareStatement("select l.loan_id, a.Full_Name, a.phone_number, l.date_start, DATEADD(day, r.max_rental_day, l.date_start), l.rule_id\n" +
                                                            "from loan l\n" +
                                                            "inner join account a\n" +
                                                            "on l.user_id = a.username\n" +
                                                            "inner join [rule] r\n" +
                                                            "on l.rule_id = r.rule_id\n" +
                                                            "order by l.loan_id desc");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(rs.getString(4));
                vt.add(rs.getString(5));
                vt.add(rs.getString(6));
                model.addRow(vt);
            }
            ps.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException ex) {
            System.out.println("Lỗi load Loan List");
        } 
    }    
    
    public void loadLoanDetail(DefaultTableModel model, String loanID){
        
        model.setNumRows(0);
        Connection ketNoi= Connect.GetConnect();
        Vector vt;
        int status = 0;
        try {
            PreparedStatement ps = ketNoi.prepareStatement("select dt.loan_id, b.title, a.name, dt.date_end, dt.status\n" +
                                                            "from loan_detail dt\n" +
                                                            "inner join book b\n" +
                                                            "on dt.book_id = b.book_id\n" +
                                                            "inner join author a\n" +
                                                            "on b.author_id = a.author_id\n" +
                                                            "where dt.loan_id = " + loanID);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(rs.getString(4));
                status = rs.getInt(5);
                /*
                    Status 0: đang mượn chưa trả
                    Status 1: đã trả, không trễ, không làm hỏng/mất
                    Status 2: đã trả, trả trễ, không làm hỏng/mất
                    Status 3: đã trả, không trễ, làm hỏng/mất
                    Status 4: đã trả, trả trễ, làm hỏng/mất
                */
                if(status == 0)
                    vt.add("Đang mượn");
                else if(status == 1)
                    vt.add("Đã trả");
                else if(status == 2)
                    vt.add("Trễ hạn");
                else if(status == 3)
                    vt.add("Hỏng/mất");
                else
                    vt.add("Trễ hạn, hỏng/mất");
                model.addRow(vt);
            }
            ps.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException ex) {
            System.out.println("Lỗi load Loan List");
        } 
    }    
    
    public boolean findChosenBook(DefaultTableModel model, String id) {
        int size = model.getRowCount();
        for(int i = 0; i < size; i++) {
            if (model.getValueAt(i,0).toString().equals(id))
                return true;
        }
        return false;
    }
    
    public boolean findBorrowedBook(String username, String bookID) {
        String query =  "select * from loan l inner join loan_detail ld on l.id = ld.loan_id where l.account_id = ? and ld.detail_status = ? and ld.book_id = ?";
        try {
            Connection conn = Connect.GetConnect();
            PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setInt(2, 0);
			ps.setString(3, bookID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {                
                return true;                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private String getCurrentLoan(Connection connection) throws SQLException {
        // Truy vấn cơ sở dữ liệu để lấy mã tăng dần hiện tại
        String query = "SELECT MAX(id) AS maxID FROM loan WHERE branch_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, view.login.LoginFrame.branch_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        String currentID = view.login.LoginFrame.branch_id + "L000"; // Giá trị mặc định nếu chưa có dữ liệu trong bảng
        
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

    private int getNumber(String currentID) {
        // Tách phần số từ mã hiện tại
        String numberPart = currentID.substring(currentID.length() - 3);
        return Integer.parseInt(numberPart);
    }

    private String generateNewID(int nextNumber) {
		nextNumber++;
        // Ghép phần số vào mã mới
		String s = view.login.LoginFrame.branch_id + "L";
        return s + String.format("%03d", nextNumber);
    }
	
    public void insertLoan(String username) {
		Connection con = Connect.GetConnect();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String ngayMuon = dateFormatter.format(new java.util.Date());
        int ruleID = getCurrentRule().getMaQuyDinh();
		
		String current_id = "";
		try {
			current_id = getCurrentLoan(con);
		} catch (SQLException ex) {
			Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		int new_num = getNumber(current_id);
		String new_id = generateNewID(new_num);
		
        try (
            PreparedStatement rs = con.prepareStatement("INSERT INTO LOAN (id, branch_id, account_id, loan_rule_id, date_start) VALUES(?, ?, ?, ?, ?)")) {
			rs.setString(1, new_id);
			rs.setString(2, view.login.LoginFrame.branch_id);
            rs.setString(3, username);
            rs.setString(5, ngayMuon);
            rs.setInt(4, ruleID);
            rs.executeUpdate();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getCurrentBorrow() {
        String query =  "select top 1 * from loan order by id desc";
        String loanID = "";
        try {
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                loanID = rs.getString(1);
            }
            rs.close();
            ps.close();
            con.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loanID;
    }
    
    public void updateBookQuantity(DefaultTableModel modelChosenBook) {
        
        int size = modelChosenBook.getRowCount();
        for (int i = 0; i < size; i++) {
            try {
                Connection con = Connect.GetConnect();
                PreparedStatement rs = con.prepareStatement("UPDATE BOOK SET current_copies = current_copies - 1 WHERE id = ?");
                rs.setString(1, modelChosenBook.getValueAt(i,0).toString());
                rs.executeUpdate();
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }          
    }
    
    public void updateBookQuantity1(DefaultTableModel modelChosenBook) {
        
        int size = modelChosenBook.getRowCount();
        for (int i = 0; i < size; i++) {
            
			System.out.println("Trạng thái: " + Integer.parseInt(modelChosenBook.getValueAt(i,4).toString()));
			
            if(Integer.parseInt(modelChosenBook.getValueAt(i,4).toString()) != 0)
                continue;
            
            try {
                Connection con = Connect.GetConnect();
                PreparedStatement rs = con.prepareStatement("UPDATE BOOK SET current_copies = current_copies + 1 WHERE id = ?");
                rs.setString(1, modelChosenBook.getValueAt(i,0).toString());
                rs.executeUpdate();
                rs.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }          
    }
    
    private String getCurrentLoan_detail(Connection connection ,String loan_ID) throws SQLException {
        String loan_part = loan_ID.substring(loan_ID.length() - 4);
		
		String query = "SELECT MAX(id) AS maxID FROM loan_detail WHERE loan_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, loan_ID);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		String loan_detail_id = loan_part + "D000";
		
		while (resultSet.next()){
			String maxID = resultSet.getString("maxID");
			if (maxID != null) {
                loan_detail_id = maxID;
            }
		}
		
        System.out.println("old_loan_detail_id: " + loan_detail_id);
		
		preparedStatement.close();
        resultSet.close();
        return loan_detail_id;
    }

    private String generateNewLoanDetailID(int nextNumber, String loan_ID) {
		nextNumber++;
        String loan_part = loan_ID.substring(loan_ID.length() - 4);
		String s = loan_part + "D";
        return s + String.format("%03d", nextNumber);
    }
	
    public void borrowBook(String username, DefaultTableModel modelChosenBook) {
        insertLoan(username);
        String loanID = getCurrentBorrow();
        String query;
        int size = modelChosenBook.getRowCount();
        for (int i = 0; i < size; i++) {
            try {
                Connection con = Connect.GetConnect();
				String old_LD_ID = getCurrentLoan_detail(con, loanID);
				int new_num = getNumber(old_LD_ID);
				String new_ld_id = generateNewLoanDetailID(new_num, loanID);
				System.out.println("new_loan_detail_id: " + new_ld_id);
                PreparedStatement rs = con.prepareStatement("INSERT INTO LOAN_DETAIL (id, loan_id, book_id, date_end, detail_status) VALUES(?, ?, ?, ?, ?)");
				Rule loan_rule = getCurrentRule();
				
				java.util.Date currentDate = new java.util.Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(currentDate);
				calendar.add(Calendar.DAY_OF_MONTH, loan_rule.getSoNgayMuonToiDa());
				java.util.Date endDate = calendar.getTime();
				java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
				
                rs.setString(1, new_ld_id);
				rs.setString(2, loanID);
                rs.setString(3, modelChosenBook.getValueAt(i,0).toString());
				rs.setDate(4, sqlEndDate);
                rs.setInt(5, 0);
                rs.executeUpdate();
                rs.close();
                con.close();
				System.out.println("done insert new_loan_detail_id");
            } catch (SQLException ex) {
                Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        updateBookQuantity(modelChosenBook);
    }
    
	private String getLoanID(String account_id, String book_id){
		String query = "select l.id from loan l inner join loan_detail ld on l.id = ld.loan_id where l.account_id = ? and ld.detail_status = 0 and ld.book_id = ?";
		try {
			Connection con = Connect.GetConnect();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, account_id);
			ps.setString(2, book_id);
		} catch (SQLException ex) {
			Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
		}
		return "";
	}
	
    public void returnBook(String username, DefaultTableModel modelChosenBook) {
        String pre_query = "select l.id from loan l inner join loan_detail ld on l.id = ld.loan_id where l.account_id = ? and ld.detail_status = 0 and ld.book_id = ?";
		String query = "update loan_detail set detail_status = ?, date_end = GETDATE() where detail_status = 0 and book_id = ? and loan_id = ?";
        int size = modelChosenBook.getRowCount();
        String bookID = "";
        int overDueFines = 0;
        int brokenLostFines = 0;
		int status = 0;
		String loan_id = "";
		
        for (int i = 0; i < size; i++) {
            bookID = modelChosenBook.getValueAt(i,0).toString();
            overDueFines = Integer.parseInt(modelChosenBook.getValueAt(i,3).toString());
            brokenLostFines = Integer.parseInt(modelChosenBook.getValueAt(i,4).toString());
			System.out.println("TEST1: " + username);
			System.out.println("TEST2: " + bookID);
            try {
                Connection con = Connect.GetConnect();
				PreparedStatement pre_ps = con.prepareStatement(pre_query);
				pre_ps.setString(1, username);
				pre_ps.setString(2, bookID);
				ResultSet pre_rs = pre_ps.executeQuery();
				pre_rs.next();
				loan_id = pre_rs.getString(1);
				System.out.println("Loan_id: " + loan_id);
				
                PreparedStatement ps = con.prepareStatement(query);
                /*
                    Status 0: đang mượn chưa trả
                    Status 1: đã trả, không trễ, không làm hỏng/mất
                    Status 2: đã trả, trả trễ, không làm hỏng/mất
                    Status 3: đã trả, không trễ, làm hỏng/mất
                    Status 4: đã trả, trả trễ, làm hỏng/mất
                */
                if(brokenLostFines != 0 && overDueFines != 0){
					status = 4;
					System.out.println("đã trả, trả trễ, làm hỏng/mất");
                    ps.setInt(1, status);
				}
                else if(brokenLostFines != 0 && overDueFines == 0){
					status = 3;
                    System.out.println("đã trả, không trễ, làm hỏng/mất");
					ps.setInt(1, status);
				}
                else if(brokenLostFines == 0 && overDueFines != 0){
					status = 2;
                    System.out.println("đã trả, trả trễ, không làm hỏng/mất");
					ps.setInt(1, status);
				}
				else{
					status = 1;
					System.out.println("đã trả, không trễ, không làm hỏng/mất");
                    ps.setInt(1, status);
				}
                ps.setString(2, bookID);
                ps.setString(3, loan_id);
                ps.executeUpdate();
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        updateBookQuantity1(modelChosenBook);
    }
    
    public boolean expiredUser(String username){
        LocalDate today = LocalDate.now();
        String query = "EXEC SP_GetExpirationDate " + username + ", null, " + view.login.LoginFrame.branch_id;
        try {
            Connection conn = Connect.GetConnect();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Calculate days between today and ngayHetHan
                LocalDate ngayHetHan = LocalDate.parse(rs.getString(1));
                Duration diff = Duration.between(ngayHetHan.atStartOfDay(), today.atStartOfDay());
                long diffDays = diff.toDays();

                if (diffDays > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int numberOfBooksBorrowing(String username) {
        String query = "select count(*) from loan_detail ldt inner join loan l on ldt.loan_id = l.id and ldt.detail_status = 0 and l.account_id = '" + username + "'";
        try (
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public Rule getCurrentRule() {
        String query = "select top(1) * FROM loan_rule ORDER BY id DESC";
        Rule rule = null;
        try {
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rule = new Rule(rs.getInt(1), rs.getInt(4), rs.getInt(5), rs.getInt(2), rs.getInt(3), rs.getString(6));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rule;
    }
    
    public int getOverdueFines(String username, String bookID) {
        String query = "select ld.date_end, r.overdue_fine from loan l inner join loan_rule r on l.loan_rule_id = r.id inner join loan_detail ld on l.id = ld.loan_id where ld.detail_status = 0 and l.account_id = ? and ld.book_id = ?";
        int overDueFines = 0;
        String date = null;
        try {
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, bookID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                date = rs.getString(1);
                overDueFines = rs.getInt(2);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        // Calculate days between today and hanTra
        LocalDate today = LocalDate.now();
        LocalDate hanTra = LocalDate.parse(date);
        Duration diff = Duration.between(hanTra.atStartOfDay(), today.atStartOfDay());
        long diffDays = diff.toDays();
        System.out.println("Số ngày trễ hạn: " + diffDays);
        
        // Check if the book is returned late or not
        if (diffDays <= 0) {
            return 0;
        }
        else {
            return (int) (overDueFines * diffDays);
        }
    }
       
    public int getBrokenLostFines(String username, String bookID) {
        String query = "select b.price, r.damage_fine from loan l inner join loan_rule r on l.loan_rule_id = r.id inner join loan_detail ld on l.id = ld.loan_id inner join book b on ld.book_id = b.id where ld.detail_status = 0 and l.account_id = ? and ld.book_id = ?";
        int brokenlost = 0;
        int price = 0;
        try {
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, bookID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                price = rs.getInt(1);
                brokenlost = rs.getInt(2);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        // Calculate fines for loss/broke book
        int fines = price * brokenlost / 100;
        return fines;
    }
    
    public boolean expiredBook(String username, int soNgayMuonToiDa) {
        String query = "select * from loan_detail ldt inner join loan l on ldt.loan_id = l.id and ldt.detail_status = 0 and l.account_id = '" + username + "'";
        LocalDate today = LocalDate.now();
        try (
                Connection con = Connect.GetConnect();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                // Calculate days between today and hanTra
                LocalDate date_start = LocalDate.parse(rs.getString("date_start"));
                Duration diff = Duration.between(date_start.atStartOfDay(), today.atStartOfDay());
                long diffDays = diff.toDays();
                System.out.println(diffDays);
                if (diffDays > soNgayMuonToiDa) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
	public String get_expired_date (String account_id){
		try {
			Connection conn = Connect.GetConnect();
			PreparedStatement ps;
			ResultSet rs;
			String query4 = "EXEC SP_GetExpirationDate " + account_id + ", null, " + view.login.LoginFrame.branch_id;
			ps = conn.prepareStatement(query4);
			rs =ps.executeQuery();
			rs.next();
			return rs.getString(1);
		} catch (SQLException ex) {
			System.out.println("Lỗi lấy expiration_date");
			Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
		}
		return "";
	}
	
    public Reader getReaderInformation(String username) {
        String query = "select id, account_name, gender, date_of_birth, account_address, phone, email, registered_date from account where id = '" + username + "'";
        Reader reader = null;
		String expiration_date = get_expired_date(username);
        try {
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                reader = new Reader(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), "");
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reader;
    }
}
