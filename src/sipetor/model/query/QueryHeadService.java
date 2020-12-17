/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.model.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sipetor.connection.SQLConnection;
import sipetor.model.Golongan;
import sipetor.model.HeadService;
import sipetor.model.interfaces.InterfaceHeadService;

/**
 *
 * @author Aldy
 */
public class QueryHeadService implements InterfaceHeadService{
    private Connection conn = SQLConnection.getConnection();
    
    @Override
    public boolean insert(HeadService p) {
        String sql = "INSERT INTO head_trans_penjualan values (?,?,?,?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, p.getId_transaksi());
            statement.setString(2, p.getId_karyawan());
            statement.setString(3, p.getTnkb_pelanggan());
            statement.setString(4, p.getTanggal_transaksi());
            statement.setInt(5, p.getPembayaran());
            statement.setInt(6, p.getSub_total());
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(HeadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(HeadService p) {
        String sql = "UPDATE head_trans_penjualan "
                + "SET pembayaran=?, sub_total=? tanggal_transaksi=? "
                + "WHERE id_transaksi=? AND id_karyawan=? AND tnkb_pelanggan=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, p.getPembayaran());
            statement.setInt(2, p.getSub_total());
            statement.setString(3, p.getTanggal_transaksi());
            statement.setString(4, p.getId_transaksi());
            statement.setString(5, p.getId_karyawan());
            statement.setString(6, p.getTnkb_pelanggan());
            
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(HeadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String id_transaksi) {
        String sql = "DELETE FROM head_trans_penjualan "
                + "where id_transaksi=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, id_transaksi);
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(HeadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<HeadService> getAllHeadService() {
        List<HeadService> listHeadService = new ArrayList<>();
        String sql = "Select * from head_trans_penjualan";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);

                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    HeadService p = new HeadService(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6)
                    );
                    listHeadService.add(p);
                }
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(HeadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHeadService;
    }

    @Override
    public HeadService getOneHeadServiceByID(String tnkb) {
        HeadService output = null;
        String sql = "Select * from head_trans_penjualan where tnkb=?";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, tnkb);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    output = new HeadService(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6)
                    );
                }
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(HeadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    @Override
    public List<HeadService> getAllHeadServiceByNama(String nama_pelanggan) {
    List<HeadService> listHeadService = new ArrayList<>();
        String sql = "Select a.*,b.nama_pelanggan "
                + "from head_trans_penjualan a "
                + "JOIN pelanggan b "
                + "ON a.tnkb_pelanggan = b.tnkb "
                + "WHERE b.nama_pelanggan like %?%";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, nama_pelanggan);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    HeadService p = new HeadService(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getInt(6)
                    );
                    listHeadService.add(p);
                }
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(HeadService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHeadService;
    }

    @Override
    public String generateID() {
        String id_transaksi = "";
        String sql = "EXEC genIDTransaksi";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                id_transaksi = rs.getString(1);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Golongan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_transaksi;
    }
    
}
