/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.database.Connect;
import org.mindrot.bcrypt.BCrypt;
import view.main.admin.AdminMainFrame;
import view.main.archivist.ArchivistMainFrame;
import view.main.librarian.LibrarianMainFrame;
import view.main.reader.ReaderMainFrame;

/**
 *
 * @author Admin
 */
public class LoginFrame extends javax.swing.JFrame {
    
    private RecoveryPasswordDialog recoveryPasswordDialog;
    private RuleLibraryDialog ruleLibraryDialog;
    private BookDialog bookDialog;
    private AdminMainFrame adminMainFrame;
    private ArchivistMainFrame archivistMainFrame;
    private LibrarianMainFrame librarianMainFrame;
    private ReaderMainFrame readerMainFrame;
    
    
    private boolean showPass = false;
    public static String OTPSystem;
	public static String account_id;
	public static String branch_id;
	public static String tmp;
	public static String branch_name;
    public static String PhoneNumber;
    public static String Email;
    public static String username;
    public static String name;
    private String password;
    private int Idrole; 
    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
        setLocationRelativeTo(null);
        jLabel_i.setToolTipText("Thông tin thư viện");
        OTPSystem = "";
        PhoneNumber = "";
        Email = "";
        username = "";
		
		setBranchComboBoxValues();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel_HideShow = new javax.swing.JLabel();
        jPasswordField_Pass = new javax.swing.JPasswordField();
        jButton_Login = new javax.swing.JButton();
        jButton_Forgot = new javax.swing.JButton();
        jButton_WithoutLogin = new javax.swing.JButton();
        jLabel_i = new javax.swing.JLabel();
        jComboBox_branch = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign In");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/library.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel2.setText("Library Management Program");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Username:");

        jTextField_Username.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Password:");

        jLabel_HideShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hide.png"))); // NOI18N
        jLabel_HideShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_HideShowMouseClicked(evt);
            }
        });

        jPasswordField_Pass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_Username, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(jPasswordField_Pass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_HideShow, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPasswordField_Pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_HideShow, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton_Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/signin.png"))); // NOI18N
        jButton_Login.setContentAreaFilled(false);
        jButton_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LoginActionPerformed(evt);
            }
        });

        jButton_Forgot.setBackground(new java.awt.Color(255, 255, 255));
        jButton_Forgot.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton_Forgot.setForeground(new java.awt.Color(0, 153, 153));
        jButton_Forgot.setText("Forgot password");
        jButton_Forgot.setContentAreaFilled(false);
        jButton_Forgot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Forgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ForgotActionPerformed(evt);
            }
        });

        jButton_WithoutLogin.setBackground(new java.awt.Color(255, 255, 255));
        jButton_WithoutLogin.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton_WithoutLogin.setForeground(new java.awt.Color(0, 51, 51));
        jButton_WithoutLogin.setText("Access without login");
        jButton_WithoutLogin.setContentAreaFilled(false);
        jButton_WithoutLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_WithoutLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_WithoutLoginActionPerformed(evt);
            }
        });

        jLabel_i.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/i-icon.png"))); // NOI18N
        jLabel_i.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_iMouseClicked(evt);
            }
        });

        jComboBox_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_branchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_i))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jButton_Login))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(jButton_Forgot)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jComboBox_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(jButton_WithoutLogin)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel_i)
                .addGap(27, 27, 27)
                .addComponent(jComboBox_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Forgot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_WithoutLogin)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ForgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ForgotActionPerformed
        // TODO add your handling code here:
        this.recoveryPasswordDialog = new RecoveryPasswordDialog(this, true);
        this.recoveryPasswordDialog.setVisible(true);
    }//GEN-LAST:event_jButton_ForgotActionPerformed

    private void jLabel_HideShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_HideShowMouseClicked
        // TODO add your handling code here:
        if (showPass) {
            showPass = false;
            jLabel_HideShow.setIcon(new ImageIcon(getClass().getResource("/img/hide.png")));
            jPasswordField_Pass.setEchoChar('*');
        } else {
            showPass = true;
            jLabel_HideShow.setIcon(new ImageIcon(getClass().getResource("/img/show.png")));
            jPasswordField_Pass.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_jLabel_HideShowMouseClicked

    private void jLabel_iMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_iMouseClicked
        // TODO add your handling code here:
        this.ruleLibraryDialog = new RuleLibraryDialog(this, true);
        this.ruleLibraryDialog.setVisible(true);
    }//GEN-LAST:event_jLabel_iMouseClicked

    private void jButton_WithoutLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_WithoutLoginActionPerformed
        branch_name = (String) jComboBox_branch.getSelectedItem();
		System.out.println("Tên Branch: " + branch_name);
		
		branch_id = getBranchID(branch_name);
		System.out.println("id_branch: " + branch_id);
        this.bookDialog = new BookDialog(this, true);
        this.bookDialog.setVisible(true);
    }//GEN-LAST:event_jButton_WithoutLoginActionPerformed

    private void jButton_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LoginActionPerformed
        // TODO add your handling code here:
		tmp = "";
		branch_name = (String) jComboBox_branch.getSelectedItem();
		System.out.println("Tên Branch: " + branch_name);
		
		branch_id = getBranchID(branch_name);
		System.out.println("id_branch: " + branch_id);
		
        String pwd = new String(jPasswordField_Pass.getPassword());
        String passwordConfirm = getPassword(jTextField_Username.getText().trim());
        if(jTextField_Username.getText().trim().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Username không được để khoảng trắng. Vui lòng nhập lại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
             return;
        }
        if(pwd.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Không được để trống password. Vui lòng nhập lại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
             return;
        }
        if(passwordConfirm.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Username không tồn tại. Vui lòng nhập lại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
             return;
        }
        
//        if(!verifyHash(pwd, passwordConfirm)){
//            JOptionPane.showMessageDialog(null, "Sai mật khẩu. Vui lòng nhập lại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
//             return;
//        }

		if(!pwd.equals(passwordConfirm)){
			JOptionPane.showMessageDialog(null, "Sai mật khẩu. Vui lòng nhập lại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
		}
	
//		System.out.println(tmp);
		
		if(!branch_id.equals(tmp)){
			JOptionPane.showMessageDialog(null, "Tài khoản không có trong chi nhánh này. Vui lòng nhập lại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
		}
		
        this.dispose();
        username = jTextField_Username.getText().trim();
		System.out.println("Da luu username: " + username);
        if(Idrole == 4){
            this.adminMainFrame = new AdminMainFrame();  
            this.adminMainFrame.setVisible(true);
        }else if(Idrole == 3){
            this.archivistMainFrame = new ArchivistMainFrame();  
            this.archivistMainFrame.setVisible(true);
        }else if(Idrole == 2){
            this.librarianMainFrame = new LibrarianMainFrame();  
            this.librarianMainFrame.setVisible(true);
        }else{
            this.readerMainFrame = new ReaderMainFrame();  
            this.readerMainFrame.setVisible(true);
        }
    }//GEN-LAST:event_jButton_LoginActionPerformed

    private void jComboBox_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_branchActionPerformed

    }//GEN-LAST:event_jComboBox_branchActionPerformed

	private void setBranchComboBoxValues() {
		Connection ketNoi = Connect.GetConnect();
		try {
			PreparedStatement ps = ketNoi.prepareStatement("SELECT id, branch_name FROM branch");
			ResultSet rs = ps.executeQuery();

			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

			while (rs.next()) {
				String branchName = rs.getString("branch_name");
				model.addElement(branchName);
			}

			jComboBox_branch.setModel(model);

			ps.close();
			rs.close();
			ketNoi.close();
		} catch (SQLException ex) {
			System.out.println("Error retrieving branch data");
		}
	}
	
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
	
	String getBranchID(String branch_name){
        Connection ketNoi= Connect.GetConnect();
        try {
            PreparedStatement ps=ketNoi.prepareStatement("select id from branch where branch_name = ?");
            ps.setString(1, branch_name);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return rs.getString(1);
            }
            ps.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException ex) {
            System.out.println("loi lay branch_id");
        }
        return "";		
	}
	
    String getPassword(String username){
      
        Connection ketNoi= Connect.GetConnect();
        try {
            PreparedStatement ps=ketNoi.prepareStatement("select account_password, account_role_id, id, branch_id from account where account_username = ?");
            ps.setString(1, username);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
				tmp = rs.getString(4);
				account_id = rs.getString(3);
				System.out.println("Da luu id: " + account_id);
                Idrole = rs.getInt(2);
				System.out.println("Role: " + Idrole);
                return rs.getString(1);
            }
            ps.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException ex) {
            System.out.println("loi lay phone and email");
        }
        return "";
    }
    
	public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public static boolean verifyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Forgot;
    private javax.swing.JButton jButton_Login;
    private javax.swing.JButton jButton_WithoutLogin;
    private javax.swing.JComboBox<String> jComboBox_branch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_HideShow;
    private javax.swing.JLabel jLabel_i;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField_Pass;
    private javax.swing.JTextField jTextField_Username;
    // End of variables declaration//GEN-END:variables
}
