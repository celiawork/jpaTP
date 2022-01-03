package fr.diginamic.banque.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * EBanque est une classe représentant une banque
 * 
 * @version 1.0
 *
 * @see EClient
 * @author Celia Gretillat
 */
@Entity
@Table(name = "BANQUE")
public class EBanque {

	/**
	 * id de la banque
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENTAL
	private int id;

	/**
	 * Nom de la banque
	 */
	@Column(name = "nom")
	private String nom_banque;

	/**
	 * Relation avec l'entité Client
	 */
	@OneToMany(mappedBy = "clientBanques")
	private Set<EClient> banqueClients;

	// CONSTRUCTEURS
	public EBanque() {

		banqueClients = new HashSet<EClient>();
	}

	public EBanque(int id, String nom_banque) {
		super();
		this.id = id;
		this.nom_banque = nom_banque;
	}

	// GUETTERS & SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_banque() {
		return nom_banque;
	}

	public void setNom_banque(String nom_banque) {
		this.nom_banque = nom_banque;
	}

	public Set<EClient> getBanqueClients() {
		return banqueClients;
	}

	public void setBanqueClients(Set<EClient> banqueClients) {
		this.banqueClients = banqueClients;
	}

}
