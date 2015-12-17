/**
 * @author Marchal François & Massart Florian
 * @version 1.0
 */

package be.ephec.modele;

import java.io.Serializable;

public class AllerPrison extends Case implements Serializable{
	
	/**
	 * Constructeur de case Aller en prison
	 * @param partie : la partie en cours
	 */
	public AllerPrison(Partie partie){
		super(partie, "AllerPrison","Aller en prison");
	}

	/* (non-Javadoc)
	 * @see be.ephec.modele.Case#action()
	 */
	public void action(){
		partie.getJoueurCourant().entreEnPrison();
	}


	/* (non-Javadoc)
	 * @see be.ephec.modele.Case#getProprietaire()
	 */
	@Override
	public String getProprietaire() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see be.ephec.modele.Case#setProprietaire(java.lang.String)
	 */
	@Override
	public void setProprietaire(String nom) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see be.ephec.modele.Case#getPrixTerrain()
	 */
	@Override
	public int getPrixTerrain() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see be.ephec.modele.Case#getNbMaison()
	 */
	@Override
	public int getNbMaison() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see be.ephec.modele.Case#getNbHotel()
	 */
	@Override
	public int getNbHotel() {
		// TODO Auto-generated method stub
		return 0;
	}
}