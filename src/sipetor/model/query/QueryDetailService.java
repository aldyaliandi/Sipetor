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
import sipetor.model.DetailService;
import sipetor.model.interfaces.InterfaceDetailService;

/**
 *
 * @author Aldy
 */
public class QueryDetailService implements InterfaceDetailService{
    private Connection conn = SQLConnection.getConnection();
    @Override
    public boolean insert(DetailService p) {
        String sql = "INSERT INTO detail_trans_penjualan values (?,?,?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, p.getId_reg());
            statement.setString(2, p.getId_transaksi());
            statement.setString(3, p.getId_sparepart());
            statement.setInt(4, p.getJumlah_beli());
            statement.setInt(5, p.getTotal_beli());
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DetailService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(DetailService p) {
        String sql = "UPDATE detail_trans_penjualan "
                + "SET jumlah_beli=?, total_beli=? "
                + "WHERE id_transaksi=? AND id_sparepart=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, p.getJumlah_beli());
            statement.setInt(2, p.getTotal_beli());
            statement.setString(3, p.getId_transaksi());
            statement.setString(4, p.getId_sparepart());
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DetailService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String id_transaksi,String id_sparepart) {
        String sql = "DELETE FROM detail_trans_penjualan "
                + "where id_transaksi=? AND id_sparepart=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, id_transaksi);
            statement.setString(2, id_sparepart);
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DetailService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<DetailService> getAllDetailService() {
        List<DetailService> listDetailService = new ArrayList<>();
        String sql = "Select * from detail_trans_penjualan";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);

                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    DetailService p = new DetailService(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getInt(5)
                    );
                    listDetailService.add(p);
                }
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDetailService;
    }

    @Override
    public DetailService getOneDetailServiceByID(String tnkb) {
        DetailService output = null;
        String sql = "Select * from detail_trans_penjualan where tnkb=?";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, tnkb);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    output = new DetailService(rs.getInt(1),rs.getString(2),
                            rs.getString(3),rs.getInt(4),rs.getInt(5));
                }
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    @Override
    public List<DetailService> getAllDetailServiceByID(String id_transaksi) {
    List<DetailService> listDetailService = new ArrayList<>();
        String sql = "SELECT * FROM detail_trans_penjualan "
                + "WHERE id_transaksi like %?%";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id_transaksi);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    DetailService p = new DetailService(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getInt(5)
                    );
                    listDetailService.add(p);
                }
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetailService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDetailService;
    }

    @Override
    public int generateID() {
        int id_detail = 0;
        String sql = "EXEC genIDDetail";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                id_detail = rs.getInt(1);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DetailService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_detail;
    }

    @Override
    public int generateIDReg() {
        int id_reg = 0;
        String sql = "EXEC generateIDReg";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                id_reg = rs.getInt(1);
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DetailService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_reg;
    }
    
}

