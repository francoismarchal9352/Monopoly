package be.ephec.modele;

public abstract class Carte {
	protected Partie partie;
	protected String texte;
	protected int methodeNum;
	
	public Carte(Partie partie, String texte, int methodeNum) {
		this.partie = partie;
		this.texte = texte;
		this.methodeNum = methodeNum;
	}

	public abstract void action(int methodeNum);
	
	public int getMethodeNum(){
		return methodeNum;
	}
}