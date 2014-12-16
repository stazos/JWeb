package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * POST.
	 * Attend en params un "name", une "photo", une "description", un float "price".
	 * créer un produit.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String name = request.getParameter("name");
		String photo = request.getParameter("photo");
		String description = request.getParameter("description");
		String priceString = request.getParameter("price");
		
		Float price = Float.valueOf(priceString);
		
		Product.createProduct(name, photo, description, price);

		response.setStatus(200);
		PrintWriter out = response.getWriter();
		out.print("SUCCESS");
		out.flush();
	}

	/**
	 * GET.
	 * Attend en params un "id" d'un produit
	 * retourne les informations de ce produit.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String idString = request.getParameter("id");
		int id = Integer.valueOf(idString);
		
		String jsonObject = Product.getProduct(id);

		response.setContentType("application/json");
		response.setStatus(200);
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
		out.flush();
	}

}
