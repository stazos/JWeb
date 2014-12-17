package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utility.DbUtility;

public class User {

	private Integer id;
	private String firtname;
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

	static public void createUser(String firstname, String lastname, String email, String password, String newsletter) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		try {
			String req = "INSERT INTO user VALUES (null, '" + firstname + "', '" + lastname + "', '" + email
					+ "', MD5('" + password + "'), " + newsletter + ", false , NOW());";
			System.out.println(req);
			int statut = statement.executeUpdate(req);
			System.out.println("statut -> " + statut);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
	}

	static public boolean checkUserMail(String email) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		boolean result = false;
		try {
			String req = "SELECT email FROM user WHERE email = '" + email + "';";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
			System.out.println(resultat);
			int rowcount = 0;
			if (resultat.last()) {
				rowcount = resultat.getRow();
			}
			if (rowcount == 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
		return result;
	}

	static public int connectUser(String email, String password) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		int id = -1;
		try {
			String req = "SELECT id FROM user WHERE email = '" + email + "' AND password = MD5('" + password + "');";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
			System.out.println(resultat);
			resultat.next();
			if (resultat.isFirst() == true) {
				id = resultat.getInt("id");
				System.out.println(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
		return id;
	}

	static public Boolean userIsAdmin(int id) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		Boolean result = false;
		try {
			String req = "SELECT admin FROM user WHERE id = " + id + ";";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
			System.out.println(resultat);
			resultat.next();
			if (resultat.isFirst() == true) {
				if (resultat.getBoolean("admin") == true) {
					result = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
		return result;
	}

	static public ArrayList<User> getUser() {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		ArrayList<User> listUser = new ArrayList<User>();
		try {
			String req = "SELECT id, firstname, lastname, email, newsletter, admin, date_inscription FROM user";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
			System.out.println(resultat);
			while (resultat.next()) {
				listUser.add(new User(resultat.getInt("id"), resultat.getString("firstname"), resultat
						.getString("lastname"), resultat.getString("email"), resultat.getBoolean("newsletter"),
						resultat.getBoolean("admin")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
		return listUser;
	}

	static public void userSetAdmin(int id) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		try {
			String req = "UPDATE user SET admin = true WHERE id = " + id + ";";
			System.out.println(req);
			int statut = statement.executeUpdate(req);
			System.out.println("statut -> " + statut);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
	}

	static public void userSetNewsletter(int id) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		try {
			String req = "UPDATE user SET newsletter = true WHERE id = " + id + ";";
			System.out.println(req);
			int statut = statement.executeUpdate(req);
			System.out.println("statut -> " + statut);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
	}

	static public void userDelete(int id) {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		try {
			String req = "DELETE FROM user WHERE id = " + id + ";";
			System.out.println(req);
			int statut = statement.executeUpdate(req);
			System.out.println("statut -> " + statut);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
	}

	static public void userUnsetNewsletter() {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		try {
			String req = "UPDATE user SET newsletter = false WHERE newsletter = true;";
			System.out.println(req);
			int statut = statement.executeUpdate(req);
			System.out.println("statut -> " + statut);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtility.closeConnexion(connexion, statement);
		}
	}
	
	static public void userUnsetAdmin() {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		try {
			String req = "UPDATE user SET admin = false WHERE admin = true;";
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
