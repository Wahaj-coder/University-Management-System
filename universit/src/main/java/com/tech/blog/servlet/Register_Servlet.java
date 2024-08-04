package com.tech.blog.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import com.tech.blog.dao.userDao;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class Register_Servlet
 */
public class Register_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html;charset=UTF-8");
		
		try (PrintWriter out = response.getWriter()){
			
			//fetch data
			String check =request.getParameter("check");
			if(check== null) {
				HttpSession e= request.getSession();
				
				response.sendRedirect("Checkall.jsp");
			}else {
				String Name = request.getParameter("user_name");
				String F_Name = request.getParameter("user_father");
				String Email = request.getParameter("user_email");
				String Password = request.getParameter("user_password");
				String Phone = request.getParameter("user_ph");
				String Gender = request.getParameter("gender");
				String Inter_Percent = request.getParameter("inter_percent");
			    LocalDate DoB = LocalDate.parse(request.getParameter("dob")); // Parse the Date of Birth as LocalDate
			    String Guardian_Name = request.getParameter("guardian_name");
			    String GProf = request.getParameter("gprof");
			    String G_Salary = request.getParameter("gsalary");
			    String G_Contact = request.getParameter("gcontact");
			    int Year = Integer.parseInt(request.getParameter("year"));
			    String Semester = request.getParameter("period");
			    int Roll = Integer.parseInt(request.getParameter("roll"));
			    String Dep = request.getParameter("dep");
				//user data object
				User user= new User(Name, F_Name, Email, Password, Phone, Gender, Inter_Percent, DoB, Guardian_Name, GProf, G_Salary, G_Contact, Year, Semester, Roll,Dep);
				
				//useDao object
				userDao dao= new userDao(ConnectionProvider.getConnection());
				if(dao.saveUser(user)) { 
					HttpSession s= request.getSession();
					
					response.sendRedirect("Done.jsp");
				}else {
					HttpSession t= request.getSession();
					
					response.sendRedirect("Error.jsp");
				}
			}
			
		}catch (DateTimeParseException e) {
	        // Redirect to the date-related error page
	        response.sendRedirect("Error.jsp");
	    }catch (Exception e) {
	        // Redirect to a generic error page for other exceptions
	        response.sendRedirect("Error.jsp");
	    }
	}

}
