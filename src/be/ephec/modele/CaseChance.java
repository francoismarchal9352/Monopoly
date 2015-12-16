package be.ephec.modele;

import java.io.Serializable;

public class CaseChance extends Case implements Serializable{
	
	public CaseChance(Partie partie){
		super(partie, "Chance", "Case Chance");
	}
	
	public void action(){
		partie.setNbCarteChancePioche(partie.getNbCarteChancePioche()+1);
		/*Affiche le texte de la carte au joueur*/
/*TEST*/partie.getAppliServeur().getGuiServeur().ajouteDansLaConsole(partie.getJoueurCourant().getNom()+" pioche carte CHANCE n°"+partie.getPlateau().getCarte("Chance", partie.getNbCarteChancePioche()%16).numMethode);
		partie.getPlateau().getCarte("Chance", partie.getNbCarteChancePioche()%16).action(partie.getPlateau().getCarte("Chance", partie.getNbCarteChancePioche()%16).getNumMethode());
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