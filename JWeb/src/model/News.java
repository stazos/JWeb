package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.DbUtility;

public class News {

	static public void createNews(String title, String description) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		try {
			String req = "INSERT INTO news VALUES (null, '" + title + "', '" + description + "', NOW());";
			System.out.println(req);
			int statut = statement.executeUpdate(req);
			System.out.println("statut -> " + statut);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
	}

	static public String getNews() {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		String jsonObject = "[";
		try {
			String req = "SELECT title, description, date FROM news;";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
			System.out.println(resultat);
			while (resultat.next()) {
				if (resultat.isFirst() == false)
					jsonObject += ", ";
				jsonObject += "{ ";
				jsonObject += "\"title\": \"" + resultat.getString("title") + "\", ";
				jsonObject += "\"description\": \"" + resultat.getString("description") + "\", ";
				jsonObject += "\"date\": \"" + resultat.getDate("date") + "\"";
				jsonObject += " }";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
		jsonObject += "]";
		System.out.println(jsonObject);
		return jsonObject;
	}
}
