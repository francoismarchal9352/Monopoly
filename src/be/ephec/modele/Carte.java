package be.ephec.modele;

import java.io.Serializable;

public abstract class Carte implements Serializable{
	protected Partie partie;
	protected String texte;
	protected int numMethode;
	
	public Carte(Partie partie, String texte, int methodeNum) {
		this.partie = partie;
		this.texte = texte;
		this.numMethode = methodeNum;
	}

	public abstract void action(int methodeNum);
	
	public int getNumMethode(){
		return numMethode;
	}
}