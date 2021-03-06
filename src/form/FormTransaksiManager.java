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
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import form.FormTransaksiManager;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import model.FormTransaksiManager2;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author fahrika
 */
public class FormTransaksiManager extends javax.swing.JFrame {
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form DataTransaksi
     */
    public FormTransaksiManager() {
        initComponents();
        updateCombo();
        fetchData();
        setLocationRelativeTo(this);

    }
    //penempatan dan pencocokan data tabel di database dan di tabel JTable
    private void fetchData() {
        ArrayList<FormTransaksiManager2> list = transaksiManager();
        DefaultTableModel model = (DefaultTableModel) tbl_transaksi_manager.getModel();
        Object[] row = new Object[7];

        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getId_transaksi();
            row[1] = list.get(i).getNama_karyawan();
            row[2] = list.get(i).getTanggal();
            row[3] = list.get(i).getNama_barang();
            row[4] = list.get(i).getJumlah();
            row[5] = list.get(i).getHarga();
            row[6] = list.get(i).getTotal_harga();

            model.addRow(row);
        }
    }
    //perintah untuk memasukkan data ke dalam tabel dan select data
    public ArrayList<FormTransaksiManager2> transaksiManager() {
        ArrayList<FormTransaksiManager2> transaksiManager = new ArrayList<>();
        try {
            Connection con = KoneksiHelper.getConnection();
            String sql = "SELECT id_transaksi, nama_karyawan, tanggal, nama_barang, jumlah, harga, total_harga FROM transaksi";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            FormTransaksiManager2 FormTransaksiManager;
            while (rs.next()) {
                FormTransaksiManager = new FormTransaksiManager2(rs.getInt("id_transaksi"),rs.getString("nama_karyawan"),rs.getString("tanggal"), rs.getString("nama_barang"), rs.getInt("jumlah"), rs.getInt("harga"), rs.getInt("total_harga"));
                transaksiManager.add(FormTransaksiManager);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return transaksiManager;
       
    }
     // memfungsikan combobox 
    private void updateCombo() {
        String sql = "Select * from karyawan";
        try {
            Connection con = KoneksiHelper.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                txt_nama_karyawan.addItem( rs.getString("nama"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
        }
    }
    // menghitung jumlah harga total
    private void getTotal() {
        try {
            int harga = Integer.parseInt(txt_harga.getText());
            int jumlah = Integer.parseInt(txt_jumlah.getText());
            double total = (harga * jumlah);
            txt_total_harga.setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
       
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
        jLabel7 = new javax.swing.JLabel();
        btn_kembali = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txt_jumlah = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_harga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_id_transaksi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_tanggal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_nama_barang = new javax.swing.JTextField();
        txt_total_harga = new javax.swing.JLabel();
        txt_nama_karyawan = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi_manager = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txt_cetak_laporan = new javax.swing.JButton();
        txt_keyword = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MANAJEMEN DATA TRANSAKSI PENJUALAN");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_kembali)
                .addGap(166, 166, 166)
                .addComponent(jLabel7)
                .addContainerGap(247, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_kembali)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, -1));

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_identification_documents_25px.png"))); // NOI18N
        jLabel2.setText("ID Transaksi");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_product_25px.png"))); // NOI18N
        jLabel4.setText("Nama Barang");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_account_25px.png"))); // NOI18N
        jLabel5.setText("Jumlah");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_age_25px.png"))); // NOI18N
        jLabel3.setText("Tanggal");

        txt_id_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_transaksiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("TOTAL BAYAR : Rp.");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_price_25px.png"))); // NOI18N
        jLabel6.setText("Harga");

        txt_nama_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nama_barangActionPerformed(evt);
            }
        });

        txt_total_harga.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        txt_nama_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nama_karyawanActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_male_user_25px.png"))); // NOI18N
        jLabel8.setText("Nama Karyawan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(38, 38, 38))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nama_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(189, 189, 189)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_total_harga, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_harga, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(txt_jumlah))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_id_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nama_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txt_nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(txt_total_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 940, 170));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbl_transaksi_manager.setAutoCreateRowSorter(true);
        tbl_transaksi_manager.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Transaksi", "Nama karyawan", "Tanggal", "Nama Barang", "Jumlah", "Harga", "Total harga"
            }
        ));
        tbl_transaksi_manager.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_transaksi_manager.setRowHeight(25);
        tbl_transaksi_manager.setRowMargin(5);
        tbl_transaksi_manager.setSelectionBackground(new java.awt.Color(122, 72, 221));
        tbl_transaksi_manager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_transaksi_managerMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_transaksi_manager);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 302, 940, 180));

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        txt_cetak_laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_print_25px.png"))); // NOI18N
        txt_cetak_laporan.setText("Cetak Laporan");
        txt_cetak_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cetak_laporanActionPerformed(evt);
            }
        });

        txt_keyword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_keywordActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_25px.png"))); // NOI18N
        jLabel9.setText("Cari Data");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(txt_cetak_laporan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 466, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(32, 32, 32)
                .addComponent(txt_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cetak_laporan))
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 245, 940, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        // memfungsikan button kembali
        new FormManager().show();
        this.dispose();
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void txt_id_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_transaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_transaksiActionPerformed

    private void tbl_transaksi_managerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_transaksi_managerMouseClicked
        // memfungsikan clickmouse tabel 
        
        int i = tbl_transaksi_manager.getSelectedRow();
        TableModel model = tbl_transaksi_manager.getModel();
        txt_id_transaksi.setText(model.getValueAt(i, 0).toString());
        txt_tanggal.setText(model.getValueAt(i, 1).toString());
        txt_nama_barang.setText(model.getValueAt(i, 2).toString());
        txt_jumlah.setText(model.getValueAt(i, 3).toString());
        txt_harga.setText(model.getValueAt(i, 4).toString());
        txt_total_harga.setText(model.getValueAt(i, 5).toString());
    }//GEN-LAST:event_tbl_transaksi_managerMouseClicked

    private void txt_keywordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_keywordActionPerformed
        // memfungsikan textfield cari
        DefaultTableModel table = (DefaultTableModel) tbl_transaksi_manager.getModel();
        String search = txt_keyword.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tbl_transaksi_manager.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txt_keywordActionPerformed

    private void txt_cetak_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cetak_laporanActionPerformed
        // Button cetak laporan
        try {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("..\\ireport\\ReportTransaksi.jasper"), null, KoneksiHelper.getConnection());
        JasperViewer.viewReport(jp, false);
        } catch(SQLException | JRException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_txt_cetak_laporanActionPerformed

    private void txt_nama_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nama_karyawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nama_karyawanActionPerformed

    private void txt_nama_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nama_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nama_barangActionPerformed

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
            java.util.logging.Logger.getLogger(FormTransaksiManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormTransaksiManager().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_kembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_transaksi_manager;
    private javax.swing.JButton txt_cetak_laporan;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_id_transaksi;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_keyword;
    private javax.swing.JTextField txt_nama_barang;
    private javax.swing.JComboBox<String> txt_nama_karyawan;
    private javax.swing.JTextField txt_tanggal;
    private javax.swing.JLabel txt_total_harga;
    // End of variables declaration//GEN-END:variables
}
