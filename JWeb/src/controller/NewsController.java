package controller;

import java.io.IOException;
import java.io.PrintWriter;

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

		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		
		News.createNews(title, description);
		response.setStatus(200);
		PrintWriter out = response.getWriter();
		out.print("SUCCESS");
		out.flush();
	}

	/**
	 * GET.
	 * N'attend rien params.
	 * return toute les news.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String jsonObject = News.getNews();
		response.setContentType("application/json");
		response.setStatus(200);
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
		out.flush();
	}

}