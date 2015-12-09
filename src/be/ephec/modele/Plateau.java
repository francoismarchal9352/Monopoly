package be.ephec.modele;

import java.util.ArrayList;
import java.util.Collections;

public class Plateau {
	private Partie partie;
	private Case[] tabCases = new Case[40];
	private ArrayList<Carte> tabCartesChance = new ArrayList<>(0);
	private ArrayList<Carte> tabCartesCaisseCom = new ArrayList<>(0);
	private De de1;
	private De de2;
	
	public Plateau(Partie partie){
		this.partie = partie;
		initCases();
		initCartes();
		initDes();
		Collections.shuffle(tabCartesChance);
		Collections.shuffle(tabCartesCaisseCom);
	}
	
	
	public void initCases(){
		tabCases[0] = new Depart(partie);
		tabCases[1] = new Propriete(partie,"Boulevard de Belleville", "Brun", 60, 50, 2, 10, 30, 90, 160, 250);
		tabCases[2] = new CaseCaisseCom(partie);
		tabCases[3] = new Propriete(partie,"Rue Lecourbe", "Brun", 60, 50, 4, 20, 60, 180, 320, 450);
		tabCases[4] = new Taxe(partie,"Imp�ts sur le revenu");
		tabCases[5] = new Gare(partie,"Gare Montparnasse");
		tabCases[6] = new Propriete(partie,"Rue Vaugirard", "Bleu clair", 100, 50, 6, 30, 90, 270, 400, 550);
		tabCases[7] = new CaseChance(partie);
		tabCases[8] = new Propriete(partie,"Rue de Courcelles", "Bleu clair", 100, 50, 6, 30, 90, 270, 400, 550);
		tabCases[9] = new Propriete(partie,"Avenue de la R�publique", "Bleu clair", 120, 50, 8, 40, 100, 300, 450, 600);
		tabCases[10] = new Prison(partie);
		tabCases[11] = new Propriete(partie,"Boulevard de la Vilette", "Rose", 140, 100, 10, 50, 150, 450, 625, 750);
		tabCases[12] = new Service(partie,"Compagnie de Distribution d'�lectricit�");
		tabCases[13] = new Propriete(partie,"Avenue de Neuilly", "Rose", 140, 100, 10, 50, 150, 450, 625, 750);
		tabCases[14] = new Propriete(partie,"Rue de Paradis", "Rose", 160, 100, 12, 60, 180, 500, 700, 900);
		tabCases[15] = new Gare(partie,"Gare de Lyon");
		tabCases[16] = new Propriete(partie,"Avenue Mozart", "Orange", 180, 100, 14, 70, 200, 550, 750, 950);
		tabCases[17] = new CaseCaisseCom(partie);
		tabCases[18] = new Propriete(partie,"Boulevard Saint-Michel", "Orange", 180, 100, 14, 70, 200, 550, 750, 950);
		tabCases[19] = new Propriete(partie,"Place Pigalle", "Orange", 200, 100, 16, 80, 220, 600, 800, 1000);
		tabCases[20] = new ParcGratuit(partie);
		tabCases[21] = new Propriete(partie,"Avenue Matignon", "Rouge", 220, 150, 18, 90, 250, 700, 875, 1050);
		tabCases[22] = new CaseChance(partie);
		tabCases[23] = new Propriete(partie,"Boulevard Malesherbes", "Rouge", 220, 150, 18, 90, 250, 700, 875, 1050);
		tabCases[24] = new Propriete(partie,"Avenue Henri-Martin", "Rouge", 240, 150, 20, 100, 300, 750, 925, 1100);
		tabCases[25] = new Gare(partie,"Garde du Nord");
		tabCases[26] = new Propriete(partie,"Faubourg Seint-Honor�", "Jaune", 260, 150, 22, 110, 330, 800, 750, 1150);
		tabCases[27] = new Propriete(partie,"Place de la Bourse", "Jaune", 260, 150, 22, 110, 330, 800, 750, 1150);
		tabCases[28] = new Service(partie,"Compagnie de Distribution des Eaux");
		tabCases[29] = new Propriete(partie,"Rue la Fayette", "Jaune", 280, 150, 24, 120, 360, 850, 1025, 1200);
		tabCases[30] = new AllerPrison(partie);
		tabCases[31] = new Propriete(partie,"Avenue du Breteuil", "Vert", 300, 200, 26, 130, 390, 900, 1100, 1275);
		tabCases[32] = new Propriete(partie,"Avenue Foch", "Vert", 300, 200, 26, 130, 390, 900, 1100, 1275);
		tabCases[33] = new CaseCaisseCom(partie);
		tabCases[34] = new Propriete(partie,"Boulevard des Capucines", "Vert", 320, 200, 28, 150, 450, 1000, 1200, 1400);
		tabCases[35] = new Gare(partie,"Gare Seint-Lazare");
		tabCases[36] = new CaseChance(partie);
		tabCases[37] = new Propriete(partie,"Avenue des Champs-�lys�es", "Bleu fonc�", 350, 200, 35, 175, 500, 1100, 1300, 1500);
		tabCases[38] = new Taxe(partie,"Taxe de luxe");
		tabCases[39] = new Propriete(partie,"Rue de la Paix", "Bleu fonc�", 400, 200, 50, 200, 600, 1400, 1700, 2000);
	}
	public void initCartes(){
		tabCartesChance.add(new CarteChance(partie,"Amende pour exc�s de vitesse.",1));
		tabCartesChance.add(new CarteChance(partie,"La banque vous verse un dividende de 50�.",2));
		tabCartesChance.add(new CarteChance(partie,"Vous �tes impos� pour les restaurations de voirie.\n40� par maison et 115� par h�tel.",3));
		tabCartesChance.add(new CarteChance(partie,"Avancez jusqu'� la case d�part.",4));
		tabCartesChance.add(new CarteChance(partie,"Payez pour les frais de scolarit� 150�",5));
		tabCartesChance.add(new CarteChance(partie,"Avancez jusqu'� la Rue de la Paix.",6)); //Ne passe forc�ment pas par la case D�part.
		tabCartesChance.add(new CarteChance(partie,"Sortez de prison. Vous gardez cette carte jusqu'� ce qu'elle vous serve ou que vous la vendiez.",7));
		tabCartesChance.add(new CarteChance(partie,"Avancez jusqu'� l'Avenue Henri-Martin.\nSi vous passez par la case D�part, touchez 200�.",8));
		tabCartesChance.add(new CarteChance(partie,"Faites des r�parations dans toutes vos propri�t�s.\n25� par maison et 100� par h�tel.",9));
		tabCartesChance.add(new CarteChance(partie,"Avancez jusqu'au Boulevard de la Vilette.\nSi vous passez par la case D�part, touchez 200�.",10));
		tabCartesChance.add(new CarteChance(partie,"Avancez jusqu'� la Garde de Lyon.\nSi vous passez par la case D�part, touchez 200�.",11));
		tabCartesChance.add(new CarteChance(partie,"Votre immeuble et votre pr�t rapportent 150�.",12));
		tabCartesChance.add(new CarteChance(partie,"Allez en Prison. Ne franchissez pas la case D�part, ne touchez pas 200�.",13));
		tabCartesChance.add(new CarteChance(partie,"Reculez de 3 cases.",14));
		tabCartesChance.add(new CarteChance(partie,"Amende pour ivresse.",15));
		tabCartesChance.add(new CarteChance(partie,"Vous avez gagn� le prix de mots crois�s",16));
		
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Payez votre police d'assurance s'�levant � 50�.",1));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Payez la note du m�decin.\n50�",2));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Erreur de la banque en votre faveur.\nRecevez 200�.",3));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Allez en prison. Ne passez pas par la case D�part et ne touchez pas 200�.",4));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Avancez jusqu'au Boulevard de Belleville.",5)); // Passe forc�ment par la case D�part.
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Recevez votre int�r�t sur l'emprunt � 7%.\n250�",6));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Payez � l'h�tpital 100�.",7));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"C'est votre anniversaire.\nChaque joueur doit vous donner 10�.",8));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Vous recevez votre revenu annuel: 100�.",9));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Vous h�ritez 100�.",10));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"La vente de votre stock vous rapporte 50�.",11));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Payez une amende de 10� pour stationnement interdit.",12));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Sortez de prison. Vous gardez cette carte jusqu'� ce qu'elle vous serve ou que vous la vendiez.",13));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Les contributions vous remboursent la somme de 20�.",14));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Vous avez gagn� le deuxi�me prix de beaut�, vous touchez 10�.",15));
		tabCartesChance.add(new CarteCaisseCom(partie,"Avancez jusqu'� la case d�part.",16));
	}
	
	private void initDes() {
		de1 = new De();
		de2 = new De();
	}

	public Case[] getTabCases() {
		return tabCases;
	}
	
	public void lancerDes(){
		de1.lancerDe();
		de2.lancerDe();
	}
	
	public De getDe1(){
		return de1;
	}
	
	public De getDe2(){
		return de2;
	}
	
	public int getSommeDes(){
		return de1.getValeur() + de2.getValeur();
	}
		
	public Carte getCarte(String typeCarte, int numCarte){
		if(typeCarte=="Chance")
			return tabCartesChance.get(numCarte);
		return tabCartesCaisseCom.get(numCarte);
	}
}