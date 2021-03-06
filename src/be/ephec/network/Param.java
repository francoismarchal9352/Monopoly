/**
 * @author Marchal François et Massart Florian
 * @version 1.0
 */

package be.ephec.network;

public class Param {
	/**
	 * C'est le numéro de port par défaut que l'on essaie d'ouvrir
	 */
	public static final int NUM_PORT_DE_BASE = 42000;
	public static final String IP_SERVEUR = "127.0.0.1";
	
	public static final int HAUTEUR_JFRAME_ACCUEIL_CLIENT = 201;
	public static final int HAUTEUR_JFRAME_ACCUEIL_SERVEUR = 400;
	public static final int LARGEUR_JFRAME_ACCUEIL_CLIENT = 300;
	public static final int LARGEUR_JFRAME_ACCUEIL_SERVEUR = 450;
	
	public static final int HAUTEUR_JFRAME_PINC_CLIENT = 200;
	public static final int HAUTEUR_JFRAME_PRINC_SERVEUR = 800;
	public static final int LARGEUR_JFRAME_PINC_CLIENT = LARGEUR_JFRAME_ACCUEIL_CLIENT-1;
	public static final int LARGEUR_JFRAME_PRINC_SERVEUR = LARGEUR_JFRAME_ACCUEIL_SERVEUR-1;
	
	public static final int COIN_SUP_GAUCHE_CLIENT_X = LARGEUR_JFRAME_ACCUEIL_SERVEUR;
	public static final int COIN_SUP_GAUCHE_CLIENT_Y = 0;
	public static final int COIN_SUP_GAUCHE_SERVEUR_X = 0;
	public static final int COIN_SUP_GAUCHE_SERVEUR_Y = 0;
	
	public static final int NB_CLIENTS = 2;
	
	public static final int NB_COLONNES_AFFICHAGE = 6;
}



