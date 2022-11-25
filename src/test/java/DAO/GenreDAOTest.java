package DAO;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

import fr.diginamic.Genre;

public class GenreDAOTest {
	
	/**
	 * Test pour voir s'il renvois bien null s'il n'a rien trouver
	 */
	@Test
	public void existeGenreTestNull() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("movieproject");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		TypedQuery<Genre> queryGenre= em.createQuery("select h from Genre h where h.nom=:nomGenre", Genre.class);
		queryGenre.setParameter("nomGenre", "bfdsbfds"); 
	
		assertEquals(0,queryGenre.getResultList().size());
	}
	/**
	 * Test pour voir s'il recupere bien les information de la table Genre 
	 */
	@Test
	public void existeGenreTest1() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("movieproject");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		TypedQuery<Genre> queryGenre= em.createQuery("select h from Genre h where h.nom=:nomGenre", Genre.class);
		queryGenre.setParameter("nomGenre", "Action"); 
	
		assertEquals(1,queryGenre.getResultList().get(0));
	}

}
