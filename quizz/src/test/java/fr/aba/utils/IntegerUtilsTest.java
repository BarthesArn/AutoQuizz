package fr.aba.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerUtilsTest {

	@Test
	public void testSafeValueOf_Null() {
		assertNull(IntegerUtils.safeValueOf(null));
	}
	
	@Test
	public void testSafeValueOf_Vide() {
		assertNull(IntegerUtils.safeValueOf(""));
	}
	
	@Test
	public void testSafeValueOf_ABC() {
		assertNull(IntegerUtils.safeValueOf("ABC"));
	}
	
	@Test
	public void testSafeValueOf_2() {
		assertEquals(Integer.valueOf(2), IntegerUtils.safeValueOf("2"));
	}
	
	@Test
	public void testSafeValueOf_Moins5() {
		assertEquals(Integer.valueOf(-5), IntegerUtils.safeValueOf("-5"));
	}

}
