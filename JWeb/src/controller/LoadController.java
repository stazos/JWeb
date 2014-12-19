package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.News;
import model.Product;
import model.User;

public class LoadController {

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

	static public void LoadUser(HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		ArrayList<News> listNews = News.getNews();
		ArrayList<Product> listProduct = Product.getAllProduct();

		request.setAttribute("listNews", listNews);
		request.setAttribute("listProduct", listProduct);
		RequestDispatcher view = request.getRequestDispatcher("pages/welcome.jsp");
		view.forward(request, response);
	}

}
