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
	// Les m�thodes utiles
	public void traiteClientConnecte(ClientCoteServeur ccs){
		getGuiServeur().ajouteDansLaConsole(
				Console.getInviteDeCommande()+"On a re�u le joueur num�ro "+
				ccs.getNum()+"\n");
		getGuiServeur().ajouteClientJComboBox(ccs);
	}

	public void traiteObjetRecu(ClientCoteServeur ccs,Object object){
		Calendar cal = Calendar.getInstance();
		getGuiServeur().ajouteDansLaConsole(
				Console.getInviteDeCommande()+"> Joueur "+ 
				ccs.getNum()+" : "+object.toString()+"\n");
		switch((String)object){
			case "Lancer les d�s":
				serveurSocket.ecrirSurTousLesClients("Joueur "+ccs.getNum()+" lance les d�s.\n");
				partie.debutTour();
				break;
			case "Acheter":
				serveurSocket.ecrirSurTousLesClients("Joueur "+ccs.getNum()+" ach�te la case sur laquelle il se trouve.\n");
				partie.acheter();
				break;
			case "Vendre": // � impl�menter
				break;
			case "Demander Loyer": //� impl�menter
				break;
			case "Finir Tour":
				serveurSocket.ecrirSurTousLesClients("Joueur "+ccs.getNum()+" fini son tour.\n");
				partie.finTour();
				break;
		}
		serveurSocket.ecrirSurTousLesClients(partie);
	}

	public void traiteObjetAEnvoyer(ClientCoteServeur ccs,Object o){
		getServeurSocket().ecrireSurUnClient(ccs, o);
	}

	public void traiteObjetAEnvoyerATousLesClients(Object o){
		getServeurSocket().ecrirSurTousLesClients(o);
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


