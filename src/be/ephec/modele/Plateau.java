package be.ephec.modele;

public class Plateau {
	private Case[] tabCases = new Case[40];
	private Carte[] tabCartesChance = new Carte[16];
	private Carte[] tabCartesCaisseCom = new Carte[16];
	private De de1;
	private De de2;
	private Partie partie;
	
	public Plateau(Partie partie){
		this.partie = partie;
		initCases();
		initCartes();
		initDes();
	}
	
	
	public void initCases(){
		this.tabCases[0] = new Depart(); 
		this.tabCases[1] = new Propriete("Boulevard de Belleville", "Brun", 60, 50, 2, 10, 30, 90, 160, 250);
		this.tabCases[2] = new CaseCaisseCom();
		this.tabCases[3] = new Propriete("Rue Lecourbe", "Brun", 60, 50, 4, 20, 60, 180, 320, 450);
		this.tabCases[4] = new Taxe("Impôts sur le revenu");
		this.tabCases[5] = new Gare("Gare Montparnasse");
		this.tabCases[6] = new Propriete("Rue Vaugirard", "Bleu clair", 100, 50, 6, 30, 90, 270, 400, 550);
		this.tabCases[7] = new CaseChance();
		this.tabCases[8] = new Propriete("Rue de Courcelles", "Bleu clair", 100, 50, 6, 30, 90, 270, 400, 550);
		this.tabCases[9] = new Propriete("Avenue de la République", "Bleu clair", 120, 50, 8, 40, 100, 300, 450, 600);
		this.tabCases[10] = new Prison();
		this.tabCases[11] = new Propriete("Boulevard de la Vilette", "Rose", 140, 100, 10, 50, 150, 450, 625, 750);
		this.tabCases[12] = new Service("Compagnie de Distribution d'Électricité");
		this.tabCases[13] = new Propriete("Avenue de Neuilly", "Rose", 140, 100, 10, 50, 150, 450, 625, 750);
		this.tabCases[14] = new Propriete("Rue de Paradis", "Rose", 160, 100, 12, 60, 180, 500, 700, 900);
		this.tabCases[15] = new Gare("Gare de Lyon");
		this.tabCases[16] = new Propriete("Avenue Mozart", "Orange", 180, 100, 14, 70, 200, 550, 750, 950);
		this.tabCases[17] = new CaseCaisseCom();
		this.tabCases[18] = new Propriete("Boulevard Saint-Michel", "Orange", 180, 100, 14, 70, 200, 550, 750, 950);
		this.tabCases[19] = new Propriete("Place Pigalle", "Orange", 200, 100, 16, 80, 220, 600, 800, 1000);
		this.tabCases[20] = new ParcGratuit();
		this.tabCases[21] = new Propriete("Avenue Matignon", "Rouge", 220, 150, 18, 90, 250, 700, 875, 1050);
		this.tabCases[22] = new CaseChance();
		this.tabCases[23] = new Propriete("Boulevard Malesherbes", "Rouge", 220, 150, 18, 90, 250, 700, 875, 1050);
		this.tabCases[24] = new Propriete("Avenue Henri-Martin", "Rouge", 240, 150, 20, 100, 300, 750, 925, 1100);
		this.tabCases[25] = new Gare("Garde du Nord");
		this.tabCases[26] = new Propriete("Faubourg Seint-Honoré", "Jaune", 260, 150, 22, 110, 330, 800, 750, 1150);
		this.tabCases[27] = new Propriete("Place de la Bourse", "Jaune", 260, 150, 22, 110, 330, 800, 750, 1150);
		this.tabCases[28] = new Service("Compagnie de Distribution des Eaux");
		this.tabCases[29] = new Propriete("Rue la Fayette", "Jaune", 280, 150, 24, 120, 360, 850, 1025, 1200);
		this.tabCases[30] = new AllerPrison();
		this.tabCases[31] = new Propriete("Avenue du Breteuil", "Vert", 300, 200, 26, 130, 390, 900, 1100, 1275);
		this.tabCases[32] = new Propriete("Avenue Foch", "Vert", 300, 200, 26, 130, 390, 900, 1100, 1275);
		this.tabCases[33] = new CaseCaisseCom();
		this.tabCases[34] = new Propriete("Boulevard des Capucines", "Vert", 320, 200, 28, 150, 450, 1000, 1200, 1400);
		this.tabCases[35] = new Gare("Gare Seint-Lazare");
		this.tabCases[36] = new CaseChance();
		this.tabCases[37] = new Propriete("Avenue des Champs-Élysées", "Bleu foncé", 350, 200, 35, 175, 500, 1100, 1300, 1500);
		this.tabCases[38] = new Taxe("Taxe de luxe");
		this.tabCases[39] = new Propriete("Rue de la Paix", "Bleu foncé", 400, 200, 50, 200, 600, 1400, 1700, 2000);
	}
	public void initCartes(){
		this.tabCartesChance[0] = new CarteChance(partie,"Amende pour excès de vitesse.",1);
		this.tabCartesChance[1] = new CarteChance(partie,"La banque vous verse un dividende de 50€.",2);
		this.tabCartesChance[2] = new CarteChance(partie,"Vous êtes imposé pour les restaurations de voirie.\n40€ par maison et 115€ par hôtel.",3);
		this.tabCartesChance[3] = new CarteChance(partie,"Avancez jusqu'à la case départ.",4);
		this.tabCartesChance[4] = new CarteChance(partie,"Payez pour les frais de scolarité 150€",5);
		this.tabCartesChance[5] = new CarteChance(partie,"Avancez jusqu'à la Rue de la Paix.",6); //Ne passe forcément pas par la case Départ.
		this.tabCartesChance[6] = new CarteChance(partie,"Sortez de prison. Vous gardez cette carte jusqu'à ce qu'elle vous serve ou que vous la vendiez.",7);
		this.tabCartesChance[7] = new CarteChance(partie,"Avancez jusqu'à l'Avenue Henri-Martin.\nSi vous passez par la case Départ, touchez 200€.",8);
		this.tabCartesChance[8] = new CarteChance(partie,"Faites des réparations dans toutes vos propriétés.\n25€ par maison et 100€ par hôtel.",9);
		this.tabCartesChance[9] = new CarteChance(partie,"Avancez jusqu'au Boulevard de la Vilette.\nSi vous passez par la case Départ, touchez 200€.",10);
		this.tabCartesChance[10] = new CarteChance(partie,"Avancez jusqu'à la Garde de Lyon.\nSi vous passez par la case Départ, touchez 200€.",11);
		this.tabCartesChance[11] = new CarteChance(partie,"Votre immeuble et votre prêt rapportent 150€.",12);
		this.tabCartesChance[12] = new CarteChance(partie,"Allez en Prison. Ne franchissez pas la case Départ, ne touchez pas 200€.",13);
		this.tabCartesChance[13] = new CarteChance(partie,"Reculez de 3 cases.",14);
		this.tabCartesChance[14] = new CarteChance(partie,"Amende pour ivresse.",15);
		this.tabCartesChance[15] = new CarteChance(partie,"Vous avez gagné le prix de mots croisés",16);
		
		this.tabCartesCaisseCom[0] = new CarteCaisseCom(partie,"Payez votre police d'assurance s'élevant à 50€.",1);
		this.tabCartesCaisseCom[1] = new CarteCaisseCom(partie,"Payez la note du médecin.\n50€",2);
		this.tabCartesCaisseCom[2] = new CarteCaisseCom(partie,"Erreur de la banque en votre faveur.\nRecevez 200€.",3);
		this.tabCartesCaisseCom[3] = new CarteCaisseCom(partie,"Allez en prison. Ne passez pas par la case Départ et ne touchez pas 200€.",4);
		this.tabCartesCaisseCom[4] = new CarteCaisseCom(partie,"Avancez jusqu'au Boulevard de Belleville.",5); // Passe forcément par la case Départ.
		this.tabCartesCaisseCom[5] = new CarteCaisseCom(partie,"Recevez votre intérêt sur l'emprunt à 7%.\n250€",6);
		this.tabCartesCaisseCom[6] = new CarteCaisseCom(partie,"Payez à l'hôtpital 100€.",7);
		this.tabCartesCaisseCom[7] = new CarteCaisseCom(partie,"C'est votre anniversaire.\nChaque joueur doit vous donner 10€.",8);
		this.tabCartesCaisseCom[8] = new CarteCaisseCom(partie,"Vous recevez votre revenu annuel: 100€.",9);
		this.tabCartesCaisseCom[9] = new CarteCaisseCom(partie,"Vous héritez 100€.",10);
		this.tabCartesCaisseCom[10] = new CarteCaisseCom(partie,"La vente de votre stock vous rapporte 50€.",11);
		this.tabCartesCaisseCom[11] = new CarteCaisseCom(partie,"Payez une amende de 10€ ou bien tirez une carte chance.",12);
		this.tabCartesCaisseCom[12] = new CarteCaisseCom(partie,"Sortez de prison. Vous gardez cette carte jusqu'à ce qu'elle vous serve ou que vous la vendiez.",13);
		this.tabCartesCaisseCom[13] = new CarteCaisseCom(partie,"Les contributions vous remboursent la somme de 20€.",14);
		this.tabCartesCaisseCom[14] = new CarteCaisseCom(partie,"Vous avez gagné le deuxième prix de beauté, vous touchez 10€.",15);
		this.tabCartesCaisseCom[15] = new CarteCaisseCom(partie,"Avancez jusqu'à la case départ.",16);
	}
	
	private void initDes() {
		De de1 = new De();
		De de2 = new De();		
	}

	public Case[] getTabCases() {
		return tabCases;
	}
	
	
}