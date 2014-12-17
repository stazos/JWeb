package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * POST.
	 * Attend en params un "name", une "photo", une "description", un float "price".
	 * créer un produit.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String name = request.getParameter("title");
		String photo = request.getParameter("file");
		String description = request.getParameter("description");
		String priceString = request.getParameter("price");
		System.out.println("name :" + name);
		Float price = Float.valueOf(priceString);
		
		// String fileName = request.getParameter("fileName");
		// if(fileName == null || fileName.equals("")){
		// throw new ServletException("File Name can't be null or empty");
		// }
		// File file = new
		// File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileName);
		// if(!file.exists()){
		// throw new ServletException("File doesn't exists on server.");
		// }
		// System.out.println("File location on server::"+file.getAbsolutePath());
		// ServletContext ctx = getServletContext();
		// InputStream fis = new FileInputStream(file);
		// String mimeType = ctx.getMimeType(file.getAbsolutePath());
		// response.setContentType(mimeType != null?
		// mimeType:"application/octet-stream");
		// response.setContentLength((int) file.length());
		// response.setHeader("Content-Disposition", "attachment; filename=\"" +
		// fileName + "\"");
		//
		// ServletOutputStream os = response.getOutputStream();
		// byte[] bufferData = new byte[1024];
		// int read=0;
		// while((read = fis.read(bufferData))!= -1){
		// os.write(bufferData, 0, read);
		// }
		// os.flush();
		// os.close();
		// fis.close();
		// System.out.println("File downloaded at client successfully");
		
		System.out.println(photo);
		
		Product.createProduct(name, null, description, price);

		request.setAttribute("successProduct", "creation du produit reussi");
		RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
	    view.forward(request, response); 
	}

	/**
	 * GET.
	 * Attend en params un "id" d'un produit
	 * retourne les informations de ce produit.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String idString = request.getParameter("id");
		int id = Integer.valueOf(idString);
		
		String jsonObject = Product.getProduct(id);

		response.setContentType("application/json");
		response.setStatus(200);
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
		out.flush();
	}

}
