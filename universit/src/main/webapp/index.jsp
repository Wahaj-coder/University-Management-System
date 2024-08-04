<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UIT University</title>
<%@include file="allcs.jsp"%>

<link href="css/mystyle.css" rel="stylesheet" type="text/css">

<style>
.banner-background {
	clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 74%, 76% 99%, 21% 81%, 0 96%, 0 0);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container-fluid p-0 m-0">
		<div
			class="jumbotron primary-background text-white text-center  banner-background">
			<div class="container">
				<h3 class="display-5">Welcome to UIT University</h3>
				<p>Welcome to UIT University,The World of Technology</p>
				<a class=" btn btn-outline-light " href="Register.jsp"> <span
					class="	fa fa-user-circle fa-spin"></span> Apply Now
				</a>

			</div>
		</div>
	</div>
	<div class="container text-center">
		<div class="row">
			<div class="col-md-3">
				<div class="card-header primary-background text-white"
					style="width: 16rem;">
					<span class="fa fa-edit fa-3x"></span>
					<div class="card-body">
						<h5 class="card-title">Qualified And Experienced Faculty</h5>
						<p class="card-text">UITU is proud of its faculty who are well
							qualified and experienced in their relevant fields. They play a
							very important role in the lives of students.</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card-header primary-background text-white"
					style="width: 16rem;">
					<span class="fa fa-graduation-cap fa-3x"></span>
					<div class="card-body">
						<h5 class="card-title">A Not-For-Profit University Faculty</h5>
						<p class="card-text">In 2020, UMF was certified by the
							Pakistan Center of Philanthropy as a Non-Profit Organization,
							which speaks volumes about the validation of our ethics.</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card-header primary-background text-white"
					style="width: 16rem;">
					<span class="fa fa-institution fa-3x"></span>

					<div class="card-body">
						<h5 class="card-title">Ideal Location</h5>
						<p class="card-text">The UITU Campus is ideally located on the
							main university road and is easily accessible by all modes of
							transportation from all parts of Karachi.</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card-header primary-background text-white"
					style="width: 16rem;">
					<span class="fa fa-star fa-3x"></span>

					<div class="card-body">
						<h5 class="card-title">State-of-the-art Facilities</h5>
						<p class="card-text">State of the art computer and
							electrical/electronic labs, well stocked library and
							purpose-built campus with air conditioned classrooms.</p>
					</div>

				</div>

			</div>
		</div>
		
	</div>
	
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
