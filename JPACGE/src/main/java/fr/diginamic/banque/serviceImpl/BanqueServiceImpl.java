package fr.diginamic.banque.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import fr.diginamic.banque.model.EBanque;
import fr.diginamic.banque.service.BanqueService;

/**
 * 
 * @author Celia Gretillat
 *
 */
public class BanqueServiceImpl implements BanqueService {

	EntityManagerFactory efm = null; // Persistence.createEntityManagerFactory("banque");
	EntityManager em = null; // efm.createEntityManager();

	public BanqueServiceImpl(EntityManagerFactory efm) {
		this.efm = efm;
		em = this.efm.createEntityManager();
	}


	@Override
	public void addBanque(EBanque banque) {

		em.getTransaction().begin();
		em.persist(banque);
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
