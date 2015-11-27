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
	
	// methode getNumCase() et getProprietaire et getPrixTerrain indéfinie dans case /!\
	public void acheter(Case x){
		if(x.getType() == "Propriété" || x.getType() == "gare"  || x.getType() == "service" && x.getProprietaire() == null && x.getNumCase() == this.tabJoueurs[getJoueurCourant()].getPosition()){
			if(this.tabJoueurs[this.getJoueurCourant()].solde - x.getPrixTerrain() >= 0){
				this.tabJoueurs[getJoueurCourant()].retraitSolde(x.getPrixTerrain());
				this.tabJoueurs[getJoueurCourant()].getTabProprietes().add(x);
			}
		} else {
			
			// si c'est pas le bon type ou déjà acheté => envoie msg au joueur 
			System.out.println("achat impossible !");
		}
	}
	
	public void vendre(Case x, int valeur){
			// verif solde autre joueur
			if(decision && /*verif solde autre joueur*/){
				this.tabJoueurs[getJoueurCourant()].ajoutSolde(valeur);
				this.tabJoueurs[getJoueurCourant()].tabProprietes.remove(x);
			}
	}
	
	
	
	public void avancer(int x){
		int anciennePosition = this.tabJoueurs[getJoueurCourant()].getPosition();
		if(this.tabJoueurs[getJoueurCourant()].getPosition() + x >= 40){ this.tabJoueurs[getJoueurCourant()].setPosition((this.tabJoueurs[getJoueurCourant()].getPosition() + x)%40);
		} else {this.tabJoueurs[getJoueurCourant()].setPosition(this.tabJoueurs[getJoueurCourant()].getPosition() + x);}
		
		if(this.tabJoueurs[getJoueurCourant()].getPosition() < anciennePosition){
			this.tabJoueurs[getJoueurCourant()].ajoutSolde(200);
		}
	}
	
	public void allerA(int x){
		this.tabJoueurs[getJoueurCourant()].setPosition(x);
	}
	
	

	public void debutTour(){
		
	}
	
	public void finTour(){
		
		
	}
	
	public int getJoueurCourant(){
		return nbTour % tabJoueurs.length;
	}
	
	public void main(String[] args) {
		// TODO Auto-generated method stub

	}
}