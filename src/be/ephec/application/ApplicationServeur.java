/**
 * @author Marchal François & Massart Florian
 * @version 1.0
 */

package be.ephec.application;

import java.util.Calendar;
import be.ephec.GUI.GuiServeur;
import be.ephec.modele.Partie;
import be.ephec.network.ClientCoteServeur;
import be.ephec.network.Console;
import be.ephec.network.ServeurSocket;

public class ApplicationServeur {
	private GuiServeur GuiServeur;
	private ServeurSocket serveurSocket;
	private Partie partie = new Partie(this);
	
	public ApplicationServeur(){
		GuiServeur = new GuiServeur(this);
	}
	public static void main(String[] args) {
		ApplicationServeur ma = new ApplicationServeur();
	}
	// Les méthodes utiles
	public void traiteClientConnecte(ClientCoteServeur ccs){
		getGuiServeur().ajouteDansLaConsole(
				Console.getInviteDeCommande()+"On a reçu le joueur numéro "+
				ccs.getNum()+"\n");
		getGuiServeur().ajouteClientJComboBox(ccs);
	}

	public void traiteObjetRecu(ClientCoteServeur ccs, Object object){
		Calendar cal = Calendar.getInstance();
		getGuiServeur().ajouteDansLaConsole(
				Console.getInviteDeCommande()+"> Joueur "+ 
				ccs.getNum()+" : "+object.toString()+"\n");
		switch((String)object){
			case "Lancer les dés":
				serveurSocket.ecrireSurTousLesClients("Joueur "+ccs.getNum()+" lance les dés.\n");
				partie.debutTour();
				break;
			case "Acheter":
				serveurSocket.ecrireSurTousLesClients("Joueur "+ccs.getNum()+" achète la case sur laquelle il se trouve.\n");
				partie.acheter();
				break;
			case "Vendre": // à implémenter
				break;
			case "Demander Loyer": //à implémenter
				break;
			case "Finir Tour":
				serveurSocket.ecrireSurTousLesClients("Joueur "+ccs.getNum()+" fini son tour.\n");
				partie.finTour();
				break;
		}
		partie.genereEtatPartie();
		serveurSocket.ecrireSurTousLesClients(partie.getEtatPartie());
	}

	public void traiteObjetAEnvoyer(ClientCoteServeur ccs,Object o){
		getServeurSocket().ecrireSurUnClient(ccs, o);
	}

	public void traiteObjetAEnvoyerATousLesClients(Object o){
		getServeurSocket().ecrireSurTousLesClients(o);
	}

	public void traiteClientDeconnecte(ClientCoteServeur ccs){
		getGuiServeur().supprimeClientJComboBox(ccs);
	}

	// Les getters et les setters
	public GuiServeur getGuiServeur() {
		return GuiServeur;
	}
	public void setGuiServeur(GuiServeur GuiServeur) {
		this.GuiServeur = GuiServeur;
	}
	public ServeurSocket getServeurSocket() {
		return serveurSocket;
	}
	public void setServeurSocket(ServeurSocket serveurSocket) {
		this.serveurSocket = serveurSocket;
	}
}


