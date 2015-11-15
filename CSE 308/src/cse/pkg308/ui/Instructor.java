package cse.pkg308.ui;

import cse.pkg308.ui.InstructorUI;
import cse.pkg308.ui.User;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructor extends User {

    private JFrame frameInstructorInterface;

    private String department;

    /**
     * Create the application.
     */
    public Instructor() {

    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }
}
