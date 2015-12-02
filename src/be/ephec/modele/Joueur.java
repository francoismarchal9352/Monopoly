package be.ephec.modele;

import java.util.ArrayList;

public class Joueur{
	private String nom;
	private int position;
	private int solde;
	private int nbTourPrison;
	private int nbTourSuite;
	private int nbCarteSortezPrison;
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
	
	public int calculNbMaison(){
		int nbMaison = 0;
		int i = 0;
		while(this.tabProprietes.iterator().hasNext()){
			if(this.tabProprietes.get(i).getType() == "Propriété"){
				nbMaison += this.tabProprietes.get(i).getNbMaison();  
			}
			i++;
		}
		return nbMaison;
	}
	
	public int calculNbHotel(){
		int nbHotel = 0;
		int i = 0;
		while(this.tabProprietes.iterator().hasNext()){
			if(this.tabProprietes.get(i).getType() == "Propriété"){
				nbHotel += this.tabProprietes.get(i).getNbHotel();  
			}
			i++;
		}
		return nbHotel;
		
	}

	public int getNbCarteSortezPrison() {
		return nbCarteSortezPrison;
	}

	public void setNbCarteSortezPrison(int nbCarteSortezPrison) {
		this.nbCarteSortezPrison = nbCarteSortezPrison;
	}
	
	
}