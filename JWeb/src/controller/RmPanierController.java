package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Panier;

public class RmPanierController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * POST.
	 * Attend en params un "idProduct" non obligatoire.
	 * Supprime le produit du panier si renseigner sinon supprime tout les produits du panier de l'utilisateur.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String idProductString = request.getParameter("idProduct");
		HttpSession session = request.getSession();
		Integer idUser = (Integer) session.getAttribute("idUser");
		if (idProductString != null) {
			int idProduct = Integer.valueOf(idProductString);
			Panier.rmProductPanier(idUser, idProduct);
		} else {
			Panier.rmAllProductPanier(idUser);
		}
		LoadController.LoadShop(request, response);
	}
}
