package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.DbUtility;

public class Reviews {

	static public void createReview(int idProduct, int idUser, String review) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		try {
			String req = "INSERT INTO reviews VALUES (null, " + idProduct + ", " + idUser + ", " + review + ");";
			System.out.println(req);
			int statut = statement.executeUpdate(req);
			System.out.println("statut -> " + statut);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
	}

	static public String getReviewsForProduct(int idProduct) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		String jsonObject = "[";
		try {
			String req = "SELECT reviews.id, reviews.review, user.name FROM reviews, user "
					+ "WHERE reviews.idUser = user.id AND reviews.idProduct = " + idProduct + ";";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
			while (resultat.next()) {
				if (resultat.isFirst() == false)
					jsonObject += ", ";
				jsonObject += "{ ";
				jsonObject += "id: '" + resultat.getInt("id") + "', ";
				jsonObject += "review: '" + resultat.getString("review") + "', ";
				jsonObject += "userName: '" + resultat.getString("name");
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
}
