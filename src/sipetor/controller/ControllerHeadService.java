/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.controller;

import java.util.List;
import sipetor.model.HeadService;
import sipetor.model.query.QueryHeadService;

/**
 *
 * @author Aldy
 */
public class ControllerHeadService {
    private QueryHeadService queryHeadService = new  QueryHeadService();
    
    public List<HeadService> getAllData() {
        return queryHeadService.getAllHeadService();
    }
    
    public boolean insertHeadService(HeadService data){
        return queryHeadService.insert(data);
    }
    
    public boolean updateHeadService(HeadService data){
        return queryHeadService.update(data);
    }
    
    public boolean deleteHeadService(String id_transaksi){
        return queryHeadService.delete(id_transaksi);
    }
    
    public String generateID(){
        return queryHeadService.generateID();
    }
}


