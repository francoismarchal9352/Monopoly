package be.ephec.modele;

public class Plateau {
	private Case[] tabCases = new Case[40];
	private Carte[] tabCartesChance = new Carte[16];
	private Carte[] tabCartesCaisseCom = new Carte[16];
	private De de1;
	private De de2;
	
	private Plateau(){
		this.tabCases[0] = new Depart(); // type départ
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
		this.tabCases[20] = new ParcGratuit(); // type parc 
		this.tabCases[21] = new Propriete("Avenue Matignon", "Rouge", 220, 150, 18, 90, 250, 700, 875, 1050);
		this.tabCases[22] = new CaseChance();
		this.tabCases[23] = new Propriete("Boulevard Malesherbes", "Rouge", 220, 150, 18, 90, 250, 700, 875, 1050);
		this.tabCases[24] = new Propriete("Avenue Henri-Martin", "Rouge", 240, 150, 20, 100, 300, 750, 925, 1100);
		this.tabCases[25] = new Gare("Garde du Nord");
		this.tabCases[26] = new Propriete("Faubourg Seint-Honoré", "Jaune", 260, 150, 22, 110, 330, 800, 750, 1150);
		this.tabCases[27] = new Propriete("Place de la Bourse", "Jaune", 260, 150, 22, 110, 330, 800, 750, 1150);
		this.tabCases[28] = new Service("Compagnie de Distribution des Eaux");
		this.tabCases[29] = new Propriete("Rue la Fayette", "Jaune", 280, 150, 24, 120, 360, 850, 1025, 1200);
		this.tabCases[30] = new AllerPrison(); // a voir
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

	public Case[] getTabCases() {
		return tabCases;
	}
	
	
}