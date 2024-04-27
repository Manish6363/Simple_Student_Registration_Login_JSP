<%@page import="students.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>
<style>
* {
	margin: 0%;
	padding: 0%;
	box-sizing: 0%;
}

body {
	background-image: url(./image/inner.png);
	background-size: cover;
	background-repeat: no-repeat;
}

#head {
	text-align: center;
	font-size: 20px;
}

@media ( min-width : 1100px) {
	#but1 {
		font-size: 20px;
		padding: 10px;
		background-color: rgb(0, 255, 0);
		color: red;
		border-radius: 10px;
		font-weight: bold;
	}
	h1 {
		text-align: center;
		font-size: 30px;
		color: white;
		padding: 20px;
	}
	span {
		color: red;
	}
	label {
		color: white;
		font-weight: bold;
	}
	input {
		margin-bottom: 8px;
		font-size: 15px;
	}
}
</style>
</head>
<body>

	<%
	String name = (String) request.getParameter("name");
	int id = Integer.parseInt((String) request.getParameter("loginID"));
	%>

	<h1 align="center">
		Mr. <span> <%=name%>
		</span>, please provide the details of <span>NEW Student...!</span>
	</h1>
	<br>
	<br>
	<div id="head">
		<form action="add">
			<input type="number" name="loginId" value="<%=id%>" hidden="true">
			<label>Name: </label> <input type="text" name="name"
				placeholder="Enter your full name" required="required"
				autofocus="autofocus"> <br> <label>Register ID:
			</label> <input type="number" name="id" placeholder="Enter your unique ID"
				required="required"> <br> <label>Email: </label> <input
				type="text" name="email" placeholder="Enter your email Id"
				required="required"> <br> <label>Phone: </label> <input
				type="number" name="phone" placeholder="Enter your Mobile no"
				required="required"> <br> <label>Age: </label> <input
				type="number" name="age" placeholder="Enter your age"
				required="required"> <br> <label>Gender: </label> <input
				type="radio" name="gender" value="Male">Male <input
				type="radio" name="gender" value="Female">Female <input
				type="radio" name="gender" value="Others">Others <br> <label>Address:
			</label> <input type="text" name="address" placeholder="Enter your Address"
				required="required"> <br> <label>Password: </label> <input
				type="password" name="password" placeholder="Enter your Password"
				required="required"> <br>
			<button id="but1">REGISTER</button>
		</form>
	</div>
</body>
</html>