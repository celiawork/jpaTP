package fr.diginamic.banque.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import fr.diginamic.banque.model.ACompte;
import fr.diginamic.banque.model.EVirement;
import fr.diginamic.banque.service.VirementService;

public class VirementServiceImpl implements VirementService {

	EntityManagerFactory efm = null; // Persistence.createEntityManagerFactory("banque");
	EntityManager em = null; // efm.createEntityManager();

	public VirementServiceImpl(EntityManagerFactory efm) {

		this.efm = efm;
		em = this.efm.createEntityManager();
	}

	@Override
	public void addVirement(EVirement virement, int id_compte) {
		em.getTransaction().begin();
		ACompte compte = em.find(ACompte.class, id_compte);
		virement.setOperationComptes(compte);
		em.persist(virement);
		em.getTransaction().commit();
	}

	@Override
	protected void finalize() throws Throwable {

		if (em != null && em.isOpen())
			em.close();

	}

}
