package be.ephec.modele;

import java.io.Serializable;

public abstract class Case implements Serializable{
	protected Partie partie;
	private String type;
	private String nom;
	private int numCase; // Encore besoin de numCase ?
	private static int cptInitCase=0;
	
	/**
	 * Constructeur de case
	 * @param partie : la partie en cours
	 * @param type : le type de la case
	 * @param nom : le nom de la case
	 */
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
	
	//On pourrait faire mieux en cr�ant une classe "achetable" qui serait m�re de Propri�t�, Gare et Service mais on n'a pas le temps.
	public abstract String getProprietaire();
	public abstract void setProprietaire(String nom);
	public abstract int getPrixTerrain();
	public abstract int getNbMaison();
	public abstract int getNbHotel();
	
	/**
	 * Methode abstraite pour l'action quand on arrive sur les cases (� implementer dans les classes qui h�ritent)
	 */
	public abstract void action();
}