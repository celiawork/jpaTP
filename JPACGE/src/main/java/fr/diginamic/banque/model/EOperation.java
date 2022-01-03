package fr.diginamic.banque.model;

import java.sql.Timestamp;

import javax.persistence.*;

/**
 * EOperation est une classe représentant les opérations bancaire effectués sur un compte bancaire 
 * Classe racine de la stratégie SINGLE_TABLE étendue par une classe EVirement
 * 
 * @version 1.0
 *
 * @see ACompte
 * @see EVirement
 * @author Celia Gretillat
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "OPERATION")
@DiscriminatorColumn(name = "TYPE")
@DiscriminatorValue("O")
public class EOperation {

	/**
	 * id de l'operation bancaire
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENTAL
	protected int id;

	/**
	 * date de l'operation bancaire
	 */
	@Column(name = "date")
	protected Timestamp date_operation;

	/**
	 * sommes retirée ou versée sur le compte bancaires
	 */
	@Column(name = "montant")
	protected Double montant;

	/**
	 * motif de l'operation bancaire
	 */
	@Column(name = "motif")
	protected String motif_operation;

	/**
	 * relation avec l'entité ECompte
	 */
	@ManyToOne
	@JoinColumn(name = "id_compte")
	protected ACompte operationComptes;

	// CONSTRUCTEURS
	public EOperation() {

	}

	public EOperation(int id, Timestamp date_operation, Double montant, String motif_operation,
			ACompte operationComptes) {
		super();
		this.id = id;
		this.date_operation = date_operation;
		this.montant = montant;
		this.motif_operation = motif_operation;
		this.operationComptes = operationComptes;
	}

	// GUETTERS & SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate_operation() {
		return date_operation;
	}

	public void setDate_operation(Timestamp date_operation) {
		this.date_operation = date_operation;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getMotif_operation() {
		return motif_operation;
	}

	public void setMotif_operation(String motif_operation) {
		this.motif_operation = motif_operation;
	}

	public ACompte getOperationComptes() {
		return operationComptes;
	}

	public void setOperationComptes(ACompte operationComptes) {
		this.operationComptes = operationComptes;
	}

}
