/**
 * @author Marchal François & Massart Florian
 * @version 1.0
 */

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
	
	/**
	 * Constructeur de partie
	 * @param appliServer : l'application serveur
	 */
	public Partie(ApplicationServeur appliServer){
		this.appliServeur = appliServer;
		initJoueur();
	}

	/*
	public static void main(String[] args) { //Méthode de test.
		Partie truc = new Partie();
		while(truc.getTabJoueurs().size()>1){
			truc.debutTour();
			System.out.println("");
			truc.finTour();
			System.out.println("Tour n° "+truc.nbTour);
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
	
	/**
	 * Methode pour commencer son tour
	 */
	public void debutTour(){
		/*Le joueur vient de lancer les dés dans la GUI*/
		this.plateau.lancerDes();
/*TEST*/AfficherDansLogClient(((getJoueurCourant().getNom()+": Les dés ont fait "+plateau.getDe1().getValeur()+" + "+plateau.getDe2().getValeur())+".\n"));
		if(plateau.getDe1().getValeur()==plateau.getDe2().getValeur())
			flagDesDouble=true;
		if(getJoueurCourant().getNbTourPrison()>0){
			getJoueurCourant().setNbTourPrison(getJoueurCourant().getNbTourPrison()+1);
			if(getJoueurCourant().getNbTourPrison()>3){
				if(!flagDesDouble)
					retraitSolde(50, getJoueurCourant());
				getJoueurCourant().setNbTourPrison(0);
				avancer(plateau.getSommeDes());
			}
			if(plateau.getDe1().getValeur() == plateau.getDe2().getValeur()){
				getJoueurCourant().setNbTourPrison(0);				
				avancer(plateau.getSommeDes());
			}
		}
		else{
			if((getJoueurCourant().getNbTourSuite()==2) && (flagDesDouble))
					getJoueurCourant().entreEnPrison();
			avancer(plateau.getSommeDes());
		}
			/*le programme attend que le joueur clique sur le bouton "Fin de tour".
			 * Pendant ce temps, le joueur peut acheter des maisons/hotels, demander des loyers et vendre des biens.*/
	}
	
	/**
	 * Methode pour finir son tour
	 */
	public void finTour(){	//Note: Bouton "fin de tour" uniquement cliquable aprés avoir lancé les dés.
		if( (!flagDesDouble) || (getJoueurCourant().getNbTourPrison()>0))
			nbTour++; //nbTour++ que si le joueur n'a pas fait un double OU si le joueur est en prison en fin de tour.
		else //Sinon, ça veut dire que le joueur a fait un double et n'a pas fini son tour en prison.
			getJoueurCourant().setNbTourSuite(getJoueurCourant().getNbTourSuite()+1);
		flagDesDouble=false;
	}
	
	/**
	 * Methode permettant d'initialiser les joueurs
	 */
	private void initJoueur() {
		tabJoueurs.add(new Joueur(this, 1));
		tabJoueurs.add(new Joueur(this, 2));
	}

	/**
	 * Methode permettant au joueur d'acheter des biens (si le bien peut étre acheté)
	 */
	public void acheter(){ // Tente d'acheter la case sur laquelle le joueur courant se trouve.
		Case terrain = plateau.getTabCases()[getJoueurCourant().getPosition()];
		if((terrain.getType().equals("Propriété") || terrain.getType().equals("Gare") || terrain.getType().equals("Service")) && terrain.getProprietaire() == null){
			if(getJoueurCourant().getSolde() - terrain.getPrixTerrain() >= 0){
				retraitSolde(terrain.getPrixTerrain(),getJoueurCourant());
				getJoueurCourant().getTabPossessions().add(terrain);
				terrain.setProprietaire(getJoueurCourant().getNom());
			}
		}
		else { // si c'est pas le bon type ou déjà acheté => envoie msg au joueur 
			AfficherDansLogClient("achat impossible !\n");
		}
	}
	
	/**
	 * Methode permettant au joueur de vendre des biens achetés auparavant
	 * @param x  : la case à acheter
	 * @param valeur : la valeur de la case
	 * @param acheteur : le joueur qui achête la case
	 */
	public void vendre(Case x, int valeur, Joueur acheteur){ // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! à check pour la décision.
			// verif solde autre joueur + decision 
			if(/*decision &&*/ acheteur.getSolde() >= valeur ){
				ajoutSolde(valeur,getJoueurCourant());
				getJoueurCourant().getTabPossessions().remove(x);
			}
	}
	
	/**
	 * Methode permettant au joueur d'avancer de X cases
	 * @param x : un nombre entier positif
	 */
	public void avancer(int x){ //Sert à avancer de X cases.
		int anciennePosition = getJoueurCourant().getPosition();
		getJoueurCourant().setPosition((getJoueurCourant().getPosition() + x)%40);
		checkPasseCaseDepart(anciennePosition);
		AfficherDansLogClient(getJoueurCourant().getNom()+" arrive sur la case "+plateau.getTabCases()[getJoueurCourant().getPosition()].getNom()+".\n");
		plateau.getTabCases()[getJoueurCourant().getPosition()].action();
	}
	
	/**
	 * Methode permettant au joueur d'avancer jusqu'a la case X
	 * @param x : un nombre entier positif (indice de la case)
	 */
	public void allerA(int x){ //Sert à placer le joueurCourant à l'indice X du plateau.
		int anciennePosition = getJoueurCourant().getPosition();
		getJoueurCourant().setPosition(x);
		checkPasseCaseDepart(anciennePosition);
		plateau.getTabCases()[getJoueurCourant().getPosition()].action();
		AfficherDansLogClient(getJoueurCourant().getNom()+" arrive sur la case "+plateau.getTabCases()[getJoueurCourant().getPosition()].getNom()+".\n");
	}
	
	/**
	 * Methode permettant de vérifier si le joueur passe par la case départ
	 * @param anciennePosition : le numéro de la case où le joueur se trouvait avant
	 */
	public void checkPasseCaseDepart(int anciennePosition){
		if((getJoueurCourant().getPosition() < anciennePosition) && getJoueurCourant().getNbTourPrison() == 0)
			ajoutSolde(200,getJoueurCourant());
	}
	
	/**
	 * Methode permettant d'augmenter le solde d'un joueur
	 * @param montant : un nombre entier positif
	 * @param joueur : le joueur duquel on doit augmenter le solde
	 */
	public void ajoutSolde(int montant, Joueur joueur){
/*TEST*/AfficherDansLogClient(getJoueurCourant().getNom()+" reçoit "+montant+" euros. Il lui reste "+(getJoueurCourant().getSolde()+montant)+".\n");
		joueur.setSolde(joueur.getSolde()+montant);
	}
	
	/**
	 * Methode permettant diminuer le solde d'un joueur
	 * @param montant : un nombre entier positif
	 * @param joueur : le joueur duquel on doit diminuer le solde
	 */
	public void retraitSolde(int montant, Joueur joueur){
/*TEST*/AfficherDansLogClient(getJoueurCourant().getNom()+" paye "+montant+" euros. Il lui reste "+(getJoueurCourant().getSolde()-montant)+".\n");
		joueur.setSolde(joueur.getSolde()-montant);
		if (joueur.getSolde()<0)
			Perdu(joueur);
	}
	
	/**
	 * Methode permettant de faire perdre un joueur
	 * @param joueur : le joueur a faire perdre
	 */
	public void Perdu(Joueur joueur) {
		// envoyer un msg au joueur 
		//supprimer le joueur perdant
/*TEST*/AfficherDansLogClient("Le joueur "+getJoueurCourant().getNom()+" a perdu.\n");
		//On set à null le propriétaire de ses possession.
		for(Case possession : joueur.getTabPossessions()){
/*TEST*/	AfficherDansLogClient(possession.getNom()+" n'appartient plus à "+joueur.getNom()+".\n");
			possession.setProprietaire(null);
		}
		tabJoueurs.remove(joueur);
		AfficherDansLogClient("La partie a duré "+nbTour+" tours.\n");
		if(tabJoueurs.size()==1)
			Gagne(tabJoueurs.get(0));
	}
	
	/**
	 * Methode permettant de faire gagner un joueur
	 * @param joueur : le joueur à faire gagner
	 */
	public void Gagne(Joueur joueur) {
		//envoyer un msg au joueur 
		// terminer la partie
		AfficherDansLogClient("Le joueur "+tabJoueurs.get(0).getNom()+" a gagné !");
	}
	
	/**
	 * Methode permettant des informations dans la console des joueurs
	 * @param s : Le message à afficher
	 */
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