package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import DTO.FilmDTO;
import fr.diginamic.Films;
import fr.diginamic.Genre;

public class GenreDAO {
	
	/**Methode qui ajoute le Genre mis en param dans la base mis aussi en param
	 * @param genre Objet de type Genre
	 * @param em EntityManager liée a une base
	 */
	public static void ajoutGenre(Genre genre, EntityManager em) {		
		em.persist(genre); 			
	}			
			
	
	/**Methode qui vérifie si le Genre donnée en param existe dans la base 
	 * @param g String qui definie un Genre
	 * @param em EntityManager liée a une base
	 * @return retourne le Genre trouve en base, sinon retourne null
	 */
	public static Genre existeGenre(String g, EntityManager em) {		
		TypedQuery<Genre> queryGenre= em.createQuery("select h from Genre h where h.nom=:nomGenre", Genre.class);
		queryGenre.setParameter("nomGenre", g); 
		
		if(queryGenre.getResultList().size() == 0) {	
			return null;
		}
		else {
			return queryGenre.getResultList().get(0);
		}
	}
	
}
