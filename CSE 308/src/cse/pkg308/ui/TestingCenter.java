/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.pkg308.ui;

import java.util.Date;
import cse.pkg308.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class TestingCenter {

    private int seats;
    private Date opens;
    private Date closes;
    private int setasideseats;
    private String Term;
    private Date gaptime;
    private static Date reminder;
    private Date[] closeddates;
    public String id;

    public TestingCenter() {

    }

    public String getId() {
        return id;
    }

    /**
     * @param seats the seats to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(int seats, String term) {
        String query = "UPDATE `scheduler`.`testingcenter` SET seats='" + seats + "' WHERE term = '" + term + "'";
        
        DBConnection.ExecUpdateQuery(query);
        
        this.seats = seats;
    }

    /**
     * @return the opens
     */
    public Date getOpens() {
        return opens;
    }

    /**
     * @param opens the opens to set
     */
    public void setOpens(Date opens) {
        this.opens = opens;
    }

    /**
     * @return the closes
     */
    public Date getCloses() {
        return closes;
    }

    /**
     * @param closes the closes to set
     */
    public void setCloses(Date closes) {
        this.closes = closes;
    }

    /**
     * @return the setasideseats
     */
    public int getSetasideseats() {
        return setasideseats;
    }

    /**
     * @param setasideseats the setasideseats to set
     */
    public void setSetasideseats(int setasideseats, String term) {
        String query = "UPDATE `scheduler`.`testingcenter` SET setasideseats='" + setasideseats + "' WHERE term = '" + term + "'";
        
        DBConnection.ExecUpdateQuery(query);
        
        this.setasideseats = setasideseats;
    }

    /**
     * @return the Term
     */
    public String getTerm() {
        return Term;
    }

    /**
     * @param Term the Term to set
     */
    public void setTerm(String Term) {
        this.Term = Term;
    }

    /**
     * @return the gaptime
     */
    public Date getGaptime() {
        return gaptime;
    }

    /**
     * @param gaptime the gaptime to set
     */
    public void setGaptime(Date gaptime, String term) {
        String query = "UPDATE `scheduler`.`testingcenter` SET gaptime='" + gaptime + "' WHERE term = '" + term + "'";
        
        DBConnection.ExecUpdateQuery(query);
        
        this.gaptime = gaptime;
    }

    /**
     * @return the reminder
     */
    public static Date getReminderForTime() {
        String query = "Select reminderinterval from testingcenter where testingcenterid = '1'";
        java.sql.ResultSet rs1 = DBConnection.ExecQuery(query);

        try {
            while (rs1.next()) {
                reminder = rs1.getTime(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reminder;
    }
    
    public Date getReminder(){
        return reminder;
    }

    /**
     * @param reminder the reminder to set
     */
    public void setReminder(Date reminder) {
        String query = "UPDATE `scheduler`.`testingcenter` SET `reminderinterval`='" + reminder + "'";
        DBConnection.ExecUpdateQuery(query);
        
        this.reminder = reminder;
    }

    /**
     * @return the closeddates
     */
    public Date[] getCloseddates() {
        return closeddates;
    }

    /**
     * @param closeddates the closeddates to set
     */
    public void setCloseddates(Date[] closeddates) {
        this.closeddates = closeddates;
    }

    public void editseats(int seats) {

    }

    public void newterm(String term) {
        String query = "Select (max(testingcenterid) + 1) from testingcenter";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

        String id = "";

        try {
            while (rs.next()) {
                id = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        query = "INSERT INTO `scheduler`.`testingcenter` (`testingcenterID`, `seats`, "
                + "`Opens`, `Closes`, `setasideseats`, `term`, `gaptime`, `reminderinterval`) "
                + "VALUES ('" + id + "', '100', '10:00:00', '19:00:00', '20', "
                + "'" + term + "', '00:30:00', '01:00:00')";
        DBConnection.ExecUpdateQuery(query);

        query = "Select * from testingcenter where testingcenterid = '" + id + "'";

        rs = DBConnection.ExecQuery(query);

        try {
            while (rs.next()) {
                setId(rs.getString(1));
                setSeats(rs.getInt(2), term);
                setOpens(rs.getTime(3));
                setCloses(rs.getTime(4));
                setSetasideseats(rs.getInt(5), term);
                setTerm(rs.getString(6));
                setGaptime(rs.getTime(7), term);
                setReminder(rs.getTime(8));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
