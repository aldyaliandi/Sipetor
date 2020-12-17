/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sipetor.controller.ControllerDetailService;
import sipetor.controller.ControllerHeadService;
import sipetor.controller.ControllerKaryawan;
import sipetor.controller.ControllerPelanggan;
import sipetor.controller.ControllerSparepart;
import sipetor.model.DetailService;
import sipetor.model.HeadService;
import sipetor.model.Karyawan;
import sipetor.model.Pelanggan;
import sipetor.model.Sparepart;

/**
 *
 * @author Aldy
 */
public class FormTransaksi extends javax.swing.JFrame {
    ControllerKaryawan controllerKaryawan = new ControllerKaryawan();
    ControllerPelanggan controllerPelanggan = new ControllerPelanggan();
    ControllerSparepart controllerSparepart = new ControllerSparepart();
    ControllerDetailService controllerDetailService = new ControllerDetailService();
    ControllerHeadService controllerHeadService = new ControllerHeadService();
    List<DetailService> collection = new ArrayList<>();
    int totalpembelian =0;
    float ppn = 0;
    float grandtotal =0;
    
    public FormTransaksi() {
        initComponents();
        initData();
    }

 

    public void initData(){
        Calendar c = Calendar.getInstance();
        String date = c.get(Calendar.YEAR) +"/"+ (c.get(Calendar.MONTH)+1) +"/"+c.get(Calendar.DATE);
        lblTanggal.setText(date);
        lblIdTransaksi.setText(controllerHeadService.generateID()+"");
        setTableDetail(collection);
    }
    
    private void setTablePelanggan(List<Pelanggan> listPelanggan) {
        if (listPelanggan==null){
            JOptionPane.showMessageDialog(this, "Data "
                    + "Pelanggan gagal diambil dari database","DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        }else{
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(
                    new String[] {
                        "Id Pelanggan",
                        "Nama Pelanggan",
                        "Alamat Pelanggan"
                    }
            );
            
            for (Pelanggan g : listPelanggan) {
                Object[] o = new Object[3];
                o[0] = g.getId_pelanggan();
                o[1] = g.getNama_pelanggan();
                o[2] = g.getAlamat_pelanggan();
                tableModel.addRow(o);
            }
            tblResult.setAutoResizeMode( javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            tblResult.setModel(tableModel);
            }
        }
    
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
            tblResult.setAutoResizeMode( javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            tblResult.setModel(tableModel);
        }
    }
    private void setTableSparepart(List<Sparepart> listSparepart) {
        if (listSparepart==null){
            JOptionPane.showMessageDialog(this, "Data "
                    + "Sparepart gagal diambil dari database","DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        }else{
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(
                    new String[] {
                        "id Sparepart",
                        "nama Sparepart",
                        "harga Sparepart",
                        "stock Sparepart"
                    }
            );
            
            for (Sparepart s : listSparepart) {
                Object[] o = new Object[4];
                o[0] = s.getId_sparepart();
                o[1] = s.getNama_sparepart();
                o[2] = s.getHarga_sparepart();
                o[3] = s.getStock_sparepart();
                tableModel.addRow(o);
            }
            tblResult.setAutoResizeMode( javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            tblResult.setModel(tableModel);
            }
        }
    
    private void setTableDetail(List<DetailService> listDetailService) {
        if (listDetailService==null){
            JOptionPane.showMessageDialog(this, "Data "
                    + "Sparepart gagal diambil dari database","DATABASE FAILED", JOptionPane.ERROR_MESSAGE);
        }else{
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(
                    new String[] {
                        "Id Registrasi",
                        "Id Transaksi",
                        "Id Sparepart",
                        "Jumlah Beli",
                        "Total Beli"
                    }
            );
            
            for (DetailService g : listDetailService) {
                Object[] o = new Object[5];
                o[0] = controllerDetailService.generateIDReg();
                o[1] = g.getId_transaksi();
                o[2] = g.getId_sparepart();
                o[3] = g.getJumlah_beli();
                o[4] = g.getTotal_beli();
                tableModel.addRow(o);
            }
            tblDetaill.setAutoResizeMode( javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            tblDetaill.setModel(tableModel);
            //tbl result dan detail teh yang mana ?
            }
        }
    
    private void setClear(){
       Calendar c = Calendar.getInstance();
       String date = c.get(Calendar.YEAR) +"/"+ c.get(Calendar.MONTH) +"/"+ c.get(Calendar.DATE);
       lblTanggal.setText(date);
       lblIdTransaksi.setText(controllerHeadService.generateID()+"");
       lblIdKaryawan.setText("id_karyawan");
       lblNamaMontir.setText("id_montir");
       lblTnkb.setText("tnkb_pelanggan");
       lblNamaPelanggan.setText("nama_pelanggan");
       
       //membersihakn data detail transaksi
       collection.clear();
       setTableDetail(collection);
       
       
       //membersihkan data perhitungan
       lblTotalPembelian.setText("0");
       lblPpn.setText("0");
       lblGrandTot.setText("0");
       txtPembayaran.setText("0");
       lblKembalian.setText("0");
      
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel20 = new javax.swing.JLabel();
        txtPencarian = new javax.swing.JTextField();
        searchData = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTanggal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblIdTransaksi = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTnkb = new javax.swing.JLabel();
        lblNamaPelanggan = new javax.swing.JLabel();
        BtnPelanggan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblIdKaryawan = new javax.swing.JLabel();
        lblNamaMontir = new javax.swing.JLabel();
        BtnMontir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetaill = new javax.swing.JTable();
        BtnTambahDetail = new javax.swing.JButton();
        BtnDeleteDetail = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblTotalPembelian = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblPpn = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblGrandTot = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtPembayaran = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        BtnSimpan = new javax.swing.JButton();
        BtnClear = new javax.swing.JButton();
        BtnClose = new javax.swing.JButton();
        lblKembalian = new javax.swing.JLabel();

        jLabel20.setText("Nama");

        txtPencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPencarianKeyTyped(evt);
            }
        });

        searchData.setText("Cari");
        searchData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDataActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hasil Pencarian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14)))); // NOI18N

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
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
        tblResult.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblResultAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblResultMousePressed(evt);
            }
        });
        tblResult.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblResultKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tblResult);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(28, 28, 28)
                        .addComponent(txtPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchData)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Head Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14)))); // NOI18N

        jLabel1.setText("Tanggal");

        lblTanggal.setText("zxz");

        jLabel3.setText("ID Transaksi");

        lblIdTransaksi.setText("xx");

        jLabel5.setText("TNKB");

        lblTnkb.setText("x");

        lblNamaPelanggan.setText("xz");

        BtnPelanggan.setText("Search Pelanggan");
        BtnPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPelangganActionPerformed(evt);
            }
        });

        jLabel8.setText("Montir");

        lblIdKaryawan.setText("s");

        lblNamaMontir.setText("sds");

        BtnMontir.setText("Search Montir");
        BtnMontir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMontirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblIdKaryawan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTnkb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNamaPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNamaMontir, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnPelanggan)
                            .addComponent(BtnMontir))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTanggal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblIdTransaksi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTnkb)
                    .addComponent(lblNamaPelanggan)
                    .addComponent(BtnPelanggan))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnMontir)
                    .addComponent(lblNamaMontir)
                    .addComponent(lblIdKaryawan)
                    .addComponent(jLabel8)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detail Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblDetaill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Registrasi", "Id Transaksi", "Id Sparepart", "Jumlah Beli", "Total Beli"
            }
        ));
        tblDetaill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDetaillMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblDetaill);

        BtnTambahDetail.setText("+");
        BtnTambahDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahDetailActionPerformed(evt);
            }
        });

        BtnDeleteDetail.setText("-");
        BtnDeleteDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteDetailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(BtnTambahDetail)
                        .addGap(18, 18, 18)
                        .addComponent(BtnDeleteDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnDeleteDetail)
                    .addComponent(BtnTambahDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detail Pembayaran", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel11.setText("Total Pembelian");

        lblTotalPembelian.setText("jj");

        jLabel13.setText("PPN 10%");

        lblPpn.setText("bjb");

        jLabel15.setText("Grand Total");

        lblGrandTot.setText("mbm");

        jLabel17.setText("Jumlah Bayar");

        txtPembayaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPembayaranKeyTyped(evt);
            }
        });

        jLabel18.setText("Kembali");

        BtnSimpan.setText("Simpan");
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });

        BtnClear.setText("Clear");
        BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClearActionPerformed(evt);
            }
        });

        BtnClose.setText("Close");
        BtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCloseActionPerformed(evt);
            }
        });

        lblKembalian.setText("h");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTotalPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnSimpan))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblGrandTot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                        .addComponent(BtnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPpn)
                            .addComponent(lblKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(lblTotalPembelian))
                    .addComponent(BtnSimpan))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblPpn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lblGrandTot)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(BtnClear)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnClose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblKembalian))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnTambahDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahDetailActionPerformed
        setTableSparepart(controllerSparepart.getAllData());
        jDialog1.setVisible(true);
    }//GEN-LAST:event_BtnTambahDetailActionPerformed

    private void BtnPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPelangganActionPerformed
        setTablePelanggan(controllerPelanggan.getAllData());
        jDialog1.requestFocusInWindow();
        jDialog1.setVisible(true);
    }//GEN-LAST:event_BtnPelangganActionPerformed

    private void BtnMontirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMontirActionPerformed
        setTableKaryawan(controllerKaryawan.getAllData());
        jDialog1.setVisible(true);
    }//GEN-LAST:event_BtnMontirActionPerformed

    private void BtnDeleteDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteDetailActionPerformed
        if(collection.size()>= 0){
            totalpembelian -= collection.get(0).getTotal_beli();
            lblTotalPembelian.setText(totalpembelian+"");
            ppn = totalpembelian * 0.1f;
            grandtotal = totalpembelian + ppn;
            lblPpn.setText(ppn + "");
            lblGrandTot.setText(grandtotal + "");
            collection.remove(0);
            setTableDetail(collection);
        }
    }//GEN-LAST:event_BtnDeleteDetailActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        HeadService head = new HeadService(
                lblIdTransaksi.getText(), lblIdKaryawan.getText(),
                lblTnkb.getText(), lblTanggal.getText(),
                Integer.parseInt(txtPembayaran.getText()),
                Integer.parseInt(lblTotalPembelian.getText())
        );
        controllerHeadService.insertHeadService(head);
        
        for(DetailService data : collection){
            DetailService detail = new DetailService(
            controllerDetailService.generateID(), data.getId_transaksi(),
            data.getId_sparepart(),data.getJumlah_beli(),
            data.getTotal_beli()
         );
         controllerDetailService.insertDetailService(detail);
        }
        setClear();
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearActionPerformed
        setClear();
    }//GEN-LAST:event_BtnClearActionPerformed

    private void BtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnCloseActionPerformed

    private void txtPembayaranKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPembayaranKeyTyped
        if(evt.getKeyCode() == 0){
            if(!txtPembayaran.getText().equals("")){
                int money = Integer.parseInt(txtPembayaran.getText());
                float change = money - grandtotal;
                lblKembalian.setText((change < 0 ? 0+"" : change+""));
            }
        }
    }//GEN-LAST:event_txtPembayaranKeyTyped

    private void txtPencarianKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPencarianKeyTyped
        String colName = tblResult.getColumnModel().getColumn(0).getHeaderValue().toString();
        if(colName.equals("NIK")){
            setTableKaryawan(controllerKaryawan.getAllKaryawanByName(txtPencarian.getText()));
        } else if(colName.equals("Id Pelanggan")){
            setTablePelanggan(controllerPelanggan.getAllPelangganByName(txtPencarian.getText()));
        } else {
            setTableSparepart(controllerSparepart.getAllSparepartByName(txtPencarian.getText()));
        }
    }//GEN-LAST:event_txtPencarianKeyTyped

    private void tblDetaillMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetaillMousePressed
       
    }//GEN-LAST:event_tblDetaillMousePressed

    private void tblResultAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblResultAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tblResultAncestorAdded

    private void tblResultKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblResultKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tblResultKeyTyped

    private void tblResultMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultMousePressed
         if(evt.getClickCount() == 2){
            String colName = tblResult.getColumnModel().getColumn(0).getHeaderValue().toString();
            int idxrow = tblResult.getSelectedRow();
            if(colName.equals("NIK")){
                lblIdKaryawan.setText(tblResult.getModel().getValueAt(idxrow, 0).toString());
                lblNamaMontir.setText(tblResult.getModel().getValueAt(idxrow, 2).toString());
            }else if(colName.equals("Id Pelanggan")){
                lblTnkb.setText(tblResult.getModel().getValueAt(idxrow, 0).toString());
                lblNamaPelanggan.setText(tblResult.getModel().getValueAt(idxrow, 2).toString());
            }else{
                int id_reg = 0;
                String id_transaksi = lblIdTransaksi.getText();
                String id_sparepart = tblResult.getModel().getValueAt(idxrow, 0).toString();
                int jumlah_beli = 1;
                int stotal_beli = Integer.parseInt(tblResult.getModel().getValueAt(idxrow,2).toString());
                int total_beli = jumlah_beli * stotal_beli;
                
                DetailService data = new DetailService(id_reg, id_transaksi,
                        id_sparepart, jumlah_beli,
                        total_beli);
                totalpembelian += total_beli;
                lblTotalPembelian.setText(totalpembelian+"");
                ppn = totalpembelian * 0.1f;
                grandtotal = totalpembelian + ppn;
                lblPpn.setText(ppn + "");
                lblGrandTot.setText(grandtotal + "");
                collection.add(data);
                
            }
            jDialog1.dispose();
            setTableDetail(collection);
        }
    }//GEN-LAST:event_tblResultMousePressed

    private void searchDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchDataActionPerformed

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
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnClose;
    private javax.swing.JButton BtnDeleteDetail;
    private javax.swing.JButton BtnMontir;
    private javax.swing.JButton BtnPelanggan;
    private javax.swing.JButton BtnSimpan;
    private javax.swing.JButton BtnTambahDetail;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGrandTot;
    private javax.swing.JLabel lblIdKaryawan;
    private javax.swing.JLabel lblIdTransaksi;
    private javax.swing.JLabel lblKembalian;
    private javax.swing.JLabel lblNamaMontir;
    private javax.swing.JLabel lblNamaPelanggan;
    private javax.swing.JLabel lblPpn;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblTnkb;
    private javax.swing.JLabel lblTotalPembelian;
    private javax.swing.JButton searchData;
    private javax.swing.JTable tblDetaill;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextField txtPembayaran;
    private javax.swing.JTextField txtPencarian;
    // End of variables declaration//GEN-END:variables
}
