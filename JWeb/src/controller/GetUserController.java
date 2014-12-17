package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * GET.
	 * N'attend rien en params.
	 * Retourne tout les utilisateurs.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		LoadController.LoadAdmin(request, response);
	}

}
