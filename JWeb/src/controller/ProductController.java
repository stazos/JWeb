package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Product;

public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * POST. Attend en params un "name", une "photo", une "description", un
	 * float "price". créer un produit.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String name = request.getParameter("title").replace("'", "''");
		String description = request.getParameter("description").replace("'", "''");
		String priceString = request.getParameter("price");
		if (priceString.equals(""))
			priceString = "0";
		Float price = Float.valueOf(priceString);
		Part part = request.getPart("file");
		String nomFichier = getFileName(part);
		
		if (!name.equals("") && !description.equals("") && !priceString.equals("") && nomFichier != null && !nomFichier.equals("\"\"") && !nomFichier.isEmpty()) {
			nomFichier = nomFichier.substring(1, nomFichier.length() - 1);
			String path = System.getProperty("user.home");
			path = path + "/git/JWeb/JWeb/WebContent/img/product/";
			writeFile(part, nomFichier, path);
			String photoPath = "./img/product/" + nomFichier;
			Product.createProduct(name, photoPath, description, price);
			request.setAttribute("success", "creation du produit reussi");
		} else
			request.setAttribute("error", "probleme lors de la mise en ligne du produit");
		LoadController.LoadAdmin(request, response);
	}

	private static String getFileName(Part part) {
		for (String contentDisposition : part.getHeader("content-disposition")
				.split(";")) {
			if (contentDisposition.trim().startsWith("filename")) {
				return contentDisposition.substring(contentDisposition
						.indexOf('=') + 1);
			}
		}
		return null;
	}

	private void writeFile(Part part, String nomFichier, String chemin)
			throws IOException {

		BufferedInputStream entree = null;
		BufferedOutputStream sortie = null;
		try {
			entree = new BufferedInputStream(part.getInputStream(), 10240);
			sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), 10240);
			byte[] tampon = new byte[10240];
			int longueur;
			while ((longueur = entree.read(tampon)) > 0) {
				sortie.write(tampon, 0, longueur);
			}
		} catch (IOException ignore) {
		} finally {
			try {
				sortie.close();
			} catch (Exception ignore) {
			}
			try {
				entree.close();
			} catch (IOException ignore) {
			}
		}
	}
}
