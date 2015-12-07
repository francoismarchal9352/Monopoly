package be.ephec.modele;

import java.util.ArrayList;

public class Partie {
	private ArrayList<Joueur> tabJoueurs = new ArrayList<Joueur>(2);
	private Plateau plateau = new Plateau(this);
	private int nbTour = 0;
	private Joueur[] tabMonopoles = new Joueur[8];
	private int nbCarteChancePioche = 0;
	private int nbCarteCaisseComPioche = 0;
	
	public Partie(){
		
	}
	
	public void initialisation(){
		initJoueur();
	}
	
	public void debutTour(){
		if(this.getJoueurCourant().getNbTourPrison()>0){
			if(this.getJoueurCourant().getNbTourPrison()>3){
				this.avancer(plateau.getSommeDe());
			}
		}
	}
	
	public void finTour(){	//Note: Bouton "fin de tour" uniquement cliquable après avoir lancé les dés.
		
		
	}
	
	public ArrayList<Joueur> getTabJoueurs() {
		return tabJoueurs;
	}
	
	private void initJoueur() {
		tabJoueurs.add(new Joueur(this, "Joueur 1"));
		tabJoueurs.add(new Joueur(this, "Joueur 2"));
	}

	public int getIndexJoueurCourant(){
		return nbTour % tabJoueurs.size();
	}

	public Joueur getJoueurCourant(){
		return this.tabJoueurs.get(getIndexJoueurCourant());
	}
	
	public void acheter(Case x){
		if((x.getType() == "Propriété" || x.getType() == "gare"  || x.getType() == "service") && x.getProprietaire() == null && x.getNumCase() == getJoueurCourant().getPosition()){
			if(getJoueurCourant().getSolde() - x.getPrixTerrain() >= 0){
				this.retraitSolde(x.getPrixTerrain(),getJoueurCourant());
				getJoueurCourant().getTabProprietes().add(x);
			}
		} else {
			// si c'est pas le bon type ou déjà acheté => envoie msg au joueur 
			System.out.println("achat impossible !");
		}
	}
	
	public void vendre(Case x, int valeur, Joueur acheteur){
			// verif solde autre joueur + decision 
			if(/*decision*/ && acheteur.getSolde() >= valeur ){ // a verif
				this.ajoutSolde(valeur,getJoueurCourant());
				getJoueurCourant().getTabProprietes().remove(x);
			}
	}
	
	
	
	public void avancer(int x){ //Sert à avancer de X cases.
		int anciennePosition = getJoueurCourant().getPosition();
		getJoueurCourant().setPosition((getJoueurCourant().getPosition() + x)%40);
		checkPasseCaseDepart(anciennePosition);
	}
	
	public void allerA(int x){ //Sert à placer le joueurCourant à l'indice X du plateau.
		int anciennePosition = getJoueurCourant().getPosition();
		getJoueurCourant().setPosition(x);
		checkPasseCaseDepart(anciennePosition);
	}
	
	public void checkPasseCaseDepart(int anciennePosition){
		if(getJoueurCourant().getPosition() < anciennePosition)
			this.ajoutSolde(200,getJoueurCourant());
	}
	

	
	public void retraitSolde(int x, Joueur player){
		player.setSolde(-x);
		if (player.getSolde()<0){
			Perdu(player);
			if(tabJoueurs.size()<2){
				Gagne(tabJoueurs.get(index)); // index => le joueur gagnant -- a faire
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
		Partie truc = new Partie();
		System.out.println("truc");
	}
}