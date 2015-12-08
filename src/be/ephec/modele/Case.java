package be.ephec.modele;

public abstract class Case {
	protected Partie partie;
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
	
	//On pourrait faire mieux en cr�ant une classe "achetable" qui serait m�re de Propri�t�, Gare et Service mais on n'a pas le temps.
	public abstract String getProprietaire();
	public abstract int getPrixTerrain();
	public abstract int getNbMaison();
	public abstract int getNbHotel();
	
	public abstract void action();
}