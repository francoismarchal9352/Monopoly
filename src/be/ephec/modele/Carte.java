package be.ephec.modele;

public class Carte {
	protected Partie partie;
	protected String texte;
	protected int methodeNum;
	
	public Carte(Partie partie, String texte, int methodeNum) {
		this.partie = partie;
		this.texte = texte;
		this.methodeNum = methodeNum;
	}

	public void action(){
	}
}