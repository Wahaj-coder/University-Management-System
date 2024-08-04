<%@page import="com.tech.blog.entities.Admin"%>
<%@page errorPage="Error.jsp"%>
<%
Admin user=(Admin)session.getAttribute("currentAdmin");

 if (user==null){
		response.sendRedirect("AdminLogin.jsp");
 }
 %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Profile</title>
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
					<li class="nav-item"><a class="nav-link" href="#!" data-bs-toggle="modal" data-bs-target="#profile-modal"><span class="fa fa-pencil-square"></span>   Add Course</a></li>											
					<li class="nav-item"><a class="nav-link" href="#!" data-bs-toggle="modal" data-bs-target="#regcourse"><span class="fa fa-pencil-square"></span>  Assign Courses</a></li>											
					
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
        <div class="card-header text-center text-white primary-background">
            <span class="fa fa-edit fa-4x"></span> <br>ADD COURSE						
        </div>	   
        <div class="card-body"> 				
            <form id="reg-form" action="Course_Servlet" method="POST">
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="cid" class="form-label">Course ID</label>
                        <input name="cid" type="text" class="form-control" id="cid" placeholder="Enter Course ID">
                    </div>
                    <div class="col-md-6">
                        <label for="cname" class="form-label">Course Name</label>
                        <input name="cname" type="text" class="form-control" id="cname" placeholder="Enter Course Name">
                    </div>
                </div>
                <div class="row mb-3">
                    <div class="col-md-6">
								<label for="gender" class="form-label">Select Department</label> <br>
								<input type="radio" id="gender" name="cddep" value="CS">CS
								<input type="radio" id="gender" name="cddep" value="SE">SE
								<input type="radio" id="gender" name="cddep" value="BBA">BBA
								<input type="radio" id="gender" name="cddep" value="ET">ET
                    </div>
                    <div class="col-md-6">
                        <label for="ctid" class="form-label">Teacher ID</label>
                        <input name="ctid" type="text" class="form-control" id="ctid" placeholder="Enter Teacher ID">
                    </div>
                </div>
                <div class="mb-3 form-check">
                    <input name="c_check" type="checkbox" class="form-check-input" id="c_check">
                    <label class="form-check-label" for="c_check">All information is correct</label>
                </div>
                <button type="submit" class="btn btn-outline-light primary-background">Submit</button>
            </form>
        </div>
    </div>
</div>

</div>
<!-- Modal -->
<div class="modal fade" id="regcourse" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <br>
  <br>
  <div class="modal-dialog"> 
    <div class="modal-content"> 
        <div class="card-header text-center text-white primary-background">
            <span class="fa fa-edit fa-4x"></span> <br>Assign Course						
        </div>	   
        <div class="card-body"> 				
            <!-- Semester and Department Selection -->
<form id="semester-department-form" action="AssignCourse_Servlet" method="POST">
    <div class="row mb-3">
        <div class="col-md-6">
            <label for="semester" class="form-label">Semester</label>
            <input name="semester" type="text" class="form-control" id="semester" placeholder="Enter Semester">
        </div>
        <div class="col-md-6">
            
								<label for="gender" class="form-label">Select Department</label> <br>
								<input type="radio" id="gender" name="department" value="CS">CS
								<input type="radio" id="gender" name="department" value="SE">SE
								<input type="radio" id="gender" name="department" value="BBA">BBA
								<input type="radio" id="gender" name="department" value="ET">ET
							
        </div>
    </div>
<table class="table">
    <thead>
        <tr>
            <th scope="col">Course ID</th>
            <th scope="col">Course Name</th>
            <th scope="col">Actions</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>
                <div class="col-md-14">
                    <input name="acidd" type="text" class="form-control" id="acid" placeholder="Enter ID">
                </div>
            </td>
            <td>
                <div class="col-md-14">
                    <input name="acnamed" type="text" class="form-control" id="acname" placeholder="Enter Name">
                </div>
            </td>
            <td>
                <div class="d-flex align-items-center">
                    <input type="hidden" id="action" name="action" value=""> <!-- Hidden input for action -->

    <button type="submit" class="btn btn-success me-2" onclick="setAction('addCourse')">Add</button>
    <button type="button" class="btn btn-danger" onclick="setActionAndSubmit('deleteCourse')">Delete</button>

                </div>
            </td>
        </tr>
        
    </tbody>
</table>
</form>
<button type="button" class="btn btn-outline-light primary-background" onclick="setActionAndSubmit('showCourse')">Show Courses</button>

        </div>
    </div>
</div>

</div>
<script>
function setAction(action) {
    document.getElementById('action').value = action;
}

function setActionAndSubmit(action) {
    setAction(action);
    document.getElementById('semester-department-form').submit();
}
</script>
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