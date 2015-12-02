package be.ephec.modele;

import java.util.ArrayList;

public class Partie {
	private int nbCarteChancePioche = 0;
	private int nbCarteCaisseComPioche = 0;
	private int nbTour = 0;
	private Joueur[] tabMonopoles = new Joueur[8];
	private ArrayList<Joueur> tabJoueurs = new ArrayList<Joueur>(2);
	public ArrayList<Joueur> getTabJoueurs() {
		return tabJoueurs;
	}

	private Plateau plateau = new Plateau(this);

	
	public Partie(){
		
	}
	
	
	public void initialisation(){
		initJoueur();
	}
	
	
	private void initJoueur() {
		tabJoueurs.add(new Joueur("Joueur 1"));
		tabJoueurs.add(new Joueur("Joueur 2"));
	}

	
	public void acheter(Case x){
		if(x.getType() == "Propriété" || x.getType() == "gare"  || x.getType() == "service" && x.getProprietaire() == null && x.getNumCase() == this.tabJoueurs.get(getIndexJoueurCourant()).getPosition()){
			if(this.tabJoueurs.get(getIndexJoueurCourant()).getSolde() - x.getPrixTerrain() >= 0){
				this.retraitSolde(x.getPrixTerrain(),this.tabJoueurs.get(getIndexJoueurCourant()));
				this.tabJoueurs.get(getIndexJoueurCourant()).getTabProprietes().add(x);
			}
		} else {
			
			// si c'est pas le bon type ou déjà acheté => envoie msg au joueur 
			System.out.println("achat impossible !");
		}
	}
	
	public void vendre(Case x, int valeur, Joueur acheteur){
			// verif solde autre joueur + decision 
			if(/*decision*/ && acheteur.getSolde() >= valeur ){ // a verif
				this.ajoutSolde(valeur,this.tabJoueurs.get(getIndexJoueurCourant()));
				this.tabJoueurs.get(getIndexJoueurCourant()).getTabProprietes().remove(x);
			}
	}
	
	
	
	public void avancer(int x){
		int anciennePosition = this.tabJoueurs.get(getIndexJoueurCourant()).getPosition();
		if(this.tabJoueurs.get(getIndexJoueurCourant()).getPosition() + x >= 40){ this.tabJoueurs.get(getIndexJoueurCourant()).setPosition((this.tabJoueurs.get(getIndexJoueurCourant()).getPosition() + x)%40);
		} else {this.tabJoueurs.get(getIndexJoueurCourant()).setPosition(this.tabJoueurs.get(getIndexJoueurCourant()).getPosition() + x);}
		
		if(this.tabJoueurs.get(getIndexJoueurCourant()).getPosition() < anciennePosition){
			this.ajoutSolde(200,this.tabJoueurs.get(getIndexJoueurCourant()));
		}
	}
	
	public void allerA(int x){
		this.tabJoueurs.get(getIndexJoueurCourant()).setPosition(x);
	}
	
	

	public void debutTour(){
		
	}
	
	public void finTour(){
		
		
	}
	
	public int getIndexJoueurCourant(){
		return nbTour % tabJoueurs.size();
	}
	
	public void retraitSolde(int x, Joueur player){
		player.setSolde(-x);
		if (player.getSolde()<0){
			Perdu(player);
			if(tabJoueurs.size()<2){
				Gagne(tabJoueurs.get(index));
			}
		}
	}
	
	public void Perdu(Joueur player) {
		// envoyer un msg au joueur 
		//supprimer le joueur perdant
		tabJoueurs.remove(player);
		
	}
	
	public void Gagne(Joueur player) {
		//envoyer un msg au joueur 
		// terminer la partie
		
		
	}
	
	


	public void ajoutSolde(int x, Joueur player){
		player.setSolde(x);
	}
	
	public void main(String[] args) {
		// TODO Auto-generated method stub

	}
}