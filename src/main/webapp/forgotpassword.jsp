<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="lumpofyums.UserServlet"%>
	
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
	<nav class="nav-wrapper">
		<a href="<%=request.getContextPath()%>/RecipeServlet/home"
			class="brand-logo">Lump Of Yums</a>
		<ul class="nav-list">
			<li><a href="<%=request.getContextPath()%>/RecipeServlet/home">Recipes</a></li>
			<li class="active"><a
				href="<%=request.getContextPath()%>/login.jsp">Sign in</a></li>
			<li><a href="<%=request.getContextPath()%>/register.jsp">Sign
					up</a></li>
		</ul>
	</nav>
	<section class="bg-white main-section">
		<div class="mb-medium">
			<h1 class="text-brown">Forgot Password</h1>
		</div>
		<div class="double-panel">
			<div class="left">
				<form id="login-form" action="ForgotPwAction.jsp"
					class="card-form bg-orange" action=forgotpasswordservice
					method="post">
					<div class="input-group">
						<label for="email">E-Mail</label> <input type="text"
							placeholder="E-mail" name="email" required />
					</div>
					<div class="input-group">
						<label for="username">Username</label> <input type="text"
							placeholder="Username" name="username" required />
					</div>
					<div class="input-group">
						<label for="question">Security Question</label> <select
							name="question">
							<option value="What was your favorite food as a child?">What
								was your favorite food as a child?</option>
							<option value="In what city were you born?">In what city
								were you born?</option>
							<option value="What was the make of your first car?">What
								was the make of your first car?</option>
						</select>
					</div>
					<div class="input-group">
						<label for="answer">Answer</label> <input placeholder="Answer"
							name="answer" required />
					</div>
					<div class="input-group">
						<label for="newPassword">Enter New Password</label> <input
							required type="password" placeholder="Password"
							name="newPassword" required />
					</div>
					<div>
						<input type="submit" value="Save" class="btn" />
					</div>
					<div class="error-msg"></div>
					<div>
						<a href="login.jsp">Back to Log-In</a>
					</div>
				</form>
				<div class="forgotPassword"></div>
				<%
				String message = request.getParameter("msg");
				if ("done".equals(message))
				{
				%>
				<h5>Password Changed Successfully.</h5>
				<%}%>
				<%
				if("invalid".equals(message))
				{
				%>
				<h5>Password Chang Unsuccessful.</h5>
				<%}%>
			</div>
			<div class="right">
				<div class="right-info">
					<p class="mb-small">Join Lump Of Yums and discover a variety of
						recipes from the community.</p>
					<div>
						<a class="btn" href="<%=request.getContextPath()%>/register.jsp">Sign
				up here</a>
			</div>
		</div>
		</div>
		</div>
	</section>

	<footer class="footer">
		<h4>
			<i class="material-icons">dining</i>
		</h4>
		<span>&copy; Lump Of Yums 2022</span>
	</footer>

</body>
</html>