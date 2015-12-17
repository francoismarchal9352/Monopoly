package be.ephec.modele;

import java.io.Serializable;
import java.util.ArrayList;

import be.ephec.application.ApplicationServeur;

public class Partie implements Serializable{
	private int nbTour = 0;
	private transient ApplicationServeur appliServeur;
	private ArrayList<Joueur> tabJoueurs = new ArrayList<Joueur>(2);
	private Plateau plateau = new Plateau(this);
	private Joueur[] tabMonopoles = new Joueur[8];
	private int nbCarteChancePioche = 0;
	private int nbCarteCaisseComPioche = 0;
	private boolean flagDesDouble = false;
	private EtatPartie etatPartie;
	
	public Partie(ApplicationServeur appliServer){
		this.appliServeur = appliServer;
		initJoueur();
	}

	/*
	public static void main(String[] args) { //M�thode de test.
		Partie truc = new Partie();
		while(truc.getTabJoueurs().size()>1){
			truc.debutTour();
			System.out.println("");
			truc.finTour();
			System.out.println("Tour n�"+truc.nbTour);
			try {
				TimeUnit.MILLISECONDS.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("La partie a dur� "+truc.nbTour+" tours.");
	}
	*/
	
	public void debutTour(){
		//while(plateau.getSommeDes() == 0){
			/*le programme attend que le joueur lance les d�s.
			 * Pendant ce temps, le joueur peut acheter des maisons/hotels, demander des loyers et vendre des biens.*/
			// La m�thode LancerDes() est li�e au bouton dans la GUI.
		//	}
		/*Le joueur vient de lancer les d�s*/
		this.plateau.lancerDes();
/*TEST*/AfficherDansLogClient(((getJoueurCourant().getNom()+": Les d�s ont fait "+plateau.getDe1().getValeur()+" + "+plateau.getDe2().getValeur())+".\n"));
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
			if((getJoueurCourant().getNbTourSuite()==2) && (flagDesDouble==true))
					getJoueurCourant().entreEnPrison();
			avancer(plateau.getSommeDes());
		}
		//while(/*quelque chose*/){
			/*le programme attend que le joueur clique sur le bouton "Fin de tour".
			 * Pendant ce temps, le joueur peut acheter des maisons/hotels, demander des loyers et vendre des biens.*/
	}
	
	public void finTour(){	//Note: Bouton "fin de tour" uniquement cliquable apr�s avoir lanc� les d�s.
		if( (!flagDesDouble) || (getJoueurCourant().getNbTourPrison()>0))
			nbTour++; //nbTour++ que si le joueur n'a pas fait un double OU si le joueur est en prison en fin de tour.
		else //Sinon, �a veut dire que le joueur a fait un double et n'a pas fini son tour en prison.
			getJoueurCourant().setNbTourSuite(getJoueurCourant().getNbTourSuite()+1);
		plateau.getDe1().setZero();
		plateau.getDe2().setZero();
		flagDesDouble=false;
	}
	
	private void initJoueur() {
		tabJoueurs.add(new Joueur(this, 1));
		tabJoueurs.add(new Joueur(this, 2));
	}

	public void acheter(){ // Tente d'acheter la case sur laquelle le joueur courant se trouve.
		Case terrain = plateau.getTabCases()[getJoueurCourant().getPosition()];
		if((terrain.getType()=="Propri�t�"  || terrain.getType().compareToIgnoreCase("Gare")==0 || terrain.getType().compareToIgnoreCase("Service")==0) && terrain.getProprietaire() == null){
			if(getJoueurCourant().getSolde() - terrain.getPrixTerrain() >= 0){
				retraitSolde(terrain.getPrixTerrain(),getJoueurCourant());
				getJoueurCourant().getTabPossessions().add(terrain);
				terrain.setProprietaire(getJoueurCourant().getNom());
			}
		}
		else { // si c'est pas le bon type ou d�j� achet� => envoie msg au joueur 
			AfficherDansLogClient("achat impossible !\n");
		}
	}
	
	public void vendre(Case x, int valeur, Joueur acheteur){ // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! � check pour la d�cision.
			// verif solde autre joueur + decision 
			if(/*decision &&*/ acheteur.getSolde() >= valeur ){
				ajoutSolde(valeur,getJoueurCourant());
				getJoueurCourant().getTabPossessions().remove(x);
			}
	}
	
	public void avancer(int x){ //Sert � avancer de X cases.
		int anciennePosition = getJoueurCourant().getPosition();
		getJoueurCourant().setPosition((getJoueurCourant().getPosition() + x)%40);
		checkPasseCaseDepart(anciennePosition);
		AfficherDansLogClient(getJoueurCourant().getNom()+" arrive sur la case "+plateau.getTabCases()[getJoueurCourant().getPosition()].getNom()+".\n");
		plateau.getTabCases()[getJoueurCourant().getPosition()].action();
	}
	
	public void allerA(int x){ //Sert � placer le joueurCourant � l'indice X du plateau.
		int anciennePosition = getJoueurCourant().getPosition();
		getJoueurCourant().setPosition(x);
		checkPasseCaseDepart(anciennePosition);
		plateau.getTabCases()[getJoueurCourant().getPosition()].action();
		AfficherDansLogClient(getJoueurCourant().getNom()+" arrive sur la case "+plateau.getTabCases()[getJoueurCourant().getPosition()].getNom()+".\n");
	}
	
	public void checkPasseCaseDepart(int anciennePosition){
		if((getJoueurCourant().getPosition() < anciennePosition) && getJoueurCourant().getNbTourPrison() == 0)
			ajoutSolde(200,getJoueurCourant());
	}
	
	public void ajoutSolde(int montant, Joueur joueur){
/*TEST*/AfficherDansLogClient(getJoueurCourant().getNom()+" re�oit "+montant+" euros. Il lui reste "+(getJoueurCourant().getSolde()+montant)+".\n");
		joueur.setSolde(joueur.getSolde()+montant);
	}
	
	public void retraitSolde(int montant, Joueur joueur){
/*TEST*/AfficherDansLogClient(getJoueurCourant().getNom()+" paye "+montant+" euros. Il lui reste "+(getJoueurCourant().getSolde()-montant)+".\n");
		joueur.setSolde(joueur.getSolde()-montant);
		if (joueur.getSolde()<0)
			Perdu(joueur);
	}
	
	public void Perdu(Joueur joueur) {
		// envoyer un msg au joueur 
		//supprimer le joueur perdant
/*TEST*/AfficherDansLogClient("Le joueur "+getJoueurCourant().getNom()+" a perdu.\n");
		//On set � null le propri�taire de ses possession.
		for(Case possession : joueur.getTabPossessions()){
/*TEST*/	AfficherDansLogClient(possession.getNom()+" n'appartient plus � "+joueur.getNom()+".\n");
			possession.setProprietaire(null);
		}
		tabJoueurs.remove(joueur);
		AfficherDansLogClient("La partie a dur� "+nbTour+" tours.\n");
		if(tabJoueurs.size()==1)
			Gagne(tabJoueurs.get(0));
	}
	
	public void Gagne(Joueur joueur) {
		//envoyer un msg au joueur 
		// terminer la partie
		AfficherDansLogClient("Le joueur "+tabJoueurs.get(0).getNom()+" a gagn� !");
	}
	
	public void AfficherDansLogClient(String s){
		appliServeur.getServeurSocket().ecrireSurTousLesClients(s);
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

	public ApplicationServeur getAppliServeur() {
		return appliServeur;
	}
	
	public EtatPartie getEtatPartie(){
		return etatPartie;
	}
	public EtatPartie genereEtatPartie() {
		etatPartie = new EtatPartie(Integer.toString(getPlateau().getDe1().getValeur()), Integer.toString(getPlateau().getDe2().getValeur()),
				Integer.toString(getTabJoueurs().get(0).getSolde()), Integer.toString(getTabJoueurs().get(1).getSolde()),
				Integer.toString(getTabJoueurs().get(0).getPosition()), Integer.toString(getTabJoueurs().get(1).getPosition()),
				Integer.toString(getTabJoueurs().get(0).getNbCarteSortezPrison()), Integer.toString(getTabJoueurs().get(1).getNbCarteSortezPrison()),
				Integer.toString(getTabJoueurs().get(0).getNbTourPrison()), Integer.toString(getTabJoueurs().get(1).getNbTourPrison()),
				Integer.toString(getTabJoueurs().get(0).getNbTourSuite()), Integer.toString(getTabJoueurs().get(1).getNbTourSuite()),
				Integer.toString(nbTour));
		return etatPartie;
	}

}