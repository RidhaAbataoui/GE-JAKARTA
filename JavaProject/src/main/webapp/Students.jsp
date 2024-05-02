<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = " com.educationalsystem.bean.DBConnection" %>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Educational system</title>
</head>
<body>
	<style>
	.table_component {
    	overflow: auto;
    	width: 100%;
	}

	.table_component table {
    	border: 1px solid #dededf;
    	height: 100%;
    	width: 100%;
   		table-layout: fixed;
    	border-collapse: collapse;
    	border-spacing: 1px;
    	text-align: left;
	}

	.table_component caption {
    	caption-side: top;
    	text-align: left;
	}

	.table_component th {
    	border: 1px solid #dededf;
    	background-color: #eceff1;
    	color: #000000;
    	padding: 5px;
	}

	.table_component td {
    	border: 1px solid #dededf;
    	background-color: #ffffff;
    	color: #000000;
    	padding: 5px;
	}
	
	.information_manipulation{
		display: flex;
 		flex-flow: row wrap;
 		width: 100%;
	}
	
	.information_manipulation >*{
		width: calc(100%/3);
	}
	
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
      		width:80%;
      }
      input[type=text]{
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
	  .return{
	  		margin-top:3%;
	  }
	</style>
	<div class="table_component" role="region" tabindex="0">
	<%
		DBConnection.getConnection();
		Connection con = DBConnection.con;
		ResultSet rs;
		rs = con.createStatement().executeQuery("SELECT * FROM Etudiant ;");
	%>
	<table>
	    <caption><h1>Students List : </h1></caption>
	    <thead>
	        <tr>
	            <th>Student ID</th>
	            <th>First name</th>
	            <th>Last name</th>
	            <th>Birthdate</th>
	            <th>CNE</th>
	            <th>Class ID</th>
	            <th>if leader</th>
	        </tr>
	    </thead>
	    <tbody>
	    	<% while(rs.next()){ %>
	        <tr>
	            <td><%=rs.getInt(1) %></td>
	            <td><%=rs.getString(3) %></td>
	            <td><%=rs.getString(4) %></td>
	            <td><%=rs.getString(5) %></td>
	            <td><%=rs.getString(6) %></td>
	            <td><%=rs.getInt(2) %></td>
	            <td><%=rs.getBoolean(7) %></td>
	        </tr>
	        <%
	        } 
	    	rs.close();
	    	con.close();
	    	%>
	    </tbody>
	</table>
	</div>
	<div class="information_manipulation">
		<div class="add_student">
			<h1>Add Student : </h1>
		    <form action="/JavaProject/ADDStudent" method="post">
	        <div class="formcontainer">
	        <div class="container">
	          <input type="text" placeholder="First name : " name="firstname" required>
	          <input type="text" placeholder="Last name : " name="lastname" required>
	          <input type="text" placeholder="Birthdate (YYYY-MM-DD) : " name="birthdate" required>
	          <input type="text" placeholder="CNE : " name="cne" required>
	          <input type="text" placeholder="if leader (true/false) :" name="ifleader" required>
	          <input type="text" placeholder="Class ID" name="classid" required>
	        </div>
	        <button type="submit">Add</button>
	        </div>
	      </form>
		  </div>
		  <div class="delete_student">
		  
			  <h1>Delete Student : </h1>
			  
			  <form action="/JavaProject/DeleteStudent" method="post">
		        <div class="formcontainer">
		        <div class="container">
		          <input type="text" placeholder="Student ID : " name="studentIDdelete" required>
		        </div>
		        <button type="submit">Delete</button>
		        </div>
		      </form>
		      
		      <form action="/JavaProject/ReturnToHome" method="post" class="return">
		      		<div class="formcontainer">
						<button type="submit">Return To Home</button>
					</div>
		      </form>
		  </div>
		  <div>
			  <h1>Modify Student : </h1>
			  <form action="/JavaProject/ModifyStudent" method="post">
		        <div class="formcontainer">
		        <div class="container">
		          <input type="text" placeholder="Student ID : " name="studentIDmodify" required>
		          <input type="text" placeholder="First name : " name="firstnameModify" >
		          <input type="text" placeholder="Last name : " name="lastnameModify" >
		          <input type="text" placeholder="Birthdate (YYYY-MM-DD) : " name="birthdateModify" >
		          <input type="text" placeholder="if leader (true/false) : " name="ifleaderModify" >
		          <input type="text" placeholder="Class ID : " name="classIDModify">
		        </div>
		        <button type="submit">Modify</button>
		        </div>
		      </form>
		  </div>
	</div>
</body>
</html>