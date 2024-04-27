package students.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import students.dao.StudentCrud;
import students.dto.Student;

@WebServlet("/edit")
public class Edit extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String updEmail = req.getParameter("email");
		int admId = Integer.parseInt(req.getParameter("id"));
		StudentCrud crud = new StudentCrud();

		try {
			Student updateStud = crud.fetchDataByEmail(updEmail);
			Student adminStud = crud.fetchDataById(admId);
			if (updateStud != null && adminStud != null ) {
				req.setAttribute("updateStud", updateStud);
				req.setAttribute("adminStud", adminStud);
				RequestDispatcher dispatcher=req.getRequestDispatcher("update.jsp");
				dispatcher.forward(req, res);
			}else {
				RequestDispatcher dispatch=req.getRequestDispatcher("login.jsp");
				dispatch.include(req, res);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
