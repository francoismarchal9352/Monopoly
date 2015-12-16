package be.ephec.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Plateau implements Serializable{
	private Partie partie;
	private Case[] tabCases = new Case[40];
	private ArrayList<Carte> tabCartesChance = new ArrayList<>(16);
	private ArrayList<Carte> tabCartesCaisseCom = new ArrayList<>(16);
	private De de1;
	private De de2;
	
	public Plateau(Partie partie){
		this.partie = partie;
		initCases();
		initCartes();
		initDes();
		Collections.shuffle(tabCartesChance); //On mélange les cartes.
		Collections.shuffle(tabCartesCaisseCom);
	}
	
	
	public void initCases(){
		tabCases[0] = new Depart(partie);
		tabCases[1] = new Propriete(partie,"Boulevard de Belleville", "Brun", 60, 50, 2, 10, 30, 90, 160, 250);
		tabCases[2] = new CaseCaisseCom(partie);
		tabCases[3] = new Propriete(partie,"Rue Lecourbe", "Brun", 60, 50, 4, 20, 60, 180, 320, 450);
		tabCases[4] = new Taxe(partie,"Impôts sur le revenu");
		tabCases[5] = new Gare(partie,"Gare Montparnasse");
		tabCases[6] = new Propriete(partie,"Rue Vaugirard", "Bleu clair", 100, 50, 6, 30, 90, 270, 400, 550);
		tabCases[7] = new CaseChance(partie);
		tabCases[8] = new Propriete(partie,"Rue de Courcelles", "Bleu clair", 100, 50, 6, 30, 90, 270, 400, 550);
		tabCases[9] = new Propriete(partie,"Avenue de la République", "Bleu clair", 120, 50, 8, 40, 100, 300, 450, 600);
		tabCases[10] = new Prison(partie);
		tabCases[11] = new Propriete(partie,"Boulevard de la Vilette", "Rose", 140, 100, 10, 50, 150, 450, 625, 750);
		tabCases[12] = new Service(partie,"Compagnie de Distribution d'Électricité");
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
		tabCases[26] = new Propriete(partie,"Faubourg Saint-Honoré", "Jaune", 260, 150, 22, 110, 330, 800, 750, 1150);
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
		tabCases[37] = new Propriete(partie,"Avenue des Champs-Élysées", "Bleu foncé", 350, 200, 35, 175, 500, 1100, 1300, 1500);
		tabCases[38] = new Taxe(partie,"Taxe de luxe");
		tabCases[39] = new Propriete(partie,"Rue de la Paix", "Bleu foncé", 400, 200, 50, 200, 600, 1400, 1700, 2000);
	}
	public void initCartes(){
		tabCartesChance.add(new CarteChance(partie,"Amende pour excès de vitesse: 10 euros€.",1));
		tabCartesChance.add(new CarteChance(partie,"La banque vous verse un dividende de 50 euros€.",2));
		tabCartesChance.add(new CarteChance(partie,"Vous êtes imposé pour les restaurations de voirie.\n40€ euros par maison et 115€ euros par hôtel.",3));
		tabCartesChance.add(new CarteChance(partie,"Avancez jusqu'à la case départ.",4));
		tabCartesChance.add(new CarteChance(partie,"Payez pour les frais de scolarité 150 euros€.",5));
		tabCartesChance.add(new CarteChance(partie,"Avancez jusqu'à la Rue de la Paix.",6)); //Ne passe forcément pas par la case Départ.
		tabCartesChance.add(new CarteChance(partie,"Sortez de prison.\nVous gardez cette carte jusqu'à ce qu'elle vous serve ou que vous la vendiez.",7));
		tabCartesChance.add(new CarteChance(partie,"Avancez jusqu'à l'Avenue Henri-Martin.\nSi vous passez par la case Départ, touchez 200 euros€.",8));
		tabCartesChance.add(new CarteChance(partie,"Faites des réparations dans toutes vos propriétés.\n25€ euros par maison et 100 euros€ par hôtel.",9));
		tabCartesChance.add(new CarteChance(partie,"Avancez jusqu'au Boulevard de la Vilette.\nSi vous passez par la case Départ, touchez 200 euros€.",10));
		tabCartesChance.add(new CarteChance(partie,"Avancez jusqu'à la Garde de Lyon.\nSi vous passez par la case Départ, touchez 200 euros€.",11));
		tabCartesChance.add(new CarteChance(partie,"Votre immeuble et votre prêt rapportent 150€ euros.",12));
		tabCartesChance.add(new CarteChance(partie,"Allez en Prison. Ne franchissez pas la case Départ, ne touchez pas 200€ euros.",13));
		tabCartesChance.add(new CarteChance(partie,"Reculez de 3 cases.",14));
		tabCartesChance.add(new CarteChance(partie,"Amende pour ivresse: 20€ euros.",15));
		tabCartesChance.add(new CarteChance(partie,"Vous avez gagné le prix de mots croisés: 100€.",16));
		
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Payez votre police d'assurance s'élevant à 50€ euros.",1));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Payez la note du médecin: 50 euros€.",2));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Erreur de la banque en votre faveur. Recevez 200€ euros.",3));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Allez en prison. Ne passez pas par la case Départ et ne touchez pas 200 euros€.",4));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Avancez jusqu'au Boulevard de Belleville.",5)); // Passe forcément par la case Départ.
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Recevez votre intérêt sur l'emprunt à 7%: 250 euros.",6));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Payez à l'hôtpital 100€ euros.",7));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"C'est votre anniversaire, chaque joueur doit vous donner 10 euros€.",8));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Vous recevez votre revenu annuel: 100€ euros.",9));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Vous héritez 100€ euros.",10));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"La vente de votre stock vous rapporte 50€ euros.",11));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Payez une amende de 10€ euros pour stationnement interdit.",12));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Sortez de prison.\nVous gardez cette carte jusqu'à ce qu'elle vous serve ou que vous la vendiez.",13));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Les contributions vous remboursent la somme de 20€ euros.",14));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Vous avez gagné le deuxième prix de beauté, vous touchez 10 euros€.",15));
		tabCartesCaisseCom.add(new CarteCaisseCom(partie,"Avancez jusqu'à la case départ.",16));
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
		if(typeCarte.compareToIgnoreCase("Chance")==0)
			return tabCartesChance.get(numCarte);
		return tabCartesCaisseCom.get(numCarte);
	}
}