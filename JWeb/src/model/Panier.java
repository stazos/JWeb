package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.DbUtility;

public class Panier {

	static public void createPanier(int idUser, int idProduct) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		try {
			String req = "INSERT INTO panier VALUES (null, " + idUser + ", " + idProduct + ");";
			System.out.println(req);
			int statut = statement.executeUpdate(req);
			System.out.println("statut -> " + statut);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
	}

	static public String getProductPanier(int idUser) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		String jsonObject = "[";
		try {
			String req = "SELECT product.id, product.name, product.photo, product.description, product.price "
					+ "FROM product, panier WHERE product.id = panier.idProduct AND panier.idUser = " + idUser + ";";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
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

	static public void rmProductPanier(int idUser, int idProduct) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		try {
			String req = "DELETE panier WHERE idUser = " + idUser + " AND idProduct = " + idProduct + ";";
			System.out.println(req);
			int statut = statement.executeUpdate(req);
			System.out.println("statut -> " + statut);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
	}
	
	static public void rmAllProductPanier(int idUser) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		try {
			String req = "DELETE panier WHERE idUser = " + idUser + ";";
			System.out.println(req);
			int statut = statement.executeUpdate(req);
			System.out.println("statut -> " + statut);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
	}

}
