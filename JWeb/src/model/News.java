package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import orm.OrmRequest;

public class News {

	private String id;
	private String title;
	private String description;
	private Date date;

	public String getId() {
		return id;
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

	public News(String id, String title, String description, Date date) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
	}

	/**
	 * valid
	 * 
	 * @param title
	 * @param description
	 */
	static public void createNews(String title, String description) {
		OrmRequest request = new OrmRequest();
		request.InsertInto("news", "null", title.toCharArray(), description.toCharArray(), "NOW()");
		int statut = request.ExecuteUpdate();
		System.out.println("statut -> " + statut);
	}

	/**
	 * valid
	 * 
	 * @return
	 */
	static public ArrayList<News> getNews() {
		OrmRequest request = new OrmRequest();
		request.Select("id", "title", "description", "date");
		request.From("news");
		ResultSet resultat = request.ExecuteQuery();

		ArrayList<News> listNews = new ArrayList<News>();
		if (resultat != null) {
			try {
				while (resultat.next()) {
					listNews.add(new News(resultat.getString("id"), resultat.getString("title"), resultat
							.getString("description"), resultat.getDate("date")));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listNews;
	}

	/**
	 * valid
	 * 
	 * @param id
	 */
	static public void newsDelete(int id) {
		OrmRequest request = new OrmRequest();
		request.DeleteFrom("news");
		HashMap<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("id", id);
		request.Where(whereMap);
		int statut = request.ExecuteUpdate();
		System.out.println("statut -> " + statut);
	}
}
