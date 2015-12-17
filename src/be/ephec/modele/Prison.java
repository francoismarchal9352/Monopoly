package be.ephec.modele;

import java.io.Serializable;

public class Prison extends Case implements Serializable{
	
	/**
	 * Constructeur de la case prison
	 * @param partie : la partie en cours
	 */
	public Prison(Partie partie){
		super(partie,"Prison","Prison");
	}

	/**
	 * Methode pour l'action de la case prison
	 */
	public void action(){
		//Rien à mettre dans cette méthode.
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