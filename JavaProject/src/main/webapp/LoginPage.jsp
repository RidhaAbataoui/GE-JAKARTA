<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
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
      }
      input[type=text], input[type=password]{
		      width: 100%;
		      padding: 16px 8px;
		      margin: 8px 0;
		      display: inline-block;
		      border: 1px solid #ccc;
		      box-sizing: border-box;
      }
      button {
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
      .loging{
      	margin-top:10%;
      }
      h1{
      	text-align:center;
      }
	</style>
	
	
	<div class="loging">
		<h1>Welcome</h1>
		<form action="/JavaProject/LogingVerification" method="post">
			        <div class="formcontainer">
			        <div class="container">
			          <input type="text" placeholder=" UserName " name="username" required>
			          <input type="password" placeholder=" Password " name="password" required>
			        </div>
			        <button type="submit">Login</button>
			        </div>
	    </form>
	</div>
	
</body>
</html>