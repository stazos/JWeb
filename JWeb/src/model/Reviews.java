package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utility.DbUtility;

public class Reviews {

	private Integer id;
	private String review;
	private String userName;

	public Integer getId() {
		return id;
	}

	public String getReview() {
		return review;
	}

	public String getUserName() {
		return userName;
	}

	public Reviews(Integer id, String review, String userName) {
		this.id = id;
		this.review = review;
		this.userName = userName;
	}

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

	static public ArrayList<Reviews> getReviewsForProduct(int idProduct) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		ArrayList<Reviews> listReview = new ArrayList<Reviews>();
		try {
			String req = "SELECT reviews.id, reviews.review, user.name FROM reviews, user "
					+ "WHERE reviews.idUser = user.id AND reviews.idProduct = " + idProduct + ";";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
			while (resultat.next()) {
				listReview.add(new Reviews(resultat.getInt("id"), resultat.getString("review"), resultat
						.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
		return listReview;
	}
}
