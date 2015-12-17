/**
 * @author Marchal François et Massart Florian
 * @version 1.0
 */

package be.ephec.modele;

import java.io.Serializable;

public class Service extends Case implements Serializable{
	private String proprietaire;
	private int prixService;

	/**
	 * Constructeur de case service
	 * @param partie : la partie en cours
	 * @param nom : le nom du service
	 */
	public Service(Partie partie, String nom){
		super(partie,"Service", nom);
		this.prixService = 150;
	}
	
	/**
	 * Methode pour l'action des cases service
	 */
	public void action(){
		//Rien à mettre dans cette méthode.
	}
	
	@Override
	public String getProprietaire() {
		return proprietaire;
	}
	
	public void setProprietaire(String nom){
		proprietaire = nom;
	}
	
	@Override
	public int getPrixTerrain() {
		return prixService;
	}
	
	@Override
	public int getNbMaison() {
		return 0;
	}
	
	@Override
	public int getNbHotel() {
		return 0;
	}
}