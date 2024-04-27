<%@page import="students.dto.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0%;
	padding: 0%;
	box-sizing: 0%;
}

body {
	background-image: url(./image/print.jpg);
	background-size: cover;
	background-repeat: no-repeat;
}

@media ( min-width : 1100px) {
	td {
		border: 1px solid blue;
	}
	h1 {
		text-align: center;
		font-size: 30px;
		color: red;
		padding: 20px;
	}
	button {
		padding: 5px;
		padding-left: 20px;
		padding-right: 20px;
		margin: auto;
		background-color: yellow;
		border: none;
		border-radius: 10px;
	}
	#but{
		margin: auto;
		font-size: 25px;
		font-weight: bold;
		padding: 10px;
		background-image: linear-gradient( orange, white, green);
		margin-left: 20px;
	}
	table {
		margin: auto;
		border: 2px solid red;
	}
	th, td {
		border: 1px solid blue;
		font-size: 20px;
	}
	span {
		color: blue;
	}
}
</style>
</head>
<body>
	<%
	Student stud = (Student) request.getAttribute("stud");
	ArrayList<Student> al = (ArrayList<Student>) request.getAttribute("al");
	%>
	<h1>
		Mr. <span><%=stud.getName()%></span> the record which are present in
		Database...!
	</h1>
	<a href="addmore.jsp?name=<%=stud.getName()%>&loginID=<%=stud.getId()%>"><button id="but">INSERT NEW RECORD</button></a>
	<table align="center">
	<tr>
	<th>Name</th>
	<th>ID</th>
	<th>Email</th>
	<th>Phone</th>
	<th>Age</th>
	<th>Gender</th>
	<th>Address</th>
	<th>Password</th>
	</tr>
	<%
	for (Student s : al) {
	%>
	
		<tr>			
			<td><%=s.getName()%></td>	
			<td><%=s.getId()%></td>
			<td><%=s.getEmail()%></td>		
			<td><%=s.getPhone()%></td>			
			<td><%=s.getAge()%></td>
			<td><%=s.getGender()%></td>
			
			<td><%=s.getAddress()%></td>
		
			
			<td><%=s.getPassword()%></td>
		</tr>
		<tr>
			<th style="border: 1px solid blue;" colspan=2><a
				href="edit?email=<%=s.getEmail()%>&id=<%=stud.getId()%>"><button>UPDATE</button></a>
			</th>
		</tr>
		<tr>
			<th style="border: 1px solid blue;" colspan=2><a
				href="delete?email=<%=s.getEmail()%>&id=<%=stud.getId()%>"><button
						style="background-color: red;">DELETE</button></a></th>
		</tr>
	</table>
	<br>
	<br>
	<%
	}
	%>


</body>
</html>