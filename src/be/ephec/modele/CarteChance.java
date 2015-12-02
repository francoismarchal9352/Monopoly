package be.ephec.modele;

import java.util.ArrayList;

public class CarteChance extends Carte {
	private String texte;
	private int methodeNum;
	private Partie partie;
	
	public CarteChance(String texte, int methodeNum){
		this.partie = partie;
		this.texte = texte;
		this.methodeNum = methodeNum;
	}
	
	public void action(int methodeNum){
		switch (methodeNum) {
		case 1: partie.retraitSolde(10,partie.getTabJoueurs().get(partie.getIndexJoueurCourant())); break;
		case 2: partie.ajoutSolde(50,partie.getTabJoueurs().get(partie.getIndexJoueurCourant())); break;
		case 3: {
			int somme = 0;
			somme += partie.getTabJoueurs().get(partie.getIndexJoueurCourant()).calculNbMaison()*40;
			somme += partie.getTabJoueurs().get(partie.getIndexJoueurCourant()).calculNbHotel()*115;
			partie.retraitSolde(somme,partie.getTabJoueurs().get(partie.getIndexJoueurCourant()));	
		} break;
		case 4: partie.allerA(0); break; // a gerer passage départ
		case 5: partie.retraitSolde(150,partie.getTabJoueurs().get(partie.getIndexJoueurCourant())); break;
		case 6: partie.allerA(39); break; // a gerer passage départ
		case 7: partie.getTabJoueurs().get(partie.getIndexJoueurCourant()).setNbCarteSortezPrison(partie.getTabJoueurs().get(partie.getIndexJoueurCourant()).getNbCarteSortezPrison() + 1); break;
		case 8: partie.allerA(24); break; // a gerer passage départ
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			break;
		case 15:
			break;
		case 16:
			break;
		}
		
	
	}
}