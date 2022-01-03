package fr.diginamic.cge.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import fr.diginamic.cge.jpa.model.Livre;

/**
 * APP est une classe qui rassemble les exercices du TP2 JPA
 * Les methodes pourront etre exécuter afin de répondre aux différentes consignes
 * 
 * @version 1.0
 *
 * @author Celia Gretillat
 */
public class App {
	public static void main(String[] args) {
		EntityManagerFactory efm = null;

		try {

			// CONNECTION
			efm = Persistence.createEntityManagerFactory("bddBiblio");
			EntityManager em = efm.createEntityManager();

			// TP 2 // Réalisez un find simple permettant d’extraire un livre en fonction de
			// son identifiant et affichez son titre et son auteur.
			Livre livre = em.find(Livre.class, 1);
			if (livre != null)
				System.out.println("Le titre du livre est : " + livre.getTitre() + " l'auteur est : " + livre.getAuteur());
			else
				System.out.println("NON TROUVE !");

			// TP 2 //Insérez un nouveau Livre de votre choix en base de données
			em.getTransaction().begin();
			Livre livre1 = new Livre();
			livre1.setTitre("Le code c'est la folie !");
			livre1.setAuteur("Celia Grey");
			em.persist(livre1);
			em.getTransaction().commit();
			System.out.println("Le nouveau livre ajouté est : " + livre1.getTitre() + " / ecris par : " + livre1.getAuteur());

			// TP 2 //Modifiez le titre du livre d’identifiant 5 qui possède une erreur : le nouveau titre doit être
			// « Du plaisir dans la cuisine » au lieu de « 1001 recettes de Cuisine ».
			em.getTransaction().begin();
			Livre livreModif = em.find(Livre.class, 5);
			livreModif.setTitre("Du plaisir dans la cuisine");
			em.merge(livreModif);
			em.getTransaction().commit();

			// TP 2 //Faites une requête JPQL pour extraire de la base un livre en fonction de son titre.
			TypedQuery<Livre> query1 = em.createQuery(
					"SELECT LIVRE from ELivre LIVRE where LIVRE.titre ='Du plaisir dans la cuisine'", Livre.class);
			Livre s1 = query1.getResultList().get(0);
			System.out.println(s1);

			// TP 2 //Faites une requête JPQL pour extraire de la base un livre en fonction de son auteur.
			TypedQuery<Livre> query2 = em
					.createQuery("SELECT LIVRE from ELivre LIVRE where LIVRE.auteur ='Gaston Pouet'", Livre.class);
			Livre s2 = query2.getResultList().get(0);
			System.out.println(s2);

			// TP 2 //Supprimez un livre de votre choix en base de données.

			em.getTransaction().begin();
			Livre livreDelete = em.find(Livre.class, 7);
			em.remove(livreDelete);
			em.getTransaction().commit();

			// TP 2 //Affichez la liste de tous les livres présents en base de données
			//(titre et auteur).

			TypedQuery<Livre> query3 = em.createQuery("SELECT LIVRE from ELivre LIVRE", Livre.class);
			java.util.List<Livre> s3 = query3.getResultList();
			for (Livre livre2 : s3) {
				System.out.println("Le titre du livre est:" + livre2.getTitre() + "et l'auteur est :" + livre2.getAuteur());
			}

			em.close();

		}catch (Exception e) {
			System.err.println("Erreurs  : " + e.getMessage());
		} finally {
			if (efm != null && efm.isOpen())
				efm.close();
		}

	}
}
