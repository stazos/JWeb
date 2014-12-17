package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

public class NewsletterController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * POST.
	 * Attend en params un "id" d'utilisateur.
	 * met a jour l'utilisateur pour qu'il reçoive la newsletter.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String idString = request.getParameter("id");
		System.out.println("fail " + idString);
		int id = Integer.valueOf(idString);

		User.userSetNewsletter(id);

		response.setStatus(200);
		PrintWriter out = response.getWriter();
		out.print("SUCCESS");
		out.flush();
	}
}