<%@page import="students.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0%;
	padding: 0%;
	box-sizing: 0%;
}

body {
	background-image: url(./image/update.jpg);
	background-size: cover;
	background-repeat: no-repeat;
}

@media ( min-width : 1100px) {
	#head {
		text-align: center;
		font-size: 20px;
	}
	#but1 {
		font-size: 20px;
		padding: 10px;
		background-color: rgb(0, 255, 0);
		color: red;
		border-radius: 10px;
		font-weight: bold;
	}
	h1 {
		color: fuchsia;
		font-size: 30px;
		text-decoration: "underline";
		padding-top: 20px;
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
	Student updateStud = (Student) request.getAttribute("updateStud");
	Student adminStud = (Student) request.getAttribute("adminStud");
	%>

	<h1 align="center">
		Welcome to Mr.
		<%=adminStud.getName()%>, please provide the details to update..!
	</h1>
	<br>
	<br>
	<div id="head">
		<form action="update">
			<input type="number" name="loginId" value="<%=adminStud.getId()%>"
				hidden="true"> <label>Name: </label> <input type="text"
				name="name" value="<%=updateStud.getName()%>"> <br> <label>Register
				ID: </label> <input type="number" name="id" value="<%=updateStud.getId()%>" readonly="readonly">
			<br> <label>Email: </label> <input type="text" name="email"
				value="<%=updateStud.getEmail()%>"> <br> <label>Phone:
			</label> <input type="number" name="phone"
				value="<%=updateStud.getPhone()%>"> <br> <label>Age:
			</label> <input type="number" name="age" value="<%=updateStud.getAge()%>">
			<br> <label>Gender: </label> <input type="radio" name="gender"
				value="<%=updateStud.getGender()%>">Male <input
				type="radio" name="gender" value="<%=updateStud.getGender()%>">Female
			<input type="radio" name="gender"
				value="<%=updateStud.getGender()%>">Others <br> <label>Address:
			</label> <input type="text" name="address"
				value="<%=updateStud.getAddress()%>"> <br> <label>Password:
			</label> <input type="password" name="password"
				value="<%=updateStud.getPassword()%>"> <br>
			<button id="but1">UPDATE DATA</button>
		</form>
	</div>
</body>
</html>