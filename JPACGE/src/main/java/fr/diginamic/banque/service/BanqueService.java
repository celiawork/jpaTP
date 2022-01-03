package fr.diginamic.banque.service;

import fr.diginamic.banque.model.EBanque;

/**
 * 
 * @author Celia Gretillat
 *
 */
public interface BanqueService {

	/**
	 * Permet d'ajouter une banque dans la BDD
	 * 
	 * @param banque
	 */
	public void addBanque(EBanque banque);

}
