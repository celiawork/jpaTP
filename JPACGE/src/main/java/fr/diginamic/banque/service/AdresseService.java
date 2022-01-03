package fr.diginamic.banque.service;

import fr.diginamic.banque.model.EAdresse;

/**
 * 
 * @author Celia Gretillat
 *
 */
public interface AdresseService {

	/**
	 * Permet de creer une adresse 
	 * @param numero 
	 *  numero de la rue
	 * @param rue 
	 * 	nom de la rue
	 * @param ville
	 * 	ville de l'adresse
	 * @param codePostal
	 * 	code postal de l'adresse
	 * @return l'adresse
	 */
	public EAdresse createAdresse(int numero, String rue, String ville, int codePostal);
}
