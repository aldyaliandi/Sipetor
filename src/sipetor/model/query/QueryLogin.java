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
import java.util.logging.Level;
import java.util.logging.Logger;
import sipetor.connection.SQLConnection;
import sipetor.model.Karyawan;
import sipetor.model.Login;
import sipetor.model.interfaces.InterfaceLogin;


/**
 *
 * @author takahashidandy
 */

public class QueryLogin implements InterfaceLogin {
    private Connection conn = SQLConnection.getConnection();
    
    @Override
    public String isCorrect(String username, String password) {
        String nama_karyawan = "";
        String sql = "select a.*,b.nama_karyawan" +
                    " from login a INNER JOIN karyawan b" +
                    " ON a.nik = b.nik" +
                    " WHERE a.username = ? AND a.password LIKE ?";
        try {
            if (SQLConnection.getConnection()==null){
                return nama_karyawan;
            }else{
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, password);
                
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    nama_karyawan = rs.getString(4); // rs.getString("nama_karyawan");
                    return nama_karyawan;
                }
                statement.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Karyawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nama_karyawan;
    }

    @Override
    public boolean insertLogin(Login data) {
        String sql = "INSERT INTO login VALUES (?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, data.getNik());
            statement.setString(2, data.getUsername());
            statement.setString(3, data.getPassword());
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Karyawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateLogin(Login data) {
        String sql = "UPDATE login SET password=?"
                + " WHERE nik=? AND username like ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, data.getPassword());
            statement.setString(2, data.getNik());
            statement.setString(3, data.getUsername());
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Karyawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean deleteLogin(String nik) {
        String sql = "DELETE FROM login WHERE nik=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, nik);
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Karyawan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
