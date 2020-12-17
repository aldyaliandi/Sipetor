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
import sipetor.model.Pelanggan;
import sipetor.model.interfaces.InterfacePelanggan;

/**
 *
 * @author Aldy
 */
public class QueryPelanggan implements InterfacePelanggan {
    private Connection conn = SQLConnection.getConnection();
    private String Id_pelanggan;

    @Override
    public boolean insert(Pelanggan p) {
        String sql = "INSERT INTO pelanggan values (?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, p.getId_pelanggan());
            statement.setString(2, p.getNama_pelanggan());
            statement.setString(3, p.getAlamat_pelanggan());
            int row = statement.executeUpdate();
            if (row > 0){
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return false;
    }

    @Override
    public boolean update(Pelanggan p) {
         String sql = "UPDATE pelanggan SET nama_pelanggan=?, alamat_pelanggan=? WHERE tnkb=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            
            statement.setString(1, p.getNama_pelanggan());
            statement.setString(2, p.getAlamat_pelanggan());
            statement.setString(3, p.getId_pelanggan());
            int row = statement.executeUpdate();
            if (row > 0){
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return false;
    }

    @Override
    public boolean delete(String id_pelanggan) {
         String sql = "DELETE FROM pelanggan where tnkb=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, id_pelanggan);
            int row = statement.executeUpdate();
            if (row > 0){
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return false;
    }

    @Override
    public List<Pelanggan> getAllPelanggan() {
      List<Pelanggan> listPelanggan = new ArrayList<>();
        String sql = "Select * from pelanggan";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    Pelanggan p = new Pelanggan (
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3)
                    );
                    listPelanggan.add(p);
                }
                statement.close();
            }
        }catch (SQLException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex); 
    }
    return listPelanggan;
}   
    @Override
    public Pelanggan getOnePelangganByID(String id_pelanggan) {
        Pelanggan output = null;
        String sql = "Select * from pelanggan where id_pelanggan=?";
        try{
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id_pelanggan);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    output = new Pelanggan(rs.getString(1), rs.getString(2), rs.getString(3));        
            }
            statement.close();
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(Golongan.class.getName()).log(Level.SEVERE, null, ex);    
    }
    return output;
    }
    

    @Override
    public List<Pelanggan> getAllPelangganByName(String nama_pelanggan) {
        List<Pelanggan> listPelanggan = new ArrayList<>();
        String sql = "Select * from pelanggan WHERE nama_pelanggan like '%"+nama_pelanggan+"%'";
        try {
            if (SQLConnection.getConnection()==null){
                return null;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    Pelanggan p = new Pelanggan (
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3)
                    );
                    listPelanggan.add(p);
                }
                statement.close();
            }
        }catch (SQLException ex) {
            Logger.getLogger(Golongan.class.getName()).log(Level.SEVERE, null, ex); 
    }
    return listPelanggan;
}
    }

