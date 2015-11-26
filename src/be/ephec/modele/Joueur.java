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
	
	public void acheter(Case x){
		if(x.getType == "Propriété" || x.getType == "gare"  || x.getType == "service" && x.getProprietaire == null && x.getNumCase == partie.getJoueurCurrent()){
			if(partie.tabJoueurs[partie.getJoueurCurrent()].solde - x.prixTerrain >= 0){
				partie.tabJoueurs[partie.getJoueurCurrent()].retraitSolde(x.prixTerrain);
				partie.tabJoueurs[partie.getJoueurCurrent()].tabProprietes.add(x);
			}
		} else {
			
			// si c'est pas le bon type ou déjà acheté => envoie msg au joueur 
			System.out.println("achat impossible !");
		}	
	}
	
	public void vendre(Case x, int valeur){
			// decision joueur + tests eventuels
			if(decision && /*verif solde autre joueur*/){
				partie.tabJoueurs[partie.getJoueurCurrent()].ajoutSolde(valeur);
				partie.tabJoueurs[partie.getJoueurCurrent()].tabProprietes.remove(x);
			}
	}
	
	
	
	public void avancer(int x){
		int anciennePosition = position;
		if(position + x >= 40){ position = (position + x) % 40;
		} else { position += x;}
		
		if(position < anciennePosition){
			partie.tabJoueurs[partie.getJoueurCurrent()].ajoutSolde(200);
		}
	}
	
	public void allerA(int x){
		position = x;
	}
	
	public int getPosition(){
		return position;
	}
	
	public void retraitSolde(int x){
		solde -= x;
	}
	
	public void ajoutSolde(int x){
		solde += x;
	}
	
	public int getSolde(){
		return solde;
	}
}