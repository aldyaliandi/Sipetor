/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.controller;

import java.util.List;
import sipetor.model.Karyawan;
import sipetor.model.Pelanggan;
import sipetor.model.query.QueryKaryawan;
import sipetor.model.query.QueryPelanggan;

/**
 *
 * @author Aldy
 */
public class ControllerPelanggan {
    private QueryPelanggan queryPelanggan = new QueryPelanggan();
    
    public List<Pelanggan> getAllData() {
        return queryPelanggan.getAllPelanggan();
    }
    
    public List<Pelanggan> getAllPelangganByName(String nama_pelanggan) {
        return queryPelanggan.getAllPelangganByName(nama_pelanggan); 
    }
    
    public boolean insertPelanggan(Pelanggan data) {
        return queryPelanggan.insert(data);
    }

    public boolean updatePelanggan(Pelanggan data) {
        return queryPelanggan.update(data);
    }
    
    public boolean deletePelanggan(String id_pelanggan) {
        return queryPelanggan.delete(id_pelanggan);  
    }
}
    