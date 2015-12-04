package be.ephec.modele;

public class CarteChance extends Carte {
	
	public CarteChance(Partie partie, String texte, int methodeNum){
		super(partie, texte, methodeNum);
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
			case 9: {
				int somme = 0;
				somme += partie.getTabJoueurs().get(partie.getIndexJoueurCourant()).calculNbMaison()*25;
				somme += partie.getTabJoueurs().get(partie.getIndexJoueurCourant()).calculNbHotel()*100;
				partie.retraitSolde(somme,partie.getTabJoueurs().get(partie.getIndexJoueurCourant()));	
			} break;
			case 10: partie.allerA(11); break; // a gerer passage départ
			case 11: partie.allerA(15); break; // a gerer passage départ
			case 12: partie.ajoutSolde(150,partie.getTabJoueurs().get(partie.getIndexJoueurCourant())); break;
			case 13: partie.allerA(10); break;
			case 14: {
				int position = partie.getTabJoueurs().get(partie.getIndexJoueurCourant()).getPosition();
				partie.allerA(position-3);
				position+=-3;
				if(position<0){
					partie.getTabJoueurs().get(partie.getIndexJoueurCourant()).setPosition(position+40); 
				}
			} break; // a gerer passage départ pour les 200€
			case 15: partie.retraitSolde(20,partie.getTabJoueurs().get(partie.getIndexJoueurCourant()));break;
			case 16: partie.ajoutSolde(100,partie.getTabJoueurs().get(partie.getIndexJoueurCourant()));break;
		}
	}
}