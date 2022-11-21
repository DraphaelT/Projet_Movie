package fr.diginamic;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Films")
public class Films {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom" , nullable = false, unique = true)
	private String nom;
	
	@Column(name = "plot" , nullable = false, unique = true)
	private String plot;
	
	@Column(name = "langue" , nullable = false, unique = true)
	private String langue;
	
	@Column(name = "anneeSortie" , nullable = false, unique = true)
	private Date anneeSortie;
	
	@ManyToOne
	@JoinColumn(name="ID_Pays")
	private Pays pay;
	
	@ManyToMany
	@JoinTable(name="FILM_ACTEUR", joinColumns = { @JoinColumn(name = "id_film") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_acteur") } )
	private ArrayList<Acteurs> acteurs = new ArrayList<Acteurs>();
	
	@ManyToMany
	@JoinTable(name="FILM_ROLE", joinColumns = { @JoinColumn(name = "id_film") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_role") } )
	private ArrayList<Role> roles = new ArrayList<Role>();
	
	@ManyToMany
	@JoinTable(name="FILM_LIEU", joinColumns = { @JoinColumn(name = "id_film") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_lieu") } )
	private ArrayList<Lieu> lieu = new ArrayList<Lieu>();
	
	@ManyToMany
	@JoinTable(name="FILM_PAYS", joinColumns = { @JoinColumn(name = "id_film") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_pays") } )
	private ArrayList<Pays> pays = new ArrayList<Pays>();
	
	@ManyToMany
	@JoinTable(name="FILM_REALISATEUR", joinColumns = { @JoinColumn(name = "id_film") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_realisateur") } )
	private ArrayList<Realisateur> Realisateurs = new ArrayList<Realisateur>();
	
	@ManyToMany
	@JoinTable(name="FILM_GENRE", joinColumns = { @JoinColumn(name = "id_film") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_genre") } )
	private ArrayList<Genre> genres = new ArrayList<Genre>();
}
