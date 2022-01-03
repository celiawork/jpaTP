package fr.diginamic.cge.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "LIVRE")

public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENTAL
	private int id;

	@Column(name = "TITRE", length = 255, nullable = false)
	private String titre;

	@Column(name = "AUTEUR", length = 50, nullable = false)
	private String auteur;

	@ManyToMany(mappedBy = "empruntLivres")
	private Set<Emprunt> livreBons;

	public Livre() {

		livreBons = new HashSet<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "[ Livre id : " + id + ", titre : " + titre + ", auteur : " + auteur + "]";
	}

}