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
	
	static private ArrayList<News> TOTO_NEWS;
	static private ArrayList<Product> TOTO_PRODUCT;

	static public void LoadAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		ArrayList<User> listUser = User.getUser();
		ArrayList<News> listNews = News.getNews();
		ArrayList<Product> listProduct = Product.getAllProduct();

		request.setAttribute("listUser", listUser);
		request.setAttribute("listProduct", listProduct);
		request.setAttribute("listNews", listNews);
		RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
		view.forward(request, response);
	}

	public ArrayList<News> getNews() {
		return TOTO_NEWS;
	}
	
	public ArrayList<Product> getListProduct() {
		return TOTO_PRODUCT;
	}
	
	static public void LoadUser(HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		ArrayList<News> listNews = News.getNews();
		TOTO_NEWS = listNews;
		ArrayList<Product> listProduct = Product.getAllProduct();
		TOTO_PRODUCT = listProduct;
		
		HttpSession session = request.getSession();
		Integer idString = (Integer) session.getAttribute("idUser");
		int id = Integer.valueOf(idString);
		int inPanier = Panier.getNumberProductPanier(id);

		request.setAttribute("listNews", listNews);
		request.setAttribute("listProduct", listProduct);
		request.setAttribute("inPanier", inPanier);
		RequestDispatcher view = request.getRequestDispatcher("pages/welcome.jsp");
		view.forward(request, response);
	}
	
	static public void LoadProduct(HttpServletRequest request, HttpServletResponse response, String idString) throws IOException,
			ServletException {
		
		int id = Integer.valueOf(idString);
		Product product = Product.getProduct(id);
		ArrayList<Reviews> listReviews = Reviews.getReviewsForProduct(id);

		request.setAttribute("Product", product);
		request.setAttribute("ListReviews", listReviews);
		RequestDispatcher view = request.getRequestDispatcher("pages/product.jsp");
		view.forward(request, response);
	}
	
	static public void LoadShop(HttpServletRequest request, HttpServletResponse response) throws IOException,
	ServletException {

		HttpSession session = request.getSession();
		Integer idString = (Integer) session.getAttribute("idUser");
		int id = Integer.valueOf(idString);
		ArrayList<Product> paniers = (ArrayList<Product>) Panier.getProductPanier(id);
		int inPanier = Panier.getNumberProductPanier(id);
		
		request.setAttribute("inPanier", inPanier);
		request.setAttribute("Panier", paniers);
		RequestDispatcher view = request.getRequestDispatcher("pages/panier.jsp");
		view.forward(request, response);
}

}
