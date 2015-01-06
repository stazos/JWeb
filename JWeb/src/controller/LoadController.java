package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.News;
import model.Panier;
import model.Product;
import model.Reviews;
import model.User;

public class LoadController {
	
	static private ArrayList<Product> ListProducts;
	static private ArrayList<User> ListUsers;
	static private ArrayList<Reviews> ListReviews;
	static private ArrayList<Product> Paniers;
	static private Product Prod;
	static private int Nb;


	public ArrayList<Product> getListProduct() {
		return ListProducts;
	}
	public ArrayList<User> getUsers() {
		return ListUsers;
	}
	public ArrayList<Reviews> getReviews() {
		return ListReviews;
	}
	public ArrayList<Product> getPanier() {
		return Paniers;
	}
	public Product getProduct() {
		return Prod;
	}
	public Integer getNbPanier() {
		return Nb;
	}

	
	static public void LoadAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		request.setAttribute("news", News.getNews());
		ListProducts = Product.getAllProduct();
		ListUsers = User.getUser();

		RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
		view.forward(request, response);
	}
	
	static public void LoadUser(HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		HttpSession session = request.getSession();

		request.setAttribute("news", News.getNews());
		ListProducts = Product.getAllProduct();		
		Nb = Panier.getNumberProductPanier((Integer)session.getAttribute("idUser"));
		
		RequestDispatcher view = request.getRequestDispatcher("pages/welcome.jsp");
		view.forward(request, response);
	}
	
	static public void LoadProduct(HttpServletRequest request, HttpServletResponse response, String idProduct) throws IOException,
			ServletException {
		
		HttpSession session = request.getSession();		
		int id = Integer.valueOf(idProduct);

		Prod = Product.getProduct(id);
		ListReviews = Reviews.getReviewsForProduct(id);		

		int idUser = (Integer)session.getAttribute("idUser");
		Nb = Panier.getNumberProductPanier(Integer.valueOf(idUser));

		RequestDispatcher view = request.getRequestDispatcher("pages/product.jsp");
		view.forward(request, response);
	}
	
	static public void LoadShop(HttpServletRequest request, HttpServletResponse response) throws IOException,
	ServletException {

		HttpSession session = request.getSession();

		Paniers = (ArrayList<Product>) Panier.getProductPanier((Integer) session.getAttribute("idUser"));
		Nb = Panier.getNumberProductPanier((Integer)session.getAttribute("idUser"));
		
		RequestDispatcher view = request.getRequestDispatcher("pages/panier.jsp");
		view.forward(request, response);
	}

}
