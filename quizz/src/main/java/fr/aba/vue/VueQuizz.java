package fr.aba.vue;

import fr.aba.controleur.QuizzControleur;
import fr.aba.modele.GenerateurQuestion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VueQuizz {

	private Stage primaryStage;

	private GenerateurQuestion generateurQuestion;

	private QuizzControleur quizzControleur;

	public VueQuizz(Stage primaryStage, GenerateurQuestion generateurQuestion, QuizzControleur quizzControleur) {
		this.primaryStage = primaryStage;
		this.generateurQuestion = generateurQuestion;
		this.quizzControleur = quizzControleur;
	}

	/**
	 * Méthode qui affiche l'écran d'accueil
	 */
	public void afficherEcranAccueil() {
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.setTitle("Quizz Boite");

		// Ajout de la racine avec un fond bleu
		Group root = new Group();
		Scene scene = new Scene(root);
		scene.setFill(Color.SKYBLUE);

		// Ajout d'un panneau avec un titre
		Group sign = new Group();
		sign.setTranslateX(150);
		sign.setTranslateY(50);

		Text text = new Text(10, 30, "Quizz Boite");
		text.setFont(new Font(80));
		text.setFill(Color.WHITE);

		Rectangle panel = new Rectangle(0, -50, 430, 110);
		panel.setFill(Color.DARKBLUE);

		sign.getChildren().add(panel);
		sign.getChildren().add(text);

		// Creating a GridPane container
		GridPane grid = new GridPane();
		grid.setTranslateX(50);
		grid.setTranslateY(150);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);

		// Affichage de la question
		final Text textQuestion = new Text(generateurQuestion.getQuestionEnCours().getIntitule());
		textQuestion.setFill(Color.BLACK);
		GridPane.setConstraints(textQuestion, 0, 0);
		grid.getChildren().add(textQuestion);

		// Saisie de la réponse
		final TextField reponseTextField = new TextField();
		reponseTextField.setPromptText("Entrez votre réponse");
		reponseTextField.setPrefColumnCount(35);
		GridPane.setConstraints(reponseTextField, 0, 1);
		grid.getChildren().add(reponseTextField);

		// Affichage de la réponse
		final Text textReponse = new Text("");
		textQuestion.setFill(Color.BLACK);
		GridPane.setConstraints(textReponse, 0, 2);
		grid.getChildren().add(textReponse);

		// Bouton Valider
		Button validerBouton = new Button("Valider");
		GridPane.setConstraints(validerBouton, 1, 1);
		grid.getChildren().add(validerBouton);
		// Action déclenchée au clic sur le bouton
		validerBouton.setOnAction(getValiderEventHandler(reponseTextField, textReponse));

		// Bouton Question Suivante
		Button passerBouton = new Button("Passer");
		GridPane.setConstraints(passerBouton, 2, 1);
		grid.getChildren().add(passerBouton);
		passerBouton.setOnAction(getPasserEventHandler(textQuestion, textReponse));

		// Ajout de tous les éléments
		root.getChildren().add(sign);
		root.getChildren().add(grid);

		primaryStage.setScene(scene);

		primaryStage.show();
	}

	private EventHandler<ActionEvent> getPasserEventHandler(final Text textQuestion, final Text textReponse) {
		return new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				quizzControleur.passerQuestion();
				textReponse.setText("");
				textQuestion.setText(generateurQuestion.getQuestionEnCours().getIntitule());
			}
		};
	}

	private EventHandler<ActionEvent> getValiderEventHandler(final TextField reponseTextField, final Text textReponse) {
		return new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (quizzControleur.confirmerReponse(reponseTextField.getText())) {
					textReponse.setText("VRAI !");
				} else {
					textReponse.setText("FAUX : " + generateurQuestion.getQuestionEnCours().getReponse());
				}				
			}
		};
	}

}
