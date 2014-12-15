package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

public class Connexion extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String email = request.getParameter("login");
		String password = request.getParameter("password");

		int id = User.connectUser(email, password);
		if (id != -1) {
			HttpSession session = request.getSession();
			session.setAttribute("idUser", id);
			session.setAttribute("admin", false);
			if (User.userIsAdmin(id) == true) {
				session.setAttribute("admin", true);
				response.setStatus(200);
				PrintWriter out = response.getWriter();
				out.print("admin/admin.jsp");
			}
			response.setStatus(200);
			PrintWriter out = response.getWriter();
			out.print("pages/welcome.jsp");
		} else {
			response.setStatus(403);
			PrintWriter out = response.getWriter();
			out.print("FAIL");
		}
	}
}