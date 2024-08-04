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
						<span class="fa fa-user-circle fa-4x"></span> <br> Teacher Register
						here
					</div>
					<div class="card-body">

						<form id="reg-form" action="TeachReg_Servlet" method="POST">

							<div class="mb-3">
								<label for="tgender" class="form-label">Select Gender</label> <br>
								<input type="radio" id="gender" name="tea_gender" value="male">Male
								<input type="radio" id="gender" name="gender" value="female">Female
							</div>

							<div class="mb-3">
								<label for="tname" class="form-label">Name</label> <input
									name="tea_name" type="text" class="form-control"
									id="exampleName" aria-describedby="emailHelp"
									placeholder="Enter Your Name">
							</div>
							<div class="mb-3">
								<label for="tid" class="form-label">ID</label> <input
									name="tea_id" type="text" class="form-control"
									id="exampleName" aria-describedby="emailHelp"
									placeholder="Enter Your Name">
							</div>

							<div class="mb-3">
								<label for="ft_addr" class="form-label">Present Address</label> <input
									name="tea_addr" type="text" class="form-control"
									id="exampleName" aria-describedby="emailHelp"
									placeholder="Enter Your Present Address.">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
									address</label> <input name="tea_email" type="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Your Mail">
								<div id="emailHelp" class="form-text">We'll never share
									your email with anyone else.</div>
							</div>

							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input name="tea_password" type="password" class="form-control"
									id="exampleInputPassword1" placeholder="Password">
							</div>
							
							<div class="mb-3">
								<label for="tdob" class="form-label">Date OF Birth</label> <input
									name="tea_dob" type="date" class="form-control"
									id="exampleName"
									placeholder="Enter Your Date of Birth.">
							</div>

							<div class="mb-3">
								<label for="tcontact" class="form-label">Contact Number</label> <input
									name="tea_contact" type="text" class="form-control"
									id="exampleName"
									placeholder="Enter Phone No.">
							</div>
							<div class="mb-3">
								<label for="tqua" class="form-label">Qualification</label> <input
									name="tea_qua" type="text" class="form-control"
									id="exampleName" 
									placeholder="Enter Your Educational Skills.">
							</div>
							
							<div class="mb-3 form-check">
								<input name="t_check" type="checkbox" class="form-check-input"
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