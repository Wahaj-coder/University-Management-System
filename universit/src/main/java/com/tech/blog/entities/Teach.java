package com.tech.blog.entities;
import java.time.LocalDate;
import java.sql.*;
public class Teach {
    private int TeacherID;
    private String TName;
    private String Addr;
    private String Gender;
    private String Email;
    private String Password;
    private LocalDate DoB; // Changed to LocalDate
    private String Contact;// Changed to LocalDate
    private String qualification;

    public Teach( String TName,int TeacherID, String Addr, String Gender, String Email, String Password, LocalDate DoB, String Contact, String qualification) {
        this.TName = TName;
        this.TeacherID = TeacherID;
        this.Addr = Addr;
        this.Gender = Gender;
        this.Email = Email;
        this.Password = Password;
        this.DoB = DoB;
        this.Contact = Contact;
        this.qualification = qualification;
    }
    public Teach() {
		
		}

    // Getters and Setters
    // TeacherID
    public int getTeacherID() {
        return TeacherID;
    }
    public void setTeacherID(int TeacherID) {
        this.TeacherID = TeacherID;
    }

    // TName
    public String getTName() {
        return TName;
    }
    public void setTName(String TName) {
        this.TName = TName;
    }

    // Addr
    public String getAddr() {
        return Addr;
    }
    public void setAddr(String Addr) {
        this.Addr = Addr;
    }

    // Gender
    public String getGender() {
        return Gender;
    }
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    // Email
    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }

    // Password
    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }

    // DoB
    public LocalDate getDoB() {
        return DoB;
    }
    public void setDoB(LocalDate DoB) {
        this.DoB = DoB;
    }

    // Contact
    public String getContact() {
        return Contact;
    }
    public void setContact(String Contact) {
        this.Contact = Contact;
    }
    // qualification
    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
