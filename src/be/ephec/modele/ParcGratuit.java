package be.ephec.modele;

public class ParcGratuit extends Case {

	public ParcGratuit(Partie partie){
		super(partie,"ParcGratuit","Parc Gratuit");
	}

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
