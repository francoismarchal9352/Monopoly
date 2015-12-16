package be.ephec.application;

import be.ephec.network.ClientSocket;
import be.ephec.network.Console;
import be.ephec.GUI.GuiClient;
import be.ephec.modele.Partie;

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
	
	
	
	
	
	// Les méthodes utiles
	public void traiteConnexionRéussieAuServeur(){
		guiClient.ajouteDansLaConsole(Console.getInviteDeCommande()+
				"Le joueur est connecté au serveur\n");
	}
	
	public void traiteObjetRecu(Object partieMonopoly){
		Partie partie = (Partie) partieMonopoly;
		guiClient.setLabelValD1(Integer.toString(partie.getPlateau().getDe1().getValeur()));
		guiClient.setLabelValD2(Integer.toString(partie.getPlateau().getDe2().getValeur()));
		guiClient.setLabelSoldeJ1(Integer.toString(partie.getTabJoueurs().get(0).getSolde()));
		guiClient.setLabelSoldeJ2(Integer.toString(partie.getTabJoueurs().get(1).getSolde()));
		guiClient.setLabelPositionJ1(Integer.toString(partie.getTabJoueurs().get(0).getPosition()));
		guiClient.setLabelPositionJ2(Integer.toString(partie.getTabJoueurs().get(1).getPosition()));
		guiClient.setLabelNbCartePrison(Integer.toString(partie.getTabJoueurs().get(num-1).getNbCarteSortezPrison()));
		guiClient.setLabelNbTourPrison(Integer.toString(partie.getTabJoueurs().get(num-1).getNbTourPrison()));
		guiClient.setLabelNbTourSuite(Integer.toString(partie.getTabJoueurs().get(num-1).getNbTourSuite()));
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

	public void envoiCommande(String actionCommand) {
		socket.ecrire(actionCommand);		
	}	
}

