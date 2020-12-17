/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor.model.interfaces;

import sipetor.model.Login;
import java.util.List;

/**
 *
 * @author Aldy
 */
public interface InterfaceLogin {

    public String isCorrect(String username, String password);
    public boolean insertLogin(Login data);
    public boolean updateLogin(Login data);
    public boolean deleteLogin(String nik);
}

