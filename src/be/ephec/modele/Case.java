package be.ephec.modele;

public abstract class Case {
	private Partie partie;
	private String type;
	private String nom;
	private int numCase;
	private static int cptInitCase=0;
	
	public Case(Partie partie, String type, String nom){
		this.partie = partie;
		this.nom = nom;
		this.type = type;
		this.numCase = cptInitCase++;
	}
	
		
	public String getType() {
		return type;
	}

/*	public abstract String getProprietaire();
	public abstract int getPrixTerrain();
	public abstract int getNbMaison();
	public abstract int getNbHotel();
*/

	public void action(){
		
	}
}