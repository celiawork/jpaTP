package fr.diginamic.banque.serviceImpl;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import fr.diginamic.banque.model.EClient;
import fr.diginamic.banque.model.ACompte;
import fr.diginamic.banque.service.ClientService;

public class ClientServiceImpl implements ClientService {

	EntityManagerFactory efm = null; // Persistence.createEntityManagerFactory("banque");
	EntityManager em = null; // efm.createEntityManager();

	public ClientServiceImpl(EntityManagerFactory efm) {

		this.efm = efm;
		em = this.efm.createEntityManager();
	}


	@Override
	public void addClient(EClient client) {
		em.getTransaction().begin();
		client.setAdresse(client.getAdresse());
		client.setClientBanques(client.getClientBanques());
		em.persist(client);
		em.getTransaction().commit();
	}


	@Override
	public void addRelationClientCompte(int id_client, int id_compte) {

		em.getTransaction().begin();
		EClient client = em.find(EClient.class, id_client);
		ACompte compte = em.find(ACompte.class, id_compte);
		client.getClientComptes().add(compte);
		em.persist(client);
		em.getTransaction().commit();
	}

	/**
	 * Fermer l'entityManager
	 */
	@Override
	protected void finalize() throws Throwable {

		if (em != null && em.isOpen())
			em.close();
		// if(efm != null && efm.isOpen()) efm.close();
	}
}
