package be.ephec.modele;

public class Service extends Case {
	private String proprietaire;
	private int prixService;
	
	public Service(Partie partie, String nom){
		super(partie,"Service", nom);
		this.prixService = 150;
	}	
	
	
	public void action(){
		
	}


	@Override
	public String getProprietaire() {
		// TODO Auto-generated method stub
		return proprietaire;
	}


	@Override
	public int getPrixTerrain() {
		// TODO Auto-generated method stub
		return prixService;
	}


	@Override
	public int getNbMaison() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getNbHotel() {
		// TODO Auto-generated method stub
		return 0;
	}
}