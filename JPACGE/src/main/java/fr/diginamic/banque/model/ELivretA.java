package fr.diginamic.banque.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ELivretA est une classe représentant un compte de livretA
 * 
 * @version 1.0
 *
 * @see ECompte
 * @author Celia Gretillat
 */
@Entity
@Table(name = "LivretA")
public class ELivretA extends ACompte {

	/**
	 * taux du livret A
	 */
	private double taux;

	// CONSTRUCTEURS
	public ELivretA() {

	}

	public ELivretA(int id, String numero_compte, Double solde_compte, double taux) {
		super(id, numero_compte, solde_compte);
		this.taux = taux;
	}

	// GUETTERS & SETTERS
	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
