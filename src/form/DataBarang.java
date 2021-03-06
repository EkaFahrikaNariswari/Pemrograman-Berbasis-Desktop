/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import Koneksi.KoneksiHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import form.DataBarang;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import model.DataBarang2;


/**
 *
 * @author fahrika
 */
public class DataBarang extends javax.swing.JFrame {
    
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form DataTransaksi
     */
    public DataBarang() {
        initComponents();
        fetchData();
    }
    //penempatan dan pencocokan data tabel di database dan di tabel JTable
    private void fetchData() {
        ArrayList<DataBarang2> list = barang();
        DefaultTableModel model = (DefaultTableModel) tbl_barang.getModel();
        Object[] row = new Object[4];

        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getId_barang();
            row[1] = list.get(i).getNama_barang();
            row[2] = list.get(i).getJumlah();
            row[3] = list.get(i).getHarga();

            model.addRow(row);
        }
    }
    //perintah untuk memasukkan data ke dalam tabel dan select data
    public ArrayList<DataBarang2> barang() {
        ArrayList<DataBarang2> barang = new ArrayList<>();
        try {
            Connection con = KoneksiHelper.getConnection();
            String sql = "SELECT id_barang, nama_barang, jumlah, harga FROM barang";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            DataBarang2 DataBarang;
            while (rs.next()) {
                DataBarang = new DataBarang2(rs.getString("id_barang"), rs.getString("nama_barang"), rs.getInt("jumlah"), rs.getInt("harga"));
                barang.add(DataBarang);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return barang;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btn_kembali = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_id_barang = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_jumlah = new javax.swing.JTextField();
        txt_harga = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txt_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        txt_tambah = new javax.swing.JButton();
        txt_keyword = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btn_baru = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_barang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MANAJEMEN DATA BARANG");

        btn_kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_back_to_25px.png"))); // NOI18N
        btn_kembali.setText("Kembali");
        btn_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btn_kembali)
                .addGap(219, 219, 219)
                .addComponent(jLabel7)
                .addContainerGap(350, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_kembali)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 981, -1));

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_identification_documents_25px.png"))); // NOI18N
        jLabel2.setText("ID Barang");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_age_25px.png"))); // NOI18N
        jLabel4.setText("Jumlah");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_male_user_25px.png"))); // NOI18N
        jLabel3.setText("Nama barang");

        txt_id_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_barangActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_price_25px.png"))); // NOI18N
        jLabel6.setText("Harga");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(564, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_id_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167)
                        .addComponent(jLabel6)
                        .addGap(33, 33, 33)
                        .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txt_id_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, -1, -1));

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        txt_ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_edit_property_25px.png"))); // NOI18N
        txt_ubah.setText("Edit");
        txt_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ubahActionPerformed(evt);
            }
        });

        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_delete_25px.png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        txt_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_plus_25px.png"))); // NOI18N
        txt_tambah.setText("Tambah");
        txt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tambahActionPerformed(evt);
            }
        });

        txt_keyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_keywordKeyReleased(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_25px.png"))); // NOI18N
        jLabel9.setText("Cari Data");

        btn_baru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_restart_25px.png"))); // NOI18N
        btn_baru.setText("Baru");
        btn_baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_baruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_tambah)
                .addGap(48, 48, 48)
                .addComponent(txt_ubah)
                .addGap(46, 46, 46)
                .addComponent(btn_hapus)
                .addGap(40, 40, 40)
                .addComponent(btn_baru)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(txt_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tambah)
                    .addComponent(txt_ubah)
                    .addComponent(btn_hapus)
                    .addComponent(btn_baru))
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 197, 961, -1));

        tbl_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Barang", "Nama Barang", "Jumlah", "Harga"
            }
        ));
        tbl_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_barang);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 960, 230));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        // memfungsikan button kembali
        new FormKaryawan().show();
        this.dispose();
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void txt_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tambahActionPerformed
        // memfungsikan button tambah
        
        //bagian masukkan data ke dalam database
        try {
            Connection con = KoneksiHelper.getConnection();
            //query insert data ke dalam database mysql
            pst = con.prepareStatement("INSERT INTO barang (id_barang, nama_barang, jumlah, harga) VALUES(?,?,?,?)");
            //validasi ketika textField kosong

            if (txt_id_barang.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Id barang tidak boleh kosong");
            } else if (txt_nama.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama barang tidak boleh kosong");
            } else if (txt_jumlah.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kosong");
            } else if (txt_harga.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Harga tidak boleh kosong");
            } else {
                //digunakan untuk memasukkan data ke masing2 variabel textfield
                
                //misal bingung pst sama rs bisa diliat di variabel diatas
                pst.setString(1, txt_id_barang.getText());
                pst.setString(2, txt_nama.getText());
                pst.setString(3, txt_jumlah.getText());
                pst.setString(4, txt_harga.getText());
                pst.executeUpdate();
                
                
                //setelah nginput data kasih ini biar textfieldnya kosong lagi
                txt_id_barang.setText("");
                txt_nama.setText("");
                txt_jumlah.setText("");
                txt_harga.setText("");
                
                //setelah berhasil
                JOptionPane.showMessageDialog(null, "Tambah Barang Berhasil");
            }

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            e.printStackTrace();
        }   
        
    }//GEN-LAST:event_txt_tambahActionPerformed

    private void txt_id_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_barangActionPerformed

    private void btn_baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_baruActionPerformed
        // memfungsikan button baru
        DefaultTableModel model = (DefaultTableModel) tbl_barang.getModel();
        model.setRowCount(0);
        fetchData();
    }//GEN-LAST:event_btn_baruActionPerformed

    private void txt_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ubahActionPerformed
        // mwmfungsikan button ubah atau edit
        
        try {
            
            Connection con = KoneksiHelper.getConnection();
            int row = tbl_barang.getSelectedRow();
            String value = (tbl_barang.getModel().getValueAt(row, 0).toString());
            String sql = "UPDATE barang SET id_barang=?,nama_barang=?,jumlah=?,harga=? WHERE id_barang = '" + value + "'";
            if (txt_id_barang.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Id tidak boleh kosong");
            } else if (txt_nama.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Barang tidak boleh kosong");
            } else if (txt_jumlah.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kosong");
            } else if (txt_harga.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Harga tidak boleh kosong");
            } else {
                pst = con.prepareStatement(sql);
                pst.setString(1, txt_id_barang.getText());
                pst.setString(2, txt_nama.getText());
                pst.setString(3, txt_jumlah.getText());
                pst.setString(4, txt_harga.getText());
                pst.executeUpdate();

                DefaultTableModel model = (DefaultTableModel) tbl_barang.getModel();
                model.setRowCount(0);
                fetchData();
                txt_id_barang.setText("");
                txt_nama.setText("");
                txt_jumlah.setText("");
                txt_harga.setText("");
                JOptionPane.showMessageDialog(null, "Update Selesai");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_txt_ubahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // memfungsikan button hapus
        
        try {

            int row = tbl_barang.getSelectedRow();
           Connection con = KoneksiHelper.getConnection();
           String value = (tbl_barang.getModel().getValueAt(row, 0).toString());
            String sql = "DELETE FROM barang WHERE id_barang = '" + value + "'";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) tbl_barang.getModel();
            model.setRowCount(0);
            fetchData();
            JOptionPane.showMessageDialog(null, "Data terhapus");
       } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
       }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void tbl_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_barangMouseClicked
        // memfungsikan clickmouse pada tabel barang
        
        int i = tbl_barang.getSelectedRow();
        TableModel model = tbl_barang.getModel();
        txt_id_barang.setText(model.getValueAt(i, 0).toString());
        txt_nama.setText(model.getValueAt(i, 1).toString());
        txt_jumlah.setText(model.getValueAt(i, 2).toString());
        txt_harga.setText(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_tbl_barangMouseClicked

    private void txt_keywordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_keywordKeyReleased
        // memfungsikan textfield cari
        DefaultTableModel table = (DefaultTableModel) tbl_barang.getModel();
        String search = txt_keyword.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tbl_barang.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txt_keywordKeyReleased

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DataBarang().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_baru;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_kembali;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_barang;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_id_barang;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_keyword;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JButton txt_tambah;
    private javax.swing.JButton txt_ubah;
    // End of variables declaration//GEN-END:variables
}
