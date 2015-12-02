package be.ephec.modele;

public abstract class Case {
	private String type;
	private int numCase = 0;
	private String nom;
	
	
	
	public Case(String type, String nom){
	this.nom = nom;
	this.type = type;
	this.numCase = numCase;
	this.numCase++;
	}
	
		
	public String getType() {
		return type;
	}
	

	public int getNumCase() {
		return numCase;
	}


	public abstract String getProprietaire();
	public abstract int getPrixTerrain();
	public abstract int getNbMaison();
	public abstract int getNbHotel();


	public void action(){
		
	}
}