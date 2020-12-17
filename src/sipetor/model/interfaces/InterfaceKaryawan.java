/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.model.interfaces;

import java.util.List;
import sipetor.model.Karyawan;

/**
 *
 * @author Aldy
 */
public interface InterfaceKaryawan {
    public boolean insert(Karyawan data);
    public boolean update(Karyawan data);
    public boolean delete(String nik);
    
    public List<Karyawan> getAllKaryawan();
    
    public Karyawan getOneKaryawanByID(String nik);
    
    public List<Karyawan> getAllKaryawanByName(String nama_karyawan);
    
}
