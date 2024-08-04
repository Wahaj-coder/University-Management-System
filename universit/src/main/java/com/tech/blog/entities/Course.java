package com.tech.blog.entities;
import java.sql.*;
public class Course {
    private String CID;
    private String CName;
    private String Dep;
    private String TID;

    public Course(String CID, String CName, String Dep, String TID) {
        this.CID = CID;
        this.CName = CName;
        this.Dep = Dep;
        this.TID = TID;
    }
    public Course() {
		}

    public String getCID() {
        return CID;
    }
    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getCName() {
        return CName;
    }
    public void setCName(String CName) {
        this.CName = CName;
    }
    public String getDep() {
        return Dep;
    }
    public void setDep(String Dep) {
        this.Dep = Dep;
    }
    public String getTID() {
        return TID;
    }
    public void setTID(String TID) {
        this.TID = TID;
    }
}
