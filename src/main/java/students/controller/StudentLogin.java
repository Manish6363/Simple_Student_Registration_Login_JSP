package students.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import students.dao.StudentCrud;
import students.dto.Student;

@WebServlet("/login")
public class StudentLogin extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		ArrayList<Student> al=new ArrayList<Student>();
		StudentCrud crud = new StudentCrud();
		
		try {
			Student stud = crud.fetchDataByEmail(email);
			if (stud != null) {
				if (stud.getPassword().equals(password)) {
					al=crud.fetchAll();

					req.setAttribute("stud", stud);
					req.setAttribute("al", al);
					
					RequestDispatcher dispatcher=req.getRequestDispatcher("print.jsp");
					dispatcher.forward(req, res);
				} else {
					req.setAttribute("msg", "Given PASSWORD is wrong...!");
					RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
					dispatcher.include(req, res);
				}
			} else {
				req.setAttribute("msg", "Given EMAIL is wrong...!");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, res);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
