package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.User;

public class LoadController {

	static public void LoadAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		ArrayList<User> listUser = User.getUser();
		
		ArrayList<Product> listProduct = Product.getAllProduct();
		
		request.setAttribute("listUser", listUser);
		request.setAttribute("listProduct", listProduct);
		RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
	    view.forward(request, response);
	}
	
}
