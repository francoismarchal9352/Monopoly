package be.ephec.modele;

public class CaseCaisseCom extends Case{
	
	public CaseCaisseCom(Partie partie){
		super(partie,"CaisseCom", "Case Caisse de Communeauté");
	}
	
	public void action(){
		/*Affiche le texte de la carte au joueur*/
		partie.getPlateau().getCarte("CaisseCom", partie.getNbCarteCaisseComPioche()%16).action(partie.getPlateau().getCarte("CaisseCom", partie.getNbCarteCaisseComPioche()%16).getMethodeNum());
		partie.setNbCarteCaisseComPioche(partie.getNbCarteCaisseComPioche()+1);
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