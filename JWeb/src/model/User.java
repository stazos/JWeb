package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class User {

	private String firstName;
	private String lastName;
	private String email;
	private Date born;
	private Boolean admin;

	static public void createUser(String firstname, String lastname, String email,
			String password, String newsletter) {
		String url = "jdbc:mysql://localhost/jweb";
		String utilisateur = "root";
		String motDePasse = "admin";
		Connection connexion = null;
		Statement statement = null;
		try {
			connexion = DriverManager.getConnection(url, utilisateur,
					motDePasse);
			statement = connexion.createStatement();
			int status = statement.executeUpdate(
					"CREATE TABLE user (id int(11) NOT NULL auto_increment, firstname varchar(255) NOT NULL, lastname varchar(255) NOT NULL, email varchar(255) NOT NULL, password varchar(255) NOT NULL, newsletter bool NOT NULL, date_inscription date DEFAULT '00-00-0000' NOT NULL, PRIMARY KEY (id), KEY id (id), UNIQUE id_2 (id) );");			
			System.out.println("statut -> " + status);
			int statut = statement
					.executeUpdate("INSERT INTO user (firstname, lastname, email, password, date_inscription) "
							+ "VALUES ('"
							+ firstname
							+ "', '"
							+ lastname
							+ "', '"
							+ email
							+ "', MD5('"
							+ password
							+ "'), NOW());");
			System.out.println("statut -> " + statut);
				

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
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
