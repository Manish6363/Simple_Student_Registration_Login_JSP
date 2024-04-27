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
	background-image: url(./image/registration.jpg);
	background-size: 100% 130%;
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
		color: yellow;
		font-size: 50px;
		text-decoration: "underline";
		padding-top: 110px;
	}
	input {
		margin-bottom: 8px;
		font-size: 15px;
	}
}
</style>
</head>
<body>

	<h1 align="center">Welcome to Registration Page</h1>
	<br>
	<br>
	<div id="head">
		<form action="register">
			<label>Name: </label> <input type="text" name="name" placeholder="Enter your full name" required="required" autofocus="autofocus"> <br>
			<label>Register ID: </label> <input type="number" name="id" placeholder="Enter your unique ID" required="required">
			<br> <label>Email: </label> <input type="text" name="email" placeholder="Enter your email Id" required="required">
			<br> <label>Phone: </label> <input type="number" name="phone" placeholder="Enter your Mobile no" required="required">
			<br> <label>Age: </label> <input type="number" name="age" placeholder="Enter your age" required="required">
			<br> <label>Gender: </label> <input type="radio" name="gender"
				value="Male">Male <input type="radio" name="gender"
				value="Female">Female <input type="radio" name="gender"
				value="Others">Others <br> <label>Address: </label> <input
				type="text" name="address" placeholder="Enter your Address" required="required"> <br> <label>Password:
			</label> <input type="password" name="password"
				placeholder="Enter your Password" required="required"> <br>
			<button id="but1">REGISTER</button>
		</form>
	</div>
</body>
</html>