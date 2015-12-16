package be.ephec.modele;

import java.io.Serializable;

public class AllerPrison extends Case implements Serializable{
	
	public AllerPrison(Partie partie){
		super(partie, "AllerPrison","Aller en prison");
	}

	public void action(){
		partie.getJoueurCourant().entreEnPrison();
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