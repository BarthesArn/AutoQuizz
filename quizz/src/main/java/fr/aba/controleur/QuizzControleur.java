package fr.aba.controleur;

import fr.aba.modele.GenerateurQuestion;

public class QuizzControleur {

	private GenerateurQuestion generateurQuestion;

	public QuizzControleur(GenerateurQuestion generateurQuestion) {
		this.generateurQuestion = generateurQuestion;
	}

	public boolean confirmerReponse(String reponseSaisie) {
		return generateurQuestion.getQuestionEnCours().getReponse().equals(reponseSaisie);		
	}
	
	public void passerQuestion() {
		generateurQuestion.genererQuestionAleatoire();
	}
}
