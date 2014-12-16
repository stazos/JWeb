package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * POST.
	 * Attend en params un "id" d'utilisateur.
	 * Donne à cette utilisateur les droits administrateur.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String idString = request.getParameter("id");
		int id = Integer.valueOf(idString);

		User.userSetAdmin(id);

		response.setStatus(200);
		PrintWriter out = response.getWriter();
		out.print("SUCCESS");
		out.flush();
	}
}