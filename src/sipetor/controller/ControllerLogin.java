
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.controller;

import java.util.List;
import sipetor.model.Login;
import sipetor.model.query.QueryLogin;

/**
 *
 * @author takahashidandy
 */
public class ControllerLogin {
    private QueryLogin queryLogin = new  QueryLogin();
    
    public String checkLogin(String username, String password){
        return queryLogin.isCorrect(username, password);
    }
    
    public boolean insertLogin(Login data){
        return queryLogin.insertLogin(data);
    }
    
    public boolean updateLogin(Login data){
        return queryLogin.updateLogin(data);
    }
    
    public boolean deleteLogin(String nik){
        return queryLogin.deleteLogin(nik);
    }

   

   
}
