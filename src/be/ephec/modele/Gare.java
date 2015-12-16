package be.ephec.modele;

import java.io.Serializable;

public class Gare extends Case implements Serializable{
	private String proprietaire;
	private int prixGare;
	private int tabLoyers[];
	
	public Gare(Partie partie, String nom){
		super(partie,"Gare", nom);
		this.prixGare = 200;
		this.tabLoyers = new int[]{25,50,100,200};
	}
	
	public void action(){
		//Rien à mettre dans cette méthode.
	}
	
	@Override
	public String getProprietaire() {
		return proprietaire;
	}
	
	public void setProprietaire(String nom){
		proprietaire = nom;
	}
	
	@Override
	public int getPrixTerrain() {
		return prixGare;
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