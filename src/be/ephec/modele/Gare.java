package be.ephec.modele;

public class Gare extends Case{
	private String proprietaire;
	private int prixGare;
	private int tabLoyers[];
	
	public Gare(String nom){
		super("Gare", nom);
		this.prixGare = 200;
		this.tabLoyers = new int[]{25,50,100,200};
	}
	
	
	public void action(){
		
	}
}