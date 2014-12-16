package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Reviews;

public class ReviewsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String idString = request.getParameter("idProduct");
		String review = request.getParameter("review");

		int idProduct = Integer.valueOf(idString);

		HttpSession session = request.getSession();
		Integer idUser = (Integer) session.getAttribute("idUser");

		Reviews.createReview(idProduct, idUser, review);

		response.setStatus(200);
		PrintWriter out = response.getWriter();
		out.print("SUCCESS");
		out.flush();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String idString = request.getParameter("id");
		int idProduct = Integer.valueOf(idString);
		
		String jsonObject = Reviews.getReviewsForProduct(idProduct);

		response.setContentType("application/json");
		response.setStatus(200);
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
		out.flush();
	}

}
