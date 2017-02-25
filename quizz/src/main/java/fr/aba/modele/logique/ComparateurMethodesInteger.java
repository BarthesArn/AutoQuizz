package fr.aba.modele.logique;

import java.lang.reflect.Method;
import java.util.Comparator;

public class ComparateurMethodesInteger implements Comparator<Object> {

	private Method methodeComparaison;

	public ComparateurMethodesInteger(Method methode) {
		methodeComparaison = methode;
	}

	public int compare(Object o1, Object o2) {
		Integer int1, int2;
		try {
			int1 = (Integer) methodeComparaison.invoke(o1);
		} catch (Exception e) {
			int1 = null;
		}
		try {
			int2 = (Integer) methodeComparaison.invoke(o2);
		} catch (Exception e) {
			int2 = null;
		}
		return Integer.compare(int1, int2);
	}

}
