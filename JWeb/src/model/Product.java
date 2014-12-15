package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.DbUtility;

public class Product {

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

	static public String getAllProduct() {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		String jsonObject = "[";
		try {
			String req = "SELECT id, name, photo, description, price FROM product;";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
			System.out.println(resultat);
			while (resultat.next()) {
				if (resultat.isFirst() == false)
					jsonObject += ", ";
				jsonObject += "{ ";
				jsonObject += "id: '" + resultat.getInt("id") + "', ";
				jsonObject += "name: '" + resultat.getString("name") + "', ";
				jsonObject += "photo: '" + resultat.getString("photo") + "', ";
				jsonObject += "description: '" + resultat.getString("description") + "', ";
				jsonObject += "price: " + resultat.getString("price") + ", ";
				jsonObject += " }";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
		jsonObject += "]";
		return jsonObject;
	}

	static public String getProduct(int id) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		String jsonObject = "";
		try {
			String req = "SELECT name, photo, description, price FROM product WHERE id = " + id + ";";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
			System.out.println(resultat);
			resultat.next();
			if (resultat.isFirst() == true) {
				jsonObject += "{ ";
				jsonObject += "name: '" + resultat.getString("name") + "', ";
				jsonObject += "photo: '" + resultat.getString("photo") + "', ";
				jsonObject += "description: '" + resultat.getString("description") + "', ";
				jsonObject += "price: " + resultat.getString("price") + ", ";
				jsonObject += " }";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
		return jsonObject;
	}

}
