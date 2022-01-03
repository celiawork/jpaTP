package fr.diginamic.banque.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * EAssuranceVie est une classe représentant un compte d'assurance vie
 * 
 * @version 1.0
 *
 * @see ACompte
 * @author Celia Gretillat
 */
@Entity
@Table(name = "AssuranceVie")
public class EAssuranceVie extends ACompte {

	/**
	 * date de fin du contrat de l'assurance vie
	 */
	private LocalDate dateFin;

	/**
	 * taux de l'assurance vie
	 */
	private double taux;

	// CONSTRUCTEURS
	public EAssuranceVie() {

	}

	public EAssuranceVie(int id, LocalDate dateFin, double taux, String numero_compte, Double solde_compte) {
		super(id, numero_compte, solde_compte);
		this.dateFin = dateFin;
		this.taux = taux;
	}

	// GUETTERS & SETTERS

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
