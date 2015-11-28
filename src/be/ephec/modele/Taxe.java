package be.ephec.modele;

public class Taxe extends Case {
	private int prixTaxe;
	
	public Taxe(String nom){
		super("Taxe", nom);
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
		return prixTaxe;
	}
}