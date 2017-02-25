package fr.aba.utils;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.Test;

import fr.aba.modele.donnees.Entreprise;

public class ClassUtilsTest {

	@Test
	public void testGetAttributsInteger_Entreprise() {
		List<Field> attributs = ClassUtils.getAttributsInteger(Entreprise.class);
		assertEquals(5, attributs.size());
	}
	
	@Test
	public void testGetAttributsInteger_Object() {
		List<Field> attributs = ClassUtils.getAttributsInteger(Object.class);
		assertEquals(0, attributs.size());
	}
	
	@Test
	public void testGetMethodesInteger_Entreprise() {
		List<Method> methodes = ClassUtils.getMethodesInteger(Entreprise.class);
		assertEquals(5, methodes.size());
	}
	
	@Test
	public void testGetMethodesInteger_Object() {
		List<Method> methodes = ClassUtils.getMethodesInteger(Object.class);
		assertEquals(0, methodes.size());
	}

}
