/**
 * @author Marchal François et Massart Florian
 * @version 1.0
 */

package be.ephec.network;

import java.util.Calendar;

public class Console {
	/**
	 * @return une chaîne de caractéres représentant l'invite de commande comprenant l'heure suivi d'un signe 
	 */
	public static String getInviteDeCommande(){
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int seconde = cal.get(Calendar.SECOND);
		return hour+":"+minute+":"+seconde+"> ";
	}
}
