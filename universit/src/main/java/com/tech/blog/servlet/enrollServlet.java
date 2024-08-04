package com.tech.blog.servlet;
import java.util.Enumeration;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.util.List;
import com.tech.blog.dao.userDao;
import com.tech.blog.entities.Enrollment;
import com.tech.blog.entities.assCourse;
import com.tech.blog.helper.ConnectionProvider;
/**
 * Servlet implementation class enrollServlet
 */
public class enrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enrollServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		HttpSession s= request.getSession();
		
	    userDao uDao = new userDao(ConnectionProvider.getConnection());
	    int semester = Integer.parseInt(request.getParameter("hiddenSemester"));
	    String department = request.getParameter("hiddendep");
		int year = Integer.parseInt(request.getParameter("hiddenyear"));	
	    String period = request.getParameter("hiddenper");
	    int roll = Integer.parseInt(request.getParameter("hiddenroll"));	
		try (PrintWriter out = response.getWriter()) {
		    assCourse c = new assCourse();
		    c.setsem(semester);
		    c.setdep(department);
		    List<assCourse> courses = uDao.getCoursesBySemesterAndDepartment(c);
		    System.out.println("GGGG"+courses);
		    for (assCourse course : courses) {
		    	System.out.println(course);
		        // Create an Enrollment object for each course and save it in the database
		        Enrollment enrollment = new Enrollment(year, period, roll, department, course.getacid());
		        uDao.addEnrollment(enrollment);
		    }response.sendRedirect("Done.jsp"); 
	    // Redirect to a success page
		} catch (Exception e) {
	        response.sendRedirect("Error.jsp");
	        e.printStackTrace();
			System.out.println(e.getMessage());		 
	    }

}}
