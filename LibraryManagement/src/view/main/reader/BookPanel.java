/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.main.reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.database.Connect;
import swing.UIController;

/**
 *
 * @author Admin
 */
public class BookPanel extends javax.swing.JPanel {

    /**
     * Creates new form BookPanel
     */
    DefaultTableModel dtm;
    
    //private ArrayList<String> columnTitlesOfJTable_DSSach = new ArrayList<>(Arrays.asList("ID", "title", "publish_date", "price", "location", "author", "publisher", "category"));

    public BookPanel() {
        initComponents();
        getbook();
        //getAndShowData(jTable_Book, columnTitlesOfJTable_DSSach, "SELECT S.book_id as ID, S.title, S.publish_date, S.price ,L.location, TG.name as author, NXB.name as publisher, TL.category as category FROM book S, author TG, publisher NXB, category TL , location L WHERE S.author_id = TG.author_id AND S.category_id = TL.category_id AND S.publisher_id = NXB.publisher_id AND S.location_id = L.location_id");
        UIController.setDefaultTableHeader(jTable_Book);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextField_Search = new javax.swing.JTextField();
        jButton_ClearSearch = new javax.swing.JButton();
        jPanel_Card = new javax.swing.JPanel();
        jRadioButton_Title = new javax.swing.JRadioButton();
        jRadioButton_Author = new javax.swing.JRadioButton();
        jRadioButton_Publisher = new javax.swing.JRadioButton();
        jRadioButton_Category = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Book = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel21.setText("Search with");

        jTextField_Search.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTextField_Search.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField_SearchCaretUpdate(evt);
            }
        });

        jButton_ClearSearch.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton_ClearSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        jButton_ClearSearch.setText("Clear");
        jButton_ClearSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClearSearchActionPerformed(evt);
            }
        });

        jPanel_Card.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Card.setLayout(new java.awt.GridLayout(1, 0, 40, 0));

        jRadioButton_Title.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton_Title);
        jRadioButton_Title.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jRadioButton_Title.setSelected(true);
        jRadioButton_Title.setText("Title");
        jRadioButton_Title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_TitleActionPerformed(evt);
            }
        });
        jPanel_Card.add(jRadioButton_Title);

        jRadioButton_Author.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton_Author);
        jRadioButton_Author.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jRadioButton_Author.setText("Author");
        jRadioButton_Author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_AuthorActionPerformed(evt);
            }
        });
        jPanel_Card.add(jRadioButton_Author);

        jRadioButton_Publisher.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton_Publisher);
        jRadioButton_Publisher.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jRadioButton_Publisher.setText("Publisher");
        jRadioButton_Publisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_PublisherActionPerformed(evt);
            }
        });
        jPanel_Card.add(jRadioButton_Publisher);

        jRadioButton_Category.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton_Category);
        jRadioButton_Category.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jRadioButton_Category.setText("Category");
        jRadioButton_Category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_CategoryActionPerformed(evt);
            }
        });
        jPanel_Card.add(jRadioButton_Category);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jPanel_Card, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addGap(71, 71, 71)
                .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_ClearSearch)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_ClearSearch))
                    .addComponent(jPanel_Card, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jTable_Book.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Category", "Title", "Author", "Publish year", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Book.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable_Book);
        if (jTable_Book.getColumnModel().getColumnCount() > 0) {
            jTable_Book.getColumnModel().getColumn(0).setPreferredWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ClearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClearSearchActionPerformed
        jTextField_Search.setText("");
    }//GEN-LAST:event_jButton_ClearSearchActionPerformed

    private void jTextField_SearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField_SearchCaretUpdate
        // TODO add your handling code here:
        String tuKhoa = jTextField_Search.getText().toLowerCase();
        TableRowSorter<TableModel> trs = new TableRowSorter<>(jTable_Book.getModel());
        jTable_Book.setRowSorter(trs);
        if (jRadioButton_Title.isSelected()) {
            trs.setRowFilter(RowFilter.regexFilter("(?i)" + tuKhoa, 2));
        }
        if (jRadioButton_Author.isSelected()) {
            trs.setRowFilter(RowFilter.regexFilter("(?i)" + tuKhoa, 3));
        }
        if (jRadioButton_Publisher.isSelected()) {
            trs.setRowFilter(RowFilter.regexFilter("(?i)" + tuKhoa, 4));
        }
        if (jRadioButton_Category.isSelected()) {
            trs.setRowFilter(RowFilter.regexFilter("(?i)" + tuKhoa, 1));
        }
    }//GEN-LAST:event_jTextField_SearchCaretUpdate

    
    void getbook() {
        dtm = (DefaultTableModel) jTable_Book.getModel();
        dtm.setNumRows(0);
        Connection ketNoi = Connect.GetConnect();
        Vector vt;
        try {
            String sql = "SELECT b.id, c.category_name, b.title, b.Author, b.published_year, b.price FROM book b INNER JOIN category c ON b.category_id = c.id where branch_id = ?";
            PreparedStatement ps = ketNoi.prepareStatement(sql);
            ps.setString(1, view.login.LoginFrame.branch_id);
			ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vt = new Vector();
                vt.add(rs.getString(1));
                vt.add(rs.getString(2));
                vt.add(rs.getString(3));
                vt.add(rs.getString(4));
                vt.add(rs.getString(5));
                vt.add(rs.getFloat(6));
                dtm.addRow(vt);
            }
            jTable_Book.setModel(dtm);
            ps.close();
            rs.close();
            ketNoi.close();
        } catch (SQLException ex) {
        }
    }
    
    private void jRadioButton_TitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_TitleActionPerformed
        // TODO add your handling code here:
        String tuKhoa = jTextField_Search.getText().toLowerCase();
        TableRowSorter<TableModel> trs = new TableRowSorter<>(jTable_Book.getModel());
        jTable_Book.setRowSorter(trs);
        if (jRadioButton_Title.isSelected()) {
            trs.setRowFilter(RowFilter.regexFilter("(?i)" + tuKhoa, 2));
        }
    }//GEN-LAST:event_jRadioButton_TitleActionPerformed

    
    private void jRadioButton_AuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_AuthorActionPerformed
        // TODO add your handling code here:
        String tuKhoa = jTextField_Search.getText().toLowerCase();
        TableRowSorter<TableModel> trs = new TableRowSorter<>(jTable_Book.getModel());
        jTable_Book.setRowSorter(trs);
        if (jRadioButton_Author.isSelected()) {
            trs.setRowFilter(RowFilter.regexFilter("(?i)" + tuKhoa, 3));
        }
    }//GEN-LAST:event_jRadioButton_AuthorActionPerformed

    private void jRadioButton_PublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_PublisherActionPerformed
        // TODO add your handling code here:
        String tuKhoa = jTextField_Search.getText().toLowerCase();
        TableRowSorter<TableModel> trs = new TableRowSorter<>(jTable_Book.getModel());
        jTable_Book.setRowSorter(trs);
        if (jRadioButton_Publisher.isSelected()) {
            trs.setRowFilter(RowFilter.regexFilter("(?i)" + tuKhoa, 4));
        }
    }//GEN-LAST:event_jRadioButton_PublisherActionPerformed

    private void jRadioButton_CategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_CategoryActionPerformed
        // TODO add your handling code here:
        String tuKhoa = jTextField_Search.getText().toLowerCase();
        TableRowSorter<TableModel> trs = new TableRowSorter<>(jTable_Book.getModel());
        jTable_Book.setRowSorter(trs);
        if (jRadioButton_Category.isSelected()) {
            trs.setRowFilter(RowFilter.regexFilter("(?i)" + tuKhoa, 1));
        }
    }//GEN-LAST:event_jRadioButton_CategoryActionPerformed

    public static void getAndShowData(JTable jTable, ArrayList<String> ColumnTitles, String selectQuery) {
        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        dtm.setRowCount(0);
        try (Connection con = Connect.GetConnect();
                PreparedStatement ps = con.prepareStatement(selectQuery);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Vector rowData = new Vector();
                for (String title : ColumnTitles) {
                    rowData.add(rs.getString(title));
                }
                dtm.addRow(rowData);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookPanel.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton_ClearSearch;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_Card;
    private javax.swing.JRadioButton jRadioButton_Author;
    private javax.swing.JRadioButton jRadioButton_Category;
    private javax.swing.JRadioButton jRadioButton_Publisher;
    private javax.swing.JRadioButton jRadioButton_Title;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Book;
    private javax.swing.JTextField jTextField_Search;
    // End of variables declaration//GEN-END:variables
}
