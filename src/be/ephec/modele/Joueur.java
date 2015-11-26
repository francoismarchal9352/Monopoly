package be.ephec.modele;

import javax.swing.JOptionPane;

public class Joueur {
	private String nom;
	private int position;
	private int solde;
	private int nbTourPrison;
	
	public Joueur(String nom){
		this.nom = nom; // a faire
		this.position = 0;
		this.solde = 15000;
		this.nbTourPrison = 0;
		
			
	}
	
	public void acheter(Case x){
	
		// a faire
		
	}
	
	public void seDeplacer(int x){
		if(position + x >= 40){ position = (position + x) % 40;
		} else { position += x;}
	}
	
	public void allerA(int x){
		position = x;
	}
	
	public int getPosition(){
		return position;
	}
}