package be.ephec.modele;

public class Taxe extends Case {
	private int prixTaxe;
	
	public Taxe(Partie partie, String nom){
		super(partie,"Taxe", nom);
		this.prixTaxe = 200;
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