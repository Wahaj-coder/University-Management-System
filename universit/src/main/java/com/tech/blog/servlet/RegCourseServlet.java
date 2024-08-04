package com.tech.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class RegCourseServlet
 */
public class RegCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegCourseServlet() {
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
		 try {
			HttpSession e = request.getSession();
            String semesterString = request.getParameter("Rsemester");
            int semester = Integer.parseInt(semesterString);
            String department = request.getParameter("Rdepartment");

            assCourse course = new assCourse();
            course.setsem(semester);
            course.setdep(department);

            userDao dao = new userDao(ConnectionProvider.getConnection());
            List<assCourse> courses = dao.getCoursesBySemesterAndDepartment(course);
            request.setAttribute("Rcourses", courses);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Rshow.jsp");
            dispatcher.forward(request, response);
        
        } catch (Exception e) {
            response.sendRedirect("Error.jsp");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
	}

}
