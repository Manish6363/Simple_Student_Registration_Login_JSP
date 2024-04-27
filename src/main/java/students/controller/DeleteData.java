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

@WebServlet("/delete")
public class DeleteData extends HttpServlet {
	StudentCrud crud = new StudentCrud();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String email = req.getParameter("email");
		int id = Integer.parseInt(req.getParameter("id"));
		StudentCrud crud = new StudentCrud();
		try {
			crud.delete(email);
			Student stud = crud.fetchDataById(id);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
