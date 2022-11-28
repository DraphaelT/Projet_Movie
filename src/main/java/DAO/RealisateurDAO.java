package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import DTO.FilmDTO;
import DTO.RealisateurDTO;
import fr.diginamic.Films;
import fr.diginamic.Pays;
import fr.diginamic.Realisateur;

public class RealisateurDAO {

	/**Methode qui ajoute le Realisateur mis en param dans la base mis aussi en param
	 * @param genre Objet de type Realisateur
	 * @param em EntityManager liée a une base
	 */
	public static void ajoutReal(Realisateur real, EntityManager em) {
		em.persist(real);
	}
	
	/**Methode qui vérifie si le Realisateur donnée en param existe dans la base 
	 * @param nomPays String qui definie l'id du Realisateur recherche
	 * @param em EntityManager liée a une base
	 * @return retourne le Pays trouve en base, sinon retourne null
	 */
	public static Realisateur existeReal(String nomReal, EntityManager em) {
		TypedQuery<Realisateur> queryReal= em.createQuery("select r from Realisateur r where r.identite=:nomReal", Realisateur.class);
		queryReal.setParameter("nomReal", nomReal); 
		
		if(queryReal.getResultList().size() == 0) {	
			return null;
		}
		else {
			return queryReal.getResultList().get(0);
		}
	}
}
