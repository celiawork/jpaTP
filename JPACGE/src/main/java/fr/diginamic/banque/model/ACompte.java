package fr.diginamic.banque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ACompte est une classe abtraite représentant un compte bancaire
 * 
 * @version 1.0
 *
 * @see ELivretA 
 * @see EAssuranceVie
 * @see EOperation
 * @see EClient
 * @author Celia Gretillat
 */

@Entity
@Table(name = "Compte")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ACompte {

	/**
	 * L'id du compte, il n'est pas modifiable
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENTAL
	protected int id;

	/**
	 * Le numero du compte bancaire
	 */
	@Column(name = "numero")
	protected String numero_compte;

	/**
	 * Le solde du compte bancaire
	 */
	@Column(name = "solde")
	protected Double solde_compte;

	/**
	 * Relation avec l'entité client
	 */
	@ManyToMany(mappedBy = "clientComptes")
	protected Set<EClient> compteClients;

	/**
	 * Relation avec l'entité operation
	 */
	@OneToMany(mappedBy = "operationComptes")
	protected Set<EOperation> compteOperations;

	
	//CONSTRUCTEURS
	public ACompte() {
		compteClients = new HashSet<>();
		compteOperations = new HashSet<>();
	}
	
	public ACompte(int id, String numero_compte, Double solde_compte) {
		super();
		this.id = id;
		this.numero_compte = numero_compte;
		this.solde_compte = solde_compte;
	
	}
	

	//GUETTERS & SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero_compte() {
		return numero_compte;
	}

	public void setNumero_compte(String numero_compte) {
		this.numero_compte = numero_compte;
	}

	public Double getSolde_compte() {
		return solde_compte;
	}

	public void setSolde_compte(Double solde_compte) {
		this.solde_compte = solde_compte;
	}

	public Set<EClient> getCompteClients() {
		return compteClients;
	}

	public void setCompteClients(Set<EClient> compteClients) {
		this.compteClients = compteClients;
	}

	public Set<EOperation> getCompteOperations() {
		return compteOperations;
	}

	public void setCompteOperations(Set<EOperation> compteOperations) {
		this.compteOperations = compteOperations;
	}

}
