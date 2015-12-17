/**
 * @author Marchal François et Massart Florian
 * @version 1.0
 */

package be.ephec.modele;

public class ParcGratuit extends Case {

	/**
	 * constructeur de case parc gratuit
	 * @param partie : la partie en cours
	 */
	public ParcGratuit(Partie partie){
		super(partie,"ParcGratuit","Parc Gratuit");
	}

	public void action(){
		//Rien à mettre dans cette méthode.
	}

	@Override
	public String getProprietaire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProprietaire(String nom) {
		// TODO Auto-generated method stub
		
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
