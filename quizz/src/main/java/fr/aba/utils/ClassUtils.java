package fr.aba.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassUtils {

	/**
	 * Méthode qui renvoie la liste des attributs de type Integer de la classe
	 * passée en paramètre
	 * 
	 * @param classe
	 * @return
	 */
	public static List<Field> getAttributsInteger(Class classe) {
		Field[] attributs = classe.getDeclaredFields();
		List<Field> attributsInteger = new ArrayList<Field>();
		for (Field field : attributs) {
			if (field.getType().equals(Integer.class)) {
				attributsInteger.add(field);
			}
		}
		return attributsInteger;
	}
	
	/**
	 * Méthode qui renvoie la liste des méthodes de type Integer de la classe
	 * passée en paramètre
	 * 
	 * @param classe
	 * @return
	 */
	public static List<Method> getMethodesInteger(Class classe) {
		Method[] methodes = classe.getDeclaredMethods();
		List<Method> methodesInteger = new ArrayList<Method>();
		for (Method method : methodes) {
			if (method.getReturnType().equals(Integer.class)) {
				methodesInteger.add(method);
			}
		}
		return methodesInteger;
	}

}
