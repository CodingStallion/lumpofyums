<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "lump_of_yums";
String userid = "root";
String password = "password";
String food=request.getParameter("food_name");
String username=request.getParameter("username");
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
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
		<div class="mb-medium">
			<h1 class="text-brown" style="float: left;">Recipes</h1>
			<%
			if (session.getAttribute("logUser") != null) {
			%>
			<a class="btn" style="float: right;"
				href="<%=request.getContextPath()%>/create_recipe.jsp">Create
				Recipe</a>
			<%
			}
			%>
		</div>
		<form id="search-form" class="search-input mb-large" method="post" action="<%=request.getContextPath()%>/search.jsp">
			
			<input type="text" placeholder="Search" name="food_name"
				class="input" />
				<button type="submit"></button>
		</form>
		

		<div>
			<ul class="restaurant-list">
		<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from recipe R INNER JOIN user U ON R.uid = U.id where food_name like '%"+ food +"%'  ";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
					<li class="restaurant-item">
						<div class="text-align-center">

							<h4 class="mb-small">
									<%=resultSet.getString("food_name") %>
							</h4>
					<h6>
							Posted by: <%=resultSet.getString("username") %>
							</h6>
							<%
							if (session.getAttribute("logUser") != null) {
							%>
							<a class="btn"
								href="RecipeServlet/recipe?food_name=<%=resultSet.getString("food_name") %>">More
								info</a>
							<%
							} else {
							%>
							<a class="btn" href="http://localhost:8090/lumpofyums/login.jsp">Log
								in to view more </a>
							<%
							}
							%>
						</div>
					</li>
	<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
		
			</ul>
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