<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" 
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
crossorigin="anonymous">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link rel="stylesheet" href="css/style.css">
<title>Lump Of Yums</title>
</head>
<body>
<!--  Lump Of Yums Update 1 -->
    <nav class="nav-wrapper">
      <a href="/" class="brand-logo">Lump Of Yums</a>
      <ul class="nav-list">
        <li class="active"><a href="/">Recipes</a></li>
        <li><a href="/login">Sign in</a></li>
        <li><a href="/register">Sign up</a></li>
      </ul>
    </nav>

<section class="bg-orange main-section">
      <div class="mb-medium">
        <h1 class="text-brown">Recipes</h1>
      </div>
      <form id="search-form" class="search-input mb-large">
        <button type="submit">
          <i class="material-icons btn-icon">search</i>
        </button>
        <input
          type="text"
          placeholder="Search"
          name="search_term"
          class="input"
        />
      </form>

      <div>
        <ul class="restaurant-list">
        	  <li class="restaurant-item">
                <img src="assets/recipie_sample.jpg" alt="Img">
                <div class="text-align-center">
                    <h4 class="mb-small">Recipe 1</h4>
                    <a class="btn">More info</a>
                  </div>
            </li>
        </ul>
      </div>
    </section>

    <footer class="footer">
      <h4><i class="material-icons">dining</i></h4>
      <span>&copy; Lump Of Yums 2022</span>
    </footer>
</body>
</html>