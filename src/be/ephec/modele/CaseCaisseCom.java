package be.ephec.modele;

import java.io.Serializable;

public class CaseCaisseCom extends Case implements Serializable{

	/**
	 * Constructeur de case caisse de communautée
	 * @param partie : la partie en cours
	 */
	public CaseCaisseCom(Partie partie){
		super(partie,"CaisseCom", "Case Caisse de Communeauté");
	}
	
	/**
	 * Methode pour l'action des cases caisse de communautée
	 */
	public void action(){
		partie.setNbCarteCaisseComPioche(partie.getNbCarteCaisseComPioche()+1);
/*TEST*/partie.AfficherDansLogClient(partie.getJoueurCourant().getNom()+" pioche carte CAISSE COM n°"+partie.getPlateau().getCarte("CaisseCom", partie.getNbCarteCaisseComPioche()%16).numMethode+".\n");
		partie.AfficherDansLogClient(partie.getPlateau().getCarte("CaisseCom", partie.getNbCarteCaisseComPioche()%16).texte+".");
		partie.getPlateau().getCarte("CaisseCom", partie.getNbCarteCaisseComPioche()%16).action(partie.getPlateau().getCarte("CaisseCom", partie.getNbCarteCaisseComPioche()%16).getNumMethode());
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