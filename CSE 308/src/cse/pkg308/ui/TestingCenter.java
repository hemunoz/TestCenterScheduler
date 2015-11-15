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
import java.util.Calendar;
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
        String query = "UPDATE `scheduler`.`testingcenter` SET seats='" + seats + "' where term ='" + term + "'";

        DBConnection.ExecUpdateQuery(query);

        this.seats = seats;
    }

    public void editseats(int seats, String term) {
        int newseats = seats;//new number of seats
        int getseats = 0;//current seats in the testing center
        Calendar cal = Calendar.getInstance();
        java.sql.Date newdate = new java.sql.Date(cal.getTimeInMillis());
        

        String query = "Select seats from testingcenter where term = '" + term + "'";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

        try {
            while (rs.next()) {
                getseats = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }

        query = "Select individualid, seatsavailable from individualexam where date > '" + newdate + "'";
        rs = DBConnection.ExecQuery(query);

        try {
            while (rs.next()) {

                /*
                The new seats available for an exam equals the new number of setaside seats 
                minus the number of appointments that have been made for that exam.
                The number of appointments is the current number of testing center setaside
                seats minus the setaside seats available
                */
                newseats = seats - (getseats - rs.getInt(2));

                /*
                This query inserts the new setaside seats available into the individualexam
                table of the database
                */
                String query2 = "UPDATE individualexam SET seatsavailable = '" + newseats + "' "
                        + "WHERE individualid = '" + rs.getString(1) + "'";
                DBConnection.ExecUpdateQuery(query2);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        /*
        Set the opens time testingcenter table in the database to the selected time
        */
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
        /*
        Set the closes time testingcenter table in the database to the selected time
        */
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
        /*
        Set the setaside seats in the testing center to the number entered
        */
        String query = "UPDATE `scheduler`.`testingcenter` SET setasideseats='" + setasideseats + "'";

        DBConnection.ExecUpdateQuery(query);

        this.setasideseats = setasideseats;
    }
    
    public void editsetaside(int setasideseats, String term) {
        int newseats = setasideseats;//new number of setaside seats
        int getseats = 0;//current setaside seats in the testing center
        Calendar cal = Calendar.getInstance();
        java.sql.Date newdate = new java.sql.Date(cal.getTimeInMillis());//Date in SQL format
        
        /*
        This query gets the current number of setaside seats for the selected term
        */
        String query = "Select setasideseats from testingcenter where term = '" + term + "'";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

        try {
            while (rs.next()) {
                getseats = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        We only need to edit the seats for future dates. This query gets the exams
        for all later dates and their setaside seats available
        */
        query = "Select individualid, setasideavailable from individualexam where date > '" + newdate + "'";
        rs = DBConnection.ExecQuery(query);

        try {
            while (rs.next()) {

                /*
                The new seats available for an exam equals the new number of setaside seats 
                minus the number of appointments that have been made for that exam.
                The number of appointments is the current number of testing center setaside
                seats minus the setaside seats available
                */
                newseats = setasideseats - (getseats - rs.getInt(2));

                /*
                This query inserts the new setaside seats available into the individualexam
                table of the database
                */
                String query2 = "UPDATE individualexam SET setasideavailable = '" + newseats + "' "
                        + "WHERE individualid = '" + rs.getString(1) + "'";
                DBConnection.ExecUpdateQuery(query2);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        /*
        Set the gaptime in the testingcenter table to the selected time
        */
        String query = "UPDATE `scheduler`.`testingcenter` SET gaptime='" + gaptime + "'";

        DBConnection.ExecUpdateQuery(query);

        this.gaptime = gaptime;
    }

    /**
     * @return the reminder
     */
    public Date getReminderForTime() {
        /*
        This query returns the testing center reminder interval
        */
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

    public Date getReminder() {
        return reminder;
    }

    /**
     * @param reminder the reminder to set
     */
    public void setReminder(Date reminder) {
        /*
        Inserts the new reminder interval into the testingcenter table of the database
        */
        String query = "UPDATE `scheduler`.`testingcenter` SET `reminderinterval`='" + reminder + "'";
        DBConnection.ExecUpdateQuery(query);

        this.reminder = reminder;
    }

    public void newterm(String term) {
        /*
        Get a new testingcenter ID to insert into the testingcenter table
        */
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

        /*
        Default information to be entered for the new term in the testingcenter table.
        */
        query = "INSERT INTO `scheduler`.`testingcenter` (`testingcenterID`, `seats`, "
                + "`Opens`, `Closes`, `setasideseats`, `term`, `gaptime`, `reminderinterval`) "
                + "VALUES ('" + id + "', '100', '10:00:00', '19:00:00', '20', "
                + "'" + term + "', '00:30:00', '01:00:00')";
        DBConnection.ExecUpdateQuery(query);

        /*
        Get the new testingcenter information to be inserted into the testing center object
        */
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

    public void addClosedDates(Date start, Date end) {
        start = getStartclosed();
        end = getEndclosed();

        int id = 0;

        /*
        This query gets the new highest closed range ID
        */
        String query = "Select (Max(rangeid) + 1) from closedranges";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

        try {
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }

       /*   query = "INSERT INTO `scheduler`.`closedranges` (`term`, `closedstart`, `rangeid`, "
         + "`closedend`) VALUES ('" + getTerm() + "', '" + start + "', '" + id + "', '" + end + "')";
        
         DBConnection.ExecUpdateQuery(query);*/
        Date curs = start;

        //System.out.println(end);

        /*
        From the start to end date, add each date to the closeddates table where the testing
        center will be closed on that date for the selected term
        */
        while (curs.getTime() < end.getTime()) {
            //System.out.println(curs);
            query = "INSERT INTO `scheduler`.`closeddates` (`date`, `term`) VALUES ('" + curs + "', '" + getTerm() + "')";
            DBConnection.ExecUpdateQuery(query);

            curs.setDate(curs.getDate() + 1);

        }
    }

    public void removeClosedDates(Date start, Date end) {

        Date curs = start;

        while (curs.getTime() < end.getTime()) {
            String query = "Delete from `scheduler`.`closeddates` where Date = '" + curs + "'";
            DBConnection.ExecUpdateQuery(query);

            curs.setDate(curs.getDate() + 1);

        }
    }

    public void addnonsbtime(Time start, Time end) {
        /*
        Get the new highest nonsb time range
        */
        String query = "Select Max(rangeid) + 1 from nonsbtimes";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

        int id = 0;

        try {
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        Enter the new time range the testing center is reserved for non stony brook exams
        on the selected term into the nonsbtimes table of the database with the start 
        and end times
        */
        query = "INSERT INTO `scheduler`.`nonsbtimes` (`rangeid`, `term`, `starttime`, `endtime`) "
                + "VALUES ('" + id + "', '" + getTerm() + "', '" + start + "', '" + end + "')";
        DBConnection.ExecUpdateQuery(query);
    }

    public String[] getNonSBTimes() {
        ArrayList<String> nonsb = new ArrayList();

        /*
        This query gets all the time periods where the testing center is reserved
        for non stony brook exams for the selected term
        */
        String query = "Select starttime, endtime from nonsbtimes where term = '" + getTerm() + "'";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

        try {
            while (rs.next()) {
                nonsb.add(rs.getString(1) + "-" + rs.getString(2));//Add range in String to ArrayList
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        Create a duplicate array to store the ArrayList of ranges
        */
        String[] nonsbarray = new String[nonsb.size()];

        for (int i = 0; i < nonsbarray.length; i++) {
            nonsbarray[i] = nonsb.get(i);
        }

        return nonsbarray;
    }

    public String pastutilization(Date date) {
        Calendar cal = Calendar.getInstance();

        int seats = 0;//Number of seats
        int numappointments = 0;//Number of appointments made on the date
        Date gaptime = cal.getTime();
        Date open = cal.getTime();
        Date close = cal.getTime();

        String season = "";

        /*
        Check for the term by the month that was entered
        */
        if (date.getMonth() == 1) {
            season = "Winter";
        } else if (date.getMonth() >= 2 && date.getMonth() <= 5) {
            season = "Spring";
        } else if (date.getMonth() >= 6 && date.getMonth() <= 7) {
            season = "Summer";
        } else {
            season = "Fall";
        }

        String term = season + " " + (date.getYear() + 1900);//Term

        /*
        This query returns the seats, gap time, open time, and closing time of the
        testing center for the selected term
        */
        String query = "Select seats, gaptime, opens, closes from testingcenter where term = '" + term + "'";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

        try {
            while (rs.next()) {
                seats = rs.getInt(1);
                gaptime = rs.getTime(2);
                open = rs.getTime(3);
                close = rs.getTime(4);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        Get the time the testing center was open by getting the difference
        of the closing time by the opening time
        */
        Date diff = cal.getTime();
        diff.setHours(close.getHours() - open.getHours());
        diff.setMinutes(close.getMinutes() - open.getMinutes());

        /*
        Add minutes to hours times 60 to get the minutes the testing center is open
        */
        int minutes = diff.getMinutes() + diff.getHours() * 60;
        int gaptimeminutes = gaptime.getMinutes();//Gap time minutes

        /*
        Convert selected date to SQL format
        */
        cal.set(Calendar.YEAR, date.getYear() + 1900);
        cal.set(Calendar.MONTH, date.getMonth());
        cal.set(Calendar.DAY_OF_MONTH, date.getDate());
        java.sql.Date newdate = new java.sql.Date(cal.getTimeInMillis());

        int totalminutes = 0;

        /*
        This query gets the exam time of an exam where an appointment for the exam has
        the selected date
        */
        query = "Select e.starttime, e.endtime from appointment a, forexam f, exam e where a.appointmentid = "
                + "f.appointmentid AND f.examID = e.examID AND a.date = '" + newdate + "'";
        rs = DBConnection.ExecQuery(query);

        try {
            while (rs.next()) {
                /*
                Get the total minutes in the exam appointment
                */
                int diffhours = rs.getTime(2).getHours() - rs.getTime(1).getHours();
                int diffminutes = rs.getTime(2).getMinutes() - rs.getTime(1).getMinutes();
                totalminutes = totalminutes + diffminutes + diffhours * 60 + gaptimeminutes;

                numappointments++;

            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        Convert number of seats to a double
        */
        double dseats = seats * 1.0;
        /*
        final utilization
        */
        double utilization = totalminutes / (dseats * minutes);

        /*
        Result for the utilization. Must be in HTML to create a newline character so
        the String will not be displayed in one line
        */
        String result = "<html> Testing Center Hours: " + open + "-" + close + "<br></br> Seats: " + seats
                + "<br></br> Appointments: " + numappointments + "<br></br> Utilization on " + newdate
                + ": " + utilization + "</html>";

        return result;

    }

    public String futureutilization(Date date) {
        Calendar cal = Calendar.getInstance();

        int seats = 0;//Number of seats
        int numappointments = 0;//Total number of appointments
        int numexams = 0;//Total number of exams
        Date gaptime = cal.getTime();
        Date open = cal.getTime();
        Date close = cal.getTime();

        String season = "";

        /*
        Get the term based on the selected date
        */
        if (date.getMonth() == 1) {
            season = "Winter";
        } else if (date.getMonth() >= 2 && date.getMonth() <= 5) {
            season = "Spring";
        } else if (date.getMonth() >= 6 && date.getMonth() <= 7) {
            season = "Summer";
        } else {
            season = "Fall";
        }

        String term = season + " " + (date.getYear() + 1900);

        /*
        This query returns the seats, gap time, open time, and closing time of the
        testing center for the selected term
        */
        String query = "Select seats, gaptime, opens, closes from testingcenter where term = '" + term + "'";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

        try {
            while (rs.next()) {
                seats = rs.getInt(1);
                gaptime = rs.getTime(2);
                open = rs.getTime(3);
                close = rs.getTime(4);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        Get the time the testing center was open by getting the difference
        of the closing time by the opening time
        */
        Date diff = cal.getTime();
        diff.setHours(close.getHours() - open.getHours());
        diff.setMinutes(close.getMinutes() - open.getMinutes());

        /*
        Add minutes to hours times 60 to get the minutes the testing center is open
        */
        int minutes = diff.getMinutes() + diff.getHours() * 60;
        int gaptimeminutes = gaptime.getMinutes();

        /*
        Convert selected date to SQL format
        */
        cal.set(Calendar.YEAR, date.getYear() + 1900);
        cal.set(Calendar.MONTH, date.getMonth());
        cal.set(Calendar.DAY_OF_MONTH, date.getDate());
        java.sql.Date newdate = new java.sql.Date(cal.getTimeInMillis());

        int totalminutes = 0;

        /*
        This query gets the exam time of an exam where an appointment for the exam has
        the selected date
        */
        query = "Select e.starttime, e.endtime from appointment a, forexam f, exam e where a.appointmentid = "
                + "f.appointmentid AND f.examID = e.examID AND a.date = '" + newdate + "'";
        rs = DBConnection.ExecQuery(query);

        try {
            while (rs.next()) {
                /*
                Get the total minutes in the exam appointment
                */
                int diffhours = rs.getTime(2).getHours() - rs.getTime(1).getHours();
                int diffminutes = rs.getTime(2).getMinutes() - rs.getTime(1).getMinutes();
                totalminutes = totalminutes + diffminutes + diffhours * 60 + gaptimeminutes;
                numappointments++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        Set seats to a double
        */
        double dseats = seats * 1.0;
        /*
        Utilization of testing center
        */
        double utilization = totalminutes / (dseats * minutes);

        Date futureclose = cal.getTime();
        Date futureopen = cal.getTime();
        double expected = 0.0;

        /*
        This query returns the start and end time and exam ID of the individual exam
        with the selected date
        */
        query = "Select i.starttime, i.endtime, i.examid from individualexam i where date = '" + newdate + "'";
        rs = DBConnection.ExecQuery(query);

        try {
            while (rs.next()) {
                /*
                Calculate the total minutes in the exam
                */
                int diffhours = rs.getTime(2).getHours() - rs.getTime(1).getHours();
                int diffminutes = rs.getTime(2).getMinutes() - rs.getTime(1).getMinutes();
                int totalmin = diffminutes + diffhours * 60 + gaptimeminutes;

                /*
                This query gets the total number of students in the course 
                the exam is for
                */
                String query2 = "Select c.students from course c, courseexam ce where"
                        + " ce.examid = '" + rs.getString(3) + "' AND ce.courseidentifier = "
                        + "c.courseID";
                java.sql.ResultSet rs2 = DBConnection.ExecQuery(query2);

                int students = 0;//initialize students in the course

                while (rs2.next()) {
                    students = rs2.getInt(1);
                }

                /*
                This query gets the number of appointments for the current exam
                */
                String query3 = "Select Count(a.appointmentid) from appointment a, forexam f "
                        + "where a.appointmentid = f.appointmentid AND f.examid = '" + rs.getString(3) + "'";
                java.sql.ResultSet rs3 = DBConnection.ExecQuery(query3);

                int appointments = 0;

                while (rs3.next()) {
                    appointments = rs3.getInt(1);
                }

                /*
                This query gets the number of days the current exam will betaken
                */
                String query4 = "Select Count(date) from individualexam where examid = '" + rs.getString(3) + "'";
                java.sql.ResultSet rs4 = DBConnection.ExecQuery(query4);

                int days = 0;

                while (rs4.next()) {
                    days = rs4.getInt(1);
                }

                System.out.println(students + " " + appointments + " " + days);

                double ddays = days * 1.0;

                /*
                Calculate the expected utilization to be the total minutes in the exam
                times the number of students that still need to take the exam
                divided by the days of the exam
                */
                expected = expected + totalmin * (students - appointments) / ddays;

                numexams++;

            }
        } catch (SQLException ex) {
            Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
        }

        expected = expected + utilization;//Expected utilization

        /*
        Result for the utilization. Must be in HTML to create a newline character so
        the String will not be displayed in one line
        */
        String result = "<html> Testing Center Hours: " + open + "-" + close + "<br></br> Seats: " + seats
                + "<br></br> Appointments: " + numappointments + "<br></br> Exams: " + numexams
                + "<br></br> Expected Utilization on " + newdate + ": " + expected + "</html>";

        return result;
    }

}
