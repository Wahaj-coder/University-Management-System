<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tech.blog.entities.Teach"%>
<%@page errorPage="Error.jsp"%>
<%
Teach teach=(Teach)session.getAttribute("currentTeach");

 if (teach==null){
		response.sendRedirect("Teacher.jsp");
 }
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Profile</title>
<%@include file="allcs.jsp"%>
<link href="css/mystyle.css" rel="stylesheet" type="text/css">
<style>
.banner-background {
	clip-path: polygon(4% 52%, 0 0, 15% 0%, 85% 0%, 100% 0, 95% 51%, 100% 100%, 88% 94%, 74% 85%, 51% 99%, 21% 85%, 0 100%);
</style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark primary-background">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">University Management System</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#!" data-bs-toggle="modal" data-bs-target="#profile-mod"><span class="fa fa-pencil-square"></span>    General   </a></li>												
												
					<li class="nav-item"><a class="nav-link" href="#!" data-bs-toggle="modal" data-bs-target="#marksmodal"><span class="fa fa-clock-o"></span>    Upload Marks   </a></li>
					<li class="nav-item"><a class="nav-link" href="LogoutServlet"><span class="fa fa-user-times"></span>    Logout</a></li>				
				</ul>
			</div>
		</div>
	</nav>
	
	<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="profile-mod" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <br>
  <br>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header primary-background text-white text-center">
        <h5 class="modal-title" id="exampleModalLabel">Teacher Info</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="container text-center">
        <br>
        <img src="img/p.png" class="img-fluid mt-1" width="120" height="120" style ="border-radius:50%">
        <br>   
        <h5 class="modal-title" id="exampleModalLabel"><%= teach.getTName() %></h5>
      	<br>
      	<table class="table">
  <tbody>
    <tr>
      <th scope="row">Name</th>
      <td><%= teach.getTName() %></td>
    </tr>
    <tr>
      <th scope="row">ID</th>
      <td><%= teach.getTeacherID() %></td>
    </tr>
    <tr>
      <th scope="row">Email</th>
      <td><%= teach.getEmail() %></td>
    </tr> 
      <tr>
      <th scope="row">Degrees</th>
      <td><%= teach.getQualification() %></td>
    </tr>
   
  </tbody>
</table>

        </div>
      </div>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>

<!-- Modal -->
<div class="modal fade" id="marksmodal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <br>
  <br>
  <div class="modal-dialog modal-sm"> 
    <div class="modal-content"> 
        <div class="card-header text-center text-white primary-background">
            <span class="fa fa-edit fa-2x"></span> <br>Your Course Id						
        </div>	   
        <div class="card-body"> 				
            <!-- Semester and Department Selection -->
<form id="semester-department-form" action="marksServlet" method="POST">
    <div class="row mb-3">
        <div class="col-md-14">
            <label for="semester" class="form-label">Course ID</label>
            <input name="Rsemester" type="text" class="form-control" id="semester" placeholder="Enter you course ID.">
            <input type="hidden" name="hiddentid" value="<%= teach.getTeacherID() %>">
        </div>
    </div>
<button type="submit" class="btn btn-outline-light primary-background">Enter</button>
</form>
	   </div>
    </div>
</div>
</div>
	<main
		class="d-flex align-items-center primary-background banner-background"
		style="height: 80vh">
</main>
	<script src="https://code.jquery.com/jquery-3.6.3.min.js"
		integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>
	<script src="JS/myjs.js" type="text/javascript"></script>
</body>
</html>