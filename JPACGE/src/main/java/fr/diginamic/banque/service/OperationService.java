package fr.diginamic.banque.service;

import fr.diginamic.banque.model.EOperation;

/**
 * 
 * @author Celia Gretillat
 *
 */
public interface OperationService {
 
	/**
	 * Permet d'ajouter une operation bancaire dans la BDD
	 * @param operation 
	 * 	l'operation à ajouter dans la BBD
	 * @param id_compte
	 * 	l'id d'un compte lié à l'opération bancaire
	 */
	public void addOperation(EOperation operation, int id_compte);
}
