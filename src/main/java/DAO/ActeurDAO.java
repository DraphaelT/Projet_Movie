package DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.diginamic.Acteurs;
import fr.diginamic.Genre;


public class ActeurDAO {

	/**Methode qui ajoute un Acteur a la Base de données tout en verifiant qu'il n'existe pas déja
	 * 
	 * @param f film pris du document JSON
	 * @param film Object qui prend les parametres avant la sauvegarde en base
	 * @param em EntityManager
	 */
	public static void ajoutActeur(Acteurs acteur, EntityManager em) {
		em.persist(acteur);
	}
}
