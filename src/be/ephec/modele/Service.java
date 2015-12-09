package be.ephec.modele;

public class Service extends Case {
	private String proprietaire;
	private int prixService;
	
	public Service(Partie partie, String nom){
		super(partie,"Service", nom);
		this.prixService = 150;
	}
	
	public void action(){
		//Rien à mettre dans cette méthode.
	}
	
	@Override
	public String getProprietaire() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setProprietaire(String nom){
		proprietaire = nom;
	}
	
	@Override
	public int getPrixTerrain() {
		return prixService;
	}
	
	@Override
	public int getNbMaison() {
		return 0;
	}
	
	@Override
	public int getNbHotel() {
		return 0;
	}
}