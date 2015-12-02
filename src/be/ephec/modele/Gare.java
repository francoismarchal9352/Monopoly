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


	@Override
	public String getProprietaire() {
		// TODO Auto-generated method stub
		return proprietaire;
	}


	@Override
	public int getPrixTerrain() {
		// TODO Auto-generated method stub
		return prixGare;
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