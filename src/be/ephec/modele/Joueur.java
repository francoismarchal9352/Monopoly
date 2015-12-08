package be.ephec.modele;

import java.util.ArrayList;

public class Joueur{
	private Partie partie;
	private String nom;
	private int position;
	private int solde;
	private int nbTourPrison;
	private int nbTourSuite;
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
		this.nbTourSuite = 0;
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
		for(Case possession : this.tabPossessions){
			if(possession.getType() == "Propri�t�"){
				nbMaison += possession.getNbMaison();
			}
		}
		return nbMaison;
	}
	
	public int getNbHotel(){
		int nbHotel = 0;
		for(Case possession : this.tabPossessions){
			if(possession.getType() == "Propri�t�"){
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

	public void entreEnPrison() {	//D�sactiver les boutons pour acheter et vendre des propri�t�s
		this.position=10;
		this.nbTourSuite=0;
		this.nbTourPrison=1;
		if(this.nbCarteSortezPrison>0){
			this.nbCarteSortezPrison--;
			this.nbTourPrison=0;
		}
		partie.finTour();
	}
	
	
}