package fr.diginamic.banque.jpa;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import fr.diginamic.banque.model.*;
import fr.diginamic.banque.serviceImpl.*;

/**
 * APP est une classe qui rassemble les exercices du TP5 JPA
 * Les methodes pourront etre exécuter afin de répondre aux différentes consignes
 * 
 * @version 1.0
 *
 * @author Celia Gretillat
 */
public class App {

	public static void main(String[] args) {

		EntityManagerFactory efm = Persistence.createEntityManagerFactory("banque");

		try {

			ClientServiceImpl clientService = new ClientServiceImpl(efm);
			BanqueServiceImpl banqueService = new BanqueServiceImpl(efm);
			CompteServiceImpl compteService = new CompteServiceImpl(efm);
			OperationServiceImpl operationService = new OperationServiceImpl(efm);
			VirementServiceImpl virementService = new VirementServiceImpl(efm);
			EAssuranceVie assurVie = new EAssuranceVie(0, LocalDate.of(2030, 5, 1), 5, "ASSS", 30000.00);
			EAssuranceVie assurVie2 = new EAssuranceVie(0, LocalDate.of(2025, 12, 1), 5, "ASQQQ", 1000.58);
			ELivretA livretA = new ELivretA(0, "L5548", 540.00, 2.2);
			EBanque banque = new EBanque(0, "BNP Paribas");
			EOperation operation = new EOperation(0, new Timestamp(System.currentTimeMillis()), 50.00, "Retrait",assurVie);
			EVirement virement = new EVirement(0, new Timestamp(System.currentTimeMillis()), 150.00,"Virement instantanée", assurVie, "Jocob Pliakov");
			EAdresse adresse = new EAdresse(40, "rue de la liberté", 34000, "Montpellier");
			EClient client1 = new EClient(0, "Bargo", "Roberto", LocalDate.of(1970, 05, 13), adresse, banque);
			EClient client2 = new EClient(0, "Payet", "Robertita", LocalDate.of(1984, 07, 01), adresse, banque);
			EClient client3 = new EClient(0, "Goutan", "Laurent", LocalDate.of(1990, 01, 07), adresse, banque);

			// AJOUTER DES DONNEES DANS LA BBD
			banqueService.addBanque(banque);
			clientService.addClient(client1);
			clientService.addClient(client2);
			clientService.addClient(client3);
			compteService.addLivretA(livretA);
			compteService.addAssuranceVie(assurVie);
			compteService.addAssuranceVie(assurVie2); 

			// ATTENTION LA BDD DOIT CONTENIR DES DONNEES AFIN DE POURVOIR EXECUTER
			// LES METHODES CI-DESSOUS

			// TP.5 // INSERER UN COMPTE ASSOCIE A 2 CLIENTS
//			clientService.addRelationClientCompte(1, 2);
//			clientService.addRelationClientCompte(2, 2);
//
//			// TP.5 //INSERER UN CLIENT AVEC PLUSIEURS COMPTES
//			clientService.addRelationClientCompte(3, 1);
//			clientService.addRelationClientCompte(3, 3);
//
//			// TP.5 //INSERER DES OPERATIONS DE TYPE VIREMENTS SUR UN COMPTE
//			virementService.addVirement(virement, 1);
//
//			// TP.5 //INSERER DES OPERATIONS DE TYPE OPERATIONS
//			operationService.addOperation(operation, 2);

		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if (efm != null && efm.isOpen())
				efm.close();
		}

	}

}
