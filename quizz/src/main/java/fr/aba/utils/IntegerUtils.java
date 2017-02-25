package fr.aba.utils;

public class IntegerUtils {

	/**
	 * Méthode qui récupère la valeur d'un entier contenue dans une chaine de
	 * caractères. Renvoie null si la chaine est vide ou bien si elle contient
	 * des caractères.
	 * 
	 * @param string
	 * @return
	 */
	public static Integer safeValueOf(String string) {
		Integer resultat;
		try {
			resultat = Integer.valueOf(string);
		} catch (NumberFormatException e) {
			resultat = null;
		}
		return resultat;
	}

}
