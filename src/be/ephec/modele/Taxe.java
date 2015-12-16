package be.ephec.modele;

import java.io.Serializable;

public class Taxe extends Case implements Serializable{
	private int prixTaxe;
	
	public Taxe(Partie partie, String nom){
		super(partie,"Taxe", nom);
		this.prixTaxe = 200;
	}
	
	public void action(){
		partie.retraitSolde(100, partie.getJoueurCourant());
	}

	@Override
	public String getProprietaire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProprietaire(String nom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPrixTerrain() {
		// TODO Auto-generated method stub
		return 0;
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