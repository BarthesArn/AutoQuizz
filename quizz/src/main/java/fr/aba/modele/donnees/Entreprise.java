package fr.aba.modele.donnees;

/**
 * Classe représentant une entreprise avec ses informations principales (nom,
 * adresse, chiffres, secteurs d'activité...)
 * 
 * @author Arnaud
 *
 */
public class Entreprise {

	private String denomination;
	private Integer siren;
	private String codeActivite;
	private String secteurActivite;
	private Integer codePostal;
	private String ville;
	private Integer resultat;
	private Integer effectif;
	private Integer chiffreAffaire;

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public Integer getSiren() {
		return siren;
	}

	public void setSiren(Integer siren) {
		this.siren = siren;
	}

	public String getCodeActivite() {
		return codeActivite;
	}

	public void setCodeActivite(String codeActivite) {
		this.codeActivite = codeActivite;
	}

	public String getSecteurActivite() {
		return secteurActivite;
	}

	public void setSecteurActivite(String secteurActivite) {
		this.secteurActivite = secteurActivite;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getResultat() {
		return resultat;
	}

	public void setResultat(Integer resultat) {
		this.resultat = resultat;
	}

	public Integer getEffectif() {
		return effectif;
	}

	public void setEffectif(Integer effectif) {
		this.effectif = effectif;
	}

	public Integer getChiffreAffaire() {
		return chiffreAffaire;
	}

	public void setChiffreAffaire(Integer chiffreAffaire) {
		this.chiffreAffaire = chiffreAffaire;
	}
	
	public String toString() {
		return denomination;
	}
}
