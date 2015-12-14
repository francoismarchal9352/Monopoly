package be.ephec.network;
import javax.swing.JOptionPane;


import be.ephec.network.ClientSocket;
import be.ephec.GUI.GuiClient;

public class ApplicationClient {
	private GuiClient GuiClient;
	private ClientSocket socket;
	private int num;
	private String nom;
	private static int nbClients = 0;
	public ApplicationClient(){
		this.nom = JOptionPane.showInputDialog("Merci de saisir ton nom");	
		GuiClient = new GuiClient(nom);
		nbClients++;
	}

	public static void main(String[] args) {
		ApplicationClient appliClient = new ApplicationClient();
	}
	
	// Les méthodes utiles
	public void traiteConnexionRéussieAuServeur(){
		GuiClient.ajouteDansLaConsole(Console.getInviteDeCommande()+
				"Le client est connecté au serveur\n");
	}
	
	public void traiteObjetRecu(Object o){
		GuiClient.ajouteDansLaConsole(Console.getInviteDeCommande()+o.toString()+"\n");
	}
	
	public void setTitle(String s){
		GuiClient.setTitle(s);
	}
	
	public void traiteObjetAEnvoyer(Object o){
		socket.ecrire(o);
	}
	
	// Les getters et les setters
	public GuiClient getGuiClient() {
		return GuiClient;
	}
	public void setGuiClient(GuiClient GuiClient) {
		this.GuiClient = GuiClient;
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

