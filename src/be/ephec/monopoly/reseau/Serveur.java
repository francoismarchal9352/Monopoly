package be.ephec.monopoly.reseau;

import java.util.concurrent.TimeUnit;

import be.ephec.modele.Partie;

public class Serveur {
	

	public static void main(String[] args) {
		Serveur s1 = new Serveur();
		s1.run();
		
	}

	private void run() {
		Partie truc = new Partie();
		
		while(truc.getTabJoueurs().size()>1){
			truc.debutTour();
			System.out.println("");
			truc.finTour();
			System.out.println("Tour n°"+truc.getNbTour());
			try {
				TimeUnit.MILLISECONDS.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("La partie a duré "+truc.getNbTour()+" tours.");
		
	}

}
