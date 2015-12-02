package be.ephec.modele;

public class CaseCaisseCom extends Case{
	
	public CaseCaisseCom(){
		super("CaisseCom", "Case Caisse de Communeauté");
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