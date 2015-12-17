/**
 * @author Marchal François et Massart Florian
 * @version 1.0
 */

package be.ephec.application;

import be.ephec.network.ClientSocket;
import be.ephec.network.Console;
import be.ephec.GUI.GuiClient;
import be.ephec.modele.EtatPartie;

public class ApplicationClient{
	private GuiClient guiClient;
	private ClientSocket socket;
	private int num;
	private static int nbClients = 0;
	private EtatPartie etatPartie;
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
	
	public void traiteObjetRecu(Object object){ // Reçoit soit la Partie soit un String à afficher dans la console.
		if(object instanceof EtatPartie){ // Si l'objet est un EtatPartie...
			etatPartie = (EtatPartie) object; // Stockage de l'objet pour faire des appels plus simples.
			guiClient.setLabelValD1(etatPartie.getValeurDe1()); // Actualisation des infos relatives à la partie dans la GUI Client...
			guiClient.setLabelValD2(etatPartie.getValeurDe2());
			guiClient.setLabelValSoldeJ1(etatPartie.getSoldeJ1());
			guiClient.setLabelValSoldeJ2(etatPartie.getSoldeJ2());
			guiClient.setLabelValPositionJ1(etatPartie.getPositionJ1());
			guiClient.setLabelValPositionJ2(etatPartie.getPositionJ2());
			if(num==1){ //Si cette appli Client est la n°1...
				guiClient.setLabelNbCartePrison(etatPartie.getNbCarteSortezPrisonJ1()); //... affiche les infos relatives au joueur 1.
				guiClient.setLabelNbTourPrison(etatPartie.getNbTourPrisonJ1());
				guiClient.setLabelNbTourSuite(etatPartie.getNbTourSuiteJ1());
			}
			else{ // Sinon, c'est la n°2...
				guiClient.setLabelNbCartePrison(etatPartie.getNbCarteSortezPrisonJ2()); // affiche les infos relatives au joueur 2.
				guiClient.setLabelNbTourPrison(etatPartie.getNbTourPrisonJ2());
				guiClient.setLabelNbTourSuite(etatPartie.getNbTourSuiteJ2());
			}
			if(((Integer.parseInt(etatPartie.getNbTour()))+1) %2 == num%2) //Si c'est le tour du joueur...
				guiClient.setButtonLancerDes(true);	// ...le bouton devient cliquable.
			else
				guiClient.setButtonLancerDes(false); // Sinon, ce n'est pas son tour, il ne peut donc pas lancer les dés et attend son tour, grâce à l'actualisation de la GUI.				
		}
		else if(object instanceof String){ //Sinon, l'objet est forcément un String à afficher dans la console.
			guiClient.ajouteDansLaConsole(Console.getInviteDeCommande()+(String) object);
		}
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