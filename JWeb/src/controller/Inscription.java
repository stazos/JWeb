package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

public class Inscription extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * POST. Attend en params un "firstname", un "lastname", un "email", un
	 * "password" et un boolean "newsletter. inscrit et connecte l'utilisateur
	 * et renvoie le chemin de la page sur laquel il doit etre redirigé.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String validPassword = request.getParameter("validPassword");
		String newsletter = request.getParameter("newsletter");
				
		if (newsletter == null)
			newsletter = "false";
		if (firstname == "" || lastname == "" || email == "" || password == "" || password.equals(validPassword) == false) {
			request.setAttribute("error", "Erreur dans le formulaire d'inscription");
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		    view.forward(request, response); 
		    return;
		}
		if (User.checkUserMail(email) == true) {
			User.createUser(firstname, lastname, email, password, newsletter);
			int id = User.connectUser(email, password);
			if (id != -1) {
				HttpSession session = request.getSession();
				session.setAttribute("idUser", id);
				session.setAttribute("admin", false);
				if (User.userIsAdmin(id) == true) {
					session.setAttribute("admin", true);
					LoadController.LoadAdmin(request, response);
				} else {
					LoadController.LoadUser(request, response); 
				}
				// RequestDispatcher view =
				// request.getRequestDispatcher("pages/welcome.jsp");
				// view.forward(request, response);
			} else {
				request.setAttribute("error", "Erreur impossible de connecter l'utilisateur");
				RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			    view.forward(request, response); 
			}
		} else {
			request.setAttribute("error", "Erreur email déja existant");
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		    view.forward(request, response); 
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