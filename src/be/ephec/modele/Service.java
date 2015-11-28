package be.ephec.modele;

public class Service extends Case {
	private String proprietaire;
	private int prixService;
	
	public Service(String nom){
		super("Service", nom);
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
}