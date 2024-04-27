<html>
<head>
<title>Home Page</title>
<style type="text/css">
* {
	margin: 0%;
	padding: 0%;
	box-sizing: 0%;
}

body {
	background-image: url(./image/home.webp);
	background-size: cover;
	background-repeat: no-repeat;
}

@media ( min-width : 1100px) {
	div {
		width: 700px;
		background-color: gainsboro;
		font-size: 50px;
		color: red;
		font-size: 20px;
		margin-left: 10%;
		padding: 10px;
		text-align: center;
		border-radius: 20px;
		margin-top: 12%;
	}
	button {
		font-size: 25px;
		padding: 5px;
		margin-bottom: 20px;
		margin-right: 30px;
		color: white;
		font-weight: bold;
		border-radius: 15px;
	}
	#but1 {
		background-color: fuchsia;
	}
	#but2 {
		background-color: green;
	}
}
</style>
</head>
<body>
	<div>
		<h1>WELCOME to STUDENT PORTAL</h1>
		<br> <a href="register.jsp"><button id="but1">New
				Registration</button></a> <a href="login.jsp"><button id="but2">Login</button></a>
	</div>
</body>
</html>


 
