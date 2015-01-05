package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.News;

public class NewsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * POST.
	 * Attend en params un "title" et une "description".
	 * créé une news.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String title = request.getParameter("title").replace("'", "''");
		String description = request.getParameter("description").replace("'", "''");
		
		if (!title.equals("") && !description.equals("")) {
			News.createNews(title, description);
			request.setAttribute("success", "creation de la news reussi");
		}
		else {
			request.setAttribute("error", "Echec de l'ajout de la news");
		}
		LoadController.LoadAdmin(request, response);
	}
}