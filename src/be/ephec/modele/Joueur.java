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
	
	/*
	public void retraitSolde(int x){
		solde -= x;
		if (this.getSolde()<0){
			Perdu(this);
			if(tabJoueurs.size()<2){
				tabJoueurs[0];
			}
		}
	}
	
	public void ajoutSolde(int x){
		solde += x;
	}
	*/
	
	public int getSolde(){
		return solde;
	}
	
	
	public void setSolde(int solde) {
		this.solde = solde;
	}

	public int getPosition(){
		return position;
	}
	
	public void setPosition(int x){
		position = x;
	}
}