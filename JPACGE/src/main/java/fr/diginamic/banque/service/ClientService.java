package fr.diginamic.banque.service;

import fr.diginamic.banque.model.EClient;

/**
 * 
 * @author Celia Gretillat
 *
 */
public interface ClientService {

	/**
	 * Permet d'ajouter un client dans la BDD
	 * @param client 
	 * 	client à ajouter dans la BDD
	 */
	public void addClient(EClient client);
	
	/**
	 * 
	 * @param id_client id du client à ajouter dans la table de relation 
	 * @param id_compte id du compte à ajouter dans la table de relation  
	 */
	public void addRelationClientCompte(int id_client, int id_compte);	
}

