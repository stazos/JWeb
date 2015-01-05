package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.News;

public class UpdateNewsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String[] listIdNewsDelete = request.getParameterValues("delete");

		if (listIdNewsDelete != null)
			for (int i = 0; i < listIdNewsDelete.length; i++) {
				Integer id = Integer.valueOf(listIdNewsDelete[i]);
				News.newsDelete(id);
			}
		request.setAttribute("success", "mise a jour base de donné reussi");
		LoadController.LoadAdmin(request, response);
	}
}