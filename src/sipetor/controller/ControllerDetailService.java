/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.controller;

import java.util.List;
import sipetor.model.DetailService;
import sipetor.model.query.QueryDetailService;

/**
 *
 * @author Aldy
 */
public class ControllerDetailService {
    private QueryDetailService queryDetailService = new  QueryDetailService();
    
    public List<DetailService> getAllData() {
        return queryDetailService.getAllDetailService();
    }
    
    public boolean insertDetailService(DetailService data){
        return queryDetailService.insert(data);
    }
    
    public boolean updateDetailService(DetailService data){
        return queryDetailService.update(data);
    }
    
    public boolean deleteDetailService(String id_transaksi, String id_sparepart){
        return queryDetailService.delete(id_transaksi,id_sparepart);
    }
    
    public int generateID(){
        return queryDetailService.generateID();
    }
    
    public int generateIDReg(){
        return queryDetailService.generateID();
    }
}
