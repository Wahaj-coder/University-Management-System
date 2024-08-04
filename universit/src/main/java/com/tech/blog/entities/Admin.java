package com.tech.blog.entities;
import java.sql.*;
public class Admin {
    private String ID;
    private String Password;
    

    public Admin(String ID, String Password) {
        this.ID = ID;
        this.Password = Password;
    }
    public Admin() {
		}

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
}
