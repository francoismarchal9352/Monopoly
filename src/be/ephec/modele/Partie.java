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
		//initCarteChance();
		//initCarteCaisseCom();
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
		//initCase();
		//initDe();
	}

	private void initDe() {
		De de1 = new De();
		De de2 = new De();
		
		
	}

	
	public void acheter(Case x){
		if(x.getType() == "Propriété" || x.getType() == "gare"  || x.getType() == "service" && x.getProprietaire() == null && x.getNumCase() == this.tabJoueurs[getJoueurCourant()].getPosition()){
			if(this.tabJoueurs[this.getJoueurCourant()].getSolde() - x.getPrixTerrain() >= 0){
				this.retraitSolde(x.getPrixTerrain(),this.tabJoueurs[getJoueurCourant()]);
				this.tabJoueurs[getJoueurCourant()].getTabProprietes().add(x);
			}
		} else {
			
			// si c'est pas le bon type ou déjà acheté => envoie msg au joueur 
			System.out.println("achat impossible !");
		}
	}
	
	public void vendre(Case x, int valeur, Joueur acheteur){
			// verif solde autre joueur + decision 
			if(/*decision*/ && acheteur.getSolde() >= valeur ){ // a verif
				this.ajoutSolde(valeur,this.tabJoueurs[getJoueurCourant()]);
				this.tabJoueurs[getJoueurCourant()].getTabProprietes().remove(x);
			}
	}
	
	
	
	public void avancer(int x){
		int anciennePosition = this.tabJoueurs[getJoueurCourant()].getPosition();
		if(this.tabJoueurs[getJoueurCourant()].getPosition() + x >= 40){ this.tabJoueurs[getJoueurCourant()].setPosition((this.tabJoueurs[getJoueurCourant()].getPosition() + x)%40);
		} else {this.tabJoueurs[getJoueurCourant()].setPosition(this.tabJoueurs[getJoueurCourant()].getPosition() + x);}
		
		if(this.tabJoueurs[getJoueurCourant()].getPosition() < anciennePosition){
			this.ajoutSolde(200,this.tabJoueurs[getJoueurCourant()]);
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
	
	public void retraitSolde(int x, Joueur player){
		player.setSolde(-x);
		if (player.getSolde()<0){
			Perdu(player);
			if(tabJoueurs.size()<2){
				Gagne(tabJoueurs[0]);
			}
		}
	}
	
	public void Perdu(Joueur player) {
		// TODO Auto-generated method stub
		
	}
	
	public void Gagne(Joueur player) {
		// TODO Auto-generated method stub
		
	}
	
	


	public void ajoutSolde(int x, Joueur player){
		player.setSolde(x);
	}
	
	public void main(String[] args) {
		// TODO Auto-generated method stub

	}
}