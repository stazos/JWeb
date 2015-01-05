package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Panier;

public class PanierController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * POST.
	 * Attend en params un "idProduct".
	 * ajoute le produit au panier de l'utilisateur courant.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String idProductString = request.getParameter("idProduct");

		int idProduct = Integer.valueOf(idProductString);
		
		HttpSession session = request.getSession();
		Integer idUser = (Integer) session.getAttribute("idUser");
		
		Panier.createPanier(idUser, idProduct);
		LoadController.LoadUser(request, response);
	}

	/**
	 * GET.
	 * N'attend aucun params.
	 * Retourne tout les produits du panier de l'utilisateur courant.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


		
		
		
		LoadController.LoadShop(request, response);
	}

}
