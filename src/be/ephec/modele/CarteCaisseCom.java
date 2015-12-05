package be.ephec.modele;

public class CarteCaisseCom extends Carte {
	
	public CarteCaisseCom(Partie partie, String texte, int methodeNum){
		super(partie, texte, methodeNum);
	}
	
	public void action(int methodeNum){// Ferai ce w-e
		switch (methodeNum) {
			case 1: partie.retraitSolde(150,partie.getTabJoueurs().get(partie.getIndexJoueurCourant())); break;		
			case 2: partie.retraitSolde(150,partie.getTabJoueurs().get(partie.getIndexJoueurCourant())); break;	
			case 3: partie.ajoutSolde(50,partie.getTabJoueurs().get(partie.getIndexJoueurCourant())); break;
			case 4: partie.allerA(10); break; // si case depart, pas 200€ 
			case 5: partie.allerA(1); break;
			case 6: partie.ajoutSolde(250,partie.getTabJoueurs().get(partie.getIndexJoueurCourant())); break;
			case 7: partie.retraitSolde(100,partie.getTabJoueurs().get(partie.getIndexJoueurCourant())); break;
			case 8: // 10 € de chaque joueur
				break;
			case 9: partie.ajoutSolde(100,partie.getTabJoueurs().get(partie.getIndexJoueurCourant())); break;
			case 10: partie.ajoutSolde(100,partie.getTabJoueurs().get(partie.getIndexJoueurCourant())); break;
			case 11: partie.ajoutSolde(50,partie.getTabJoueurs().get(partie.getIndexJoueurCourant())); break;
			case 12: partie.retraitSolde(10,partie.getTabJoueurs().get(partie.getIndexJoueurCourant())); break; // ou tire carte chance
			case 13: partie.getTabJoueurs().get(partie.getIndexJoueurCourant()).setNbCarteSortezPrison(partie.getTabJoueurs().get(partie.getIndexJoueurCourant()).getNbCarteSortezPrison() + 1); break;
			case 14: partie.ajoutSolde(20,partie.getTabJoueurs().get(partie.getIndexJoueurCourant())); break;
			case 15: partie.ajoutSolde(10,partie.getTabJoueurs().get(partie.getIndexJoueurCourant())); break;
			case 16: partie.allerA(0); break;
		}
	}
}