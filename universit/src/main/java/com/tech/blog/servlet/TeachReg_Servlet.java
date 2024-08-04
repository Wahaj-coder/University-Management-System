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
import com.tech.blog.entities.Teach;
import com.tech.blog.helper.ConnectionProvider;
/**
 * Servlet implementation class TeachReg_Servlet
 */
public class TeachReg_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachReg_Servlet() {
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

	    try (PrintWriter out = response.getWriter()) {
	        String checks = request.getParameter("t_check");

	        if (checks == null) {
	            HttpSession e = request.getSession();
	            response.sendRedirect("Checkall.jsp");
	        } else {
	            // Fetch teacher data
	            String Name = request.getParameter("tea_name");
	            int TID = Integer.parseInt(request.getParameter("tea_id"));
	            String Addr = request.getParameter("tea_addr");
	            String Gender = request.getParameter("tea_gender");
	            String Email = request.getParameter("tea_email");
	            String Password = request.getParameter("tea_password");
	            LocalDate DoB = LocalDate.parse(request.getParameter("tea_dob")); // Assuming dobString is in the format 'YYYY-MM-DD'
	            String Contact = request.getParameter("tea_contact");
	            String Qualification = request.getParameter("tea_qua");

	            // Create a Teach object with the fetched data
	            Teach teach = new Teach(Name,TID, Addr, Gender, Email, Password, DoB, Contact, Qualification);

	            // Save the teacher using userDao
	            userDao dao = new userDao(ConnectionProvider.getConnection());
	            if (dao.saveTeach(teach)) {
	                HttpSession s = request.getSession();
	                response.sendRedirect("Done.jsp");
	            } else {
	                HttpSession t = request.getSession();
	                response.sendRedirect("Error.jsp");
	                
	            }
	        }
	    } catch (Exception e) {
	        response.sendRedirect("Error.jsp");
	        e.printStackTrace();
			System.out.println(e.getMessage());		 
	    }
	}
}
