package be.ephec.modele;

public class Depart extends Case{
	
	public Depart(Partie partie){
		super(partie,"Depart","Case Depart");
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


