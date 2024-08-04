package com.tech.blog.entities;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class assCourse {
    private int sem;
    private String dep;
    private String acid;
    private String acname;
    

    public assCourse(int sem, String dep, String acid, String acname ) {
        this.sem = sem;
        this.dep = dep;
        this.acid=acid;
        this.acname=acname;
    }
    public assCourse() {
		}

    public int getsem() {
        return sem;
    }
    public void setsem(int sem) {
        this.sem = sem;
    }

    public String getdep() {
        return dep;
    }
    public void setdep(String dep) {
        this.dep = dep;
    }
    public String getacid() {
        return acid;
    }
    public void setacid(String acid) {
        this.acid = acid;
    }public String getacname() {
        return acname;
    }
    public void setacname(String acname) {
        this.acname = acname;
    }
}
