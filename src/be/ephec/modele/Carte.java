package be.ephec.modele;

import java.io.Serializable;

public abstract class Carte implements Serializable{
	protected Partie partie;
	protected String texte;
	protected int numMethode;
	
	/**
	 * Constructeur de carte
	 * @param partie : la partie en cours
	 * @param texte : le texte � afficher sur la carte
	 * @param methodeNum : le num�ro de la m�thode � executer
	 */
	public Carte(Partie partie, String texte, int methodeNum) {
		this.partie = partie;
		this.texte = texte;
		this.numMethode = methodeNum;
	}

	/**
	 * Methode abstraite pour l'action des cartes (� implementer dans les classes qui h�ritent)
	 * @param methodeNum : le num�ro de la m�thode � executer
	 */
	public abstract void action(int methodeNum);
	

	public int getNumMethode(){
		return numMethode;
	}
}