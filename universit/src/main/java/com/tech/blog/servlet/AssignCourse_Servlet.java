package com.tech.blog.servlet;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.util.List;

import com.tech.blog.dao.userDao;
import com.tech.blog.entities.assCourse;
import com.tech.blog.helper.ConnectionProvider;
/**
 * Servlet implementation class AssignCourse_Servlet
 */
public class AssignCourse_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignCourse_Servlet() {
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
	    String action = request.getParameter("action");

	    if ("addCourse".equals(action)) {
	        // Handle adding course logic
	    
	    try (PrintWriter out = response.getWriter()) {
	            HttpSession e = request.getSession();
	            String semesterString = request.getParameter("semester");
	            int semester = Integer.parseInt(semesterString);
	            String dep = request.getParameter("department");
	            String ac = request.getParameter("acidd");
	            String acn = request.getParameter("acnamed");
	            
	            // Create a Teach object with the fetched data
	            assCourse teach = new assCourse(semester, dep, ac, acn);

	            // Save the teacher using userDao
	            userDao dao = new userDao(ConnectionProvider.getConnection());
	            if (dao.addCourseToReg(teach)) {
	                HttpSession s = request.getSession();
	                response.sendRedirect("Done.jsp");
	            } else {
	                HttpSession t = request.getSession();
	                response.sendRedirect("Error.jsp");
	                
	            }
	        
	    } catch (Exception e) {
	        response.sendRedirect("Error.jsp");
	        e.printStackTrace();
			System.out.println(e.getMessage());		 
	    }
	    }else if ("deleteCourse".equals(action)) {
	        // Handle deleting course logic
	    	try (PrintWriter out = response.getWriter()) {
	            HttpSession e = request.getSession();
	            String semesterString = request.getParameter("semester");
	            int semester = Integer.parseInt(semesterString);
	            String dep = request.getParameter("department");
	            String ac = request.getParameter("acidd");
	            String acn = request.getParameter("acnamed");
	            
	            // Create a Teach object with the fetched data
	            assCourse teach = new assCourse(semester, dep, ac, acn);

	            // Save the teacher using userDao
	            userDao dao = new userDao(ConnectionProvider.getConnection());
	            
	            if (dao.deleteCourseFromRegister(teach)) {
	                HttpSession s = request.getSession();
	                response.sendRedirect("Done.jsp");
	            } else {
	                HttpSession t = request.getSession();
	                response.sendRedirect("Error.jsp");	                
	            }	        
	    } catch (Exception e) {
	        response.sendRedirect("Error.jsp");
	        e.printStackTrace();
			System.out.println(e.getMessage());		 
	    }
	    }else if ("showCourse".equals(action)) {
	        try {
	        	HttpSession e = request.getSession();
	            String semesterString = request.getParameter("semester");
	            int semester = Integer.parseInt(semesterString);
	            String department = request.getParameter("department");

	            assCourse course = new assCourse();
	            course.setsem(semester);
	            course.setdep(department);

	            userDao dao = new userDao(ConnectionProvider.getConnection());
	            List<assCourse> courses = dao.getCoursesBySemesterAndDepartment(course);
	            request.setAttribute("courses", courses);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("show.jsp");
	            dispatcher.forward(request, response);
	        
	        } catch (Exception e) {
	            response.sendRedirect("Error.jsp");
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	    }

	}
}