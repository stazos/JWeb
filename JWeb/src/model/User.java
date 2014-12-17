package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.DbUtility;

public class User {

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

	static public String getUser() {
		Connection connexion = DbUtility.connectToDB();
		Statement statement = DbUtility.getConnectStatement(connexion);
		String jsonObject = "[";
		try {
			String req = "SELECT id, firstname, lastname, email, newsletter, admin, date_inscription FROM user";
			System.out.println(req);
			ResultSet resultat = statement.executeQuery(req);
			System.out.println(resultat);
			while (resultat.next()) {
				if (resultat.isFirst() == false)
					jsonObject += ", ";
				jsonObject += "{ ";
				jsonObject += "\"id\": \"" + resultat.getInt("id") + "\", ";
				jsonObject += "\"firstname\": \"" + resultat.getString("firstname") + "\", ";
				jsonObject += "\"lastname\": \"" + resultat.getString("lastname") + "\", ";
				jsonObject += "\"email\": \"" + resultat.getString("email") + "\", ";
				jsonObject += "\"newsletter\": \"" + resultat.getBoolean("newsletter") + "\", ";
				jsonObject += "\"admin\": \"" + resultat.getBoolean("admin") + "\", ";
				jsonObject += "\"date_inscription\": \"" + resultat.getDate("date_inscription") + "\"";
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

}
