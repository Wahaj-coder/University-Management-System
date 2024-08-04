package com.tech.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.dao.userDao;
import com.tech.blog.entities.Admin;
import com.tech.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class Login_Servlet
 */
public class AdminLogin_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin_Servlet() {
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
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet LoginServlet</title>");
			out.println("</head>");
			out.println("<body>");
			//login
			String aid=request.getParameter("aid");
			String apas=request.getParameter("apassword");
			
			userDao dao = new userDao(ConnectionProvider.getConnection());
			Admin u = dao.getAdminIDAndPassword(aid, apas);
			
			if(u==null) {
				HttpSession e= request.getSession();				
				response.sendRedirect("Checkall.jsp");
			}else {
				HttpSession s= request.getSession();
				s.setAttribute("currentAdmin", u);
				response.sendRedirect("AdminProfile.jsp");
			
			}
			out.println("</body>");
			out.println("</html>");
			
		}
	}

}
