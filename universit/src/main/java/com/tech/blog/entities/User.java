package com.tech.blog.entities;
import java.time.LocalDate;
import java.sql.*;
public class User {
	private String Name ;
	private String F_Name ;
	private String Email;
	private String Password;
	private String Phone;
	private String Gender;	
	private String Inter_Percent;
    private LocalDate DoB; 
    private String Guardian_Name;
    private String GProf;
    private String G_Salary;
    private String G_Contact;
    private int Year;
    private String Semester;
    private int Roll;
    private String Dep;
	
	
	
	public User(String Name, String F_Name, String Email, String Password, String Phone, String Gender, String Inter_Percent,LocalDate DoB , String Guardian_Name, String GProf, String G_Salary, String G_Contact, int Year, String Semester, int Roll,String Dep) {
		this.Name = Name;
		this.F_Name = F_Name;
		this.Email = Email;
		this.Password = Password;
		this.Phone = Phone;		
		this.Gender = Gender;
		this.Inter_Percent = Inter_Percent;
        this.DoB = DoB; // Set the LocalDate parameter to DoB
        this.Guardian_Name = Guardian_Name;
        this.GProf = GProf;
        this.G_Salary = G_Salary;
        this.G_Contact = G_Contact;
        this.Year = Year;
        this.Semester = Semester;
        this.Roll=Roll;
        this.Dep = Dep;
	}
	public User() {
		
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getF_Name() {
		return F_Name;
	}
	public void setF_Name(String f_Name) {
		F_Name = f_Name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getInter_Percent() {
        return Inter_Percent;
    }
    public void setInter_Percent(String Inter_Percent) {
        this.Inter_Percent = Inter_Percent;
    }
    public LocalDate getDoB() {
        return DoB;
    }

    public void setDoB(LocalDate DoB) {
        this.DoB = DoB;
    }
    // Getter and setter for Guardian
    public String getGuardian_Name() {
        return Guardian_Name;
    }
    public void setGuardian_Name(String Guardian) {
        this.Guardian_Name = Guardian;
    }
    // Getter and setter for GProf
    public String getGProf() {
        return GProf;
    }
    public void setGProf(String GProf) {
        this.GProf = GProf;
    }
    // Getter and setter for G_Salary
    public String getG_Salary() {
        return G_Salary;
    }
    public void setG_Salary(String G_Salary) {
        this.G_Salary = G_Salary;
    }
    // Getter and setter for G_Contact
    public String getG_Contact() {
        return G_Contact;
    }
    public void setG_Contact(String G_Contact) {
        this.G_Contact = G_Contact;
    }
    // Getter and setter for Year
    public int getYear() {
        return Year;
    }
    public void setYear(int Year) {
        this.Year = Year;
    }
    // Getter and setter for Semester
    public String getSemester() {
        return Semester;
    }
    public void setSemester(String Semester) {
        this.Semester = Semester;
    }
    // Getter and setter for Roll
    public int getRoll() {
        return Roll;
    }
    public void setRoll(int Roll) {
        this.Roll = Roll;
    }
    // Getter and setter for Dep
    public String getDep() {
        return Dep;
    }
    public void setDep(String Dep) {
        this.Dep = Dep;
    }
}
