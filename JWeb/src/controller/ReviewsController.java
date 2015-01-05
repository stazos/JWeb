package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Reviews;

public class ReviewsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * POST.
	 * Attend en params un "idProduct" et une "review"
	 * Créer une review lier a l'utilisateur connecter et au produit.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String idString = request.getParameter("idProduct");
		String review = request.getParameter("review").replace("'", "''").replace("\"", "\\\"");
		System.out.println(review);
		int idProduct = Integer.valueOf(idString);

		HttpSession session = request.getSession();
		Integer idUser = (Integer) session.getAttribute("idUser");

		Reviews.createReview(idProduct, idUser, review);
		LoadController.LoadProduct(request, response, idString);
	}
}
