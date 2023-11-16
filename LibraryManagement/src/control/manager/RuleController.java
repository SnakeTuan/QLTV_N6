/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control.manager;

import control.librarian.BookLoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.database.Connect;
import model.database.Rule;

/**
 *
 * @author TRINH
 */
public class RuleController {
    
    public int insertRule(Rule rule) {
        
        try (
            Connection con = Connect.GetConnect();
            PreparedStatement rs = con.prepareStatement("INSERT INTO loan_rule (id, max_day, max_book, overdue_fine, damage_fine, date_start) VALUES(?, ?, ?, ?, ?, ?)")) {
            rs.setInt(1, rule.getMaQuyDinh());
			rs.setInt(2, rule.getSoNgayMuonToiDa());
            rs.setInt(3, rule.getSoSachMuonToiDa());
            rs.setInt(4, rule.getTienPhatQuaHan());
            rs.setInt(5, rule.getTienPhatHongMat());
            rs.setString(6, rule.getNgayThayDoi());
            rs.executeUpdate();
            rs.close();
            con.close();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(BookLoan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public Rule searchRule(String date) {
        String query = "select top 1 * from loan_rule where date_start <= ? order by id desc";
        Rule rule = null;
        try {
            Connection con = Connect.GetConnect();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, date);
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
}
