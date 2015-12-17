/**
 * @author Marchal François & Massart Florian
 * @version 1.0
 */

package be.ephec.modele;

import java.io.Serializable;

public class Propriete extends Case implements Serializable{
	private String proprietaire;
	private String couleur;
	private int prixTerrain;
	private int nbMaison;
	private int nbHotel;
	private int prixConstruction;
	private int[] tabLoyers = new int[6];
	
	/**
	 * Constructeur de case propriété
	 * @param partie : la partie en cours
	 * @param nom : le nom de la case
	 * @param couleur : la couleur de la case (pour le monopole)
	 * @param prixTerrain : le prix du terrain nu
	 * @param prixConstruction : prix des maisons et hôtel
	 * @param loyer1 : prix à payer si il y a 1 maison sur la case
	 * @param loyer2 : prix à payer si il y a 2 maisons sur la case 
	 * @param loyer3 : prix à payer si il y a 3 maisons sur la case
	 * @param loyer4 : prix à payer si il y a 4 maisons sur la case 
	 * @param loyer5 : prix à payer si il y a 5 maisons sur la case
	 * @param loyer6 : prix à payer si il y a 1 hôtel sur la case 
	 */
	public Propriete(Partie partie, String nom, String couleur, int prixTerrain, int prixConstruction, int loyer1, int loyer2, int loyer3, int loyer4, int loyer5, int loyer6){
		super(partie,"Propriété", nom);
		this.couleur = couleur;
		this.prixTerrain = prixTerrain;
		this.nbMaison = 0;
		this.nbHotel = 0;
		this.prixConstruction = prixConstruction;
		this.tabLoyers = new int[]{loyer1,loyer2,loyer3,loyer4,loyer5,loyer6};	
	}
	
	/**
	 * Methode pour l'action des cases propriétés
	 */
	public void action(){
		//Rien à mettre dans cette méthode.
	}
	
	public String getProprietaire() {
		return proprietaire;
	}
	
	public void setProprietaire(String nom){
		proprietaire = nom;
	}
	
	public int getPrixTerrain() {
		return prixTerrain;
	}
	
	public int getNbMaison() {
		return nbMaison;
	}
	
	public int getNbHotel() {
		return nbHotel;
	}
}