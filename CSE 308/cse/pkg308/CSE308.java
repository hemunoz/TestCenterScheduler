/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg308;

import cse.pkg308.DBConnection;
import cse.pkg308.ui.schedulesession;
import cse.pkg308.ui.Login;
import cse.pkg308.ui.Student;
import cse.pkg308.ui.User;
import cse.pkg308.ui.StudentTakeAnExam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class CSE308 {

    static Login login = new Login();
    static User user = new User();
    
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        user.startlogin();
        
        
        /*String query = "SELECT * from student";
        
        //Connection connection = DBConnection.getconnection();
        //System.out.println(connection);
            
            java.sql.ResultSet rs = DBConnection.ExecQuery(query);
            //System.out.println(DBConnection.getconnection());
        try {
            while (rs.next()) {
                
                System.out.println(rs.getString(1));
            } 
        } catch (SQLException ex) {
            Logger.getLogger(CSE308.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        query = "SELECT * from user";
        
        //Connection connection = DBConnection.getconnection();
        //System.out.println(connection);
            
            rs = DBConnection.ExecQuery(query);
            //System.out.println(DBConnection.getconnection());
        try {
            while (rs.next()) {
                
                System.out.println(rs.getString(1));
            } 
        } catch (SQLException ex) {
            Logger.getLogger(CSE308.class.getName()).log(Level.SEVERE, null, ex);
        }*/
            
    }
    
}
