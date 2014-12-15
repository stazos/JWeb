package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

public class Inscription extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String newsletter = request.getParameter("newsletter");

		System.out.println(newsletter);
		if (newsletter == null)
			newsletter = "false";
		// Now use our Coffee Model above
		if (User.checkUserMail(email) == true) {
			User.createUser(firstname, lastname, email, password, newsletter);
			int id = User.connectUser(email, password);
			if (id != -1) {
				HttpSession session = request.getSession();
				session.setAttribute("idUser", id);
				session.setAttribute("admin", false);
				if (User.userIsAdmin(id) == true) {
					session.setAttribute("admin", true);
					response.setStatus(200);
					PrintWriter out = response.getWriter();
					out.print("admin/admin.jsp");
					// RequestDispatcher view =
					// request.getRequestDispatcher("admin/admin.jsp");
					// view.forward(request, response);
				}
				response.setStatus(200);
				PrintWriter out = response.getWriter();
				out.print("pages/welcome.jsp");
				// RequestDispatcher view =
				// request.getRequestDispatcher("pages/welcome.jsp");
				// view.forward(request, response);
			} else {
				response.setStatus(403);
				PrintWriter out = response.getWriter();
				out.print("FAIL");
			}
		} else {
			response.setStatus(403);
			PrintWriter out = response.getWriter();
			out.print("FAIL");
		}
		// Use the below code to debug the program if you get problems
		// response.setContentType("text/html"):
		// PrintWriter out = response.getWriter();
		// out.println("Coffee Selection Advise<br>");

		// Iterator it = result.iterator();
		// while(it.hasNext()) {
		// out.print("<br>try: " + it.next());
		// }

		// The results will be passed back (as an attribute) to the JSP view
		// The attribute will be a name/value pair, the value in this case will
		// be a List object
		// request.setAttribute("styles", result);
		// RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		// view.forward(request, response);
	}
}