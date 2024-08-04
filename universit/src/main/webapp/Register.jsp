<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UITU</title>
<%@include file="allcs.jsp"%>
<link href="css/mystyle.css" rel="stylesheet" type="text/css">
<style>
.banner-background {
	clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 88%, 38% 100%, 10% 93%, 0 100%, 0 0
		);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<main class="primary-background banner-background p-5"
		style="padding-bottom: 400px;">

		<div class="container">

			<div class="col-md-6 offset-md-3">
			
				<div class="card">
					<div class="card-header text-center text-white primary-background">
						<span class="fa fa-user-circle fa-4x"></span> <br> Student Register
						here
					</div>
					<div class="card-body">

						<form id="reg-form" action="Register_Servlet" method="POST">

							<div class="mb-3">
								<label for="gender" class="form-label">Select Gender</label> <br>
								<input type="radio" id="gender" name="gender" value="male">Male
								<input type="radio" id="gender" name="gender" value="female">Female
							</div>

							<div class="mb-3">
								<label for="name" class="form-label">Name</label> <input
									name="user_name" type="text" class="form-control"
									id="exampleName" aria-describedby="emailHelp"
									placeholder="Enter Your Name">
							</div>
							<div class="mb-3">
								<label for="f_name" class="form-label">Father Name</label> <input
									name="user_father" type="text" class="form-control"
									id="exampleName" aria-describedby="emailHelp"
									placeholder="Enter Your Father Name">
							</div>
							<div class="mb-3">
								<label for="inter_percent" class="form-label">Intermediate
									Percentage</label> <input name="inter_percent" type="text"
									class="form-control" id="exampleName"
									placeholder="Enter Previous Result">
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
									address</label> <input name="user_email" type="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Your Mail">
								<div id="emailHelp" class="form-text">We'll never share
									your email with anyone else.</div>
							</div>

							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input name="user_password" type="password" class="form-control"
									id="exampleInputPassword1" placeholder="Password">
							</div>

							<div class="mb-3">
								<label for="ph" class="form-label">Phone Number</label> <input
									name="user_ph" type="text" class="form-control"
									id="exampleName"
									placeholder="Enter Phone No.">
							</div>
							<div class="mb-3">
								<label for="dob" class="form-label">Date OF Birth</label> <input
									name="dob" type="date" class="form-control"
									id="exampleName"
									placeholder="Enter Your Date of Birth.">
							</div>
							<div class="mb-3">
								<label for="depa" class="form-label">Select Department</label> <br>
								<input type="radio" id="gender" name="dep" value="CS">CS
								<input type="radio" id="gender" name="dep" value="SE">SE
								<input type="radio" id="gender" name="dep" value="BBA">BBA
								<input type="radio" id="gender" name="dep" value="ET">ET
							</div>
							<div class="mb-3">
								<label for="d" class="form-label">ROLL#</label> <input
									name="roll" type="text" class="form-control"
									id="exampleName"
									placeholder="Enter roll# given by University i.e.59">
							</div>
							<div class="mb-3">
								<label for="ye" class="form-label">Year</label> <input
									name="year" type="text" class="form-control"
									id="exampleName" 
									placeholder="Enter Year of Enrollment i.e. 1999">
							</div>
							<div class="mb-3">
								<label for="perio" class="form-label">Select Enrollment Period</label> <br>
								<input type="radio" id="gender" name="period" value="Spring">Spring
								<input type="radio" id="gender" name="period" value="Fall">Fall
							</div>
							<div class="mb-3">
								<label for="gname" class="form-label">Guardian's Name</label> <input
									name="guardian_name" type="text" class="form-control"
									id="exampleName" 
									placeholder="Enter Your Guardian Name">
							</div>
							<div class="mb-3">
								<label for="gp" class="form-label">Guardian's Profession</label> <input
									name="gprof" type="text" class="form-control"
									id="exampleName" 
									placeholder="Enter Guardian's Profession">
							</div>
							<div class="mb-3">
								<label for="gs" class="form-label">Guardian's Salary</label> <input
									name="gsalary" type="text" class="form-control"
									id="exampleName"
									placeholder="Enter Phone Guardian's Monthly Income">
							</div>
							<div class="mb-3">
								<label for="gc" class="form-label">Guardian's Phone No.</label> <input
									name="gcontact" type="text" class="form-control"
									id="exampleName"
									placeholder="Enter Guardian's Phone No.">
							</div>
							<div class="mb-3 form-check">
								<input name="check" type="checkbox" class="form-check-input"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">All information is correct</label>
							</div>

							<button type="submit"
								class=" btn btn-outline-light primary-background ">Submit</button>

						</form>

					</div>

				</div>
			</div>
		</div>
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
	<script>
$(document).ready(function(){
	console.log("loaded......")
	
	
</script>
</body>
</html>