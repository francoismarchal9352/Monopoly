package be.ephec.modele;

public class Propriete extends Case{
	private String proprietaire;
	private String couleur;
	private int prixTerrain;
	private int nbMaison;
	private int nbHotel;
	private int prixConstruction;
	private int[] tabLoyers = new int[6];
	
	
	public Propriete(Partie partie, String nom, String couleur, int prixTerrain, int prixConstruction, int loyer1, int loyer2, int loyer3, int loyer4, int loyer5, int loyer6){
		super(partie,"Propriété", nom);
		this.couleur = couleur;
		this.prixTerrain = prixTerrain;
		this.nbMaison = 0;
		this.nbHotel = 0;
		this.prixConstruction = prixConstruction;
		this.tabLoyers = new int[]{loyer1,loyer2,loyer3,loyer4,loyer5,loyer6};	
	}
	
	public String getProprietaire() {
		return proprietaire;
	}
	
	public int getPrixTerrain() {
		return prixTerrain;
	}
	
	public int getNbMaison() {
		return nbMaison;
	}
	public int getNbHotel() {
		return nbHotel;
	}
	public void action(){
		
	}
	
}