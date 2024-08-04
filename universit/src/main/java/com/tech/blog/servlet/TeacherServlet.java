package com.tech.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.dao.userDao;
import com.tech.blog.entities.Teach;
import com.tech.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class TeacherServlet
 */
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet() {
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
			out.println("<title>Servlet TeacherServlet</title>");
			out.println("</head>");
			out.println("<body>");
			//login
			String useremail=request.getParameter("email");
			String userpassword=request.getParameter("password");
			
			userDao dao = new userDao(ConnectionProvider.getConnection());
			Teach t = dao.getTeachEmailAndPassword(useremail, userpassword);
			
			if(t==null) {
				HttpSession e= request.getSession();
				
				response.sendRedirect("Checkall.jsp");
			}else {
				HttpSession s= request.getSession();
				s.setAttribute("currentTeach", t);
				response.sendRedirect("tprofile.jsp");
			
			}
			
			out.println("</body>");
			out.println("</html>");
			
		}
	}

	

}
