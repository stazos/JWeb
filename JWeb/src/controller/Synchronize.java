package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Synchronize {

	public static void synDB() {
		String url = "jdbc:mysql://localhost/jweb";
		String utilisateur = "root";
		String motDePasse = "admin";
		Connection connexion = null;
		Statement statement = null;
		try {
			connexion = DriverManager.getConnection(url, utilisateur,
					motDePasse);
			statement = connexion.createStatement();
			int status = statement.executeUpdate("DROP TABLE user");
			status = statement.executeUpdate("DROP TABLE product");
			status = statement.executeUpdate("DROP TABLE reviews");
			status = statement.executeUpdate("DROP TABLE news");
			status = statement.executeUpdate("DROP TABLE panier");
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
			//produit : id, nom , photo, description, prix
			status = statement
					.executeUpdate("CREATE TABLE IF NOT EXISTS product ("
							+ "id int(11) NOT NULL auto_increment, "
							+ "name varchar(255) NOT NULL, "
							+ "photo varchar(255) NOT NULL, "
							+ "prix float NOT NULL, "
							+ "PRIMARY KEY (id), KEY id (id), "
							+ "UNIQUE id_2 (id) );");
			System.out.println("statut -> " + status);
			//avis: id, idProduit, idUser, avis
			status = statement
					.executeUpdate("CREATE TABLE IF NOT EXISTS reviews ("
							+ "id int(11) NOT NULL auto_increment, "
							+ "idProduct int(11) NOT NULL, "
							+ "idUser int(11) NOT NULL, "
							+ "review varchar(255) NOT NULL, "
							+ "PRIMARY KEY (id), KEY id (id), "
							+ "UNIQUE id_2 (id) );");
			System.out.println("statut -> " + status);
			//news: id, titre, description
			status = statement
					.executeUpdate("CREATE TABLE IF NOT EXISTS news ("
							+ "id int(11) NOT NULL auto_increment, "
							+ "title varchar(255) NOT NULL, "
							+ "descirption varchar(255) NOT NULL, "
							+ "PRIMARY KEY (id), KEY id (id), "
							+ "UNIQUE id_2 (id) );");
			System.out.println("statut -> " + status);
			//panier:  id, idUser, idProduct
			status = statement
					.executeUpdate("CREATE TABLE IF NOT EXISTS panier ("
							+ "id int(11) NOT NULL auto_increment, "
							+ "idUser int(11) NOT NULL, "
							+ "idProduct int(11) NOT NULL, "
							+ "PRIMARY KEY (id), KEY id (id), "
							+ "UNIQUE id_2 (id) );");
			System.out.println("statut -> " + status);
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
}
