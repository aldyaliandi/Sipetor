/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.model.interfaces;

import sipetor.model.Golongan;
import java.util.List;

/**
 *
 * @author Aldy
 */
public interface InterfaceGolongan {
    public boolean insert (Golongan data);
    public boolean update (Golongan data);
    public boolean delete (byte id_golongan);
    public int generateID();
    
    public List<Golongan> getAllGolongan();
    
    public Golongan getOneGolonganByID(byte id_golongan);
    
    public List<Golongan> getAllGolonganbyName(String nama_golongan);

}
