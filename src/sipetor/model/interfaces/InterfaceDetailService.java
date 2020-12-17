/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.model.interfaces;

import java.util.List;
import sipetor.model.DetailService;

/**
 *
 * @author Aldy
 */
public interface InterfaceDetailService {
    public boolean insert(DetailService data);
    public boolean update(DetailService data);
    public boolean delete(String id_transaksi, String id_sparepart);
    
    public int generateID();
    
    public int generateIDReg();
    
    public List<DetailService> getAllDetailService();
    
    public DetailService getOneDetailServiceByID(String id_transaksi);
    
    public List<DetailService> getAllDetailServiceByID(String id_transaksi);
}

