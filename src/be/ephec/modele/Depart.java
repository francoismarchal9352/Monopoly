package be.ephec.modele;

import java.io.Serializable;

public class Depart extends Case implements Serializable{
	
	/**
	 * Constructeeur de case d�part
	 * @param partie : la partie en cours
	 */
	public Depart(Partie partie){
		super(partie,"Depart","Case Depart");
	}
	
	/**
	 * Methode pour l'action de la case d�part
	 */
	public void action(){
		//Rien � mettre dans cette m�thode.
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


