package fr.aba.modele;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;

import fr.aba.enumeration.TypeQuestionEnumeration;
import fr.aba.modele.logique.ComparateurMethodesInteger;
import fr.aba.modele.logique.Question;
import fr.aba.utils.ClassUtils;

/**
 * Classe permettant de générer aléatoirement des questions sur les donnees
 * 
 * @author Arnaud
 *
 */
public class GenerateurQuestion {

	private List<Object> objets;
	private Question questionEnCours;

	public GenerateurQuestion(List<Object> objets) {
		this.objets = objets;
		genererQuestionAleatoire();
	}

	public Question genererQuestionAleatoire() {
		if (objets.size() > 0) {
			TypeQuestionEnumeration typeQuestion = choisirTypeQuestionAleatoire();
			Method methode = choisirMethodeIntegerAleatoire();
			questionEnCours = new Question();
			questionEnCours.setTypeQuestion(typeQuestion);
			questionEnCours.setMethode(methode);
			questionEnCours.setReponse(chercherReponse(typeQuestion, methode));
			System.out.println(typeQuestion+" "+methode.getName()+" "+questionEnCours.getReponse());
		}
		return questionEnCours;
	}

	private String chercherReponse(TypeQuestionEnumeration typeQuestion, Method methode) {
		String reponse = "";
		try {
			ComparateurMethodesInteger comparateurAttributsInteger = new ComparateurMethodesInteger(methode);
			List<Object> objetsFiltres = new ArrayList<Object>();
			for (Object object : objets) {
				if (methode.invoke(object) != null) {
					objetsFiltres.add(object);
				}
			}
			objetsFiltres.sort(comparateurAttributsInteger);
			if (typeQuestion.equals(TypeQuestionEnumeration.MAXI)) {
				reponse = objetsFiltres.get(0).toString();
			} else if (typeQuestion.equals(TypeQuestionEnumeration.MINI)) {
				reponse = objetsFiltres.get(objetsFiltres.size()-1).toString();
			}
		} catch (Exception e) {
			reponse = "Impossible à trouver la réponse";
		}
		return reponse;
	}

	private Method choisirMethodeIntegerAleatoire() {
		List<Method> methodesInteger = ClassUtils.getMethodesInteger(objets.get(0).getClass());
		int entierAleatoire = RandomUtils.nextInt(0, methodesInteger.size());
		return methodesInteger.get(entierAleatoire);
	}

	private TypeQuestionEnumeration choisirTypeQuestionAleatoire() {
		double nombreAleatoire = Math.random();
		TypeQuestionEnumeration typeQuestion;
		if (nombreAleatoire < 0.5) {
			typeQuestion = TypeQuestionEnumeration.MINI;
		} else {
			typeQuestion = TypeQuestionEnumeration.MAXI;
		}
		return typeQuestion;
	}

	public Question genererQuestion(TypeQuestionEnumeration typeQuestion, String attribut) {
		return null;
	}

	public Question getQuestionEnCours() {
		return questionEnCours;
	}
}
