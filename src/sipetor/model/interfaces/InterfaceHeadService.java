/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.model.interfaces;

import java.util.List;
import sipetor.model.HeadService;

/**
 *
 * @author Aldy
 */
public interface InterfaceHeadService {
    public boolean insert(HeadService data);
    public boolean update(HeadService data);
    public boolean delete(String id_transaksi);
    public String generateID();
    
    public List<HeadService> getAllHeadService();
    
    public HeadService getOneHeadServiceByID(String id_transaksi);
    
    public List<HeadService> getAllHeadServiceByNama(String nama_pelanggan);
}

