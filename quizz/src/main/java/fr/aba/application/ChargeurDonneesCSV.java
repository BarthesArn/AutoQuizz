package fr.aba.application;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import fr.aba.modele.donnees.Entreprise;
import fr.aba.utils.IntegerUtils;

/**
 * Classe offrant des méthodes de chargement des données à partir d'un csv
 * 
 * @author Arnaud
 *
 */
public class ChargeurDonneesCSV implements IChargeurDonnees {

	/**
	 * Méthode de chargement des données des entreprises depuis un fichier CSV
	 */
	public List<Object> chargerDonnees() {
		List<Object> objets = new ArrayList<Object>();
		try {
			CSVReader reader = new CSVReader(new FileReader("src/main/resources/ChiffreEntreprise13.csv"), ';');

			String[] ligneSuivante;
			// On passe la première ligne qui contient les titre des colonnes
			ligneSuivante = reader.readNext();
			while ((ligneSuivante = reader.readNext()) != null) {
				objets.add(mapperCSVversEntreprise(ligneSuivante));
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return objets;
	}

	/**
	 * Mapping d'une ligne du CSV vers un objet Entreprise
	 * 
	 * @param ligne
	 * @return
	 */
	private Entreprise mapperCSVversEntreprise(String[] ligne) {
		Entreprise entreprise = new Entreprise();

		entreprise.setDenomination(ligne[0]);
		entreprise.setSiren(IntegerUtils.safeValueOf(ligne[1]));
		entreprise.setChiffreAffaire(IntegerUtils.safeValueOf(ligne[5]));
		entreprise.setResultat(IntegerUtils.safeValueOf(ligne[6]));
		entreprise.setEffectif(IntegerUtils.safeValueOf(ligne[7]));
		entreprise.setCodeActivite(ligne[11]);
		entreprise.setSecteurActivite(ligne[12]);
		entreprise.setCodePostal(IntegerUtils.safeValueOf(ligne[13]));
		entreprise.setVille(ligne[14]);

		return entreprise;
	}
}
