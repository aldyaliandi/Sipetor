/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.controller;

import java.util.List;
import sipetor.model.Karyawan;
import sipetor.model.query.QueryKaryawan;

/**
 *
 * @author Aldy
 */
public class ControllerKaryawan {
    private QueryKaryawan queryKaryawan = new QueryKaryawan();
    
    public List<Karyawan> getAllData() {
        return queryKaryawan.getAllKaryawan();
    }
    
    public List<Karyawan> getAllKaryawanByName(String nama_karyawan) {
        return queryKaryawan.getAllKaryawanByName(nama_karyawan); 
    }
    
    public boolean insertKaryawan(Karyawan data) {
        return queryKaryawan.insert(data);
    }

    public boolean updateKaryawan(Karyawan data) {
        return queryKaryawan.update(data);
    }
    
    public boolean deleteKaryawan(String nik) {
        return queryKaryawan.delete(nik);  
    }
}
    