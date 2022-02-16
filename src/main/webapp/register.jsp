<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Google Fonts 1 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Cookie&family=Mochiy+Pop+P+One&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link rel="stylesheet" href="css/style.css">
<title>Lump Of Yums</title>
</head>
<body>
<%
String username = request.getParameter("username");
String email = request.getParameter("email");
String address = request.getParameter("address");
String password = request.getParameter("password");
String first_name = request.getParameter("first_name");
String last_name = request.getParameter("last_name");
int phone = Integer.parseInt(request.getParameter("phone"));
String gender = request.getParameter("gender");

%>
	<!--  Lump Of Yums Update 2 -->
	<nav class="nav-wrapper">
		<a href="<%=request.getContextPath()%>/RecipeServlet/home"
			class="brand-logo">Lump Of Yums</a>
		<ul class="nav-list">
			<li><a href="<%=request.getContextPath()%>/RecipeServlet/home">Recipes</a></li>
			<li><a href="<%=request.getContextPath()%>/login.jsp">Sign
					in</a></li>
			<li class="active"><a
				href="<%=request.getContextPath()%>/register.jsp">Sign up</a></li>
		</ul>
	</nav>

	<section class="bg-white main-section">
		<div class="mb-medium">
			<h1 class="text-brown">Sign Up</h1>
		</div>
		<form id="register-form" action="RegisterServlet" method="post">
			<div class="double-panel bg-orange card-form">
				<div class="left card-form">
					<div class="input-group">
						<label for="username">Username</label> <input type="text"
							placeholder="Username" name="username"/>
							<c:if test="${username == null}">
							<p>Username is null</p>
							</c:if>
					</div>
					<div class="input-group">
						<label for="email">Email address</label> <input type="text"
							placeholder="Email Address" name="email" />
					</div>
					<div class="input-group">
						<label for="password">Password</label> <input type="password"
							placeholder="Password" name="password" />
					</div>
					<div class="input-group">
						<label for="confirm_password">Confirm Password</label> <input
							type="password" placeholder="Confirm Password"
							name="confirm_password" />
					</div>
					<div class="input-group">
						<label for="address">Address</label> <input type="text"
							placeholder="Address" name="address" />
					</div>
					<div class="input-group">
						<label for="postal_code">Postal Code</label> <input type="text"
							placeholder="Postal Code" name="postal_code" />
					</div>
				</div>
				<div class="right card-form">
					<div class="input-group">
						<label for="first_name">First Name</label> <input type="text"
							placeholder="First Name" name="first_name" />
					</div>
					<div class="input-group">
						<label for="last_name">Last Name</label> <input type="text"
							placeholder="Last Name" name="last_name" />
					</div>
					<div class="input-group">
						<label for="gender">Gender</label> <select name="gender">
							<option value="M">M</option>
							<option value="F">F</option>
						</select>
					</div>
					<div class="input-group">
						<label for="phone">Phone</label> <input type="text"
							placeholder="Phone" name="phone" />
					</div>
					<div>
						<input type="submit" value="Register" class="btn" />
					</div>
					<div class="error-msg"></div>
					<div class="success-msg"></div>
				</div>
			</div>
		</form>
	</section>

	<footer class="footer">
		<h4>
			<i class="material-icons">dining</i>
		</h4>
		<span>&copy; Lumps Of Yums 2022</span>
	</footer>


</body>
</html>