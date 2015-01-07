package orm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;

import utility.DbUtility;

public class OrmRequest {

	String request;

	public OrmRequest() {
		request = "";
	}

	/**
	 * creation du debut d'une requette select, Args sont les colones qui vont
	 * etre selectionner.
	 * 
	 * @param Args
	 */
	public void Select(String... Args) {
		int i = 0;
		request = "SELECT ";
		for (String str : Args) {
			if (i != 0)
				request += ", ";
			request += str;
			i = i + 1;
		}
	}

	/**
	 * ajout de from a la requete, Args sont les tables selectionner
	 * 
	 * @param Args
	 */
	public void From(String... Args) {
		int i = 0;
		request += " FROM ";
		for (String str : Args) {
			if (i != 0)
				request += ", ";
			request += str;
			i = i + 1;
		}
	}

	/**
	 * ajout de where a la requete, map la requete va etre creer comme key =
	 * value AND key = value
	 * 
	 * @param map
	 */
	public void Where(HashMap<String, Object> map) {
		int i = 0;
		request += " WHERE ";
		for (Entry<String, Object> entry : map.entrySet()) {
			if (i != 0)
				request += " AND ";
			request += entry.getKey();
			request += " = ";
			if (entry.getValue() instanceof String)
				request += "\"" + (String) entry.getValue() + "\"";
			else if (entry.getValue() instanceof char[])
				request += String.valueOf((char[]) entry.getValue());
			else
				request += entry.getValue();
			i = i + 1;
		}
	}

	/**
	 * commence une requete delete, nameTable est le nom de la table sur laquel
	 * on veut faire des delete
	 * 
	 * @param nameTable
	 */
	public void DeleteFrom(String nameTable) {
		request = "DELETE FROM " + nameTable;
	}

	/**
	 * cree une requete insert into, nameTable est le nom de la table et Args
	 * les value que lon veut inserer
	 * 
	 * @param nameTable
	 * @param Args
	 */
	public void InsertInto(String nameTable, Object... Args) {
		request = "INSERT INTO " + nameTable;
		request += " VALUE (";
		int i = 0;
		for (Object obj : Args) {
			if (i != 0)
				request += ", ";
			if (obj instanceof char[])
				request += "\"" + String.valueOf((char[]) obj) + "\"";
			else
				request += obj;
			i = i + 1;
		}
		request += ")";
	}

	/**
	 * cree une requete update nom avec le nameTable, qui creer setName =
	 * setValue
	 * 
	 * @param nameTable
	 * @param setName
	 * @param setValue
	 */
	public void Update(String nameTable, String setName, String setValue) {
		request = "UPDATE " + nameTable;
		request += " SET " + setName + " = " + setValue;
	}

	/**
	 * execute un query de selection
	 * 
	 * @return
	 */
	public ResultSet ExecuteQuery() {
		request += ";";
		System.out.println(request);
		Statement statement = DbUtility.getInstance().getConnectStatement();
		ResultSet resultat = null;
		try {
			resultat = statement.executeQuery(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	/**
	 * execute un query de mise a jour de la base de donne
	 * 
	 * @return
	 */
	public int ExecuteUpdate() {
		request += ";";
		System.out.println(request);
		Statement statement = DbUtility.getInstance().getConnectStatement();
		int statut = -1;
		try {
			statut = statement.executeUpdate(request);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statut;
	}

}
