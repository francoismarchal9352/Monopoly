package be.ephec.modele;

import java.io.Serializable;

public class De implements Serializable{
	private int valeur;
	
	/**
	 * Constructeur pour les de
	 */
	public De(){
	}
	
	/**
	 * methode pour lancer les d�s
	 * @return valeur : la valeur du d�
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

