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
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>    

<nav class="nav-wrapper">
    
      <a href="RecipeServlet"  class="brand-logo">Lump Of Yums</a>
      <ul class="nav-list">
        <li class="active"><a href="RecipeServlet" >Recipes</a></li>
            <%
                                   
                if (session.getAttribute("logUser") == null) {
            %>
        <li><a href="<%=request.getContextPath()%>/login.jsp">Sign in</a></li>
        <li><a href="<%=request.getContextPath()%>/register.jsp">Sign up</a></li>
        <% } else {
         %>
         	<li><a href="<%=request.getContextPath()%>/account.jsp">Account</a></li>
            <li><a href="LogoutServlet">Logout</a></li>
        <% }%>
      </ul>
    </nav>
    <section class="bg-orange main-section">
      <div class="restaurant-header">
        <h1 class="text-brown" id="name">Review Name</h1>
        <div class="restaurant-info">
          <div class="rating">Preparation time: 15 minutes</div>
          <div class="price" id="price">Cooking time: 20 minutes</div>
        </div>
        <div class="mb-medium">
          <p class="address">Level: Easy</p>
        </div>
        <img
          src="/img/photo-1414235077428-338989a2e8c0.jpeg"
          alt="restaurant"
          class="full-width-img"
        />
      </div>
      <div class="restaurant-details">
        <h1 class="text-brown mb-small">About this restaurant</h1>
        <div class="double-panel restaurant-details-content">
          <div class="left" style="width: 70%;">
            <div>
              <i class="material-icons">description</i>
              <span class="address">Hainan chicken rice ftw!</span>
            <div>
              <i class="material-icons">menu_book</i>
              <span id="cuisine">3 lb whole chicken(1.3 kg), giblets removed
¼ cup kosher salt(60 g), divided
4 inch pieces fresh ginger, peeled and cut into ¼-inch (6 mm) slices
1 bunch fresh scallion
1 gal cold water(3.7 L), plus more as needed
2 tablespoons sesame oil</span>
            </div>
            </div>
          </div>
          <div class="right">
     		Preparation:
     		
     		To clean the chicken, rub all over with a handful of kosher salt, getting rid of any loose skin. Rinse the chicken well inside and out. Pat dry with paper towels.
Remove any excess fat from the chicken and set aside for later.
Season the chicken generously with salt. Stuff the chicken cavity with the ginger slices and scallions.
Place the chicken in a large stock pot, cover with cold water by 1 inch (2 cm), and season with salt to taste.
          </div>
        </div>
      </div>
      <div class="restaurant-reviews">
        <h1 class="text-brown mb-small">Reviews</h1>
        <a class="btn" id="btn-review">Click here</a>
      </div>
    </section>
    
        <footer class="footer">
      <h4><i class="material-icons">dining</i></h4>
      <span>&copy; Lump Of Yums 2022</span>
    </footer>
</body>
</html>