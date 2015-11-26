package be.ephec.modele;

public class Partie {
	private int nbCarteChancePioche;
	private int nbCarteCaisseComPioche;
	private int nbTour;
	private Joueur monopoles[];
	
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
		// TODO Auto-generated method stub
		
	}

	private void initPlateau() {
		initCase();
		initDe();
	}

	private void initDe() {
		// TODO Auto-generated method stub
		
	}

	private void initCase() {
		initPropriete();
		initCaseCaisseCom(); // a voir
		initCaseChance(); // a voir
		initPrison(); // a voir
		initService();
		initTaxe();
		initGare();
		
		
		
	}
/*
	private void initPrison() {
		// TODO Auto-generated method stub
		
	}

	private void initCaseChance() {
		// TODO Auto-generated method stub
		
	}

	private void initCaseCaisseCom() {
		// TODO Auto-generated method stub
		
	}
*/
	
	private void initGare() {
		// TODO Auto-generated method stub
		
	}

	private void initTaxe() {
		// TODO Auto-generated method stub
		
	}

	private void initService() {
		// TODO Auto-generated method stub
		
	}

	private void initPropriete() {
		// TODO Auto-generated method stub
		
	}

	private void initCarteCaisseCom() {
		// TODO Auto-generated method stub
		
	}

	private void initCarteChance() {
		// TODO Auto-generated method stub
		
	}

	public void debutTour(){
		
	}
	
	public void finTour(){
		
	}
	
	public void main(String[] args) {
		// TODO Auto-generated method stub

	}
}