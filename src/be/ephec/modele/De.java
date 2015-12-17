/**
 * @author Marchal François et Massart Florian
 * @version 1.0
 */

package be.ephec.modele;

public class De {
	private int valeur;
	
	/**
	 * Constructeur pour les de
	 */
	public De(){
	}
	
	/**
	 * methode pour lancer les dés
	 * @return valeur : la valeur du dé
	 */
	public int lancerDe(){
		valeur = (int)(Math.random()*6) + 1;
		return valeur;
	}
	
	public int getValeur(){
		return valeur;
	}
	
	public void setZero(){
		valeur=0;
	}
}

