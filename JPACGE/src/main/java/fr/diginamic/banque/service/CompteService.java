package fr.diginamic.banque.service;

import fr.diginamic.banque.model.EAssuranceVie;
import fr.diginamic.banque.model.ELivretA;

/**
 * 
 * @author Celia Gretillat
 *
 */
public interface CompteService {

	/**
	 * Permet d'ajouter un compte assurance vie dans la BDD
	 * @param assurVie 
	 * 	le compte assurance vie à ajouter
	 */
	public void addAssuranceVie(EAssuranceVie assurVie);
	
	/**
	 * Permet d'ajouter un livret A dans la BDD
	 * @param livretA 
	 * 	compte livretA à ajouter dans la BDD
	 */
	public void addLivretA(ELivretA livretA);

}
