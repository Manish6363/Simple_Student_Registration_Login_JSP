package students.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import students.dao.StudentCrud;
import students.dto.Student;

@WebServlet("/add")
public class AddMore extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		int id = Integer.parseInt(req.getParameter("id"));
		String email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("phone"));
		int age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		String password = req.getParameter("password");
		PrintWriter out = res.getWriter();
		
		Student stud = new Student(name, id, email, phone, age, gender, address, password);
		StudentCrud crud = new StudentCrud();
		
		try {
			crud.insertData(stud);
			int loginId = Integer.parseInt(req.getParameter("loginId"));
			System.out.println(loginId);
			stud = crud.fetchDataById(loginId);
			if (stud != null) {
				ArrayList<Student> al = crud.fetchAll();
				req.setAttribute("stud", stud);
				req.setAttribute("al", al);
				RequestDispatcher dispatcher = req.getRequestDispatcher("print.jsp");
				dispatcher.forward(req, res);
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, res);
			}
		} catch (ClassNotFoundException | SQLException e) {
			out.println("<h1><font color='white'> Something went wrong...!</font></h1>");
			e.printStackTrace();
			RequestDispatcher dispatch=req.getRequestDispatcher("update.jsp");
			dispatch.include(req, res);
		}
	}

}

