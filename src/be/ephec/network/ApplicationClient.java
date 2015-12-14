package be.ephec.network;
import javax.swing.JOptionPane;

import be.ephec.interfaceGraphiqueMonopoly.*;

public class ApplicationClient {
	private GuiMonopoly interfaceGraphiqueClient;
	private ClientSocket socket;
	private int num;
	private String nom;
	private static int nbClients = 0;
	public ApplicationClient(){
		this.nom = JOptionPane.showInputDialog("Merci de saisir ton nom");	
		interfaceGraphiqueClient = new GuiMonopoly(nom);
		nbClients++;
	}

	public static void main(String[] args) {
		ApplicationClient appliClient = new ApplicationClient();
	}
	/*
	// Les méthodes utiles
	public void traiteConnexionRéussieAuServeur(){
		interfaceGraphiqueClient.ajouteDansLaConsole(Console.getInviteDeCommande()+
				"Le client est connecté au serveur\n");
	}
	
	public void traiteObjetRecu(Object o){
		interfaceGraphiqueClient.ajouteDansLaConsole(Console.getInviteDeCommande()+o.toString()+"\n");
	}
	*/
	public void setTitle(String s){
		interfaceGraphiqueClient.setTitle(s);
	}
	
	public void traiteObjetAEnvoyer(Object o){
		socket.ecrire(o);
	}
	
	// Les getters et les setters
	public GuiMonopoly getInterfaceGraphiqueClient() {
		return interfaceGraphiqueClient;
	}
	public void setInterfaceGraphiqueClient(GuiMonopoly interfaceGraphiqueClient) {
		this.interfaceGraphiqueClient = interfaceGraphiqueClient;
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

