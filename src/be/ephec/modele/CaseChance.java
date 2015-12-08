package be.ephec.modele;

public class CaseChance extends Case {
	
	public CaseChance(Partie partie){
		super(partie, "Chance", "Case Chance");
	}
	
	public void action(){
		/*Affiche le texte de la carte au joueur*/
		partie.getPlateau().getCarte("Chance", partie.getNbCarteChancePioche()).action(partie.getPlateau().getCarte("Chance", partie.getNbCarteChancePioche()).getMethodeNum());
		partie.setNbCarteChancePioche(partie.getNbCarteChancePioche()+1);
	}
		
	@Override
	public String getProprietaire() {
		// TODO Auto-generated method stub
		return null;
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