package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import DTO.FilmDTO;
import DTO.RoleDTO;
import fr.diginamic.Films;
import fr.diginamic.Pays;
import fr.diginamic.Role;

public class RoleDAO {

	/**Methode qui ajoute le Role mis en param dans la base mis aussi en param
	 * @param genre Objet de type Role
	 * @param em EntityManager liée a une base
	 */
	public static void ajoutRole(Role role, EntityManager em) {		
			em.persist(role);					
	}
	
	/**Methode qui vérifie si le Role donnée en param existe dans la base 
	 * @param nomPays String qui definie le nom du Role recherche
	 * @param em EntityManager liée a une base
	 * @return retourne le Role trouve en base, sinon retourne null
	 */
	public static Role existePays(String nomRole, EntityManager em) {
		TypedQuery<Role> queryRole= em.createQuery("select r from Role r where r.nom=:nomRole", Role.class);
		queryRole.setParameter("nomRole", nomRole); 
		
		if(queryRole.getResultList().size() == 0) {	
			return null;
		}
		else {
			return queryRole.getResultList().get(0);
		}
	}
	
}
