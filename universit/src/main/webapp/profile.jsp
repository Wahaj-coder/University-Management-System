<%@page import="com.tech.blog.entities.User"%>
<%@page errorPage="Error.jsp"%>
<%
User user=(User)session.getAttribute("currentUser");

 if (user==null){
		response.sendRedirect("profile.jsp");
 }
 %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Profile</title>
<%@include file="allcs.jsp"%>
<link href="css/mystyle.css" rel="stylesheet" type="text/css">


<style>
.banner-background {
	clip-path: polygon(20% 0%, 80% 0%, 100% 0, 100% 96%, 60% 84%, 31% 99%, 0 83%, 0 0);
}
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
					<li class="nav-item"><a class="nav-link" href="#!" data-bs-toggle="modal" data-bs-target="#profile-modal"><span class="fa fa-pencil-square"></span>    General   </a></li>									
					<li class="nav-item"><a class="nav-link" href="#!" data-bs-toggle="modal" data-bs-target="#profiles-modal"><span class="fa fa-book"></span>    Courses   </a></li>								
					<li class="nav-item"><a class="nav-link" href="#!" data-bs-toggle="modal" data-bs-target="#reg-modal"><span class="fa fa-clock-o"></span>    Registration   </a></li>								    				
        			<li class="nav-item"><a class="nav-link" href="#!" data-bs-toggle="modal" data-bs-target="#profile-modals"><span class="fa fa-clock-o"></span>    Time Table   </a></li>								    				        			
        			
    				
					<li class="nav-item"><a class="nav-link" href="LogoutServlet"><span class="fa fa-user-times"></span>    Logout</a></li>				
				</ul>
			</div>
		</div>
	</nav>
	
	<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="profile-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <br>
  <br>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header primary-background text-white text-center">
        <h5 class="modal-title" id="exampleModalLabel">Student Info</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="container text-center">
        <br>
        <img src="img/p.png" class="img-fluid mt-1" width="120" height="120" style ="border-radius:50%">
        <br>   
        <h5 class="modal-title" id="exampleModalLabel"><%= user.getName() %></h5>
      	<br>
      	<table class="table">
  <tbody>
    <tr>
      <th scope="row">Name</th>
      <td><%= user.getName() %></td>
    </tr>
    <tr>
      <th scope="row">Roll Number</th>
      <td><%= user.getRoll()%></td>
    </tr>
    <tr>
      <th scope="row">Father Name</th>
      <td><%= user.getF_Name()%></td>
    </tr>
    <tr>
      <th scope="row">Gender</th>
      <td><%= user.getGender() %></td>
    </tr>
    <tr>
      <th scope="row">Email</th>
      <td><%= user.getEmail() %></td>
    </tr>
    <tr>
      <th scope="row">Phone</th>
      <td><%= user.getPhone() %></td>
    </tr>
    <tr>
      <th scope="row">InterPerc</th>
      <td><%= user.getInter_Percent() %></td>
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

<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="profiles-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <br>
  <br>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header primary-background text-white text-center">
        <h5 class="modal-title" id="exampleModalLabel">Course Info</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="container text-center">
        <br>
        
        <h5 class="modal-title" id="exampleModalLabel">Courses</h5>
      	<br>
      	<table class="table">
</table>

        </div>
      </div>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>



<!-- Modal -->
<div class="modal fade" id="profile-modals" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <br>
  <br>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header primary-background text-white text-center">
        <h5 class="modal-title" id="exampleModalLabel">TimeTable</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="container text-center">
        <br>
        
        <h5 class="modal-title" id="exampleModalLabel">Time Table</h5>
      	<br>
      	<table class="table">
  <tbody>
  <thead>
    <tr>
      <th scope="col">Subjects</th>
      <th scope="col">9:00-10:00</th>
      <th scope="col">11:00-12:00</th>
      <th scope="col">1:00-2:00</th>
      <th scope="col">3:00-4:00</th>
      <th scope="col">5:00-6:00</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">Mon</th>
      <td>DLD</td>
      <td>DS</td>
      <td></td>
      <td>OOP</td>
      <td>@mdo</td>
      
    </tr>
    <tr>
      <th scope="row">Tue</th>
      <td>OOP</td>
      <td></td>
      <td>DLD</td>
      <td></td>
      <td>OC</td>
      
    </tr>
    <tr>
      <th scope="row">Wed</th>
      <td>OC</td>
      <td>DLD</td>
      <td></td>
      <td>DS</td>
      <td></td>
      
    </tr>
    <tr>
      <th scope="row">THU</th>
      <td >OOP</td>
      <td>DS</td>
      <td></td>
      <td>DS</td>
      <td></td>
    
    </tr>
    
    <tr>
      <th scope="row">FRI</th>
      <td >OOP(Pr)</td>
      <td>OOP(Pr)</td>
      <td>OOP(Pr)</td>
      <td></td>
     
    </tr>
    <tr>
      <th scope="row">SAT</th>
      <td>DLD(Pr)</td>
      <td>DLD(Pr)</td>
      <td>DLD(Pr)</td>
      <td></td>
      
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
<div class="modal fade" id="reg-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <br>
  <br>
  <div class="modal-dialog"> 
    <div class="modal-content"> 
        <div class="card-header text-center text-white primary-background">
            <span class="fa fa-edit fa-4x"></span> <br>Register Course						
        </div>	   
        <div class="card-body"> 				
            <!-- Semester and Department Selection -->
<form id="semester-department-form" action="RegCourseServlet" method="POST">
    <div class="row mb-3">
        <div class="col-md-6">
            <label for="semester" class="form-label">Semester</label>
            <input name="Rsemester" type="text" class="form-control" id="semester" placeholder="Enter Semester from 1-8">
        </div>
        <div class="col-md-6">
            
								<label for="gender" class="form-label">Select Department</label> <br>
								<input type="radio" id="gender" name="Rdepartment" value="CS">CS
								<input type="radio" id="gender" name="Rdepartment" value="SE">SE
								<input type="radio" id="gender" name="Rdepartment" value="BBA">BBA
								<input type="radio" id="gender" name="Rdepartment" value="ET">ET
							
        </div>
    </div>
<button type="submit" class="btn btn-outline-light primary-background">Show Courses</button>
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