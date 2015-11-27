package be.ephec.modele;

public class Partie {
	private int nbCarteChancePioche;
	private int nbCarteCaisseComPioche;
	private int nbTour;
	private Joueur[] tabMonopoles = new Joueur[8];
	private Joueur[] tabJoueurs = new Joueur[2];
	
	public Partie(){
		
	}
	
	
	public void initialisation(){
		initCarteChance();
		initCarteCaisseCom();
		initPlateau();
		initJoueur();
	}
	
	private void initMonopoles() {
		// TODO Auto-generated method stub
		
	}

	private void initJoueur() {
		tabJoueurs[0] = new Joueur("nom1");
		tabJoueurs[1] = new Joueur("nom2");
		
		
		
	}

	private void initPlateau() {
		initCase();
		initDe();
	}

	private void initDe() {
		De de1 = new De();
		De de2 = new De();
		
		
	}

	private void initCase() {

		
		
		
	}

	public void debutTour(){
		
	}
	
	public void finTour(){
		
		
	}
	
	public int getJoueurCurrent(){
		return nbTour % tabJoueurs.length;
	}
	
	public void main(String[] args) {
		// TODO Auto-generated method stub

	}
}