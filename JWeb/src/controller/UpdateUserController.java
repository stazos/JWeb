package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

public class UpdateUserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String[] listIdNewsletter = request.getParameterValues("newsletter");
		String[] listIdAdmin = request.getParameterValues("admin");
		String[] listIdUserDelete = request.getParameterValues("delete");

		User.userUnsetNewsletter();
		User.userUnsetAdmin();
		
		if (listIdNewsletter != null)
			for (int i = 0; i < listIdNewsletter.length; i++) {
				Integer id = Integer.valueOf(listIdNewsletter[i]);
				User.userSetNewsletter(id);
			}
		if (listIdAdmin != null)
			for (int i = 0; i < listIdAdmin.length; i++) {
				Integer id = Integer.valueOf(listIdAdmin[i]);
				User.userSetAdmin(id);
			}
		if (listIdUserDelete != null)
			for (int i = 0; i < listIdUserDelete.length; i++) {
				Integer id = Integer.valueOf(listIdUserDelete[i]);
				User.userDelete(id);
			}
		request.setAttribute("success", "mise a jour base de donné reussi");
		LoadController.LoadAdmin(request, response);
	}

}