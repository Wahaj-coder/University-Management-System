package com.tech.blog.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tech.blog.entities.Teach;
import com.tech.blog.entities.User;
import com.tech.blog.entities.Admin;
import com.tech.blog.entities.Course;
import com.tech.blog.entities.assCourse;
import com.tech.blog.entities.Enrollment;
public class userDao {
	private Connection con;
	 public userDao(Connection con) {
		 this.con = con;
	 }
	 //insert to database
	 public boolean saveUser(User user) {
		 boolean f= false;
		 try {
			 //user to database
			 String query  = "insert into Student(Name, F_Name, Email, Password, Phone, Gender, Inter_Percent, DoB, Guardian_Name, GProf, GSalary, GContact, Year, Semester,Roll, Dep) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			 PreparedStatement pstmt = this.con.prepareStatement(query);			 			 
			 pstmt.setString(1, user.getName());
			 pstmt.setString(2, user.getF_Name());
			 pstmt.setString(3, user.getEmail());
			 pstmt.setString(4, user.getPassword());
			 pstmt.setString(5, user.getPhone());
			 pstmt.setString(6, user.getGender());
			 pstmt.setString(7, user.getInter_Percent());
	         pstmt.setObject(8, user.getDoB()); // Assuming DoB is a LocalDate
	         pstmt.setString(9, user.getGuardian_Name());
	         pstmt.setString(10, user.getGProf());
	         pstmt.setString(11, user.getG_Salary());
	         pstmt.setString(12, user.getG_Contact());
	         pstmt.setInt(13, user.getYear());
	         pstmt.setString(14, user.getSemester());
	         pstmt.setInt(15, user.getRoll());
	         pstmt.setString(16, user.getDep());
			 int rowsAffected = pstmt.executeUpdate();
		        if (rowsAffected > 0) {
		            f = true;
		            // Commit changes after successful insertion
		            con.commit();
		        } else {
		            // Handle case when insertion fails
		            f = false;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        System.out.println(e.getMessage());		        		        		        
		    }
		    return f;
		}
	 
	 //save teacher data
	 public boolean saveTeach(Teach teach) {
		    boolean f = false;
		    try {
		        // Teacher data to database
		        String query = "INSERT INTO Teacher(TeacherID, TName, Addr, Gender, Email, Password, DoB, Contact, qualification) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		        PreparedStatement pstmt = this.con.prepareStatement(query);

		        pstmt.setInt(1, teach.getTeacherID());
		        pstmt.setString(2, teach.getTName());
		        pstmt.setString(3, teach.getAddr());
		        pstmt.setString(4, teach.getGender());
		        pstmt.setString(5, teach.getEmail());
		        pstmt.setString(6, teach.getPassword());
		        pstmt.setObject(7, teach.getDoB()); // Assuming DoB is a LocalDate
		        pstmt.setString(8, teach.getContact());
		        pstmt.setString(9, teach.getQualification());

		        int rowsAffected = pstmt.executeUpdate();
		        if (rowsAffected > 0) {
		            f = true;
		            // Commit changes after successful insertion
		            con.commit();
		        } else {
		            // Handle case when insertion fails
		            f = false;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        System.out.println(e.getMessage());
		    }
		    return f;
		}
	 //save course
	 public boolean saveCourse(Course c) {
		    boolean f = false;
		    try {
		        // Teacher data to database
		        String query = "INSERT INTO Course(CID, CName, Dep, TID) VALUES(?, ?, ?, ?)";
		        PreparedStatement pstmt = this.con.prepareStatement(query);

		        pstmt.setString(1, c.getCID());
		        pstmt.setString(2, c.getCName());
		        pstmt.setString(3, c.getDep());
		        pstmt.setString(4, c.getTID());
		        int rowsAffected = pstmt.executeUpdate();
		        if (rowsAffected > 0) {
		            f = true;
		            // Commit changes after successful insertion
		            con.commit();
		        } else {
		            // Handle case when insertion fails
		            f = false;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        System.out.println(e.getMessage());
		    }
		    return f;
		}
	 //login
	 public User getUserEmailAndPassword(String Email, String Password) {
		 User user=null;
		 try {
			 String query="select * from Student where Email =? and Password=?";
			 PreparedStatement pstmt = con.prepareStatement(query);
			 pstmt.setString(1, Email);
			 pstmt.setString(2, Password);
			 
			 ResultSet set =  pstmt.executeQuery();
			 if(set.next()) {
				 user=new User();
				 
				 String Name= set.getString("Name");
				 user.setName(Name);
				 user.setEmail(set.getString("Email"));
				 user.setPassword(set.getString("Password"));
				 user.setPhone(set.getString("Phone"));
				 user.setGender(set.getString("Gender"));
				 
				 user.setYear(set.getInt("Year"));
		         user.setSemester(set.getString("Semester"));
		         user.setRoll(set.getInt("Roll"));
		         user.setDep(set.getString("Dep"));
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }		 		 
		 return user;		 
	 }
//teacher login
	 public Teach getTeachEmailAndPassword(String Email, String Password) {
		    Teach teach = null;
		    try {
		        String query = "SELECT * FROM Teacher WHERE Email = ? AND Password = ?";
		        PreparedStatement pstmt = con.prepareStatement(query);
		        pstmt.setString(1, Email);
		        pstmt.setString(2, Password);

		        ResultSet set = pstmt.executeQuery();
		        if(set.next()) {
					 teach=new Teach();
					 
					 String Name= set.getString("TName");
					 teach.setTName(Name);
					 teach.setTeacherID(set.getInt("TeacherID"));
					 teach.setEmail(set.getString("Email"));
					 teach.setPassword(set.getString("Password"));
					 teach.setContact(set.getString("Phone"));
					 teach.setGender(set.getString("Gender"));
					 teach.setQualification(set.getString("Qualification"));
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return teach;
		}
	 //admin login
	 public Admin getAdminIDAndPassword(String ID, String Password) {
		 Admin admin=null;
		 try {
			 String query="select * from Admin where ID =? and Password=?";
			 PreparedStatement pstmt = con.prepareStatement(query);
			 pstmt.setString(1, ID);
			 pstmt.setString(2, Password);
			 
			 ResultSet set = pstmt.executeQuery();
			 if(set.next()) {
				 admin=new Admin();
				 admin.setID(set.getString("ID"));
				 admin.setPassword(set.getString("Password"));				 
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }		 		 
		 return admin;		 
	 }
	 //assign courses
	 public List<assCourse> getCoursesBySemesterAndDepartment(assCourse c) {
		    List<assCourse> registeredCourses = new ArrayList<>();
		    try {
		        String qu = "SELECT * FROM AssignCourses WHERE sem =? AND dep =?";
		        PreparedStatement pstmt = con.prepareStatement(qu);
		        pstmt.setInt(1, c.getsem());
		        pstmt.setString(2, c.getdep());
		        ResultSet set = pstmt.executeQuery();
		        while (set.next()) {
		            assCourse register = new assCourse();
		            register.setsem(set.getInt("sem"));
		            register.setdep(set.getString("dep"));
		            register.setacid(set.getString("courseID"));
		            register.setacname(set.getString("courseName"));
		            registeredCourses.add(register);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println(e.getMessage());
		    }
		    return registeredCourses;
		}


	 //add sem's course
	 public boolean addCourseToReg(assCourse c) {
		 boolean f = false;
		 try {
		        // Teacher data to database
		        String query = "INSERT INTO AssignCourses(sem, dep, courseID, courseName) VALUES(?, ?, ?, ?)";
		        PreparedStatement pstmt = this.con.prepareStatement(query);

		        pstmt.setInt(1, c.getsem());
		        pstmt.setString(2, c.getdep());
		        pstmt.setString(3, c.getacid());
		        pstmt.setString(4, c.getacname());
		        int rowsAffected = pstmt.executeUpdate();
		        if (rowsAffected > 0) {
		            f = true;
		            // Commit changes after successful insertion
		            con.commit();
		        } else {
		            // Handle case when insertion fails
		            f = false;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        System.out.println(e.getMessage());
		    }
		    return f;
		}

	 //delete course
	 public boolean deleteCourseFromRegister(assCourse c) {
		 boolean f = false;
		    try {
		        String query = "DELETE FROM AssignCourses WHERE sem = ? AND dep = ? AND courseID = ?";
		        PreparedStatement pstmt = con.prepareStatement(query);

		        pstmt.setInt(1, c.getsem());
		        pstmt.setString(2, c.getdep());
		        pstmt.setString(3, c.getacid());
		        int rowsAffected = pstmt.executeUpdate();
		        if (rowsAffected > 0) {
		            f = true;
		            // Commit changes after successful insertion
		            con.commit();
		        } else {
		            // Handle case when insertion fails
		            f = false;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        System.out.println(e.getMessage());
		    }
		    return f;
		}
	 
	 //enroll
	 public boolean addEnrollment(Enrollment enrollment) {
	        boolean f = false;
	        try {
	            String query = "INSERT INTO Enrollment(year, period, srdRoll, department,  courseID) VALUES(?,?,?,?,?)";
	            PreparedStatement pstmt = con.prepareStatement(query);
	            pstmt.setInt(1, enrollment.getYear());
	            pstmt.setString(2, enrollment.getPeriod());
	            pstmt.setInt(3, enrollment.getroll());
	            pstmt.setString(4, enrollment.getDepartment());
	            pstmt.setString(5, enrollment.getCourseID());

	            int rowsAffected = pstmt.executeUpdate();
		        if (rowsAffected > 0) {
		            f = true;
		            // Commit changes after successful insertion
		            con.commit();
		        } else {
		            // Handle case when insertion fails
		            f = false;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        System.out.println(e.getMessage());
		    }
		    return f;
		}
	    
	 public boolean updateMarksInEnrollment(Enrollment e) {
		    boolean success = false;

		    try {
		        String query = "UPDATE Enrollment SET assignment_marks = ?, mid = ?, assignment = ?, quiz = ? , final = ?" +
		                "WHERE srdRoll = ? AND courseID = ?";
		        PreparedStatement pstmt = con.prepareStatement(query);
		        pstmt.setInt(1, e.getMid());
		        pstmt.setInt(2, e.getAss());
		        pstmt.setInt(3, e.getQuiz());
		        pstmt.setInt(4, e.getFin());
		        pstmt.setInt(5, e.getroll());
		        pstmt.setString(6, e.getCourseID());

		        int rowsAffected = pstmt.executeUpdate();
		        if (rowsAffected > 0) {
		            success = true;
		        } else {
		            success = false;
		        }
		        con.commit();
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		        // Handle exceptions
		    }
		    return success;
		}

}
