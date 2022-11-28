package DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import DTO.FilmDTO;
import fr.diginamic.Films;
import fr.diginamic.Genre;
import fr.diginamic.Lieu;

public class LieuDAO {

	/**Methode qui ajoute un Lieu a la Base de données tout en verifiant qu'il n'existe pas déja
	 * 
	 * @param f film pris du document JSON
	 * @param film Object qui prend les parametres avant de le sauvegarde en base
	 * @param em EntityManager
	 */
	public static void ajoutLieu(Lieu lieu, EntityManager em){
		em.persist(lieu);
	}
	
	/**Methode qui vérifie si le Lieu donnée en param existe dans la base 
	 * @param g String qui definie le nom du lieu
	 * @param em EntityManager liée a une base
	 * @return retourne le Lieu trouve en base, sinon retourne null
	 */
	public static Lieu existLieu(String nomLieu, EntityManager em) {		
		TypedQuery<Lieu> queryLieu = em.createQuery("select l from Lieu l where l.ville=:nomLieu", Lieu.class);
		queryLieu.setParameter("nomLieu", nomLieu); 		
		if(queryLieu.getResultList().size() == 0) {	
			return null;
		}
		else {
			return queryLieu.getResultList().get(0);
		}
	}
}
