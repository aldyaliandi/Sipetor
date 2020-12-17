/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.model.interfaces;

import java.util.List;
import sipetor.model.Sparepart;

/**
 *
 * @author Aldy
 */
public interface InterfaceSparepart {
    public boolean insert (Sparepart data);
    public boolean update (Sparepart data);
    public boolean delete (int id_sparepart);
    public int generateID();
    
    public List<Sparepart> getAllSparepart();
    
    public Sparepart getOneSparepartByID(int id_sparepart);
    
    public List<Sparepart> getAllSparepartbyName(String nama_sparepart);

}
