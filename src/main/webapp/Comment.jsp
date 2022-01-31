<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
		<%
		String userName = (String) session.getAttribute("logUser1");
		String foodName = (String) session.getAttribute("food_name");
		String food_username = (String) session.getAttribute("username");
		%>


		<div class="restaurant-header">

			<h1 class="text-brown" id="name">
				<c:out value="${food_name}" />
			</h1>

			<div class="restaurant-info">
				<div class="rating" style="color: black;">
					Preparation time:
					<c:out value="${recipe.prep_time}" />
					Minutes
				</div>
				<div class="price" id="price">
					Cooking time:
					<c:out value="${recipe.cooking_time}" />
					Minutes
				</div>
				<div class="price" id="price">
					Level:
					<c:out value="${recipe.level}" />
				</div>
			</div>
			<div class="mb-medium">
				<p class="address">
					<c:out value="Posted by: ${username}" />
				</p>
			</div>
		</div>


		<h1 class="text-brown mb-small" style="margin-top: 30px;">Comments</h1>

		<c:forEach var="comments" items="${listComment}">

			<c:if test="${comments.recipe_name == food_name}">

				<div class="card" style="width: 100%; margin-bottom: 20px;">
					<div class="card-body">
						<h4 class="card-title" style="display: inline;">
							<c:out value="${comments.username}" />
						</h4>
						<%
						if (session.getAttribute("logUser") != null) {
						%>
						<c:if test="${comments.username == logUser1}">
							<div style="display: inline;">
								<a href="edit?id=<c:out value='${comments.id}' />"><i
									class="material-icons btn-icon" id="btn-edit">edit</i></a><a
									href="delete?id=<c:out value='${comments.id}' />"><i
									class="material-icons btn-icon" id="btn-delete">delete</i></a>
							</div>
						</c:if>
						<%
						}
						%>


						<p class="card-text">
							<c:out value="${comments.created_at}" />
						</p>
						<p class="card-text">
							<c:out value="${comments.comment}" />
						</p>
					</div>
				</div>

			</c:if>
		</c:forEach>

	</section>

	<footer class="footer">
		<h4>
			<i class="material-icons">dining</i>
		</h4>
		<span>&copy; Lump Of Yums 2022</span>
	</footer>
</body>
</html>