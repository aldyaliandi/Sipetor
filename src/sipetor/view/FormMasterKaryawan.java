/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.view;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sipetor.controller.ControllerGolongan;
import sipetor.controller.ControllerKaryawan;
import sipetor.model.Karyawan;
import sipetor.model.Golongan;

/**
 *
 * @author Aldy
 */
public class FormMasterKaryawan extends javax.swing.JDialog {
    private final ControllerKaryawan controllerKaryawan = new ControllerKaryawan();
    private final ControllerGolongan controllerGolongan = new ControllerGolongan();
    

    /**
     * Creates new form JDialogKaryawan
     */
    public FormMasterKaryawan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTableKaryawan(controllerKaryawan.getAllData());
        setComboGolongan(controllerGolongan.getAllData());
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ppTabel = new javax.swing.JPopupMenu();
        mnDelete = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdKaryawan = new javax.swing.JTextField();
        txtNamaKaryawan = new javax.swing.JTextField();
        cbxGolongan = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lblOutput = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKaryawan = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtEmailKaryawan = new javax.swing.JTextField();
        txtAlamatKaryawan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        mnDelete.setText("Delete");
        mnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDeleteActionPerformed(evt);
            }
        });
        ppTabel.add(mnDelete);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Field Golongan")));

        jLabel2.setText("NIK Karyawan");

        jLabel3.setText("Nama Karyawan");

        txtIdKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdKaryawanActionPerformed(evt);
            }
        });

        txtNamaKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaKaryawanActionPerformed(evt);
            }
        });

        cbxGolongan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGolonganActionPerformed(evt);
            }
        });

        jLabel1.setText("Alamat Karyawan");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Aksi"));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblOutput)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addGap(130, 130, 130)
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnClear)
                    .addComponent(btnClose))
                .addGap(29, 29, 29)
                .addComponent(lblOutput)
                .addGap(41, 41, 41))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Output"));

        tblKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Golongan"
            }
        ));
        tblKaryawan.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblKaryawanAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKaryawanMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblKaryawanMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblKaryawan);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel4.setText("Email Karyawan");

        jLabel5.setText("Golongan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxGolongan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNamaKaryawan)
                            .addComponent(txtEmailKaryawan)
                            .addComponent(txtAlamatKaryawan)
                            .addComponent(txtIdKaryawan))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNamaKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addComponent(txtAlamatKaryawan))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmailKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxGolongan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String nik = txtIdKaryawan.getText();
        String nama_karyawan = txtNamaKaryawan.getText();
        String alamat_karyawan = txtAlamatKaryawan.getText();
        String email_karyawan = txtEmailKaryawan.getText();
        String cbx = cbxGolongan.getSelectedItem().toString();
        
        //kode pengambilan kode golongan di combobox
        char[] id= new char [1];
        for(int x =0; x< cbx.length(); x++){
            if(cbx.charAt(x) != '_'){
                id[x] = cbx.charAt(x);
            }else{
                break;
            }
        }
        //return kode sebagai byte
        byte id_golongan = Byte.parseByte(new String(id));
        
        Karyawan data = new Karyawan(
                nik,
                nama_karyawan,
                alamat_karyawan,
                email_karyawan,
                id_golongan
        ); 
        if(btnSimpan.getText().equals("Simpan")){
            if(controllerKaryawan.insertKaryawan(data)){
                lblOutput.setText("Insert Berhasil");
            }else{
                lblOutput.setText("Insert Gagal");
            }
        }else{
            if(controllerKaryawan.updateKaryawan(data)){
                lblOutput.setText("Update Berhasil");
            }else{
                lblOutput.setText("Update Gagal");
            }
        }
        setClear();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        setClear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void tblKaryawanAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblKaryawanAncestorAdded
        
    }//GEN-LAST:event_tblKaryawanAncestorAdded

    private void tblKaryawanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKaryawanMousePressed
        if(evt.getClickCount() == 2){
            int idxrow = tblKaryawan.getSelectedRow();
            txtIdKaryawan.setText(tblKaryawan.getModel().getValueAt(idxrow, 0).toString());
            txtNamaKaryawan.setText(tblKaryawan.getModel().getValueAt(idxrow, 2).toString());
            txtAlamatKaryawan.setText(tblKaryawan.getModel().getValueAt(idxrow, 3).toString());
            txtEmailKaryawan.setText(tblKaryawan.getModel().getValueAt(idxrow, 4).toString());
            btnSimpan.setText("Update");
        }
       if(evt.isPopupTrigger()){
           ppTabel.show(tblKaryawan, evt.getX(), evt.getY());
       }
    }//GEN-LAST:event_tblKaryawanMousePressed
    private void setTableKaryawan(List<Karyawan> listKaryawan) {
        if (listKaryawan==null){
            JOptionPane.showMessageDialog(this, "Data karyawan gagal diambil dari database",
                     "DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        }else{
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(
                    new String[] {
                        "NIK",
                        "GOLONGAN",
                        "Nama Karyawan",
                        "Alamat Karyawan",
                        "Email Karyawan"
                    }
            );
            
            for (Karyawan g : listKaryawan) {
                Object[] o = new Object[5];
                o[0] = g.getNik();
                o[1] = g.getId_golongan();
                o[2] = g.getNama_karyawan();
                o[3] = g.getAlamat_karyawan();
                o[4] = g.getEmail_karyawan();
                tableModel.addRow(o);
            }
            tblKaryawan.setAutoResizeMode( javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            tblKaryawan.setModel(tableModel);
        }
    }
    private void setComboGolongan (List <Golongan> listGolongan){
        if (listGolongan==null){
            JOptionPane.showMessageDialog(this, "Data golongan gagal diambil dari database",
                        "DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        }else{
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for(Golongan g : listGolongan){
                model.addElement(g.getId_golongan() + "_" +g.getNama_golongan());
            }
        
            cbxGolongan.setModel(model);
        }
        }
    
    private void setClear(){
        txtIdKaryawan.setText(" ");
        txtNamaKaryawan.setText(" ");
        txtAlamatKaryawan.setText(" ");
        txtEmailKaryawan.setText(" ");
        cbxGolongan.setSelectedIndex(0);
        btnSimpan.setText("Simpan");
        setTableKaryawan(controllerKaryawan.getAllData());
        
    }
    
    private void tblKaryawanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKaryawanMouseReleased
        if(evt.getClickCount() == 2){
            int idxrow = tblKaryawan.getSelectedRow();
            txtIdKaryawan.setText(tblKaryawan.getModel().getValueAt(idxrow, 0).toString());
            txtNamaKaryawan.setText(tblKaryawan.getModel().getValueAt(idxrow, 2).toString());
            txtAlamatKaryawan.setText(tblKaryawan.getModel().getValueAt(idxrow, 3).toString());
            txtEmailKaryawan.setText(tblKaryawan.getModel().getValueAt(idxrow, 4).toString());
            btnSimpan.setText("Update");

        }
        if(evt.isPopupTrigger()){
            ppTabel.show(tblKaryawan, evt.getX(), evt.getY());
        }
        
    }//GEN-LAST:event_tblKaryawanMouseReleased

    private void mnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDeleteActionPerformed
        int result = JOptionPane.showConfirmDialog(rootPane,
                "Apakah Yakin Untuk Didelete?",
                "Delete Dialog", JOptionPane.YES_NO_OPTION);
         if(result == JOptionPane.YES_OPTION){
             String nik = tblKaryawan.getModel().getValueAt(tblKaryawan.getSelectedRow(), 0).toString();
             controllerKaryawan.deleteKaryawan(nik);
             setClear();    
    }    
    }//GEN-LAST:event_mnDeleteActionPerformed

    private void txtIdKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdKaryawanActionPerformed

    private void cbxGolonganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGolonganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxGolonganActionPerformed

    private void txtNamaKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaKaryawanActionPerformed

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
            java.util.logging.Logger.getLogger(FormMasterKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMasterKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMasterKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMasterKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormMasterKaryawan dialog = new FormMasterKaryawan(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cbxGolongan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOutput;
    private javax.swing.JMenuItem mnDelete;
    private javax.swing.JPopupMenu ppTabel;
    private javax.swing.JTable tblKaryawan;
    private javax.swing.JTextField txtAlamatKaryawan;
    private javax.swing.JTextField txtEmailKaryawan;
    private javax.swing.JTextField txtIdKaryawan;
    private javax.swing.JTextField txtNamaKaryawan;
    // End of variables declaration//GEN-END:variables

}