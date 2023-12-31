/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import model.database.Connect;
import view.main.librarian.ReaderPanel;
import static view.main.librarian.ReaderPanel.validate;
import static view.main.librarian.ReaderPanel.validatePhone;
import static view.main.librarian.ReaderPanel.verifyFullname;

/**
 *
 * @author Admin
 */
public class ProfilePanel extends javax.swing.JPanel {

    PasswordChangeDialog passwordChangeDialog;

    /**
     * Creates new form ProfilePanel
     */
    public ProfilePanel() {
        initComponents();
        layUser();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGender = new javax.swing.ButtonGroup();
        jLabel_Image = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton_EditProfile = new javax.swing.JButton();
        jButton_ChangePass = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Name = new javax.swing.JTextField();
        jRadioButton_Male = new javax.swing.JRadioButton();
        jRadioButton_Female = new javax.swing.JRadioButton();
        jRadioButton_Other = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser_DateOfBirth = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_PhoneNumber = new javax.swing.JTextField();
        jTextField_Email = new javax.swing.JTextField();
        jTextField_Address = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jLabel_Image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/User_256px.png"))); // NOI18N
        add(jLabel_Image, java.awt.BorderLayout.NORTH);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton_EditProfile.setBackground(new java.awt.Color(51, 153, 255));
        jButton_EditProfile.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButton_EditProfile.setForeground(new java.awt.Color(255, 255, 255));
        jButton_EditProfile.setText("Edit profile");
        jButton_EditProfile.setBorderPainted(false);
        jButton_EditProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_EditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EditProfileActionPerformed(evt);
            }
        });

        jButton_ChangePass.setBackground(new java.awt.Color(51, 153, 255));
        jButton_ChangePass.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButton_ChangePass.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ChangePass.setText("Change password");
        jButton_ChangePass.setBorderPainted(false);
        jButton_ChangePass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_ChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ChangePassActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("Username");

        jTextField_Username.setEditable(false);
        jTextField_Username.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setText("Gender");

        jTextField_Name.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jRadioButton_Male.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupGender.add(jRadioButton_Male);
        jRadioButton_Male.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jRadioButton_Male.setSelected(true);
        jRadioButton_Male.setText("Male");

        jRadioButton_Female.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupGender.add(jRadioButton_Female);
        jRadioButton_Female.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jRadioButton_Female.setText("Female");

        jRadioButton_Other.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupGender.add(jRadioButton_Other);
        jRadioButton_Other.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jRadioButton_Other.setText("Other");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setText("Date of birth");

        jDateChooser_DateOfBirth.setDateFormatString("yyyy-MM-dd");
        jDateChooser_DateOfBirth.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setText("Phone number");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel8.setText("Address:");

        jTextField_PhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jTextField_Email.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jTextField_Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_AddressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_EditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField_Username, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addComponent(jTextField_Name))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jRadioButton_Male)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton_Female)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton_Other))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser_DateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField_PhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(jTextField_Email)))
                        .addContainerGap(224, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jButton_ChangePass))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(jLabel5)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jRadioButton_Male)
                            .addComponent(jRadioButton_Female)
                            .addComponent(jRadioButton_Other))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addComponent(jDateChooser_DateOfBirth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_EditProfile)
                    .addComponent(jButton_ChangePass))
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ChangePassActionPerformed
        // TODO add your handling code here:
        this.passwordChangeDialog = new PasswordChangeDialog(null, true, this);
        this.passwordChangeDialog.setVisible(true);
    }//GEN-LAST:event_jButton_ChangePassActionPerformed

    private void jTextField_AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_AddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_AddressActionPerformed

    private void jButton_EditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditProfileActionPerformed
        // TODO add your handling code here:
        // kiểm tra date và lấy date
            Date dateCheck = jDateChooser_DateOfBirth.getDate();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            try {
                Date dateAgeAllow = simpleDateFormat.parse("2017-01-01");
                Date today = new Date();
                if(!dateAgeAllow.after(dateCheck) && !today.before(dateCheck)) {
                        JOptionPane.showMessageDialog(null, "Không quá ngày hiện tại\n Phải hơn 6 tuổi", "Ngày sinh sai định dạng", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
            } catch (ParseException ex) {
                Logger.getLogger(ReaderPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String date_of_birth = sdf.format(jDateChooser_DateOfBirth.getDate());
            
            
           
            String Full_Name = jTextField_Name.getText();
            String genderEndlish = getSelectedButtonText(buttonGroupGender);
            String gender = "";
            if(genderEndlish.equalsIgnoreCase("Male")){
                gender = "Nam";
            }else if(genderEndlish.equalsIgnoreCase("Female")){
                gender = "Nữ";
            }else{
                gender = "Khác";
            }
            String email = jTextField_Email.getText();
            String address = jTextField_Address.getText();
            String phone_number = jTextField_PhoneNumber.getText();
//            int IdWard = getIdWard(jComboBox_Commune.getSelectedItem().toString(),jComboBox_District.getSelectedItem().toString(),jComboBox_Province.getSelectedItem().toString());          
            String username = jTextField_Username.getText();
          

            if(!verifyFullname(Full_Name)) {
                JOptionPane.showMessageDialog(null, "Không được để trống\n Sử dụng bảng chữ cái Việt Nam", "Vui lòng nhập tên đúng định dạng sau", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(!validate(email)){
                JOptionPane.showMessageDialog(null, "Không được để trống\n Sử dụng đúng định dạng Email chuẩn", "Vui lòng nhập email đúng định dạng", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(!validatePhone(phone_number)){
                JOptionPane.showMessageDialog(null, "Không được để trống\n Chỉ nhận kí tự số \nYêu cầu đủ 10 chữ số", "Vui lòng nhập số điện thoại đúng định dạng", JOptionPane.ERROR_MESSAGE);
                return;
            }         
//            if(!verifyUsername(useName)){    
//                JOptionPane.showMessageDialog(null, "Không được để trống\nChứa các bảng chữ cái, chữ số và dấu gạch ngang \nKhông chứa kí tự đặc biệt", "Vui lòng nhập username đúng định dạng", JOptionPane.ERROR_MESSAGE);
//                    return;
//            }
            int i = checkExistPhoneOrEmailWhenUpdate(phone_number, email, username); 
                if(i > 0){
                if(i == 1){
                    JOptionPane.showMessageDialog(null, "Số điện thoại đã có người sử dụng. Vui lòng nhập số điện thoại khác!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(i == 2){
                    JOptionPane.showMessageDialog(null, "email đã có người sử dụng. Vui lòng nhập username khác!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
            }
            updateAccount(Full_Name, gender, date_of_birth, phone_number, email, address, username);
//            updateAddress(address_id, IdWard, address);
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
    }//GEN-LAST:event_jButton_EditProfileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupGender;
    private javax.swing.JButton jButton_ChangePass;
    private javax.swing.JButton jButton_EditProfile;
    private com.toedter.calendar.JDateChooser jDateChooser_DateOfBirth;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Image;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton_Female;
    private javax.swing.JRadioButton jRadioButton_Male;
    private javax.swing.JRadioButton jRadioButton_Other;
    private javax.swing.JTextField jTextField_Address;
    private javax.swing.JTextField jTextField_Email;
    private javax.swing.JTextField jTextField_Name;
    private javax.swing.JTextField jTextField_PhoneNumber;
    private javax.swing.JTextField jTextField_Username;
    // End of variables declaration//GEN-END:variables

    private void layUser() {
        Connection ketNoi= Connect.GetConnect();
       
        try {
            PreparedStatement ps=ketNoi.prepareStatement("select account_name, account_username, account_address, email, phone, gender, date_of_birth from account where id = ?");
            ps.setString(1, view.login.LoginFrame.account_id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                  
                jTextField_Username.setText(rs.getString("account_username"));
                jTextField_Name.setText(rs.getString("account_name"));
                jTextField_Email.setText(rs.getString("email"));
                jTextField_PhoneNumber.setText(rs.getString("phone"));
                jTextField_Address.setText(rs.getString("account_address"));
//                jComboBox_Province.setSelectedIndex(rs.getInt("province_id")-1);
//                jComboBox_District.setSelectedItem(rs.getString("district_name"));
//                jComboBox_Commune.setSelectedItem(rs.getString("ward_name"));
                if(rs.getString("gender").equalsIgnoreCase("nam")){
                    jRadioButton_Male.setSelected(true);
                }else if(rs.getString("gender").toString().equalsIgnoreCase("nữ")){
                    jRadioButton_Female.setSelected(true);
                }else{
                    jRadioButton_Other.setSelected(true);
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");                
                jDateChooser_DateOfBirth.setDate(rs.getDate("date_of_birth"));
               
            }
            
            ps.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException ex) {
            System.out.println("loi lay lay user");
        }
    }


    public boolean updateAccount(String Full_Name,String gender,String date_of_birth, String phone_number, String email, String address, String username){
       Connection ketNoi =Connect.GetConnect();
        String sql = "UPDATE account SET account_name= ?, gender= ?, date_of_birth = ?, phone= ?, email= ?, account_address=? WHERE account_username = ?";
        PreparedStatement ps;
		try {
			ps = ketNoi.prepareStatement(sql);
			ps.setString(1, Full_Name);
			ps.setString(2, gender);
			ps.setString(3, date_of_birth);
			ps.setString(4, phone_number);
			ps.setString(5, email);
			ps.setString(6, address);
			ps.setString(7, username);
			ps.executeUpdate();
			System.out.print("Update account thanh cong");
			return true;
		} catch (SQLException ex) {
			System.out.print("Update account that bai");
			Logger.getLogger(ReaderPanel.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    int checkExistPhoneOrEmailWhenUpdate(String PhoneNumber, String Email,String username)
    {
        Connection ketNoi= Connect.GetConnect();
        try {
            PreparedStatement ps=ketNoi.prepareStatement("select 1 from account a where a.phone = ? and account_username not in (?)");
            ps.setString(1, PhoneNumber);
            ps.setString(2, username);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){  
                return 1;
            }
            ps.close();
            rs.close();
            
            PreparedStatement ps1 = ketNoi.prepareStatement("select 1 from account a where a.email = ? and account_username not in (?)");
            ps1.setString(1, Email);
            ps1.setString(2, username);
            ResultSet rs1=ps1.executeQuery();
            while(rs1.next()){  
                return 2;
            }
            ps1.close();
            rs1.close();

            ketNoi.close();
        } catch (SQLException ex) {
            System.out.println("loi checkExistPhoneOrEmailWhenUpdate");
        }
        return 0;
    }
    
    // email hop le
   public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
            return matcher.find();
    }
}
