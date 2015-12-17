/**
 * @author Marchal François et Massart Florian
 * @version 1.0
 */

package be.ephec.modele;

import java.io.Serializable;


public class CarteChance extends Carte implements Serializable{
	
	/**
	 * Constructeur de carte chance
	 * @param partie : la partie en cours
	 * @param texte : le texte à afficher sur la carte
	 * @param methodeNum : le numéro de la méthode à executer
	 */
	public CarteChance(Partie partie, String texte, int methodeNum){
		super(partie, texte, methodeNum);
	}
	
	/**
	 * Methode pour l'action des cartes chance
	 * @param methodeNum : le numéro de la méthode à executer
	 */
	public void action(int methodeNum){
		switch (methodeNum) { //peut mieux faire en stackant les fonctions similaires mais pas urgent.
			case 1: partie.retraitSolde(10,partie.getJoueurCourant()); break;
			case 2: partie.ajoutSolde(50,partie.getJoueurCourant()); break;
			case 3: reparations(40,115); break;
			case 4: partie.allerA(0); break;
			case 5: partie.retraitSolde(150,partie.getJoueurCourant()); break;
			case 6: partie.allerA(39); break;
			case 7: partie.getJoueurCourant().setNbCarteSortezPrison(partie.getJoueurCourant().getNbCarteSortezPrison() + 1); break;
			case 8: partie.allerA(24); break;
			case 9: reparations(25,100); break;
			case 10: partie.allerA(11); break;
			case 11: partie.allerA(15); break;
			case 12: partie.ajoutSolde(150,partie.getJoueurCourant()); break;
			case 13: partie.getJoueurCourant().entreEnPrison(); break;
			case 14: partie.getJoueurCourant().setPosition(partie.getJoueurCourant().getPosition()-3); break;
			case 15: partie.retraitSolde(20,partie.getJoueurCourant());break;
			case 16: partie.ajoutSolde(100,partie.getJoueurCourant());break;
		}
	}
	
	/**
	 * méthode permettant de gérer la carte réparation
	 * @param prixParMaison : cout de la réparation des maisons
	 * @param prixParHotel : cout de la réparation des hôtels
	 */
	private void reparations(int prixParMaison, int prixParHotel) {
		int somme = 0;
		somme += partie.getJoueurCourant().getNbMaison()*40;
		somme += partie.getJoueurCourant().getNbHotel()*115;
		partie.retraitSolde(somme,partie.getJoueurCourant());		
	}
}