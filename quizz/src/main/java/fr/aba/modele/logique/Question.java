package fr.aba.modele.logique;

import java.lang.reflect.Method;

import fr.aba.enumeration.TypeQuestionEnumeration;

/**
 * Classe représentant une question
 * @author Arnaud
 *
 */
public class Question {
	
	private TypeQuestionEnumeration typeQuestion;
	private Method methode;
	private String reponse;
	
	public String getIntitule() {
		StringBuilder sb = new StringBuilder();
		sb.append("Quelle entreprise a le plus ");
		if (typeQuestion.equals(TypeQuestionEnumeration.MINI)) {
			sb.append("petit ");
		} else if (typeQuestion.equals(TypeQuestionEnumeration.MAXI)){
			sb.append("grand ");
		}
		sb.append(methode.getName());
		sb.append(" ?");
		return sb.toString();
	}
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	public Method getMethode() {
		return methode;
	}
	public void setMethode(Method attribut) {
		this.methode = attribut;
	}
	public TypeQuestionEnumeration getTypeQuestion() {
		return typeQuestion;
	}
	public void setTypeQuestion(TypeQuestionEnumeration typeQuestion) {
		this.typeQuestion = typeQuestion;
	}
	
}
