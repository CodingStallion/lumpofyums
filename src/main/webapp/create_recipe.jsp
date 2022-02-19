<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="lumpofyums.User"%>
<% User user = (User) session.getAttribute("logUser");
    if(user==null){
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Cookie&family=Mochiy+Pop+P+One&display=swap"
	rel="stylesheet">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<title>Lump Of Yums</title>
</head>
<body>

	<!--  Lump Of Yums Update 1 -->
	<nav class="nav-wrapper">

		<a href="<%=request.getContextPath()%>/RecipeServlet/home"
			class="brand-logo">Lump Of Yums</a>
		<ul class="nav-list">
			<li class="active"><a
				href="<%=request.getContextPath()%>/RecipeServlet/home">Recipes</a></li>
			<%
                                   
                if (session.getAttribute("logUser") == null) {
            %>
			<li><a href="<%=request.getContextPath()%>/login.jsp">Sign
					in</a></li>
			<li><a href="<%=request.getContextPath()%>/register.jsp">Sign
					up</a></li>
			<% } else {
         %>
			<li><a href="<%=request.getContextPath()%>/account.jsp">Account</a></li>
			<li><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></li>
			<% }%>
		</ul>
	</nav>
	<section class="bg-orange main-section">
		<div class="restaurant-header">
			<h1 class="text-brown" id="name">Share your recipe with the
				community</h1>
			<div class="restaurant-info">
				<div class="rating"></div>
				<div class="price" id="price"></div>
			</div>
			<div class="mb-medium">
				<p class="address"></p>
			</div>
		</div>


		<div class="restaurant-reviews" id="authenticated-reviews">
			<form id="review-form" action="CreateRecipeServlet" method="post" enctype="multipart/form-data">

				<h2 class="text-brown mb-small">Recipe name</h2>
				<div class="mb-small">
					<input type="text" placeholder="Recipe name" name="food_name" />
				</div>
				<h2 class="text-brown mb-small">Prep time</h2>
				<div class="mb-small">
					<input type="number" value="1" name="prep_time" min="1" max="100" />
					minutes
				</div>
				<h2 class="text-brown mb-small">Cooking time</h2>
				<div class="mb-small">
					<input type="number" value="1" name="cooking_time" min="1"
						max="100" /> minutes
				</div>
				
				<h2 class="text-brown mb-small">Image</h2>
				<div class="mb-small">
					<input type="file" name="file">
				</div>

				<div class="mb-small" style="display: none;">
					<input type="number" value=<%= user.getId() %> name="uid" />
				</div>
				

				<h2 class="text-brown mb-small">Level</h2>
				<div class="mb-small">
					<select name="level">
						<option value="Easy">Easy</option>
						<option value="Normal">Normal</option>
						<option value="Hard">Hard</option>
					</select>
				</div>


				<h2 class="text-brown mb-small">Description</h2>
				<div class="input-group mb-small">
					<textarea rows="6" cols="6" name="description"
						placeholder="Your description here"></textarea>
				</div>

				<h2 class="text-brown mb-small">Ingredients</h2>
				<div class="input-group mb-small">
					<textarea rows="10" cols="30" name="ingredients"
						placeholder="Your ingredients here"></textarea>
				</div>

				<h2 class="text-brown mb-small">Preparation</h2>
				<div class="input-group mb-small">
					<textarea rows="10" cols="30" name="preparation"
						placeholder="Your preparation here"></textarea>
				</div>
				<input type="submit" class="btn" value="Submit" />
				<div class="success-msg"></div>
				<div class="error-msg"></div>
			</form>
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