package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Deconnexion extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * POST.
	 * Attend en params un "id"
	 * DeConnect l'utilisateur et retourne le chemin page sur laquel il doit etre redirigé.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession();
		session.setAttribute("idUser", null);
		session.setAttribute("admin", false);
		request.setAttribute("success", "Vous vous êtes bien déconnecté.");
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
	    view.forward(request, response);
	}
}