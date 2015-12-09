package be.ephec.modele;

public class CaseCaisseCom extends Case{
	
	public CaseCaisseCom(Partie partie){
		super(partie,"CaisseCom", "Case Caisse de Communeaut�");
	}
	
	public void action(){
		partie.setNbCarteCaisseComPioche(partie.getNbCarteCaisseComPioche()+1);
		/*Affiche le texte de la carte au joueur*/
/*TEST*/System.out.println(partie.getJoueurCourant().getNom()+" pioche carte CAISSE COM n�"+partie.getPlateau().getCarte("CaisseCom", partie.getNbCarteCaisseComPioche()%16).numMethode);
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