<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<style>
	.formcontainer {
      		text-align: left;
      		margin: 24px 50px 12px;
      }
      .container {
      		padding: 16px 0;
      		text-align:left;
      }
      
       form {
      		border: 5px solid #f1f1f1;
      		width:450px;
      		margin-top:11%;
      }
      input[type=submit] {
	      background-color: #8ebf42;
	      color: white;
	      padding: 14px 0;
	      margin: 10px 0;
	      border: none;
	      cursor: grabbing;
	      width: 100%;
      }
      body{
      	height:100%;
      	display:flex;
      	justify-content:center;
      	
      }
      h1{
      	text-align:center;
      }
	</style>
	<form action="/JavaProject/HomePageServlet" method="post">
		        <div class="formcontainer">
		        <div class="container">
		          <input type="submit" value="Students" name="button" />
		          <input type="submit" value="Teachers" name="button" />
		          <input type="submit" value="Classes" name="button" />
		          <input type="submit" value="Exams" name="button" />
		        </div>
		        </div>
	</form>
</body>
</html>