package be.ephec.modele;

import java.util.ArrayList;

public class Partie {
	private ArrayList<Joueur> tabJoueurs = new ArrayList<Joueur>(2);
	private Plateau plateau = new Plateau(this);
	private int nbTour = 0;
	private int nbTourSuite = 0;
	private Joueur[] tabMonopoles = new Joueur[8];
	private int nbCarteChancePioche = 0;
	private int nbCarteCaisseComPioche = 0;
	private boolean flagDesDouble = false;
	
	public Partie(){
		
	}
	
	public void initialisation(){ // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! à check si la moindre utilité.
		initJoueur();
	}
	
	public void debutTour(){
		while(plateau.getSommeDes() == 0){
			/*le programme attend que le joueur lance les dés.
			 * Pendant ce temps, le joueur peut acheter des maisons/hotels, demander des loyers et vendre des biens.*/
			// La méthode LancerDes() est liée au bouton dans la GUI.
			}
		/*Le vient de lancer les dés*/
		if(plateau.getDe1().getValeur()==plateau.getDe2().getValeur())
			flagDesDouble=true;
		if(getJoueurCourant().getNbTourPrison()>0){
			getJoueurCourant().setNbTourPrison(getJoueurCourant().getNbTourPrison()+1);
			if(getJoueurCourant().getNbTourPrison()>3){
				if(plateau.getDe1().getValeur()!=plateau.getDe2().getValeur())
					retraitSolde(50, getJoueurCourant());
				avancer(plateau.getSommeDes());
			}
			if(plateau.getDe1().getValeur() == plateau.getDe2().getValeur())
				avancer(plateau.getSommeDes());
		}
		else{
			if((nbTourSuite==2) && (flagDesDouble==true))
					getJoueurCourant().entreEnPrison(); //Besoin de créer la méthode dans Joueur
			avancer(plateau.getSommeDes());
		}
		//while(/*quelque chose*/){
			/*le programme attend que le joueur clique sur le bouton "Fin de tour".
			 * Pendant ce temps, le joueur peut acheter des maisons/hotels, demander des loyers et vendre des biens.*/
		finTour();
	}
	
	public void finTour(){	//Note: Bouton "fin de tour" uniquement cliquable après avoir lancé les dés.
		if( (!flagDesDouble) || (getJoueurCourant().getNbTourPrison()>0))
			nbTour++; //nbTour++ que si le joueur n'a pas fait un double OU si le joueur est en prison en fin de tour.
		else
			nbTourSuite++;
		plateau.getDe1().setZero();
		plateau.getDe2().setZero();
		flagDesDouble=false;
		debutTour();
	}
	
	public ArrayList<Joueur> getTabJoueurs() {
		return tabJoueurs;
	}
	
	private void initJoueur() {
		tabJoueurs.add(new Joueur(this, "Joueur 1"));
		tabJoueurs.add(new Joueur(this, "Joueur 2"));
	}

	public int getIndiceJoueurCourant(){
		return nbTour % tabJoueurs.size();
	}

	public Joueur getJoueurCourant(){
		return tabJoueurs.get(getIndiceJoueurCourant());
	}
	
	public Plateau getPlateau(){
		return plateau;
	}
	
	public int getNbCarteChancePioche(){
		return nbCarteChancePioche;
	}
	public void setNbCarteChancePioche(int nb){
		nbCarteChancePioche=nb;
	}
	
	public int getNbCarteCaisseComPioche(){
		return nbCarteCaisseComPioche;
	}
	
	public void setNbCarteCaisseComPioche(int nb){
		nbCarteCaisseComPioche=nb;
	}
	
	public void acheter(Case terrain){ //L'argument est la case sur laquelle le joueur qui appelle la méthode se trouve.
		if((terrain.getType() == "Propriété" || terrain.getType() == "gare"  || terrain.getType() == "service") && terrain.getProprietaire() == null){
			if(getJoueurCourant().getSolde() - terrain.getPrixTerrain() >= 0){
				retraitSolde(terrain.getPrixTerrain(),getJoueurCourant());
				getJoueurCourant().getTabPossessions().add(terrain);
			}
		}
		else { // si c'est pas le bon type ou déjà acheté => envoie msg au joueur 
			System.out.println("achat impossible !");
		}
	}
	
	public void vendre(Case x, int valeur, Joueur acheteur){ // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! à check pour la décision.
			// verif solde autre joueur + decision 
			if(/*decision &&*/ acheteur.getSolde() >= valeur ){
				ajoutSolde(valeur,getJoueurCourant());
				getJoueurCourant().getTabPossessions().remove(x);
			}
	}
	
	public void avancer(int x){ //Sert à avancer de X cases.
		int anciennePosition = getJoueurCourant().getPosition();
		getJoueurCourant().setPosition((getJoueurCourant().getPosition() + x)%40);
		checkPasseCaseDepart(anciennePosition);
		plateau.getTabCases()[getJoueurCourant().getPosition()].action();
	}
	
	public void allerA(int x){ //Sert à placer le joueurCourant à l'indice X du plateau.
		int anciennePosition = getJoueurCourant().getPosition();
		getJoueurCourant().setPosition(x);
		checkPasseCaseDepart(anciennePosition);
		plateau.getTabCases()[getJoueurCourant().getPosition()].action();
	}
	
	public void checkPasseCaseDepart(int anciennePosition){
		if((getJoueurCourant().getPosition() < anciennePosition) && getJoueurCourant().getNbTourPrison() == 0)
			ajoutSolde(200,getJoueurCourant());
	}
	

	
	public void retraitSolde(int x, Joueur player){
		player.setSolde(-x);
		if (player.getSolde()<0){
			Perdu(player);
			if(tabJoueurs.size()<2){
				Gagne(tabJoueurs.get(0));
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

	public void setNbTourSuite(int nb) {
		nbTourSuite=nb;
	}
	
	
	
	
	
	
	
	
	
}