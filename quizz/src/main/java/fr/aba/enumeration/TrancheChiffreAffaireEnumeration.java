package fr.aba.enumeration;

public enum TrancheChiffreAffaireEnumeration {
	
	A("A","- de 32 K"), 
	B("B","entre 32K et 82K"),
	C("C","entre 82K et 250K"),
	D("D","entre 250K et 1M"),
	E("E","+ d 1M");
	
	private String code;
	private String libelle;
	
	TrancheChiffreAffaireEnumeration(String code, String libelle) {
		this.code = code;
		this.libelle = libelle;
	}
	
	protected String getCode() {
		return code;
	}

	protected String getLibelle() {
		return libelle;
	}

}
