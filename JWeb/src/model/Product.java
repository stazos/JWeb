package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utility.DbUtility;

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

	static public void createProduct(String name, String photo, String description, Float price) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		try {
			String req = "INSERT INTO product VALUES (null, '" + name + "', '" + photo + "', '" + description + "', "
					+ price + ");";
			System.out.println(req);
			int statut = statement.executeUpdate(req);
			System.out.println("statut -> " + statut);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
	}

	static public ArrayList<Product> getAllProduct() {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		ArrayList<Product> listProduct = new ArrayList<Product>();
		try {
			String req = "SELECT id, name, photo, description, price FROM product;";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
			System.out.println(resultat);
			while (resultat.next()) {
				listProduct.add(new Product(resultat.getInt("id"), resultat.getString("name"), resultat
						.getString("photo"), resultat.getString("description"), resultat.getFloat("price")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
		return listProduct;
	}

	static public Product getProduct(int id) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		Product product = null;
		try {
			String req = "SELECT name, photo, description, price FROM product WHERE id = " + id + ";";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
			System.out.println(resultat);
			resultat.next();
			if (resultat.isFirst() == true) {
				product = new Product(id, resultat.getString("name"), resultat.getString("photo"),
						resultat.getString("description"), resultat.getFloat("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
		return product;
	}
}
