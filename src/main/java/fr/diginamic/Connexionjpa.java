package fr.diginamic;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import DAO.GenreDAO;
import DTO.ActeurDTO;
import DTO.FilmDTO;
import DTO.RealisateurDTO;
import DTO.RoleDTO;
import DTO.Traitement;

public class Connexionjpa {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("movieproject");
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		ArrayList<FilmDTO> listeFilms = Traitement.lireFichier();
	
		for(FilmDTO f : listeFilms) {
			
			//Entre en base des Films
		
			Films film = new Films();
			film.setId(f.getId());
			film.setNom(f.getNom());
			if(f.getResume() != null) {
				film.setPlot(f.getResume());
			}
			film.setLangue(f.getLangue());		
			film.setAnneeSortie(f.getDateSortie());
			
			em.persist(film);
			
			//Entre en Base des Lieux
			Lieu lieu = new Lieu();
			TypedQuery<Lieu> queryLieu = em.createQuery("select l from Lieu l where l.ville=:nomLieu", Lieu.class);
			if(f.getLieu() != null ) {
				queryLieu.setParameter("nomLieu", f.getLieu().getNom()); 
				
				if(!f.getLieu().getNom().equals(null)) {
					if(queryLieu.getResultList().size() == 0) {
	
						lieu.setVille(f.getLieu().getNom());
						lieu.setEtatDept(f.getLieu().getEtat());
										
						em.persist(lieu);
					
					}else {
						lieu = queryLieu.getResultList().get(0);
					}
					film.getLieu().add(lieu);
				}
				
			}
			
			//Entre en Base des Pays
			TypedQuery<Pays> queryPays = em.createQuery("select p from Pays p where p.nom=:nomPays", Pays.class);
			
			Pays pays = new Pays();
			
			if(f.getPays() != null ) {
				queryPays.setParameter("nomPays", f.getPays().getNom()); 
				if(queryPays.getResultList().size() == 0) {
					pays.setNom(f.getPays().getNom());
					pays.setUrl(f.getPays().getUrl());
					pays.getLieux().add(lieu);
					pays.getFilmsPays().add(film);
					film.setPay(pays);
					em.persist(pays);
				}else {
					pays = queryPays.getResultList().get(0);
				}
				film.setPay(pays);
			}
					
			//Entre en Base des Genres	
			//TypedQuery<Genre> queryGenre= em.createQuery("select h from Genre h where h.nom=:nomGenre", Genre.class);
		
			for(String g : f.getGenres() ) {
				Genre genres = new Genre();
				//queryGenre.setParameter("nomGenre", g); 
				
				if(GenreDAO.existeGenre(g, em)==null) {		
					genres.setNom(g);
					GenreDAO.ajoutGenre(genres, em);; 
				}else {
					genres = GenreDAO.existeGenre(g, em);
				}
				film.getGenres().add(genres);
			}
			
			//Entre en Base des Realisateurs
			TypedQuery<Realisateur> queryReal = em.createQuery("select r from Realisateur r where r.identite=:nomRea", Realisateur.class);
			Realisateur real = new Realisateur();
			
			List<RealisateurDTO> listeReal = f.getRealis();
			for(RealisateurDTO r : listeReal) {
				queryReal.setParameter("nomRea", r.getIdentite()); 
				if(queryReal.getResultList().size() == 0) {		
					real.setIdentite(r.getIdentite());
					real.setUrl(r.getUrl());
					em.persist(real);
				}else {
					real = queryReal.getResultList().get(0);
				}
				film.getRealisateurs().add(real);
			}
			
			
			//Entre en Base des Acteurs
			
			List<ActeurDTO> listeActeur = f.getActeurPrincipals();
			for(ActeurDTO a : listeActeur) {
				Acteurs acteur = new Acteurs();
				if(em.find(Acteurs.class, a.getId()) == null) {
					acteur.setId(a.getId());
					acteur.setIdentite(a.getIdentite());
					acteur.setHeight(a.getHeight());
					acteur.setUrl(a.getUrl());
			
					acteur.setDateNaissance(a.getNaissance().getDateNaissance());
					
					if(a.getNaissance().getLieuNaissance() != "") {
						String[] tabString = a.getNaissance().getLieuNaissance().split(", ");
						queryPays.setParameter("nomPays", tabString[tabString.length-1]); 
						
						switch (tabString.length) {
						case 1 :
							if(queryPays.getResultList().size() == 0) {
								pays.setNom(tabString[tabString.length-1]);
								em.persist(pays);
							}else {
								pays = queryPays.getResultList().get(0);
							}
							pays.getLieux().add(lieu);
						break;
						
						case 2 :
							lieu.setVille(tabString[tabString.length-2]);
							lieu.setEtatDept(null);
							if(queryPays.getResultList().size() == 0) {
								pays.setNom(tabString[tabString.length-1]);
								em.persist(pays);
							}else {
								pays = queryPays.getResultList().get(0);
							}
							pays.getLieux().add(lieu);
						break;
						
						default :
							lieu.setVille(tabString[tabString.length-3]);
							lieu.setEtatDept(tabString[tabString.length-2]);
							if(queryPays.getResultList().size() == 0) {
								pays.setNom(tabString[tabString.length-1]);
								em.persist(pays);
							}else {
								pays = queryPays.getResultList().get(0);
							}
							pays.getLieux().add(lieu);
						break;
					}
					em.persist(lieu);		
					acteur.setNaissance(lieu);		
					film.getActeurs().add(acteur);
					
					em.persist(acteur);	
							
					}
				}
			
			}
				
			//Entre en Base les Roles
			List<RoleDTO> listeRole = f.getRoles();
			
			for(RoleDTO r : listeRole) {
				Acteurs acteur = new Acteurs();
				Role role = new Role();					
				role.setNom(r.getNom());
				em.persist(role);
				
				film.getRoles().add(role);						
				if(em.find(Acteurs.class, r.getActeur().getId()) != null) {
					acteur = em.find(Acteurs.class, r.getActeur().getId());	
				}else {
					//Creation d'un acteur s'il n'existe pas
					acteur.setId(r.getActeur().getId());
					acteur.setIdentite(r.getActeur().getIdentite());
					acteur.setUrl(r.getActeur().getUrl());
					if(r.getActeur().getNaissance() != null) {
						acteur.setDateNaissance(r.getActeur().getNaissance().getDateNaissance());					
						if(r.getActeur().getNaissance().getLieuNaissance() != "") {
							String[] tabString = r.getActeur().getNaissance().getLieuNaissance().split(", ");
							queryPays.setParameter("nomPays", tabString[tabString.length-1]); 
							
							switch (tabString.length) {
							case 1 :
								if(queryPays.getResultList().size() == 0) {
									pays.setNom(tabString[tabString.length-1]);
									em.persist(pays);
								}else {
									pays = queryPays.getResultList().get(0);
								}
								pays.getLieux().add(lieu);
							break;
							
							case 2 :
								lieu.setVille(tabString[tabString.length-2]);
								lieu.setEtatDept(null);
								if(queryPays.getResultList().size() == 0) {
									pays.setNom(tabString[tabString.length-1]);
									em.persist(pays);
								}else {
									pays = queryPays.getResultList().get(0);
								}
								pays.getLieux().add(lieu);
							break;
							
							default :
								lieu.setVille(tabString[tabString.length-3]);
								lieu.setEtatDept(tabString[tabString.length-2]);
								if(queryPays.getResultList().size() == 0) {
									pays.setNom(tabString[tabString.length-1]);
									em.persist(pays);
								}else {
									pays = queryPays.getResultList().get(0);
								}
								pays.getLieux().add(lieu);
							break;
						}
						pays.getLieux().add(lieu);
					}
				}
				em.persist(acteur);
				
			}
			role.setActeur(acteur);	
			}
		}		
		transaction.commit();
	}
}

