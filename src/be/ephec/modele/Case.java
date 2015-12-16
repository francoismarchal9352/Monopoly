package be.ephec.modele;

import java.io.Serializable;

public abstract class Case implements Serializable{
	protected Partie partie;
	private String type;
	private String nom;
	private int numCase; // Encore besoin de numCase ?
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
	
	public String getNom(){
		return nom;
	}
	
	//On pourrait faire mieux en créant une classe "achetable" qui serait mère de Propriété, Gare et Service mais on n'a pas le temps.
	public abstract String getProprietaire();
	public abstract void setProprietaire(String nom);
	public abstract int getPrixTerrain();
	public abstract int getNbMaison();
	public abstract int getNbHotel();
	
	public abstract void action();
}