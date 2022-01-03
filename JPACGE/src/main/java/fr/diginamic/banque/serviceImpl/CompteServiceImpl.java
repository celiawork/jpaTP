package fr.diginamic.banque.serviceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import fr.diginamic.banque.model.EAssuranceVie;
import fr.diginamic.banque.model.ELivretA;
import fr.diginamic.banque.service.CompteService;

public class CompteServiceImpl implements CompteService {

	EntityManagerFactory efm = null; // Persistence.createEntityManagerFactory("banque");
	EntityManager em = null; // efm.createEntityManager();

	public CompteServiceImpl(EntityManagerFactory efm) {

		this.efm = efm;
		em = this.efm.createEntityManager();
	}

	@Override
	public void addAssuranceVie(EAssuranceVie assurVie) {

		em.getTransaction().begin();
		em.persist(assurVie);
		em.getTransaction().commit();
	}

	@Override
	public void addLivretA(ELivretA livretA) {
		em.getTransaction().begin();
		em.persist(livretA);
		em.getTransaction().commit();
	}


	@Override
	protected void finalize() throws Throwable {

		if (em != null && em.isOpen())
			em.close();
		// if(efm != null && efm.isOpen()) efm.close();
	}

}
