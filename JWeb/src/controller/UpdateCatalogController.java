package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

public class UpdateCatalogController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String[] listIdUserDelete = request.getParameterValues("delete");
		
		if (listIdUserDelete != null)
			for (int i = 0; i < listIdUserDelete.length; i++) {
				Integer id = Integer.valueOf(listIdUserDelete[i]);
				Product.productDelete(id);
			}
		request.setAttribute("success", "Article supprimé");
		LoadController.LoadAdmin(request, response);
	}
}