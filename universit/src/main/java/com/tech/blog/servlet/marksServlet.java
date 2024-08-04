package com.tech.blog.servlet;
import java.util.List;
import java.io.IOException;
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
 * Servlet implementation class marksServlet
 */
public class marksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public marksServlet() {
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
        // Retrieve parameters from the request
		response.setContentType("text/html;charset=UTF-8");
		HttpSession s= request.getSession();
        int mid = Integer.parseInt(request.getParameter("mid"));
        int ass = Integer.parseInt(request.getParameter("ass"));
        int quiz = Integer.parseInt(request.getParameter("quiz"));
        int fin = Integer.parseInt(request.getParameter("fin"));
        int roll = Integer.parseInt(request.getParameter("roll"));
        
        String courseID = request.getParameter("courseID");

        // Create an Enrollment object with the retrieved parameters
        Enrollment enrollment = new Enrollment(mid, ass, quiz, fin, roll, courseID);

        // Perform the database update using the provided method
        userDao uDao = new userDao(ConnectionProvider.getConnection()); // Initialize your database connection class
        boolean updateSuccess = uDao.updateMarksInEnrollment(enrollment);

        if (updateSuccess) {
            // If the update was successful, do something (e.g., redirect to a success page)
            response.sendRedirect("Done.jsp");
        } else {
            // If the update failed, handle the failure (e.g., redirect to an error page)
            response.sendRedirect("error.jsp");
        }
    }

}
