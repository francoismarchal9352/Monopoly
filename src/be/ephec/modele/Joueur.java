package be.ephec.modele;

import java.util.ArrayList;

public class Joueur{
	private String nom;
	private int position;
	private int solde;
	private int nbTourPrison;
	private int nbTourSuite;
	private ArrayList<Case> tabProprietes;
	
	public Joueur(String nom){
		this.nom = nom; // a faire
		this.position = 0;
		this.solde = 15000;
		this.nbTourPrison = 0;
		this.nbTourSuite = 0; 
		this.tabProprietes = new ArrayList<Case>(5);
		
	}
}