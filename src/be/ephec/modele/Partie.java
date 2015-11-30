package be.ephec.modele;

public class Partie {
	private Plateau plateau;
	private int nbCarteChancePioche;
	private int nbCarteCaisseComPioche;
	private int nbTour;
	private Joueur[] tabMonopoles = new Joueur[8];
	private Joueur[] tabJoueurs = new Joueur[2];
	
	public Partie(){
		
	}
	
	
	public void initialisation(){
		this.plateau = new Plateau();
		initJoueur();
	}
	
	private void initMonopoles() {
		// TODO Auto-generated method stub
		
	}
	

	private void initJoueur() {
		tabJoueurs[0] = new Joueur("nom1");
		tabJoueurs[1] = new Joueur("nom2");	
	}

	}

	
	public void acheter(Case x){
		if(x.getType() == "Propriété" || x.getType() == "gare"  || x.getType() == "service" && x.getProprietaire() == null && x.getNumCase() == this.tabJoueurs[getJoueurCourant()].getPosition()){
			if(this.tabJoueurs[this.getJoueurCourant()].getSolde() - x.getPrixTerrain() >= 0){
				this.tabJoueurs[getJoueurCourant()].retraitSolde(x.getPrixTerrain());
				this.tabJoueurs[getJoueurCourant()].getTabProprietes().add(x);
			}
		} else {
			
			// si c'est pas le bon type ou déjà acheté => envoie msg au joueur 
			System.out.println("achat impossible !");
		}
	}
	
	public void vendre(Case x, int valeur){
			// verif solde autre joueur + decision 
			if(decision && this.tabJoueurs[0].getSolde() >= valeur ){ // a verif
				this.tabJoueurs[getJoueurCourant()].ajoutSolde(valeur);
				this.tabJoueurs[getJoueurCourant()].getTabProprietes().remove(x);
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
	
	public Joueur getJoueurCourant(){
		return TabJoueur[nbTour % tabJoueurs.length];
	}
	
	public void main(String[] args) {
		// TODO Auto-generated method stub

	}
}