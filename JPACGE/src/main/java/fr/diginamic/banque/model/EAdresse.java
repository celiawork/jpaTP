package fr.diginamic.banque.model;

import javax.persistence.*;

/**
 * EAdresse est une classe représentant l'adresse d'un client
 * classe d'objets inclus de EClient
 * 
 * @version 1.0
 *
 * @see EClient
 * @author Celia Gretillat
 */
@Embeddable
public class EAdresse {

	/**
	 * Numero de rue de l'adresse du client
	 */
	private Integer numero;
	/**
	 * Nom de la rue de l'adresse du client
	 */
	private String rue;
	/**
	 * Code postal de l'adresse du client
	 */
	private Integer codePostal;
	/**
	 * Ville de l'adresse du client
	 */
	private String ville;

	// CONSTRUCTEURS
	public EAdresse() {

	}

	public EAdresse(Integer numero, String rue, Integer codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	// GUETTERS & SETTERS

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
