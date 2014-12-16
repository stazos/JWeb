package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtility {

	public static void synDB() {
		Connection connexion = connectToDB();
		Statement statement = getConnectStatement(connexion);
		try {
			int status = statement.executeUpdate("DROP TABLE IF EXISTS user");
			status = statement.executeUpdate("DROP TABLE IF EXISTS product");
			status = statement.executeUpdate("DROP TABLE IF EXISTS reviews");
			status = statement.executeUpdate("DROP TABLE IF EXISTS news");
			status = statement.executeUpdate("DROP TABLE IF EXISTS panier");
			status = statement
					.executeUpdate("CREATE TABLE IF NOT EXISTS user ("
							+ "id int(11) NOT NULL auto_increment, "
							+ "firstname varchar(255) NOT NULL, "
							+ "lastname varchar(255) NOT NULL, "
							+ "email varchar(255) NOT NULL, "
							+ "password varchar(255) NOT NULL, "
							+ "newsletter bool DEFAULT false NOT NULL, "
							+ "admin bool DEFAULT false NOT NULL, "
							+ "date_inscription date DEFAULT '00-00-0000' NOT NULL, "
							+ "PRIMARY KEY (id), KEY id (id), "
							+ "UNIQUE id_2 (id) );");
			System.out.println("statut -> " + status);
			// product : id, nom , photo, description, prix
			status = statement
					.executeUpdate("CREATE TABLE IF NOT EXISTS product ("
							+ "id int(11) NOT NULL auto_increment, "
							+ "name varchar(255) NOT NULL, "
							+ "photo varchar(255) NOT NULL, "
							+ "description varchar(255) NOT NULL, "
							+ "price float NOT NULL, "
							+ "PRIMARY KEY (id), KEY id (id), "
							+ "UNIQUE id_2 (id) );");
			System.out.println("statut -> " + status);
			// reviews: id, idProduit, idUser, avis
			status = statement
					.executeUpdate("CREATE TABLE IF NOT EXISTS reviews ("
							+ "id int(11) NOT NULL auto_increment, "
							+ "idProduct int(11) NOT NULL, "
							+ "idUser int(11) NOT NULL, "
							+ "review varchar(255) NOT NULL, "
							+ "PRIMARY KEY (id), KEY id (id), "
							+ "UNIQUE id_2 (id) );");
			System.out.println("statut -> " + status);
			// news: id, titre, description
			status = statement
					.executeUpdate("CREATE TABLE IF NOT EXISTS news ("
							+ "id int(11) NOT NULL auto_increment, "
							+ "title varchar(255) NOT NULL, "
							+ "description varchar(255) NOT NULL, "
							+ "date date DEFAULT '00-00-0000' NOT NULL, "
							+ "PRIMARY KEY (id), KEY id (id), "
							+ "UNIQUE id_2 (id) );");
			System.out.println("statut -> " + status);
			// panier: id, idUser, idProduct
			status = statement
					.executeUpdate("CREATE TABLE IF NOT EXISTS panier ("
							+ "id int(11) NOT NULL auto_increment, "
							+ "idUser int(11) NOT NULL, "
							+ "idProduct int(11) NOT NULL, "
							+ "PRIMARY KEY (id), KEY id (id), "
							+ "UNIQUE id_2 (id) );");
			System.out.println("statut -> " + status);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnexion(connexion, statement);
		}
	}

	static public Connection connectToDB() {
		String url = "jdbc:mysql://localhost/jweb";
		String utilisateur = "root";
		String motDePasse = "admin";
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection(url, utilisateur,
					motDePasse);
		} catch (SQLException e) {
			e.printStackTrace();
			closeConnexion(connexion, null);
		}
		return connexion;
	}

	static public Statement getConnectStatement(Connection connexion) {
		Statement statement = null;
		try {
			statement = connexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			closeConnexion(connexion, statement);
		}
		return statement;
	}

	static public void closeConnexion(Connection connexion, Statement statement) {
		if (statement != null) {
			try {
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
