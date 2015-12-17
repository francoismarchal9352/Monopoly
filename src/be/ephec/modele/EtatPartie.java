package be.ephec.modele;

import java.io.Serializable;

public class EtatPartie implements Serializable {
	private String valeurDe1;
	private String valeurDe2;
	private String soldeJ1;
	private String soldeJ2;
	private String positionJ1;
	private String positionJ2;
	private String nbCarteSortezPrisonJ1;
	private String nbCarteSortezPrisonJ2;
	private String nbTourPrisonJ1;
	private String nbTourPrisonJ2;
	private String nbTourSuiteJ1;
	private String nbTourSuiteJ2;
	private String nbTour;
	
	public EtatPartie(String valeurDe1, String valeurDe2, String soldeJ1, String soldeJ2,
					String positionJ1, String positionJ2, String nbCarteSortezPrisonJ1, String nbCarteSortezPrisonJ2,
					String nbTourPrisonJ1, String nbTourPrisonJ2, String nbTourSuiteJ1, String nbTourSuiteJ2, String nbTour){
		this.valeurDe1 = valeurDe1;
		this.valeurDe2 = valeurDe2;
		this.soldeJ1 = soldeJ1;
		this.soldeJ2 = soldeJ2;
		this.positionJ1 = positionJ1;
		this.positionJ2 = positionJ2;
		this.nbCarteSortezPrisonJ1 = nbCarteSortezPrisonJ1;
		this.nbCarteSortezPrisonJ2 = nbCarteSortezPrisonJ2;
		this.nbTourPrisonJ1 = nbTourPrisonJ1;
		this.nbTourPrisonJ2 = nbTourPrisonJ2;
		this.nbTourSuiteJ1 = nbTourSuiteJ1;
		this.nbTourSuiteJ2 = nbTourSuiteJ2;
		this.nbTour = nbTour;
	}
	
	public String getNbTour() {
		return nbTour;
	}

	public String getValeurDe1() {
		return valeurDe1;
	}
	
	public String getValeurDe2() {
		return valeurDe2;
	}
	
	public String getSoldeJ1() {
		return soldeJ1;
	}
	
	public String getSoldeJ2() {
		return soldeJ2;
	}
	
	public String getPositionJ1() {
		return positionJ1;
	}
	
	public String getPositionJ2() {
		return positionJ2;
	}
	
	public String getNbCarteSortezPrisonJ1() {
		return nbCarteSortezPrisonJ1;
	}
	
	public String getNbCarteSortezPrisonJ2() {
		return nbCarteSortezPrisonJ2;
	}
	
	public String getNbTourPrisonJ1() {
		return nbTourPrisonJ1;
	}
	
	public String getNbTourPrisonJ2() {
		return nbTourPrisonJ2;
	}
	
	public String getNbTourSuiteJ1() {
		return nbTourSuiteJ1;
	}
	
	public String getNbTourSuiteJ2() {
		return nbTourSuiteJ2;
	}
}