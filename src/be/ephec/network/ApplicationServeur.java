package be.ephec.network;

import java.util.Calendar;
import be.ephec.GUI.GuiServeur;
import be.ephec.network.ClientCoteServeur;
import be.ephec.network.ServeurSocket;

public class ApplicationServeur {
	private GuiServeur GuiServeur;
	private ServeurSocket serveurSocket;
	public ApplicationServeur(){
		GuiServeur = new GuiServeur(this);
	}
	public static void main(String[] args) {
		ApplicationServeur ma = new ApplicationServeur();
	}
	// Les méthodes utiles
	public void traiteClientConnecte(ClientCoteServeur ccs){
		getGuiServeur().ajouteDansLaConsole(
				Console.getInviteDeCommande()+"On a reçu le client numéro "+
				ccs.getNum()+"\n");
		getGuiServeur().ajouteClientJComboBox(ccs);
	}

	public void traiteObjetRecu(ClientCoteServeur ccs,Object object){
		Calendar cal = Calendar.getInstance();
		getGuiServeur().ajouteDansLaConsole(
				Console.getInviteDeCommande()+"> Reçu du client "+ 
				ccs.getNum()+" : "+object.toString()+"\n");
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

	// Les getteurs et les setteurs
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


