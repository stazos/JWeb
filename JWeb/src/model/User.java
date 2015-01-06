package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import orm.OrmRequest;

public class User {

	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private Boolean newsletter;
	private Boolean admin;

	public Integer getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public Boolean getNewsletter() {
		return newsletter;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public User(Integer id, String firstname, String lastname, String email, Boolean newsletter, Boolean admin) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.newsletter = newsletter;
		this.admin = admin;
	}

	/**
	 * valid
	 * 
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param password
	 * @param newsletter
	 */
	static public void createUser(String firstname, String lastname, String email, String password, String newsletter) {
		OrmRequest request = new OrmRequest();
		request.InsertInto("user", "null", firstname.toCharArray(), lastname.toCharArray(), email.toCharArray(),
				"MD5(\"" + password + "\")", newsletter, "false", "NOW()");
		int statut = request.ExecuteUpdate();
		System.out.println("statut -> " + statut);
	}

	/**
	 * valid
	 * 
	 * @param email
	 * @return
	 */
	static public boolean checkUserMail(String email) {
		OrmRequest request = new OrmRequest();
		request.Select("email");
		request.From("user");
		HashMap<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("email", email);
		request.Where(whereMap);
		ResultSet resultat = request.ExecuteQuery();

		boolean result = false;
		if (resultat != null) {
			try {
				int rowcount = 0;
				if (resultat.last()) {
					rowcount = resultat.getRow();
				}
				if (rowcount == 0) {
					result = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * valid
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	static public int connectUser(String email, String password) {
		OrmRequest request = new OrmRequest();
		request.Select("id");
		request.From("user");
		HashMap<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("email", email);
		String md5 = "MD5(\"" + password + "\")";
		whereMap.put("password", md5.toCharArray());
		request.Where(whereMap);
		ResultSet resultat = request.ExecuteQuery();

		int id = -1;
		if (resultat != null) {
			try {
				resultat.next();
				if (resultat.isFirst() == true) {
					id = resultat.getInt("id");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}

	/**
	 * valid
	 * 
	 * @param id
	 * @return
	 */
	static public Boolean userIsAdmin(int id) {
		OrmRequest request = new OrmRequest();
		request.Select("admin");
		request.From("user");
		HashMap<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("id", id);
		request.Where(whereMap);
		ResultSet resultat = request.ExecuteQuery();

		Boolean result = false;
		if (resultat != null) {
			try {
				resultat.next();
				if (resultat.isFirst() == true) {
					if (resultat.getBoolean("admin") == true) {
						result = true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * valid
	 * 
	 * @return
	 */
	static public ArrayList<User> getUser() {
		OrmRequest request = new OrmRequest();
		request.Select("id", "firstname", "lastname", "email", "newsletter", "admin", "date_inscription");
		request.From("user");
		ResultSet resultat = request.ExecuteQuery();

		ArrayList<User> listUser = new ArrayList<User>();
		if (resultat != null) {
			try {
				while (resultat.next()) {
					listUser.add(new User(resultat.getInt("id"), resultat.getString("firstname"), resultat
							.getString("lastname"), resultat.getString("email"), resultat.getBoolean("newsletter"),
							resultat.getBoolean("admin")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listUser;
	}

	/**
	 * valid
	 * 
	 * @param id
	 */
	static public void userSetAdmin(int id) {
		OrmRequest request = new OrmRequest();
		request.Update("user", "admin", "true");
		HashMap<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("id", id);
		request.Where(whereMap);
		int statut = request.ExecuteUpdate();
		System.out.println("statut -> " + statut);
	}

	/**
	 * valid
	 * 
	 * @param id
	 */
	static public void userSetNewsletter(int id) {
		OrmRequest request = new OrmRequest();
		request.Update("user", "newsletter", "true");
		HashMap<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("id", id);
		request.Where(whereMap);
		int statut = request.ExecuteUpdate();
		System.out.println("statut -> " + statut);
	}

	/**
	 * valid
	 * 
	 * @param id
	 */
	static public void userDelete(int id) {
		OrmRequest request = new OrmRequest();
		request.DeleteFrom("user");
		HashMap<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("id", id);
		request.Where(whereMap);
		int statut = request.ExecuteUpdate();
		System.out.println("statut -> " + statut);
	}

	/**
	 * valid
	 */
	static public void userUnsetNewsletter() {
		OrmRequest request = new OrmRequest();
		request.Update("user", "newsletter", "false");
		HashMap<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("newsletter", "true".toCharArray());
		request.Where(whereMap);
		int statut = request.ExecuteUpdate();
		System.out.println("statut -> " + statut);
	}

	/**
	 * valid
	 */
	static public void userUnsetAdmin() {
		OrmRequest request = new OrmRequest();
		request.Update("user", "admin", "false");
		HashMap<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("admin", "true".toCharArray());
		request.Where(whereMap);
		int statut = request.ExecuteUpdate();
		System.out.println("statut -> " + statut);
	}

}
