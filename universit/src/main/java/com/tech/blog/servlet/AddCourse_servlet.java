package com.tech.blog.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.format.DateTimeParseException;

import com.tech.blog.dao.userDao;
import com.tech.blog.entities.Course;
import com.tech.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class Register_Servlet
 */
public class AddCourse_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourse_servlet() {
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
			String check =request.getParameter("c_check");
			if(check == null) {
				HttpSession e= request.getSession();				
				response.sendRedirect("Checkall.jsp");
			}else {
				String CID = request.getParameter("cid");
				String Name = request.getParameter("cname");
				String Dep = request.getParameter("cdep");
			    String TID = request.getParameter("ctid");
				//user data object
				Course course= new Course(CID, Name, Dep, TID);				
				//useDao object
				userDao dao= new userDao(ConnectionProvider.getConnection());
				if(dao.saveCourse(course)) { 
					HttpSession s= request.getSession();					
					response.sendRedirect("Done.jsp");
				}else {
					HttpSession t= request.getSession();
					response.sendRedirect("Error.jsp");
				}
			}			
		}catch (Exception e) {
	        // Redirect to a generic error page for other exceptions
	        response.sendRedirect("Error.jsp");
	    }
	}

}
