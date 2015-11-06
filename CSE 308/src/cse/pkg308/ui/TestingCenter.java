/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.pkg308.ui;

import cse.pkg308.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
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
    private Date startclosed;
    private Date endclosed;
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
    public void setOpens(Date opens, String term) {
        String query = "UPDATE `scheduler`.`testingcenter` SET Opens='" + opens + "' WHERE term = '" + term + "'";
        DBConnection.ExecUpdateQuery(query);
        
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
    public void setCloses(Date closes, String term) {
        String query = "UPDATE `scheduler`.`testingcenter` SET Closes='" + closes + "' WHERE term = '" + term + "'";
        DBConnection.ExecUpdateQuery(query);
        
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
                setOpens(rs.getTime(3), term);
                setCloses(rs.getTime(4), term);
                setSetasideseats(rs.getInt(5), term);
                setTerm(rs.getString(6));
                setGaptime(rs.getTime(7), term);
                setReminder(rs.getTime(8));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @return the startclosed
     */
    public Date getStartclosed() {
        return startclosed;
    }

    /**
     * @param startclosed the startclosed to set
     */
    public void setStartclosed(Date startclosed) {
        this.startclosed = startclosed;
    }

    /**
     * @return the endclosed
     */
    public Date getEndclosed() {
        return endclosed;
    }

    /**
     * @param endclosed the endclosed to set
     */
    public void setEndclosed(Date endclosed) {
        this.endclosed = endclosed;
    }
    
    public void addClosedDates(Date start, Date end)
    {
        start = getStartclosed();
        end = getEndclosed();
        
        int id = 0;
        
        String query = "Select (Max(rangeid) + 1) from closedranges";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        
        try {
            while(rs.next())
            {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      /*  query = "INSERT INTO `scheduler`.`closedranges` (`term`, `closedstart`, `rangeid`, "
                + "`closedend`) VALUES ('" + getTerm() + "', '" + start + "', '" + id + "', '" + end + "')";
        
        DBConnection.ExecUpdateQuery(query);*/
        
        Date curs =  start;
        
        System.out.println(end);
        
        while(curs.getTime() < end.getTime())
        {
            System.out.println(curs);
            query = "INSERT INTO `scheduler`.`closeddates` (`date`, `term`) VALUES ('" + curs + "', '" + getTerm() + "')";
            DBConnection.ExecUpdateQuery(query);
            
            curs.setDate(curs.getDate() + 1);
            
        }
    }
    
    public void removeClosedDates(Date start, Date end)
    {
        
        Date curs =  start;
        
        while(curs.getTime() < end.getTime())
        {
            String query = "Delete from `scheduler`.`closeddates` where Date = '" + curs + "'";
            DBConnection.ExecUpdateQuery(query);
            
            curs.setDate(curs.getDate() + 1);
            
        }
    }
    
    public void addnonsbtime(Time start, Time end)
    {
        String query = "Select Max(rangeid) + 1 from nonsbtimes";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        
        int id = 0;
        
        try {
            while(rs.next())
            {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        query = "INSERT INTO `scheduler`.`nonsbtimes` (`rangeid`, `term`, `starttime`, `endtime`) "
                + "VALUES ('" + id + "', '" + getTerm() + "', '" + start + "', '" + end + "')";
        DBConnection.ExecUpdateQuery(query);
    }
    
    public String[] getNonSBTimes(){
        ArrayList <String> nonsb = new ArrayList();
        
        String query = "Select starttime, endtime from nonsbtimes where term = '" + getTerm() + "'";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        
        try {
            while(rs.next())
            {
                nonsb.add(rs.getString(1) + "-" + rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String [] nonsbarray = new String [nonsb.size()];
        
        for(int i = 0; i < nonsbarray.length; i++)
        {
            nonsbarray[i] = nonsb.get(i);
        }
        
        return nonsbarray;
    }

}
