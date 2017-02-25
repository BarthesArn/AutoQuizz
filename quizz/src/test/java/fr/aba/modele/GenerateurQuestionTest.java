package fr.aba.modele;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GenerateurQuestionTest {
	
	private GenerateurQuestion generateurQuestion;
	private List<Object> entreprises;

	@Before
	public void setUp() throws Exception {
		entreprises = new ArrayList<Object>();
		generateurQuestion = new GenerateurQuestion(entreprises);
	}

	@Test
	public void test() {
		
	}

}
