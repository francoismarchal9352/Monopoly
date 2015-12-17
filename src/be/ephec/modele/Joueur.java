/**
 * @author Marchal François et Massart Florian
 * @version 1.0
 */

package be.ephec.modele;

import java.io.Serializable;
import java.util.ArrayList;


public class Joueur implements Serializable{
	private Partie partie;
	private String nom;
	private int num;
	private int position;
	private int solde;
	private int nbCarteSortezPrison;
	private int nbTourPrison;
	private int nbTourSuite;
	private ArrayList<Case> tabPossessions;
	
	public ArrayList<Case> getTabPossessions() {
		return tabPossessions;
	}

	/**
	 * Constructeur de joueur
	 * @param partie : la partie en cours
	 * @param nb : le numéro du joueur
	 */
	public Joueur(Partie partie, int nb){
		this.partie = partie;
		this.nom = "Joueur "+nb;
		this.num = nb;
		position = 0;
		solde = 15000;
		nbCarteSortezPrison = 0;
		nbTourPrison = 0;
		nbTourSuite = 0;
		tabPossessions = new ArrayList<Case>(); // défault size d'un ArrayList est 10. Autant laisser cette valeur pour gagner un peu en perf lors de l'exec.	
	}
	
	/**
	 * Methode pour envoyer un joueur en prison
	 */
	public void entreEnPrison() {	//Désactiver les boutons pour acheter et vendre des propriétés
		partie.AfficherDansLogClient(partie.getJoueurCourant().getNom()+" entre en PRISOOOOOOOON !\n");
		position=10;
		this.setNbTourSuite(0);
		nbTourPrison=1;
		if(nbCarteSortezPrison>0){
			nbCarteSortezPrison--;
			nbTourPrison=0;
		}
	}
	
	public int getSolde(){
		return solde;
	}
	
	public void setSolde(int solde) {
		this.solde = solde;
	}

	public int getPosition(){
		return position;
	}
	
	public void setPosition(int x){
		position = x;
	}
	
	public int getNbMaison(){
		int nbMaison = 0;
		for(Case possession : tabPossessions){
			if(possession.getType() == "Propriété"){
				nbMaison += possession.getNbMaison();
			}
		}
		return nbMaison;
	}
	
	public int getNbHotel(){
		int nbHotel = 0;
		for(Case possession : tabPossessions){
			if(possession.getType() == "Propriété"){
				nbHotel += possession.getNbHotel();
			}
		}
		return nbHotel;
		
	}

	
	public int getNbCarteSortezPrison() {
		return nbCarteSortezPrison;
	}

	public void setNbCarteSortezPrison(int nbCarteSortezPrison) {
		this.nbCarteSortezPrison = nbCarteSortezPrison;
	}

	public int getNbTourPrison() {
		return nbTourPrison;
	}

	public void setNbTourPrison(int nbTourPrison) {
		this.nbTourPrison = nbTourPrison;
	}
	
	public int getNbTourSuite(){
		return nbTourSuite;
	}
	
	public void setNbTourSuite(int nb) {
		nbTourSuite=nb;
	}

	public String getNom(){
		return nom;
	}
	
	public int getNum(){
		return num;
	}

}