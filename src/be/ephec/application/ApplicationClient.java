package be.ephec.application;

import be.ephec.network.ClientSocket;
import be.ephec.network.Console;
import be.ephec.GUI.GuiClient;

public class ApplicationClient{
	private GuiClient guiClient;
	private ClientSocket socket;
	private int num;
	private static int nbClients = 0;
	public ApplicationClient(){
		guiClient = new GuiClient(this);
		nbClients++;
	}

	public static void main(String[] args) {
		ApplicationClient appliClient = new ApplicationClient();
	}
	
	
	
	
	
	// Les m�thodes utiles
	public void traiteConnexionR�ussieAuServeur(){
		guiClient.ajouteDansLaConsole(Console.getInviteDeCommande()+
				"Le joueur est connect� au serveur\n");
	}
	
	public void traiteObjetRecu(Object o){
		guiClient.ajouteDansLaConsole(Console.getInviteDeCommande()+o.toString()+"\n");
	}

	public void setTitle(String s){
		guiClient.setTitle(s);
	}
	
	public void traiteObjetAEnvoyer(Object o){
		socket.ecrire(o);
	}
	
	// Les getters et les setters
	public GuiClient getGuiClient() {
		return guiClient;
	}
	public void setGuiClient(GuiClient GuiClient) {
		this.guiClient = GuiClient;
	}

	public ClientSocket getSocket() {
		return socket;
	}

	public void setSocket(ClientSocket socket) {
		this.socket = socket;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	public static int getNbClients() {
		return nbClients;
	}
	public static void setNbClients(int nbClients) {
		ApplicationClient.nbClients = nbClients;
	}	
}

