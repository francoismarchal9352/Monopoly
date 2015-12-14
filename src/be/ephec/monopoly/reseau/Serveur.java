package be.ephec.monopoly.reseau;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import be.ephec.network.*;

public class Serveur extends ServerSocket implements Runnable {
	private ArrayList<Client> listeClients = new ArrayList<Client>();
	
	public Serveur() throws IOException {
		super(62900);
		System.out.println("le serveur est à l'écoute sur le port "+ this.getLocalPort());
		acceptePlusieurClients();
	}
	
	public void acceptePlusieurClients(){
		Thread t = new Thread(this);
		t.start();
		
	}
	
/*
	public static void main(String[] args) throws IOException {

		
	}
*/
	public void run() {
		while(!this.isClosed()){
			try {
				System.out.println("on attend un client...");
				this.listeClients.add(new Client(this.accept()));
				
				System.out.println("on a reçu un client...");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*
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
		*/
	}
}
