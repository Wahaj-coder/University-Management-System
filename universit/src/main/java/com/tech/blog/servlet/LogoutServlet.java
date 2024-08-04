package com.tech.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.entities.User;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out = response.getWriter();
		  
	        // Set the content type of response to "text/html"
	        response.setContentType("text/html");
	  
	        // For understanding purpose, print the session object in the console before
	        // invalidating the session.
	        System.out.println("Session before invalidate: "+ request.getSession(false));
	  
	        // Invalidate the session.
	        request.getSession(false).invalidate();
	  
	        // Print the session object in the console after invalidating the session.
	        System.out.println("Session after invalidate: "+ request.getSession(false));
	  
	        // Print success message to the user and close the print writer object.
	        HttpSession e= request.getSession();
			
			response.sendRedirect("index.jsp");
	        out.close();
	    
	
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html;charset=UTF-8");
		
		
	}
}
