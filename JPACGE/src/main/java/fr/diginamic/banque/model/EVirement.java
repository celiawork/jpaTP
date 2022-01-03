package fr.diginamic.banque.model;

import java.sql.Timestamp;

import javax.persistence.*;

/**
 * EVirement est une classe représentant un virement sur un compte bancaire
 * Stratégie SINGLE_TABLE avec la classe EOperation
 * 
 * @version 1.0
 *
 * @see EOperation
 * @author Celia Gretillat
 */
@Entity
@DiscriminatorValue("V")
public class EVirement extends EOperation {

	/**
	 * nom et prenom du beneficiaire du virement bancaire
	 */
	private String beneficiaire;

	// CONSTRUCTEURS
	public EVirement() {

	}

	public EVirement(int id, Timestamp date_operation, Double montant, String motif_operation, ACompte operationComptes,
			String beneficiaire) {
		super(id, date_operation, montant, motif_operation, operationComptes);
		this.beneficiaire = beneficiaire;
	}

	// GUETTERS & SETTERS
	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

}
