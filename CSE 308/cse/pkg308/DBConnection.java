/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg308;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static org.apache.tomcat.jni.User.username;


public class DBConnection {
    static String mysJDBCDriver = "com.mysql.jdbc.Driver";
    //static String url = "jdbc:mysql://mysql2.cs.stonybrook.edu:3306/segert"; //jdbc:mysql://hostname:port number/database name
    //static String username = "segert";//mysql username/netid
    //static String password = "108495858";//mysql password/id number
    static String url = "jdbc:mysql://localhost:3306/scheduler"; //jdbc:mysql://hostname:port number/database name
    static String username = "root";//mysql username/netid
    static String password = "pussycat327";//mysql password/id number
    static java.sql.Connection myConnection = null;
    
    static PreparedStatement myPreparedStatement = null;
    
    public static java.sql.Connection getconnection()
    {
        
        return myConnection;
    }
   
    public static ResultSet ExecQuery(String query){
   // public static java.sql.Connection ExecQuery(String query)
        ResultSet myResultSet = null;
        try{
            if(myConnection == null || (myConnection !=null && !myConnection.isValid(0)))
            {
                Class.forName(mysJDBCDriver).newInstance();
                myConnection = DriverManager.getConnection(url,username,password);
            }
            myPreparedStatement = myConnection.prepareStatement(query);
            myResultSet = myPreparedStatement.executeQuery();
            
        } catch(ClassNotFoundException e)
        {
        }
        catch (SQLException e){
        } catch (InstantiationException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        myConnection = null;
        return  myResultSet;
    }
    
    public static int ExecUpdateQuery(String query){
       int retValue = 0;
        try{
            if(myConnection == null || (myConnection !=null && !myConnection.isValid(0)))
            {
                Class.forName(mysJDBCDriver).newInstance();
                myConnection = DriverManager.getConnection(url,username,password);
            }
            myPreparedStatement = myConnection.prepareStatement(query);
            retValue = myPreparedStatement.executeUpdate();
            
        } catch(ClassNotFoundException e)
        {
        }
        catch (SQLException e){
        } catch (InstantiationException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  retValue;
    }
}

