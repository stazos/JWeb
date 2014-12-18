package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

import utility.DbUtility;

public class News {

	private String title;
	private String description;
	private Date date;

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Date getDate() {
		return date;
	}

	public News(String title, String description, Date date) {
		this.title = title;
		this.description = description;
		this.date = date;
	}

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

	static public ArrayList<News> getNews() {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		ArrayList<News> listNews = new ArrayList<News>();
		try {
			String req = "SELECT title, description, date FROM news;";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
			System.out.println(resultat);
			while (resultat.next()) {
				listNews.add(new News(resultat.getString("title"), resultat.getString("description"), resultat
						.getDate("date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
		return listNews;
	}
}
