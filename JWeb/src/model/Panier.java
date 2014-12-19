package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

	static public ArrayList<Product> getProductPanier(int idUser) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		ArrayList<Product> listProduct = new ArrayList<Product>();
		try {
			String req = "SELECT product.id, product.name, product.photo, product.description, product.price "
					+ "FROM product, panier WHERE product.id = panier.idProduct AND panier.idUser = " + idUser + ";";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
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
	
	static public int getNumberProductPanier(int idUser) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		int nb = 0;
		try {
			String req = "SELECT COUNT(*) as total FROM panier WHERE idUser = " + idUser + ";";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
			resultat.next();
			nb = resultat.getInt("total");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
		return nb;
	}

	static public void rmProductPanier(int idUser, int idProduct) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		try {
			String req = "DELETE FROM panier WHERE idUser = " + idUser + " AND idProduct = " + idProduct + ";";
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
			String req = "DELETE FROM panier WHERE idUser = " + idUser + ";";
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
