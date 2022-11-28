package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import DTO.ActeurDTO;
import DTO.FilmDTO;
import DTO.RoleDTO;
import DTO.Traitement;
import fr.diginamic.Acteurs;
import fr.diginamic.Films;
import fr.diginamic.Genre;
import fr.diginamic.Lieu;
import fr.diginamic.Pays;
import fr.diginamic.Role;

public class FilmDAO {

	
	/**Methode qui ajoute le Film mis en param dans la base mis aussi en param
	 * @param f Objet de type Film
	 * @param em EntityManager liée a une base
	 */
	public static void ajoutFilm(Films f, EntityManager em){	
			em.persist(f); 
	}
}
