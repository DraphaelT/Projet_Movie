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

import DAO.ActeurDAO;
import DAO.FilmDAO;
import DAO.GenreDAO;
import DAO.LieuDAO;
import DAO.PaysDAO;
import DAO.RealisateurDAO;
import DAO.RoleDAO;
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
			
			FilmDAO.ajoutFilm(film, em);
			
			//Entre en Base des Lieux
			Lieu lieu = new Lieu();
			
			if(f.getLieu() != null ) {				
				if(!f.getLieu().getNom().equals(null)) {
					if(LieuDAO.existLieu(f.getLieu().getNom(), em) == null) {
	
						lieu.setVille(f.getLieu().getNom());
						lieu.setEtatDept(f.getLieu().getEtat());
						
						LieuDAO.ajoutLieu(lieu, em);
						em.persist(lieu);
					
					}else {
						lieu = LieuDAO.existLieu(f.getLieu().getNom(), em);
					}
					film.getLieu().add(lieu);
				}
				
			}
			
			//Entre en Base des Pays
					
			Pays pays = new Pays();
			
			if(f.getPays() != null ) {		
				if(PaysDAO.existePays(pays.getNom(), em) == null) {
					pays.setNom(f.getPays().getNom());
					pays.setUrl(f.getPays().getUrl());
					pays.getLieux().add(lieu);
					pays.getFilmsPays().add(film);
					film.setPay(pays);
					PaysDAO.ajoutPays(pays, em);
				}else {
					pays = PaysDAO.existePays(pays.getNom(), em);
				}
				film.setPay(pays);
			}
					
			//Entre en Base des Genres	

		
			for(String g : f.getGenres() ) {
				Genre genres = new Genre();	
				if(GenreDAO.existeGenre(g, em)==null) {		
					genres.setNom(g);
					GenreDAO.ajoutGenre(genres, em);; 
				}else {
					genres = GenreDAO.existeGenre(g, em);
				}
				film.getGenres().add(genres);
			}
			
			//Entre en Base des Realisateurs
			Realisateur real = new Realisateur();
			
			List<RealisateurDTO> listeReal = f.getRealis();
			
			for(RealisateurDTO r : listeReal) {
				if(RealisateurDAO.existeReal(r.getIdentite(), em) == null) {		
					real.setIdentite(r.getIdentite());
					real.setUrl(r.getUrl());
					RealisateurDAO.ajoutReal(real, em);
				}else {
					real = RealisateurDAO.existeReal(r.getIdentite(), em);
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
						
						switch (tabString.length) {
						case 1 :
							if(PaysDAO.existePays(tabString[tabString.length-1], em) == null) {
								pays.setNom(tabString[tabString.length-1]);
								PaysDAO.ajoutPays(pays, em);
							}else {
								pays = PaysDAO.existePays(tabString[tabString.length-1], em);
							}
							pays.getLieux().add(lieu);
						break;
						
						case 2 :
							lieu.setVille(tabString[tabString.length-2]);
							lieu.setEtatDept(null);
							if(PaysDAO.existePays(tabString[tabString.length-1], em) == null) {
								pays.setNom(tabString[tabString.length-1]);
								PaysDAO.ajoutPays(pays, em);
							}else {
								pays = PaysDAO.existePays(tabString[tabString.length-1], em);
							}
							pays.getLieux().add(lieu);
						break;
						
						default :
							lieu.setVille(tabString[tabString.length-3]);
							lieu.setEtatDept(tabString[tabString.length-2]);
							if(PaysDAO.existePays(tabString[tabString.length-1], em) == null) {
								pays.setNom(tabString[tabString.length-1]);
								PaysDAO.ajoutPays(pays, em);
							}else {
								pays = PaysDAO.existePays(tabString[tabString.length-1], em);
							}
							pays.getLieux().add(lieu);
						break;
					}
					LieuDAO.ajoutLieu(lieu, em);		
					acteur.setNaissance(lieu);		
					film.getActeurs().add(acteur);
					
					ActeurDAO.ajoutActeur(acteur, em);
							
					}
				}
			
			}
				
			//Entre en Base les Roles
			List<RoleDTO> listeRole = f.getRoles();
			
			for(RoleDTO r : listeRole) {
				Acteurs acteur = new Acteurs();
				Role role = new Role();					
				role.setNom(r.getNom());
				RoleDAO.ajoutRole(role, em);
				
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
							
							
							switch (tabString.length) {
							case 1 :
								if(PaysDAO.existePays(tabString[tabString.length-1], em) == null) {
									pays.setNom(tabString[tabString.length-1]);
									PaysDAO.ajoutPays(pays, em);
								}else {
									pays = PaysDAO.existePays(tabString[tabString.length-1], em);
								}
								pays.getLieux().add(lieu);
							break;
							
							case 2 :
								lieu.setVille(tabString[tabString.length-2]);
								lieu.setEtatDept(null);
								if(PaysDAO.existePays(tabString[tabString.length-1], em) == null) {
									pays.setNom(tabString[tabString.length-1]);
									PaysDAO.ajoutPays(pays, em);
								}else {
									pays = PaysDAO.existePays(tabString[tabString.length-1], em);
								}
								pays.getLieux().add(lieu);
							break;
							
							default :
								lieu.setVille(tabString[tabString.length-3]);
								lieu.setEtatDept(tabString[tabString.length-2]);
								if(PaysDAO.existePays(tabString[tabString.length-1], em) == null) {
									pays.setNom(tabString[tabString.length-1]);
									PaysDAO.ajoutPays(pays, em);
								}else {
									pays = PaysDAO.existePays(tabString[tabString.length-1], em);
								}
								pays.getLieux().add(lieu);
							break;
						}
						pays.getLieux().add(lieu);
					}
				}
				ActeurDAO.ajoutActeur(acteur, em);
				
			}
			role.setActeur(acteur);	
			}
		}		
		transaction.commit();
	}
}

