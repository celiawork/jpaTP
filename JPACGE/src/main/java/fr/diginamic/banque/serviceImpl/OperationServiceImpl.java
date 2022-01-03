package fr.diginamic.banque.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import fr.diginamic.banque.model.ACompte;
import fr.diginamic.banque.model.EOperation;
import fr.diginamic.banque.service.OperationService;

public class OperationServiceImpl implements OperationService {

	EntityManagerFactory efm = null; // Persistence.createEntityManagerFactory("banque");
	EntityManager em = null; // efm.createEntityManager();

	public OperationServiceImpl(EntityManagerFactory efm) {

		this.efm = efm;
		em = this.efm.createEntityManager();
	}

	@Override
	public void addOperation(EOperation operation, int id_compte) {

		em.getTransaction().begin();
		ACompte compte = em.find(ACompte.class, id_compte);
		operation.setOperationComptes(compte);
		em.persist(operation);
		em.getTransaction().commit();

	}

	@Override
	protected void finalize() throws Throwable {

		if (em != null && em.isOpen())
			em.close();

	}

}
