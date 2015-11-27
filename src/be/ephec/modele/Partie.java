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
	prout;

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
	
	public void acheter(Case x){
		if(x.getType == "Propriété" || x.getType == "gare"  || x.getType == "service" && x.getProprietaire == null && x.getNumCase == this.getJoueurCurrent()){
			if(this.tabJoueurs[this.getJoueurCourant()].solde - x.prixTerrain >= 0){
				this.tabJoueurs[getJoueurCourant()].retraitSolde(x.prixTerrain);
				this.tabJoueurs[getJoueurCourant()].tabProprietes.add(x);
			}
		} else {
			
			// si c'est pas le bon type ou déjà acheté => envoie msg au joueur 
			System.out.println("achat impossible !");
		}
	}
	
	public void vendre(Case x, int valeur){
			// decision joueur + tests eventuels
			if(decision && /*verif solde autre joueur*/){
				this.tabJoueurs[getJoueurCourant()].ajoutSolde(valeur);
				this.tabJoueurs[getJoueurCourant()].tabProprietes.remove(x);
			}
	}
	
	
	
	public void avancer(int x){
		int anciennePosition = position;
		if(position + x >= 40){ position = (position + x) % 40;
		} else { position += x;}
		
		if(position < anciennePosition){
			this.tabJoueurs[getJoueurCurrent()].ajoutSolde(200);
		}
	}
	
	public void allerA(int x){
		position = x;
	}
	
	public int getPosition(){
		return position;
	}
	
	public void retraitSolde(int x){
		solde -= x;
	}
	
	public void ajoutSolde(int x){
		solde += x;
	}
	
	public int getSolde(){
		return solde;
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