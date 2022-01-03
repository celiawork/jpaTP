package fr.diginamic.banque.service;

import fr.diginamic.banque.model.EVirement;

/**
 * 
 * @author Celia Gretillat
 *
 */
public interface VirementService {
	
	/**
	 * Permet d'ajouter une operation bancaire de type virement bancaire dans la BDD
	 * @param virement 
	 * 	l'operation virement à ajouter dans la BDD
	 * @param id_compte
	 *  l'id du compte lié à l'operation virement 
	 */
	public void addVirement(EVirement virement, int id_compte);
}
