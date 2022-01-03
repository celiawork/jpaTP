package fr.diginamic.cge.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import fr.diginamic.cge.jpa.model.Client;
import fr.diginamic.cge.jpa.model.Emprunt;

/**
 * APP2 est une classe qui rassemble les exercices du TP3 JPA
 * Les methodes pourront etre exécuter afin de répondre aux différentes consignes
 * 
 * @version 1.0
 *
 * @author Celia Gretillat
 */
public class App2 {

	public static void main(String[] args) {

		EntityManagerFactory efm = null;

		try {
			efm = Persistence.createEntityManagerFactory("bddBiblio");
			EntityManager em = efm.createEntityManager();

			// TP3 // Réalisez une requête qui permet d’extraire un emprunt et tous ses livres associés.
			Emprunt emp = em.find(Emprunt.class, 1);
			if (emp != null)
				System.out.println("Identification de l'emprunt : " + emp.getId() + " et les livres associés : " +  emp.getEmpruntLivres());
			else
				System.out.println("NON TROUVE !");

			// TP3 // Réalisez une requête qui permet d’extraire tous les emprunts d’un client donné
			Client client = em.find(Client.class, 1);
			if (client != null)
				System.out.println("Identité du client :" +  client.getPrenom() + " " + client.getNom() + " Voici ces emprunts : " + client.getEmprunts() );
			else
				System.out.println("NON TROUVE !");
			
			em.close();

		} catch (Exception e) {
			
			System.err.println("Erreur  : " + e.getMessage());
			
		} finally {
			
			if (efm != null && efm.isOpen())
				efm.close();
		}

	}

}
