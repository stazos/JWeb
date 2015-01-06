package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import orm.OrmRequest;

public class Product {

	private Integer id;
	private String name;
	private String photo;
	private String description;
	private Float price;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhoto() {
		return photo;
	}

	public String getDescription() {
		return description;
	}

	public Float getPrice() {
		return price;
	}

	public Product(Integer id, String name, String photo, String description, Float price) {
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.description = description;
		this.price = price;
	}

	/**
	 * valid
	 * 
	 * @param name
	 * @param photo
	 * @param description
	 * @param price
	 */
	static public void createProduct(String name, String photo, String description, Float price) {
		OrmRequest request = new OrmRequest();
		request.InsertInto("product", "null", name.toCharArray(), photo.toCharArray(), description.toCharArray(), price);
		int statut = request.ExecuteUpdate();
		System.out.println("statut -> " + statut);
	}

	/**
	 * valid
	 * 
	 * @return
	 */
	static public ArrayList<Product> getAllProduct() {
		OrmRequest request = new OrmRequest();
		request.Select("id", "name", "photo", "description", "price");
		request.From("product");
		ResultSet resultat = request.ExecuteQuery();

		ArrayList<Product> listProduct = new ArrayList<Product>();
		if (resultat != null) {
			try {
				while (resultat.next()) {
					listProduct.add(new Product(resultat.getInt("id"), resultat.getString("name"), resultat
							.getString("photo"), resultat.getString("description"), resultat.getFloat("price")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listProduct;
	}

	/**
	 * valid
	 * 
	 * @param id
	 * @return
	 */
	static public Product getProduct(int id) {
		OrmRequest request = new OrmRequest();
		request.Select("name", "photo", "description", "price");
		request.From("product");
		HashMap<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("id", id);
		request.Where(whereMap);
		ResultSet resultat = request.ExecuteQuery();
		Product product = null;
		if (resultat != null) {
			try {
				resultat.next();
				if (resultat.isFirst() == true) {
					product = new Product(id, resultat.getString("name"), resultat.getString("photo"),
							resultat.getString("description"), resultat.getFloat("price"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return product;
	}

	/**
	 * valid
	 * 
	 * @param id
	 */
	static public void productDelete(int id) {
		OrmRequest request = new OrmRequest();
		request.DeleteFrom("product");
		HashMap<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("id", id);
		request.Where(whereMap);
		int statut = request.ExecuteUpdate();
		System.out.println("statut -> " + statut);
	}
}
