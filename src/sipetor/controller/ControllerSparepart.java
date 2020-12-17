/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.controller;

import java.util.List;
import sipetor.model.Sparepart;
import sipetor.model.query.QuerySparepart;

/**
 *
 * @author Aldy
 */
public class ControllerSparepart {
    private QuerySparepart querySparepart = new QuerySparepart();
   
    public List<Sparepart> getAllData(){
        return querySparepart.getAllSparepart();
    }
    
    public boolean insertSparepart(int id, String name, int harga_sparepart, int stock_sparepart){
        if(id==0 && name.isEmpty()){
            return false;
        }else{
            Sparepart spa = new Sparepart(id, name, harga_sparepart, stock_sparepart);
            return querySparepart.insert(spa);
        }
    }
    
    public boolean updateSparepart(int id, String name, int harga_sparepart, int stock_sparepart){
        if(id==0 && name.isEmpty()){
            return false;
        }else{
            Sparepart spa = new Sparepart(id, name, harga_sparepart, stock_sparepart);
            return querySparepart.update(spa);
        }
    }
    
    public boolean deleteSparepart(int id_sparepart){
        return querySparepart.delete(id_sparepart);
    }
    public int generateID(){
        return querySparepart.generateID();
    }
    
    
    public List<Sparepart> getAllSparepartByName(String nama_sprepart) {
        return querySparepart.getAllSparepartbyName(nama_sprepart); 
    }
    

}
