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
	private Partie partie;
	private String messageConsole;
	
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
	
	public void traiteObjetRecu(Object object){
//		if(object.getClass().equals(partie.getClass())){ //à vérifier
			partie = (Partie) object;
			guiClient.setLabelValD1(Integer.toString(partie.getPlateau().getDe1().getValeur()));
			guiClient.setLabelValD2(Integer.toString(partie.getPlateau().getDe2().getValeur()));
			guiClient.setLabelValSoldeJ1(Integer.toString(partie.getTabJoueurs().get(0).getSolde()));
			guiClient.setLabelValSoldeJ2(Integer.toString(partie.getTabJoueurs().get(1).getSolde()));
			guiClient.setLabelValPositionJ1(Integer.toString(partie.getTabJoueurs().get(0).getPosition()));
			guiClient.setLabelValPositionJ2(Integer.toString(partie.getTabJoueurs().get(1).getPosition()));
			guiClient.setLabelNbCartePrison(Integer.toString(partie.getTabJoueurs().get(num-1).getNbCarteSortezPrison()));
			guiClient.setLabelNbTourPrison(Integer.toString(partie.getTabJoueurs().get(num-1).getNbTourPrison()));
			guiClient.setLabelNbTourSuite(Integer.toString(partie.getTabJoueurs().get(num-1).getNbTourSuite()));
			System.out.println("C'est le tour de "+partie.getJoueurCourant().getNum());
			System.out.println("Tour numéro "+partie.getNbTour());
			if(partie.getJoueurCourant().getNum()==num)
				guiClient.setButtonLancerDes(true);
			else
				guiClient.setButtonLancerDes(false);
		}
/*		else if(object.getClass().equals(messageConsole.getClass())){
			messageConsole = (String)object;
			guiClient.ajouteDansLaConsole(messageConsole);
		}
	}
*/
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