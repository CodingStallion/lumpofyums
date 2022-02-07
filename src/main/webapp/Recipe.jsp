<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="lumpofyums.User"%>

<%@page import="lumpofyums.Recipe"%>
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
<%@page import="lumpofyums.User"%>
<%@page import="lumpofyums.Recipe"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
User user = (User) session.getAttribute("logUser");
if (user == null) {
	response.sendRedirect("index.jsp");
}

%>

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
		if (session.getAttribute("logUser") != null) {
		%>


		<%
           String userName = (String) session.getAttribute("logUser1");
         
         
            %>



		<c:if test="${recipe.username == logUser1}">
			<a class="btn" style="float: right; color: white;"
				href="edit?food_name=<c:out value='${recipe.food_name}' />">Edit
				Recipe</a>

			<a class="btn"
				style="float: right; margin-right: 10px; color: white;"
				href="delete?food_name=<c:out value='${recipe.food_name}' />">Delete
				Recipe</a>

		</c:if>
		<%
		}
		%>
		<div class="restaurant-header">
			<c:if test="${recipe != null}">
				<h1 class="text-brown" id="name">
					<c:out value="${recipe.food_name}" />
				</h1>
			</c:if>
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
					<c:out value="Posted by: ${recipe.username}" />
				</p>
			</div>
		</div>
		<div class="restaurant-details">
			<h1 class="text-brown mb-small">Content</h1>
			<div class="double-panel restaurant-details-content">
				<div class="left" style="width: 70%;">
					<div>

						<i class="material-icons">description</i> <span class="address"><b>Description:
						</b><br />
						<c:out value="${recipe.description}" /></span>
					</div>
					<div>
						<i class="material-icons">menu_book</i> <span id="cuisine"><b>Ingredients:
						</b><br />
						<c:out value="${recipe.ingredients}" /></span>
					</div>

				</div>
				<div class="left">
					<div>
						<i class="material-icons">soup_kitchen</i> <span id="cuisine"><b>Directions:
						</b><br />
						<c:out value="${recipe.preparation}" /></span>
					</div>

				</div>
			</div>
		</div>

		<div class="restaurant-reviews">

			<%
			if (session.getAttribute("logUser") == null) {
			%>

			<div class="restaurant-reviews" id="unauthenticated-reviews">
				<h1 class="text-brown mb-small">Want to write a comment?</h1>
				<div class="review-btns mb-medium">
					<a href="<%=request.getContextPath()%>/login.jsp"
						class="btn mr-small">Sign in</a> <a
						href="<%=request.getContextPath()%>/register.jsp" class="btn">Sign
						up</a>
				</div>
			</div>
		</div>

		<%
		} else {
		%>
		<!--Write Comment -->
		<h2 class="text-brown mb-small">Write a comment</h2>
		<form id="review-form" action="CreateCommentServlet" method="post">
			<div class="input-group mb-small">
				<textarea rows="10" cols="30" name="comment"
					placeholder="Your comment here"></textarea>
				<br />
			</div>
			<div class="mb-small" style="display: none;">
				<input type="number" value=<%=user.getId()%> name="uid" />

			</div>
			<div class="mb-small" style="display: none;">
				<input type="text" value="${recipe.food_name}" name="recipe_name" />
			</div>

			<input type="submit" class="btn" value="Submit" />
		</form>


		<%
		}
		%>

		<h1 class="text-brown mb-small" style="margin-top: 30px;">Comments</h1>

		<a class="btn"
			href="<%=request.getContextPath()%>/CommentServlet/list">View
			Comments</a>

	</section>

	<footer class="footer">
		<h4>
			<i class="material-icons">dining</i>
		</h4>
		<span>&copy; Lump Of Yums 2022</span>
	</footer>

</body>
</html>