package be.ephec.modele;

import java.io.Serializable;

public class De implements Serializable{
	private int valeur;
//	private int cpt;
	
	public De(/*int cpt*/){
//		this.cpt = cpt;
	}
	
	public int lancerDe(){
		valeur = (int)(Math.random()*6) + 1;
//		valeur = cpt++%6+1; //Sert à faire un roll fixe pour les tests.
		return valeur;
	}
	
	public int getValeur(){
		return valeur;
	}
	
	public void setZero(){
		valeur=0;
	}
	
}