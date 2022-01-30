<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<title>Lump Of Yums</title>
</head>
<body>

    <nav class="nav-wrapper">
    
      <a href="<%=request.getContextPath()%>/RecipeServlet/home" class="brand-logo">Lump Of Yums</a>
      <ul class="nav-list">
        <li class="active"><a href="<%=request.getContextPath()%>/RecipeServlet/home">Recipes</a></li>
            <%
                                   
                if (session.getAttribute("logUser") == null) {
            %>
        <li><a href="<%=request.getContextPath()%>/login.jsp">Sign in</a></li>
        <li><a href="<%=request.getContextPath()%>/register.jsp">Sign up</a></li>
        <% } else {
         %>
         	<li><a href="<%=request.getContextPath()%>/account.jsp">Account</a></li>
            <li><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></li>
        <% }%>
      </ul>
    </nav>
    <section class="bg-orange main-section">
      <div class="restaurant-header">
        <h1 class="text-brown" id="name">Edit your recipe</h1>
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
        
              <h2 class="text-brown mb-small">Edit Comment</h2> 
    		<div class="mb-small">
              <input type="text" placeholder="Comment" name="comment" value="<c:out value="${edit.comment}" />"/> 
            </div>
            
             	<div class="mb-small">
              <input type="hidden" placeholder="Recipe name" name="recipe_name" value="<c:out value="${edit.recipe_name}" />"/> 
            </div>
          
            	<div class="mb-small">
              <input type="hidden"  name="uid" value="<c:out value="${edit.uid}" />" /> 
            </div>
            
            <div class="mb-small">
              <input type="text"  name="created_at" value="<c:out value="${edit.created_at}" />" /> 
            </div>
 
 
    
          <input type="submit" class="btn" value="Submit" />
   
        </form>
      </div>

   
    
     <footer class="footer">
      <h4><i class="material-icons">dining</i></h4>
      <span>&copy; Lump Of Yums 2022</span>
    </footer>
</body>
</html>