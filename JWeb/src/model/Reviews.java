package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import orm.OrmRequest;

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

	/**
	 * creation d'un avis lier a un idProduct et a un idUser avec un review
	 * 
	 * @param idProduct
	 * @param idUser
	 * @param review
	 */
	static public void createReview(int idProduct, int idUser, String review) {
		OrmRequest request = new OrmRequest();
		request.InsertInto("reviews", "null", idProduct, idUser, review.toCharArray());
		int statut = request.ExecuteUpdate();
		System.out.println("statut -> " + statut);
	}

	/**
	 * obtention d'une liste d'avis avec un idProduct
	 * 
	 * @param idProduct
	 * @return
	 */
	static public ArrayList<Reviews> getReviewsForProduct(int idProduct) {
		OrmRequest request = new OrmRequest();
		request.Select("reviews.id", "reviews.review", "user.firstname");
		request.From("reviews", "user");
		HashMap<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("reviews.idUser", "user.id".toCharArray());
		whereMap.put("reviews.idProduct", idProduct);
		request.Where(whereMap);
		ResultSet resultat = request.ExecuteQuery();

		ArrayList<Reviews> listReview = new ArrayList<Reviews>();
		if (resultat != null) {
			try {
				while (resultat.next()) {
					listReview.add(new Reviews(resultat.getInt("id"), resultat.getString("review"), resultat
							.getString("firstname")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listReview;
	}
}
