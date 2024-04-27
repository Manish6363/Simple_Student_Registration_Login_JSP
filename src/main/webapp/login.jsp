<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
* {
	margin: 0%;
	padding: 0%;
	box-sizing: 0%;
}

body {
	background-image: url(./image/login.jpg);
	background-size: cover;
	background-repeat: no-repeat;
}

@media ( min-width : 1100px) {
	#head {
		border: 2px solid red;
		width: 350px;
		text-align: center;
		font-size: 20px;
		padding: 20px;
		margin-left: 80px;
		border-radius: 20px;
		background-image: url(./image/inner.png);
		background-size: cover;
		background-repeat: no-repeat;
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
		color: white;
		font-size: 50px;
		text-decoration: "underline";
		padding-top: 80px;
		padding-left: 170px;
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
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
	%>
	<h1 style='color: red; font-size: 30px; display: inline;'>
		<%=msg%>

	</h1>
	<%
	}
	%>

	<h1>Login Page</h1>
	<br>
	<div id="head">
		<form action="login">
			<label>Email: </label> <input type="text" name="email"> <br>
			<br> <label>Password: </label> <input type="password"
				name="password"> <br> <br>
			<button id="but1">FETCH DATA</button>
		</form>
	</div>
</body>
</html>