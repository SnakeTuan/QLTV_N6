/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.login;

import control.librarian.BookLoan;
import model.database.Rule;

/**
 *
 * @author Admin
 */
public class RuleLibraryDialog extends javax.swing.JDialog {

    private BookLoan bookLoan;
    private Rule rule;
    /**
     * Creates new form RuleLibraryDialog
     */
    public RuleLibraryDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTextArea_Rule.setWrapStyleWord(true);
        bookLoan = new BookLoan();
        rule = bookLoan.getCurrentRule();
        jTextArea_Rule.setText(showQuyDinh());
        setLocationRelativeTo(null);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_Rule = new javax.swing.JTextArea();
        jButton_Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Library Rule");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Library rule");
        jLabel1.setPreferredSize(new java.awt.Dimension(214, 50));
        jPanel1.add(jLabel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBorder(null);

        jTextArea_Rule.setEditable(false);
        jTextArea_Rule.setColumns(20);
        jTextArea_Rule.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextArea_Rule.setLineWrap(true);
        jTextArea_Rule.setRows(5);
        jScrollPane2.setViewportView(jTextArea_Rule);

        jButton_Cancel.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jButton_Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        jButton_Cancel.setText("Cancel");
        jButton_Cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jButton_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

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

    private String showQuyDinh() {
        String str = "";
        str = str + "\n- Độc giả truy cập vào phần mềm để tra cứu sách bằng tài khoản đã được cung cấp và có thể thay đổi mật khẩu sau khi đăng nhập."
                + "\n- Độc giả chọn tài liệu theo nhu cầu cá nhân, mỗi đầu sách chỉ được mượn 1 quyển."
                + "\n   Số sách được mượn không quá " + rule.getSoSachMuonToiDa() + " quyển. Độc giả được mượn sách tối đa " + rule.getSoNgayMuonToiDa() + " ngày tính từ ngày mượn sách."
                + "\n- Độc giả có trách nhiệm trả tài liệu đúng hạn cho thư viện, thanh toán các khoản phạt, bồi thường (nếu có)."
                + "\n   Độc giả có trách nhiệm bảo quản tài liệu của Thư viện, các trường hợp làm mất, gây hư hỏng,... phải bồi thường theo quy định của Thư viện."
                + "\n   Độc giả mượn sách đến hạn trả sách mà chưa trả sẽ bị phạt " + rule.getTienPhatQuaHan() + "/ngày trễ."
                + "\n   Làm hỏng hoặc mất sách sẽ bị phạt " + rule.getTienPhatHongMat() + "% giá trên bìa sách."
                + "\n- Độc giả phải trả sách mượn quá hạn mới được tiếp tục mượn sách."
                + "\n\t\t\t\t" + rule.getNgayThayDoi();
        return str;
    }
    
    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton_CancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea_Rule;
    // End of variables declaration//GEN-END:variables
}
