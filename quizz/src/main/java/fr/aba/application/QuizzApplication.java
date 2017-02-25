package fr.aba.application;

import fr.aba.controleur.QuizzControleur;
import fr.aba.modele.GenerateurQuestion;
import fr.aba.vue.VueQuizz;
import javafx.application.Application;
import javafx.stage.Stage;

public class QuizzApplication extends Application {
	
	IChargeurDonnees chargeurDonnees = new ChargeurDonneesCSV();
	
	public static void main(String[] args) {		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Initialisation du modèle avec les données chargées
		GenerateurQuestion generateurQuestion = new GenerateurQuestion(chargeurDonnees.chargerDonnees());		
		
		// Initialisation du controleur en lui fournissant le modele
		QuizzControleur quizzControleur = new QuizzControleur(generateurQuestion);
		
		// Initialisation de la vue avec le composant d'affichage, le modele et le controleur
		VueQuizz vue = new VueQuizz(primaryStage, generateurQuestion, quizzControleur);		
		vue.afficherEcranAccueil();
	}

}
