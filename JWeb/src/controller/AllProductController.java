package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

public class AllProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * GET.
	 * N'attend rien en params.
	 * Retourne tout les products.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String jsonObject = Product.getAllProduct();

		response.setContentType("application/json");
		response.setStatus(200);
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
		out.flush();
	}

}
