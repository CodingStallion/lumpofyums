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
<link href="https://fonts.googleapis.com/css2?family=Cookie&family=Mochiy+Pop+P+One&display=swap" rel="stylesheet">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" 
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
crossorigin="anonymous">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>

<!--  Lump Of Yums Update 1 -->
    <nav class="nav-wrapper">
      <a href="RecipeServlet"  class="brand-logo">Lump Of Yums</a>
      <ul class="nav-list">
        <li><a href="RecipeServlet" >Recipes</a></li>
                    <%               
                if (session.getAttribute("logUser") == null) {
            %>
        <li><a href="<%=request.getContextPath()%>/login.jsp">Sign in</a></li>
        <li><a href="<%=request.getContextPath()%>/register.jsp">Sign up</a></li>
        <% } else {
         %>
         	<li class="active"><a href="<%=request.getContextPath()%>/account.jsp">Account</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        <% }%>

      </ul>
    </nav>
    
<section class="bg-white main-section">
      <div class="mb-medium">
        <h1 class="text-brown">My Account</h1>
      </div>
      <div class="mb-medium">
        <div class="account-detail">
          <span>Username:</span>
          <p id="username"><%= user.getUserName() %></p>
        </div>
        <div class="account-detail">
          <span>Gender:</span>
          <p id="gender"><%= user.getGender() %></p>
        </div>
        <div class="account-detail">
          <span>First name:</span>
          <p id="first_name"><%= user.getFirstName() %></p>
        </div>
        <div class="account-detail">
          <span>Last name:</span>
          <p id="last_name"><%= user.getLastName() %></p>
        </div>
        <div class="account-detail">
          <span>Address:</span>
          <p id="address"><%= user.getAddress() %></p>
        </div>
        <div class="account-detail">
          <span>Email:</span>
          <p id="email"><%= user.getEmail() %></p>
        </div>
        <div class="account-detail">
          <span>Phone:</span>
          <p id="phone"><%= user.getPhone() %></p>
        </div>
      </div>
      <div class="deactivate">
        <span>Deactivate account?</span>
        <a id="btn-deactivate" class="btn">Deactivate here</a>
      </div>
    </section>
    
        <footer class="footer">
      <h4><i class="material-icons">dining</i></h4>
      <span>&copy; Lump Of Yums 2022</span>
    </footer>
</body>
</html>