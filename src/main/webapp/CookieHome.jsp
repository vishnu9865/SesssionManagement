<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Cookie Home</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
  <h1 class="text-center mt-3">Cookie Home</h1>
  <hr>
  <%
  boolean isSet = false;
  String username = "";
  Cookie cookies[] = request.getCookies();
  if( cookies != null) {
	  for( Cookie cookie: cookies) {
		  if( cookie.getName().equals("username")) {
			  isSet = true;
			  username = cookie.getValue();
		  }
	  }
  }
  if( !isSet) username = "Value not Set";
  %>
  <div class="card w-50 mx-auto">
  	<div class="card-body">
  		 <div class="mx-auto d-block">Cookie Name: <%= username %></div>
  		 <form action="CookieLogout" method="get">
  		 	<button type="submit" class="btn btn-primary">Logout</button>
  		 </form>
  	</div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>