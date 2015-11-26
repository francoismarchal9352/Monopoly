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
}