<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.List" %>
	<%@ page import="com.tech.blog.entities.assCourse" %>
	
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
            <div class="col-md-8 offset-md-2">
                <div class="card">
                    <div class="card-header text-center text-white primary-background">
                       <h5 class="card-text">
                                Semester: <%= request.getParameter("semester") %><br>
                                Department: <%= request.getParameter("department") %>
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
                                        List<assCourse> courses = (List<assCourse>) request.getAttribute("courses");
                                        if (courses != null && !courses.isEmpty()) {
                                            for (assCourse course : courses) {
                                    %>
                                                <tr>
                                                    <td><%= course.getacid() %></td>
                                                    <td><%= course.getacname() %></td>
                                                    <!-- Display other course details -->
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
                        </div>
                    </div>
                </div>
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
