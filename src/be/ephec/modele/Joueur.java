package be.ephec.modele;

import java.util.ArrayList;

public class Joueur{
	private String nom;
	private int position;
	private int solde;
	private int nbTourPrison;
	private int nbTourSuite;
	private ArrayList<Case> tabProprietes;
	
	public ArrayList<Case> getTabProprietes() {
		return tabProprietes;
	}

	public Joueur(String nom){
		this.nom = nom; // a faire
		this.position = 0;
		this.solde = 15000;
		this.nbTourPrison = 0;
		this.nbTourSuite = 0; 
		this.tabProprietes = new ArrayList<Case>(5);
		
	}
	
	public void retraitSolde(int x){
		solde -= x;
		if (solde<0){
			Perdu(this);
			if(tabJoueur.size()<2){
				tabJoueur[0] a gagné;
			}
		}
	}
	
	public void ajoutSolde(int x){
		solde += x;
	}
	
	public int getSolde(){
		return solde;
	}
	
	public int getPosition(){
		return position;
	}
	
	public void setPosition(int x){
		position = x;
	}
}