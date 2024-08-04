<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.List" %>
	<%@ page import="com.tech.blog.entities.assCourse" %>
	<%@ page import="com.tech.blog.entities.User" %>
	<%
User user=(User)session.getAttribute("currentUser");

 if (user==null){
		response.sendRedirect("Students.jsp");
 }
 %>
	
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>UITU</title>
    <%@ include file="allcs.jsp" %>
    <link href="css/mystyle.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .banner-background {
            clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 88%, 38% 100%, 10% 93%, 0 100%, 0 0);
        }
    </style>
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <main class="primary-background banner-background p-5" style="padding-bottom: 400px;">
        <div class="container">
            <div class="col-md-6 offset-md-3">
            <form id="semester-department-form" action="enrollServlet" method="POST">
                <div class="card">
                    <div class="card-header text-center text-white primary-background">
                       <h5 class="card-text">
                                Semester: <%= request.getParameter("Rsemester") %><br>
                                Department: <%= request.getParameter("Rdepartment") %><br>
                                <input type="hidden" name="hiddenSemester" value="<%= request.getParameter("Rsemester") %>">
                                <input type="hidden" name="hiddendep" value="<%= request.getParameter("Rdepartment") %>">
                                <input type="hidden" name="hiddenyear" value="<%= user.getYear() %>">
                                <input type="hidden" name="hiddenper" value="<%= user.getSemester() %>">
                                <input type="hidden" name="hiddenroll" value="<%= user.getRoll() %>">
                            </h5>
                    </div>
                    <div class="card-body">
                        
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>Course ID</th>
                                        <th>Course Name</th>
                                        <!-- Add other table headers if needed -->
                                    </tr>
                                </thead>
                                <tbody>
                                    <% 
                                        List<assCourse> courses = (List<assCourse>) request.getAttribute("Rcourses");
                                        if (courses != null && !courses.isEmpty()) {
                                            for (assCourse course : courses) {
                                    %>
                                                <tr>
                                                    <td><%= course.getacid() %></td>
                                                    <td><%= course.getacname() %></td>             <!-- Display other course details -->
                                                </tr>
                                    <%      }
                                        } else {
                                    %>
                                                <tr>
                                                    <td colspan="2">No courses found</td>
                                                </tr>
                                    <% } %>
                                </tbody>
                            </table>
                            <div class="text-end">
    							<button type="submit" id="printVoucherBtn" class="btn btn-outline-light primary-background">Enroll</button>
							</div>
                        </div>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </main>

    <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.min.js"></script>
    <script src="JS/myjs.js" type="text/javascript"></script>
    <script>
        $(document).ready(function(){
            console.log("loaded...");
        });
    </script>
    
</body>
</html>
