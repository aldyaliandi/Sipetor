/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.model.interfaces;

import java.util.List;
import sipetor.model.Pelanggan;

/**
 *
 * @author Aldy
 */
public interface InterfacePelanggan {
  public boolean insert(Pelanggan data);
    public boolean update(Pelanggan data);
    public boolean delete(String id_pelanggan);
    
    public List<Pelanggan> getAllPelanggan();
    
    public Pelanggan getOnePelangganByID(String id_pelanggan);
    
    public List<Pelanggan> getAllPelangganByName(String nama_pelanggan);
    
}
