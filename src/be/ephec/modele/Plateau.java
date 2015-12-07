package be.ephec.modele;

public class Plateau {
	private Partie partie;
	private Case[] tabCases = new Case[40];
	private Carte[] tabCartesChance = new Carte[16];
	private Carte[] tabCartesCaisseCom = new Carte[16];
	private De de1;
	private De de2;
	
	public Plateau(Partie partie){
		this.partie = partie;
		initCases();
		initCartes();
		initDes();
	}
	
	
	public void initCases(){
		this.tabCases[0] = new Depart(partie);
		this.tabCases[1] = new Propriete(partie,"Boulevard de Belleville", "Brun", 60, 50, 2, 10, 30, 90, 160, 250);
		this.tabCases[2] = new CaseCaisseCom(partie);
		this.tabCases[3] = new Propriete(partie,"Rue Lecourbe", "Brun", 60, 50, 4, 20, 60, 180, 320, 450);
		this.tabCases[4] = new Taxe(partie,"Imp�ts sur le revenu");
		this.tabCases[5] = new Gare(partie,"Gare Montparnasse");
		this.tabCases[6] = new Propriete(partie,"Rue Vaugirard", "Bleu clair", 100, 50, 6, 30, 90, 270, 400, 550);
		this.tabCases[7] = new CaseChance(partie);
		this.tabCases[8] = new Propriete(partie,"Rue de Courcelles", "Bleu clair", 100, 50, 6, 30, 90, 270, 400, 550);
		this.tabCases[9] = new Propriete(partie,"Avenue de la R�publique", "Bleu clair", 120, 50, 8, 40, 100, 300, 450, 600);
		this.tabCases[10] = new Prison(partie);
		this.tabCases[11] = new Propriete(partie,"Boulevard de la Vilette", "Rose", 140, 100, 10, 50, 150, 450, 625, 750);
		this.tabCases[12] = new Service(partie,"Compagnie de Distribution d'�lectricit�");
		this.tabCases[13] = new Propriete(partie,"Avenue de Neuilly", "Rose", 140, 100, 10, 50, 150, 450, 625, 750);
		this.tabCases[14] = new Propriete(partie,"Rue de Paradis", "Rose", 160, 100, 12, 60, 180, 500, 700, 900);
		this.tabCases[15] = new Gare(partie,"Gare de Lyon");
		this.tabCases[16] = new Propriete(partie,"Avenue Mozart", "Orange", 180, 100, 14, 70, 200, 550, 750, 950);
		this.tabCases[17] = new CaseCaisseCom(partie);
		this.tabCases[18] = new Propriete(partie,"Boulevard Saint-Michel", "Orange", 180, 100, 14, 70, 200, 550, 750, 950);
		this.tabCases[19] = new Propriete(partie,"Place Pigalle", "Orange", 200, 100, 16, 80, 220, 600, 800, 1000);
		this.tabCases[20] = new ParcGratuit(partie);
		this.tabCases[21] = new Propriete(partie,"Avenue Matignon", "Rouge", 220, 150, 18, 90, 250, 700, 875, 1050);
		this.tabCases[22] = new CaseChance(partie);
		this.tabCases[23] = new Propriete(partie,"Boulevard Malesherbes", "Rouge", 220, 150, 18, 90, 250, 700, 875, 1050);
		this.tabCases[24] = new Propriete(partie,"Avenue Henri-Martin", "Rouge", 240, 150, 20, 100, 300, 750, 925, 1100);
		this.tabCases[25] = new Gare(partie,"Garde du Nord");
		this.tabCases[26] = new Propriete(partie,"Faubourg Seint-Honor�", "Jaune", 260, 150, 22, 110, 330, 800, 750, 1150);
		this.tabCases[27] = new Propriete(partie,"Place de la Bourse", "Jaune", 260, 150, 22, 110, 330, 800, 750, 1150);
		this.tabCases[28] = new Service(partie,"Compagnie de Distribution des Eaux");
		this.tabCases[29] = new Propriete(partie,"Rue la Fayette", "Jaune", 280, 150, 24, 120, 360, 850, 1025, 1200);
		this.tabCases[30] = new AllerPrison(partie);
		this.tabCases[31] = new Propriete(partie,"Avenue du Breteuil", "Vert", 300, 200, 26, 130, 390, 900, 1100, 1275);
		this.tabCases[32] = new Propriete(partie,"Avenue Foch", "Vert", 300, 200, 26, 130, 390, 900, 1100, 1275);
		this.tabCases[33] = new CaseCaisseCom(partie);
		this.tabCases[34] = new Propriete(partie,"Boulevard des Capucines", "Vert", 320, 200, 28, 150, 450, 1000, 1200, 1400);
		this.tabCases[35] = new Gare(partie,"Gare Seint-Lazare");
		this.tabCases[36] = new CaseChance(partie);
		this.tabCases[37] = new Propriete(partie,"Avenue des Champs-�lys�es", "Bleu fonc�", 350, 200, 35, 175, 500, 1100, 1300, 1500);
		this.tabCases[38] = new Taxe(partie,"Taxe de luxe");
		this.tabCases[39] = new Propriete(partie,"Rue de la Paix", "Bleu fonc�", 400, 200, 50, 200, 600, 1400, 1700, 2000);
	}
	public void initCartes(){
		this.tabCartesChance[0] = new CarteChance(partie,"Amende pour exc�s de vitesse.",1);
		this.tabCartesChance[1] = new CarteChance(partie,"La banque vous verse un dividende de 50�.",2);
		this.tabCartesChance[2] = new CarteChance(partie,"Vous �tes impos� pour les restaurations de voirie.\n40� par maison et 115� par h�tel.",3);
		this.tabCartesChance[3] = new CarteChance(partie,"Avancez jusqu'� la case d�part.",4);
		this.tabCartesChance[4] = new CarteChance(partie,"Payez pour les frais de scolarit� 150�",5);
		this.tabCartesChance[5] = new CarteChance(partie,"Avancez jusqu'� la Rue de la Paix.",6); //Ne passe forc�ment pas par la case D�part.
		this.tabCartesChance[6] = new CarteChance(partie,"Sortez de prison. Vous gardez cette carte jusqu'� ce qu'elle vous serve ou que vous la vendiez.",7);
		this.tabCartesChance[7] = new CarteChance(partie,"Avancez jusqu'� l'Avenue Henri-Martin.\nSi vous passez par la case D�part, touchez 200�.",8);
		this.tabCartesChance[8] = new CarteChance(partie,"Faites des r�parations dans toutes vos propri�t�s.\n25� par maison et 100� par h�tel.",9);
		this.tabCartesChance[9] = new CarteChance(partie,"Avancez jusqu'au Boulevard de la Vilette.\nSi vous passez par la case D�part, touchez 200�.",10);
		this.tabCartesChance[10] = new CarteChance(partie,"Avancez jusqu'� la Garde de Lyon.\nSi vous passez par la case D�part, touchez 200�.",11);
		this.tabCartesChance[11] = new CarteChance(partie,"Votre immeuble et votre pr�t rapportent 150�.",12);
		this.tabCartesChance[12] = new CarteChance(partie,"Allez en Prison. Ne franchissez pas la case D�part, ne touchez pas 200�.",13);
		this.tabCartesChance[13] = new CarteChance(partie,"Reculez de 3 cases.",14);
		this.tabCartesChance[14] = new CarteChance(partie,"Amende pour ivresse.",15);
		this.tabCartesChance[15] = new CarteChance(partie,"Vous avez gagn� le prix de mots crois�s",16);
		
		this.tabCartesCaisseCom[0] = new CarteCaisseCom(partie,"Payez votre police d'assurance s'�levant � 50�.",1);
		this.tabCartesCaisseCom[1] = new CarteCaisseCom(partie,"Payez la note du m�decin.\n50�",2);
		this.tabCartesCaisseCom[2] = new CarteCaisseCom(partie,"Erreur de la banque en votre faveur.\nRecevez 200�.",3);
		this.tabCartesCaisseCom[3] = new CarteCaisseCom(partie,"Allez en prison. Ne passez pas par la case D�part et ne touchez pas 200�.",4);
		this.tabCartesCaisseCom[4] = new CarteCaisseCom(partie,"Avancez jusqu'au Boulevard de Belleville.",5); // Passe forc�ment par la case D�part.
		this.tabCartesCaisseCom[5] = new CarteCaisseCom(partie,"Recevez votre int�r�t sur l'emprunt � 7%.\n250�",6);
		this.tabCartesCaisseCom[6] = new CarteCaisseCom(partie,"Payez � l'h�tpital 100�.",7);
		this.tabCartesCaisseCom[7] = new CarteCaisseCom(partie,"C'est votre anniversaire.\nChaque joueur doit vous donner 10�.",8);
		this.tabCartesCaisseCom[8] = new CarteCaisseCom(partie,"Vous recevez votre revenu annuel: 100�.",9);
		this.tabCartesCaisseCom[9] = new CarteCaisseCom(partie,"Vous h�ritez 100�.",10);
		this.tabCartesCaisseCom[10] = new CarteCaisseCom(partie,"La vente de votre stock vous rapporte 50�.",11);
		this.tabCartesCaisseCom[11] = new CarteCaisseCom(partie,"Payez une amende de 10� pour stationnement interdit.",12);
		this.tabCartesCaisseCom[12] = new CarteCaisseCom(partie,"Sortez de prison. Vous gardez cette carte jusqu'� ce qu'elle vous serve ou que vous la vendiez.",13);
		this.tabCartesCaisseCom[13] = new CarteCaisseCom(partie,"Les contributions vous remboursent la somme de 20�.",14);
		this.tabCartesCaisseCom[14] = new CarteCaisseCom(partie,"Vous avez gagn� le deuxi�me prix de beaut�, vous touchez 10�.",15);
		this.tabCartesCaisseCom[15] = new CarteCaisseCom(partie,"Avancez jusqu'� la case d�part.",16);
	}
	
	private void initDes() {
		this.de1 = new De();
		this.de2 = new De();
	}

	public Case[] getTabCases() {
		return tabCases;
	}
	
	public De getDe1(){
		return de1;
	}
	
	public De getDe2(){
		return de2;
	}
	
	public int getSommeDe(){
		return de1.getValeur() + de2.getValeur();
	}
	
}