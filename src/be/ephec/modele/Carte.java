/**
 * @author Marchal François et Massart Florian
 * @version 1.0
 */

package be.ephec.modele;

public abstract class Carte {
	protected Partie partie;
	protected String texte;
	protected int numMethode;
	
	/**
	 * Constructeur de carte
	 * @param partie : la partie en cours
	 * @param texte : le texte à afficher sur la carte
	 * @param methodeNum : le numéro de la méthode à executer
	 */
	public Carte(Partie partie, String texte, int methodeNum) {
		this.partie = partie;
		this.texte = texte;
		this.numMethode = methodeNum;
	}

	/**
	 * Methode abstraite pour l'action des cartes (à implementer dans les classes qui héritent)
	 * @param methodeNum : le numéro de la méthode à executer
	 */
	public abstract void action(int methodeNum);
	

	public int getNumMethode(){
		return numMethode;
	}
}