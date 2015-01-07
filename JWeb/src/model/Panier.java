package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import orm.OrmRequest;

public class Panier {

	/**
	 * creation d'un panier qui va lier un idUser a un idProduct
	 * 
	 * @param idUser
	 * @param idProduct
	 */
	static public void createPanier(int idUser, int idProduct) {
		OrmRequest request = new OrmRequest();
		request.InsertInto("panier", "null", idUser, idProduct);
		int statut = request.ExecuteUpdate();
		System.out.println("statut -> " + statut);
	}

	/**
	 * obtention d'une liste de produit contenu dans le panier d'un idUser
	 * 
	 * @param idUser
	 * @return
	 */
	static public ArrayList<Product> getProductPanier(int idUser) {
		OrmRequest request = new OrmRequest();
		request.Select("product.id", "product.name", "product.photo", "product.description", "product.price");
		request.From("product", "panier");
		HashMap<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("product.id", "panier.idProduct".toCharArray());
		whereMap.put("panier.idUser", idUser);
		request.Where(whereMap);
		ResultSet resultat = request.ExecuteQuery();

		ArrayList<Product> listProduct = new ArrayList<Product>();
		if (resultat != null) {
			try {
				while (resultat.next()) {
					listProduct.add(new Product(resultat.getInt("id"), resultat.getString("name"), resultat
							.getString("photo"), resultat.getString("description"), resultat.getFloat("price")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listProduct;
	}

	/**
	 * obtention du nombre de produit contenu dans le panier de l'idUser
	 * 
	 * @param idUser
	 * @return
	 */
	static public int getNumberProductPanier(int idUser) {
		OrmRequest request = new OrmRequest();
		request.Select("COUNT(*) as total");
		request.From("panier");
		HashMap<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("idUser", idUser);
		request.Where(whereMap);
		ResultSet resultat = request.ExecuteQuery();

		int nb = 0;
		if (resultat != null) {
			try {
				resultat.next();
				nb = resultat.getInt("total");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return nb;
	}

	/**
	 * suppression de tout les produit du panier de l'idUser
	 * 
	 * @param idUser
	 */
	static public void rmAllProductPanier(int idUser) {
		OrmRequest request = new OrmRequest();
		request.DeleteFrom("panier");
		HashMap<String, Object> whereMap = new HashMap<String, Object>();
		whereMap.put("idUser", idUser);
		request.Where(whereMap);
		int statut = request.ExecuteUpdate();
		System.out.println("statut -> " + statut);
	}

}
