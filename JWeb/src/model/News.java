package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utility.DbUtility;

public class News {

	private String title;
	private String description;
	private Date date;

	public News(String title, String description, Date date) {
		this.title = title;
		this.description = description;
		this.date = date;
	}

	static public void createNews(String title, String description) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		try {
			String req = "INSERT INTO news VALUES (null, '" + title + "', '"
					+ description + "', NOW());";
			System.out.println(req);
			int statut = statement.executeUpdate(req);
			System.out.println("statut -> " + statut);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
	}

	static public List<News> getNews() {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		List<News> listNews = new ArrayList<News>();
		try {
			String req = "SELECT title, description, date FROM news;";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
			System.out.println(resultat);
			while (resultat.next()) {
				String title = resultat.getString("title");
				String description = resultat.getString("description");
				Date date = resultat.getDate("date");
				listNews.add(new News(title, description, date));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
		return listNews;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Date getDate() {
		return date;
	}
}
