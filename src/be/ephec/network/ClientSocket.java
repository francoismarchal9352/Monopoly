/**
 * @author Marchal François et Massart Florian
 * @version 1.0
 */

package be.ephec.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import be.ephec.application.ApplicationClient;
import be.ephec.modele.EtatPartie;
import be.ephec.modele.Partie;

public class ClientSocket extends Socket implements Runnable{
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private ApplicationClient appliClient;
	
	public ClientSocket(ApplicationClient appliClient) throws UnknownHostException, IOException{
		super(Param.IP_SERVEUR,Param.NUM_PORT_DE_BASE);
		this.appliClient = appliClient;
		methodeCommuneAuxConstructeurs();
	}
	public ClientSocket(String ip, int port,ApplicationClient appliClient) throws UnknownHostException, IOException{
		super(ip,port);
		this.appliClient = appliClient;
		methodeCommuneAuxConstructeurs();
	}
	public void methodeCommuneAuxConstructeurs(){
		try {
			oos = new ObjectOutputStream(this.getOutputStream());
			ois = new ObjectInputStream(this.getInputStream());
			appliClient.setNum((int)ois.readObject());
			appliClient.setTitle("Joueur "+appliClient.getNum());
			appliClient.getGuiClient().setLabelJoueur("Joueur "+appliClient.getNum());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	public void lireNonStop(){
		new Thread(this).start();
	}
	public void finalize(){
		try {
			this.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void ecrire(Object o){
		try {
			oos.writeObject(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void lire(){
		try {
			Object o = ois.readObject();
			appliClient.traiteObjetRecu(o);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			try {
				this.close(); 
				// si on ne sait pas lire c'est que le serveur est fermé
				//TODO Trouver une solution moins radicale
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
//		return null;
	}
	@Override
	public void run() {
		while (!this.isClosed()){
			lire();
		}
		
	}
}



