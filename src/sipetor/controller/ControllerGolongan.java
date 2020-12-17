
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.controller;

import java.util.List;
import sipetor.model.Golongan;
import sipetor.model.query.QueryGolongan;

/**
 *
 * @author aldy
 */
public class ControllerGolongan {
    private QueryGolongan queryGolongan = new  QueryGolongan();
    
    public List<Golongan> getAllData() {
        return queryGolongan.getAllGolongan();
    }
    
    public boolean insertGolongan(byte id, String name){
        if(id==0 && name.isEmpty()){
            return false;
        } else{
            Golongan gol = new Golongan(id,name);
            return queryGolongan.insert(gol);
        }
    }
    
    public boolean updateGolongan(byte id, String name){
        if(id==0 && name.isEmpty()){
            return false;
        } else{
            Golongan gol = new Golongan(id,name);
            return queryGolongan.update(gol);
        }
    }
    
    public boolean deleteGolongan(byte id){
        return queryGolongan.delete(id);
    }
    
    public int generateID(){
        return queryGolongan.generateID();
    }
}
