package students.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import students.dao.StudentCrud;
import students.dto.Student;

@WebServlet("/register")
public class StudentRegistration extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		int id=Integer.parseInt(req.getParameter("id"));
		String email=req.getParameter("email");
		long phone=Long.parseLong(req.getParameter("phone"));
		int age=Integer.parseInt(req.getParameter("age"));
		String gender=req.getParameter("gender");
		String address=req.getParameter("address");
		String password=req.getParameter("password");
		
		Student stud=new Student(name, id, email, phone, age, gender, address, password);
		
		StudentCrud crud=new StudentCrud();
		
		try {
			crud.insertData(stud);
			RequestDispatcher dispatch=req.getRequestDispatcher("login.jsp");
			dispatch.forward(req, res);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			PrintWriter out=res.getWriter();
			out.println("<h1 style='color: red; font-size: 50px; display: inline; padding-left:350px; margin:0px; '> Something went wrong...!</font></h1>");
			RequestDispatcher dispatch=req.getRequestDispatcher("register.jsp");
			dispatch.include(req, res);
		}
	}

}
