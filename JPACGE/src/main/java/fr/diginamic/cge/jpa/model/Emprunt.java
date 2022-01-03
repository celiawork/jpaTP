package fr.diginamic.cge.jpa.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRUNT")

public class Emprunt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENTAL
	private int id;

	@Column(name = "DATE_DEBUT", nullable = false)
	private Timestamp date_debut;

	@Column(name = "DELAI", length = 10)
	private int delai_max;

	@Column(name = "DATE_FIN")
	private Timestamp date_fin;

	@ManyToOne
	@JoinColumn(name = "ID_Client")
	private Client id_client;

	@ManyToMany
	@JoinTable(name = "COMPO", joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))

	private Set<Livre> empruntLivres;

	public Emprunt() {

		empruntLivres = new HashSet<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Timestamp date_debut) {
		this.date_debut = date_debut;
	}

	public int getDelai_max() {
		return delai_max;
	}

	public void setDelai_max(int delai_max) {
		this.delai_max = delai_max;
	}

	public Timestamp getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Timestamp date_fin) {
		this.date_fin = date_fin;
	}

	public Client getId_client() {
		return id_client;
	}

	public void setId_client(Client id_client) {
		this.id_client = id_client;
	}
	

	public Set<Livre> getEmpruntLivres() {
		return empruntLivres;
	}

	public void setEmpruntLivres(Set<Livre> empruntLivres) {
		this.empruntLivres = empruntLivres;
	}

	@Override
	public String toString() {
		return "Emprunt id : " + id + ", date_debut : " + date_debut + ", delai_max : " + delai_max + ", date_fin : "
				+ date_fin + "]";
	}

}
