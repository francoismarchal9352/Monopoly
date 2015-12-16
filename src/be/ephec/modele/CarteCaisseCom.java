package be.ephec.modele;

import java.io.Serializable;

public class CarteCaisseCom extends Carte implements Serializable{
	
	public CarteCaisseCom(Partie partie, String texte, int methodeNum){
		super(partie, texte, methodeNum);
	}
	
	public void action(int methodeNum){
		switch (methodeNum) { //peut mieux faire en stackant les fonctions similaires mais pas urgent.
			case 1: partie.retraitSolde(50,partie.getJoueurCourant()); break;
			case 2: partie.retraitSolde(50,partie.getJoueurCourant()); break;
			case 3: partie.ajoutSolde(200,partie.getJoueurCourant()); break;
			case 4: partie.getJoueurCourant().entreEnPrison(); break;
			case 5: partie.allerA(1); break;
			case 6: partie.ajoutSolde(50,partie.getJoueurCourant()); break;
			case 7: partie.retraitSolde(100,partie.getJoueurCourant()); break;
			case 8: anniversaire();	break;
			case 9: partie.ajoutSolde(100,partie.getJoueurCourant()); break;
			case 10: partie.ajoutSolde(100,partie.getJoueurCourant()); break;
			case 11: partie.ajoutSolde(50,partie.getJoueurCourant()); break;
			case 12: partie.retraitSolde(10,partie.getJoueurCourant()); break;
			case 13: partie.getJoueurCourant().setNbCarteSortezPrison(partie.getJoueurCourant().getNbCarteSortezPrison() + 1); break;
			case 14: partie.ajoutSolde(20,partie.getJoueurCourant()); break;
			case 15: partie.ajoutSolde(10,partie.getJoueurCourant()); break;
			case 16: partie.allerA(0); break;
		}
	}
	
	private void anniversaire(){ //M�thode bug si un joueur � 0� euro.
		int somme = 0;
		for(Joueur J : partie.getTabJoueurs()){
			if(!(J.equals(partie.getJoueurCourant()))){
				partie.retraitSolde(10, J);
				somme+=10;
			}
		}
		partie.ajoutSolde(somme, partie.getJoueurCourant());
	}
}