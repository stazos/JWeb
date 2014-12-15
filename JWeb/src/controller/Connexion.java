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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		int id = User.connectUser(email, password);
		if (id != -1) {
			HttpSession session = request.getSession();
			session.setAttribute("idUser", id);
			response.setStatus(200);
			PrintWriter out = response.getWriter();
			out.print("SUCCESS");
		} else {
			response.setStatus(403);
			PrintWriter out = response.getWriter();
			out.print("FAIL");
		}
	}
}