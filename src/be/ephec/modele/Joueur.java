package be.ephec.modele;

import java.util.ArrayList;

public class Joueur{
	private Partie partie;
	private String nom;
	private int position;
	private int solde;
	private int nbTourPrison;
	private int nbCarteSortezPrison;
	private ArrayList<Case> tabPossessions;
	
	public ArrayList<Case> getTabPossessions() {
		return tabPossessions;
	}

	public Joueur(Partie partie, String nom){
		this.partie = partie;
		this.nom = nom;
		this.position = 0;
		this.solde = 15000;
		this.nbTourPrison = 0;
		this.tabPossessions = new ArrayList<Case>(0);
		
	}
	
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
	
	public int getNbMaison(){
		int nbMaison = 0;
		for(Case possession : tabPossessions){
			if(possession.getType() == "Propriété"){
				nbMaison += possession.getNbMaison();
			}
		}
		return nbMaison;
	}
	
	public int getNbHotel(){
		int nbHotel = 0;
		for(Case possession : tabPossessions){
			if(possession.getType() == "Propriété"){
				nbHotel += possession.getNbHotel();
			}
		}
		return nbHotel;
		
	}

	public int getNbCarteSortezPrison() {
		return nbCarteSortezPrison;
	}

	public void setNbCarteSortezPrison(int nbCarteSortezPrison) {
		this.nbCarteSortezPrison = nbCarteSortezPrison;
	}

	public int getNbTourPrison() {
		return nbTourPrison;
	}

	public void setNbTourPrison(int nbTourPrison) {
		this.nbTourPrison = nbTourPrison;
	}

	public void entreEnPrison() {	//Désactiver les boutons pour acheter et vendre des propriétés
		position=10;
		partie.setNbTourSuite(0);
		nbTourPrison=1;
		if(nbCarteSortezPrison>0){
			nbCarteSortezPrison--;
			nbTourPrison=0;
		}
		partie.finTour();
	}
	
	
}