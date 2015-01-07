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

	public void DeleteFrom(String nameTable) {
		request = "DELETE FROM " + nameTable;
	}

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

	public void Update(String nameTable, String setName, String setValue) {
		request = "UPDATE " + nameTable;
		request += " SET " + setName + " = " + setValue;
	}

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
