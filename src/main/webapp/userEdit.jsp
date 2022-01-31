<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<%
			} else {
			%>
			<li><a href="<%=request.getContextPath()%>/account.jsp">Account</a></li>
			<li><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></li>
			<%
			}
			%>
		</ul>
	</nav>
	<section class="bg-orange main-section">
		<div class="restaurant-header">
			<h1 class="text-brown" id="name">Edit Comment</h1>
			<div class="restaurant-info">
				<div class="rating"></div>
				<div class="price" id="price"></div>
			</div>
			<div class="mb-medium">
				<p class="address"></p>
			</div>
		</div>


		<div class="restaurant-reviews" id="authenticated-reviews">
			<form id="review-form" action="update" method="post">

				<h2 class="text-brown mb-small">Edit User</h2>
				<div class="mb-small">
					<input type="text" placeholder="Username" name="username"
						value="<c:out value="${user.username}" />" />
				</div>

				<div class="mb-small">
					<input type="text"  name="email"
						value="<c:out value="${user.email}" />" />
						
				</div>
				<div class="mb-small">
					<input type="text"  name="password"
						value="<c:out value="${user.password}" />" />
				</div>
				
				<div class="mb-small">
					<input type="text"  name="address"
						value="<c:out value="${user.address}" />" />
				</div>
				<div class="mb-small">
					<input type="text"  name="first_name"
						value="<c:out value="${user.first_name}" />" />
				</div>
				<div class="mb-small">
					<input type="text"  name="last_name"
						value="<c:out value="${user.last_name}" />" />
				</div>
				

				<div class="mb-small">
					<input type="text" name="phone"
						value="<c:out value="${user.phone}" />" />
						
						
				</div>
				
			 <div class="input-group">
              <label for="gender">Gender</label>
              <select name="gender">
                <option value="M">M</option>
                <option value="F">F</option>
              </select>
            
				</div>
				
				<div class="mb-small">
					<input type="hidden" name="id"
						value="<c:out value="${user.id}" />" />
				</div>
				<input type="submit" class="btn" value="Submit" />

			</form>
		</div>

		<footer class="footer">
			<h4>
				<i class="material-icons">dining</i>
			</h4>
			<span>&copy; Lump Of Yums 2022</span>
		</footer>
</body>
</html>