package com.tech.blog.entities;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class Enrollment {
	private String department;
    private int year;
    private String period;
    private String courseID;
    private int roll;
    private int mid;
    private int ass;
    private int quiz;
    private int fin;

    public Enrollment( int year, String period,int roll, String department,String courseID) {
        this.department = department;
        this.year = year;
        this.period = period;
        this.courseID = courseID;
        this.roll = roll;
    }
    
    public Enrollment(int mid, int ass, int quiz, int fin,int roll,String courseID) {
        this.mid = mid;
        this.ass = ass;
        this.quiz = quiz;
        this.fin = fin;
        this.roll = roll;
        this.courseID = courseID;
    }

    // Getters and setters for fields initialized in the second constructor

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getAss() {
        return ass;
    }

    public void setAss(int ass) {
        this.ass = ass;
    }

    public int getQuiz() {
        return quiz;
    }

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int roll) {
        this.roll = roll;
    }
    public int getroll() {
        return year;
    }

    public void setroll(int roll) {
        this.roll = roll;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
}