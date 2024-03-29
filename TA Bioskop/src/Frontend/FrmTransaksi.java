/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC-HP
 */
public class FrmTransaksi extends javax.swing.JFrame {

    /**
     * Creates new form FrmTransaksi
     */
    public FrmTransaksi() {
        initComponents();
        tampilkanCmbFilm();
        kosongkanForm();
        tampilkanData();
    }

    public void kosongkanForm() {
        cmbFilm.setSelectedIndex(0);
        cmbHari.setSelectedIndex(0);
        txtJmlhTiket.setText("");
        txtTotalHarga.setText("");
        txtJmlhSnack.setText("0");
    }

    public void tampilkanCmbFilm() {
        cmbFilm.setModel(new DefaultComboBoxModel(new Film().getAll().toArray()));
    }

    public void tampilTotalHarga() {
        Transaksi trnsks = new Transaksi();
        System.out.println(trnsks.getTotalHarga()+totalSnack());
    }
  
    public int totalSnack(){
        int total= 0;
        String pilih = (String) cmbSnack.getSelectedItem();
        switch(pilih){           
            case "Coca Cola":
                CocaCola cocaCola= new CocaCola();
                cocaCola.cocaCola();
                cocaCola.setJumlah(Integer.parseInt(txtJmlhSnack.getText()));
                total+= cocaCola.totalHarga();
                break;
            case "Pop Corn":
                PopCorn popCorn = new PopCorn();
                popCorn.Popcorn();
                popCorn.setJumlah(Integer.parseInt(txtJmlhSnack.getText()));
                total += popCorn.totalHarga();
                break;
            case "Paket 1":
                Paket1 paket1 = new Paket1();
                paket1.Popcorn();
                paket1.cocaCola();
                total += paket1.totalHarga();
                break;
            case "Paket 2":
                Paket2 paket2 = new Paket2();
                paket2.Popcorn();
                paket2.cocaCola();
                total += paket2.totalHarga();
                break;
        }
    return total;
    }
    
     public void tampilkanData(){
    String[]kolom ={"Film","Jadwal"};
    ArrayList<Film>list = new Film().getAll();
    Object rowData[] =  new Object[2];
    
    tblJadwal.setModel(new DefaultTableModel(new Object[][]{}, kolom));
    
    for (Film film : list){
        rowData[0] = film.getJudul();
        rowData[1] = film.getKeterangan();
        ((DefaultTableModel)tblJadwal.getModel()).addRow(rowData);
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

        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFilm = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbFilm = new javax.swing.JComboBox<>();
        cmbHari = new javax.swing.JComboBox<>();
        txtJmlhTiket = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTotalHarga = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        lblSelamat = new javax.swing.JLabel();
        btnBeli = new javax.swing.JButton();
        btnSelesai = new javax.swing.JButton();
        cmbSnack = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtJmlhSnack = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblJadwal = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        tblFilm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblFilm);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Jadwal");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Film");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Hari");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tiket");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Total Harga");

        cmbFilm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbHari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu" }));
        cmbHari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHariActionPerformed(evt);
            }
        });

        txtTotalHarga.setColumns(20);
        txtTotalHarga.setRows(5);
        jScrollPane1.setViewportView(txtTotalHarga);

        jLabel5.setFont(new java.awt.Font("OCR-A BT", 1, 48)); // NOI18N
        jLabel5.setText("Tiket Bioskop");

        lblSelamat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSelamat.setText("               Selamat Datang di XXI Movie");
        lblSelamat.setFocusable(false);
        lblSelamat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnBeli.setText("Beli");
        btnBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBeliActionPerformed(evt);
            }
        });

        btnSelesai.setText("Selesai");
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });

        cmbSnack.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Menu", "Coca Cola", "Pop Corn", "Paket 1", "Paket 2" }));
        cmbSnack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbSnackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmbSnackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmbSnackMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Snack");

        txtJmlhSnack.setText("0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Jumlah");

        tblJadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJadwalMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblJadwal);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Jadwal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbSnack, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtJmlhSnack, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBeli)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSelesai))
                            .addComponent(cmbHari, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJmlhTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(173, 173, 173))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(186, 186, 186))
            .addGroup(layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(lblSelamat, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtJmlhTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbSnack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtJmlhSnack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBeli)
                            .addComponent(btnSelesai)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(lblSelamat, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBeliActionPerformed
        // TODO add your handling code here:
        Transaksi trnsks = new Transaksi();
        trnsks.setFilm((Film) cmbFilm.getSelectedItem());
        trnsks.setHari((String) cmbHari.getSelectedItem());
        trnsks.setJmlhtiket(Integer.parseInt(txtJmlhTiket.getText()));
        trnsks.setTotalHarga(trnsks.totalHarga()+totalSnack());
        trnsks.save();
        txtTotalHarga.setText(Integer.toString(trnsks.totalHarga));
        lblSelamat.setText("Terima Kasih Atas Kunjungan Anda di XXI Movie");
    }//GEN-LAST:event_btnBeliActionPerformed

    private void cmbHariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHariActionPerformed
        // TODO add your handling code here:
        Transaksi trnsks = new Transaksi();
        trnsks.setHari((String) cmbHari.getSelectedItem());
    }//GEN-LAST:event_cmbHariActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
        // TODO add your handling code here:
        kosongkanForm();
        lblSelamat.setText("Selamat Datang di XXI Movie");
    }//GEN-LAST:event_btnSelesaiActionPerformed

    private void cmbSnackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSnackMouseEntered
        // TODO add your handling code here:
        if(cmbSnack.getSelectedIndex()>2){
        txtJmlhSnack.setEnabled(false);
        txtJmlhSnack.setText("0");
        }else{
        txtJmlhSnack.setEnabled(true);
        }
    }//GEN-LAST:event_cmbSnackMouseEntered

    private void cmbSnackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSnackMouseExited
        // TODO add your handling code here:
        if(cmbSnack.getSelectedIndex()>2){
        txtJmlhSnack.setEnabled(false);
        txtJmlhSnack.setText("0");
        }else{
        txtJmlhSnack.setEnabled(true);
        }
    }//GEN-LAST:event_cmbSnackMouseExited

    private void cmbSnackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSnackMouseClicked
        // TODO add your handling code here:
         if(cmbSnack.getSelectedIndex()>2){
        txtJmlhSnack.setEnabled(false);
        txtJmlhSnack.setText("0");
        }else{
        txtJmlhSnack.setEnabled(true);
        }
    }//GEN-LAST:event_cmbSnackMouseClicked

    private void tblJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJadwalMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblJadwalMouseClicked

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
            java.util.logging.Logger.getLogger(FrmTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBeli;
    private javax.swing.JButton btnSelesai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JComboBox<String> cmbFilm;
    private javax.swing.JComboBox<String> cmbHari;
    private javax.swing.JComboBox<String> cmbSnack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblSelamat;
    private javax.swing.JTable tblFilm;
    private javax.swing.JTable tblJadwal;
    private javax.swing.JTextField txtJmlhSnack;
    private javax.swing.JTextField txtJmlhTiket;
    private javax.swing.JTextArea txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}
