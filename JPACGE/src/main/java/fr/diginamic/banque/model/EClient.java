package fr.diginamic.banque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * EClient est une classe représentant un client d'une banque
 * 
 * 
 * @version 1.0
 *
 * @see EAdresse
 * @see EBanque
 * @see ACompte
 * @author Celia Gretillat
 */
@Entity
@Table(name = "CLIENT")
public class EClient implements Serializable {

	/**
	 * Numero de version de "Serializable"
	 */
	private static final long serialVersionUID = 6015194981248452053L;

	/**
	 * l'id du client
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENTAL
	private int id;

	/**
	 * le nom du client
	 */
	@Column(name = "nom")
	private String nom_client;

	/**
	 * le prenom du client
	 */
	@Column(name = "prenom")
	private String prenom_client;

	/**
	 * la date de naissance du client
	 */
	@Column(name = "dateNaissance")
	private LocalDate dateNaissance;

	/**
	 * Utilisation d'objets inclus de EAdresse
	 */
	@Embedded
	private EAdresse adresse;

	/**
	 * Relation avec l'entité EBanque
	 */
	@ManyToOne
	@JoinColumn(name = "id_banque")
	private EBanque clientBanques;

	/**
	 * Création d'une table d'association avec l'Entité ECompte
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "client_compte", joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id"))
	private Set<ACompte> clientComptes;

	// CONSTRUCTEURS
	public EClient() {
		clientComptes = new HashSet<>();
	}

	public EClient(int id, String nom_client, String prenom_client, LocalDate dateNaissance, EAdresse adresse,
			EBanque clientBanques) {
		super();
		this.id = id;
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.clientBanques = clientBanques;
	}

	// GUETTERS & SETTER

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}

	public String getPrenom_client() {
		return prenom_client;
	}

	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public EAdresse getAdresse() {
		return adresse;
	}

	public void setAdresse(EAdresse adresse) {
		this.adresse = adresse;
	}

	public EBanque getClientBanques() {
		return clientBanques;
	}

	public void setClientBanques(EBanque clientBanques) {
		this.clientBanques = clientBanques;
	}

	public Set<ACompte> getClientComptes() {
		return clientComptes;
	}

	public void setClientComptes(Set<ACompte> clientComptes) {
		this.clientComptes = clientComptes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
