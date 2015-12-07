package be.ephec.modele;

public class ParcGratuit extends Case {

	public ParcGratuit(Partie partie){
		super(partie,"ParcGratuit","Parc Gratuit");
	}

	public void action(){
		
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
