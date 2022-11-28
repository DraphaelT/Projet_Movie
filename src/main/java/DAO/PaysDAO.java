package DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import DTO.FilmDTO;
import fr.diginamic.Films;
import fr.diginamic.Genre;
import fr.diginamic.Pays;

public class PaysDAO {

	
	/**Methode qui ajoute le Pays mis en param dans la base mis aussi en param
	 * @param genre Objet de type Pays
	 * @param em EntityManager liée a une base
	 */
	public static void ajoutPays(Pays pays, EntityManager em) {
		em.persist(pays);
	}
	
	/**Methode qui vérifie si le Pays donnée en param existe dans la base 
	 * @param nomPays String qui definie le nom du Pays recherche
	 * @param em EntityManager liée a une base
	 * @return retourne le Pays trouve en base, sinon retourne null
	 */
	public static Pays existePays(String nomPays, EntityManager em) {
		TypedQuery<Pays> queryPays= em.createQuery("select p from Pays p where p.nom=:nomPays", Pays.class);
		queryPays.setParameter("nomPays", nomPays); 
		
		if(queryPays.getResultList().size() == 0) {	
			return null;
		}
		else {
			return queryPays.getResultList().get(0);
		}
	}
	
}
