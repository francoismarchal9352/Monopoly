package be.ephec.modele;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Partie {
	private ArrayList<Joueur> tabJoueurs = new ArrayList<Joueur>(2);
	private Plateau plateau = new Plateau(this);
	private int nbTour = 0;
	private int nbTourSuite = 0;
	private Joueur[] tabMonopoles = new Joueur[8];
	private int nbCarteChancePioche = 0;
	private int nbCarteCaisseComPioche = 0;
	private boolean flagDesDouble = false;
	
	private int nbJoueurs = 2;
	
	public Partie(){
		initJoueur();
	}
	
	/*
	public static void main(String[] args) { //Méthode de test.
		Partie truc = new Partie();
		while(truc.getTabJoueurs().size()>1){
			truc.debutTour();
			System.out.println("");
			truc.finTour();
			System.out.println("Tour n°"+truc.nbTour);
			try {
				TimeUnit.MILLISECONDS.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("La partie a duré "+truc.nbTour+" tours.");
	}
	*/
	
	public void debutTour(){
		//while(plateau.getSommeDes() == 0){
			/*le programme attend que le joueur lance les dés.
			 * Pendant ce temps, le joueur peut acheter des maisons/hotels, demander des loyers et vendre des biens.*/
			// La méthode LancerDes() est liée au bouton dans la GUI.
		//	}
		/*Le vient de lancer les dés*/
		this.plateau.lancerDes();
/*TEST*/System.out.println(getJoueurCourant().getNom()+": Les dés ont fait "+plateau.getDe1().getValeur()+" + "+plateau.getDe2().getValeur());
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
					getJoueurCourant().entreEnPrison();
			avancer(plateau.getSommeDes());
		}
		//while(/*quelque chose*/){
			/*le programme attend que le joueur clique sur le bouton "Fin de tour".
			 * Pendant ce temps, le joueur peut acheter des maisons/hotels, demander des loyers et vendre des biens.*/
	}
	
	public void finTour(){	//Note: Bouton "fin de tour" uniquement cliquable après avoir lancé les dés.
		if( (!flagDesDouble) || (getJoueurCourant().getNbTourPrison()>0))
			nbTour++; //nbTour++ que si le joueur n'a pas fait un double OU si le joueur est en prison en fin de tour.
		else //Sinon, ça veut dire que le joueur a fait un double et n'a pas fini son tour en prison.
			nbTourSuite++;
		plateau.getDe1().setZero();
		plateau.getDe2().setZero();
		flagDesDouble=false;
	}
	
	private void initJoueur() {
		tabJoueurs.add(new Joueur(this, "1"));
		tabJoueurs.add(new Joueur(this, "2"));
	}

	public void acheter(Case terrain){ //L'argument est la case sur laquelle le joueur qui appelle la méthode se trouve.
		if((terrain.getType()=="Propriété"  || terrain.getType().compareToIgnoreCase("Gare")==0 || terrain.getType().compareToIgnoreCase("Service")==0) && terrain.getProprietaire() == null){
			if(getJoueurCourant().getSolde() - terrain.getPrixTerrain() >= 0){
				retraitSolde(terrain.getPrixTerrain(),getJoueurCourant());
				getJoueurCourant().getTabPossessions().add(terrain);
				terrain.setProprietaire(getJoueurCourant().getNom());
/*TEST*/		System.out.println(getJoueurCourant().getNom()+" achète sa case.");
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
		System.out.println(getJoueurCourant().getNom()+" arrive sur la case "+plateau.getTabCases()[getJoueurCourant().getPosition()].getNom());
		plateau.getTabCases()[getJoueurCourant().getPosition()].action();
/*TEST*/if(getJoueurCourant().getSolde()>500)
/*TEST*/	acheter(plateau.getTabCases()[getJoueurCourant().getPosition()]);
	}
	
	public void allerA(int x){ //Sert à placer le joueurCourant à l'indice X du plateau.
		int anciennePosition = getJoueurCourant().getPosition();
		getJoueurCourant().setPosition(x);
		checkPasseCaseDepart(anciennePosition);
		plateau.getTabCases()[getJoueurCourant().getPosition()].action();
		System.out.println(getJoueurCourant().getNom()+"Le joueur arrive sur la case "+plateau.getTabCases()[getJoueurCourant().getPosition()].getNom());
	}
	
	public void checkPasseCaseDepart(int anciennePosition){
		if((getJoueurCourant().getPosition() < anciennePosition) && getJoueurCourant().getNbTourPrison() == 0)
			ajoutSolde(200,getJoueurCourant());
	}
	
	public void ajoutSolde(int montant, Joueur joueur){
/*TEST*/System.out.println(getJoueurCourant().getNom()+" reçoit "+montant+" euros. Il lui reste "+(getJoueurCourant().getSolde()+montant));
		joueur.setSolde(joueur.getSolde()+montant);
	}
	
	public void retraitSolde(int montant, Joueur joueur){
/*TEST*/System.out.println(getJoueurCourant().getNom()+" paye "+montant+" euros. Il lui reste "+(getJoueurCourant().getSolde()-montant));
		joueur.setSolde(joueur.getSolde()-montant);
		if (joueur.getSolde()<0)
			Perdu(joueur);
	}
	
	public void Perdu(Joueur joueur) {
		// envoyer un msg au joueur 
		//supprimer le joueur perdant
/*TEST*/System.out.println("Le joueur "+getJoueurCourant().getNom()+" a perdu");
		//On set à null le propriétaire de ses possession.
		for(Case possession : joueur.getTabPossessions()){
/*TEST*/	System.out.println(possession.getNom()+" n'appartient plus à "+joueur.getNom());
			possession.setProprietaire(null);
		}
		tabJoueurs.remove(joueur);
		tabJoueurs.add(1, new Joueur(this, ""+nbJoueurs++));
		System.out.println("La partie dure depuis "+nbTour+" tours.");
		if(tabJoueurs.size()==1)
			Gagne(tabJoueurs.get(0));
	}
	
	public void Gagne(Joueur joueur) {
		//envoyer un msg au joueur 
		// terminer la partie
		System.out.println("Le joueur "+tabJoueurs.get(0).getNom()+" a gagné !");
	}
	

	public ArrayList<Joueur> getTabJoueurs() {
		return tabJoueurs;
	}
	
	public Joueur getJoueurCourant(){
		return tabJoueurs.get(nbTour % tabJoueurs.size());
	}
	
	public Plateau getPlateau(){
		return plateau;
	}
	
	
	
	public int getNbTour() {
		return nbTour;
	}

	public void setNbTour(int nbTour) {
		this.nbTour = nbTour;
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
	
	public void setNbTourSuite(int nb) {
		nbTourSuite=nb;
	}
}