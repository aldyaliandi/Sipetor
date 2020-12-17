/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipetor;

import java.sql.Connection;
import sipetor.connection.SQLConnection;

/**
 *
 * @author Aldy
 */
public class Sipetor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection sql = SQLConnection.getConnection();
    }

    private static class Coonection {

        public Coonection() {
        }
    }
    
}
