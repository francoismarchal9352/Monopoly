package be.ephec.monopoly.reseau;

import be.ephec.modele.*;
import be.ephec.network.*;
import be.ephec.interfaceGraphiqueMonopoly.*;

import javax.swing.JOptionPane;

public class Client implements Runnable{
	private String nom;

	public Client(){
		nom = JOptionPane.showInputDialog("Merci de saisir ton nom");	
	}

	public static void main(String[] args) {
		Client c1 = new Client();
		c1.run();
	}
	
	@Override
	public void run() {
		try {
			Monopoly frame = new Monopoly(nom);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

