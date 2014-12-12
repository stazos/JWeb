package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import controller.Synchronize;

public class User {

	private String firstName;
	private String lastName;
	private String email;
	private Date born;
	private Boolean admin;

	static public void createUser(String firstname, String lastname,
			String email, String password, String newsletter) {
		String url = "jdbc:mysql://localhost/jweb";
		String utilisateur = "root";
		String motDePasse = "admin";
		Connection connexion = null;
		Statement statement = null;
		try {
			System.out.println(newsletter);
			connexion = DriverManager.getConnection(url, utilisateur,
					motDePasse);
			statement = connexion.createStatement();
			String req = "INSERT INTO user (firstname, lastname, email, password, newsletter, date_inscription) "
					+ "VALUES ('"
					+ firstname
					+ "', '"
					+ lastname
					+ "', '"
					+ email
					+ "', MD5('"
					+ password
					+ "'), "
					+ newsletter
					+ ", NOW());";
			String req2 = "INSERT INTO user VALUES (null, '" + firstname
					+ "', '" + lastname + "', '" + email + "', MD5('"
					+ password + "'), " + newsletter + ", false , NOW());";
			System.out.println(req2);
			int statut = statement.executeUpdate(req2);
			System.out.println("statut -> " + statut);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				try {
					/* Puis on ferme le Statement */
					statement.close();
				} catch (SQLException ignore) {
				}
			}
			if (connexion != null)
				try {
					connexion.close();
				} catch (SQLException ignore) {
				}
		}
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

}
