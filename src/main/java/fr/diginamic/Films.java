package fr.diginamic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private String id;
	
	@Column(name = "nom" , nullable = false)
	private String nom;
	
	@Column(name = "plot")
	private String plot;
	
	@Column(name = "langue" )
	private String langue;
	
	@Column(name = "anneeSortie")
	private String anneeSortie;
	
	@ManyToOne
	@JoinColumn(name="ID_Pays")
	private Pays pay;
	
	@ManyToMany
	@JoinTable(name="FILM_ACTEUR", joinColumns = { @JoinColumn(name = "id_film") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_acteur") } )
	private List<Acteurs> acteurs = new ArrayList<Acteurs>();
	
	@ManyToMany
	@JoinTable(name="FILM_ROLE", joinColumns = { @JoinColumn(name = "id_film") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_role") } )
	private List<Role> roles = new ArrayList<Role>();
	
	@ManyToMany
	@JoinTable(name="FILM_LIEU", joinColumns = { @JoinColumn(name = "id_film") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_lieu") } )
	private List<Lieu> lieu = new ArrayList<Lieu>();
	/*
	@ManyToMany
	@JoinTable(name="FILM_PAYS", joinColumns = { @JoinColumn(name = "id_film") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_pays") } )
	private List<Pays> pays = new ArrayList<Pays>();
	*/
	@ManyToMany
	@JoinTable(name="FILM_REALISATEUR", joinColumns = { @JoinColumn(name = "id_film") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_realisateur") } )
	private List<Realisateur> Realisateurs = new ArrayList<Realisateur>();
	
	@ManyToMany
	@JoinTable(name="FILM_GENRE", joinColumns = { @JoinColumn(name = "id_film") }, 
    inverseJoinColumns = { @JoinColumn(name = "id_genre") } )
	private List<Genre> genres = new ArrayList<Genre>();

	/** Getter pour l'attribut id
	 * @return id renvois id 
	 */
	public String getId() {
		return id;
	}

	/** Setter pour l'attribut id
	 * @param id the id sauvegarde la valeur dans id the id  
	 */
	public void setId(String id) {
		this.id = id;
	}

	/** Getter pour l'attribut nom
	 * @return nom renvois nom 
	 */
	public String getNom() {
		return nom;
	}

	/** Setter pour l'attribut nom
	 * @param nom the nom sauvegarde la valeur dans nom the nom  
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter pour l'attribut plot
	 * @return plot renvois plot 
	 */
	public String getPlot() {
		return plot;
	}

	/** Setter pour l'attribut plot
	 * @param plot the plot sauvegarde la valeur dans plot the plot  
	 */
	public void setPlot(String plot) {
		this.plot = plot;
	}

	/** Getter pour l'attribut langue
	 * @return langue renvois langue 
	 */
	public String getLangue() {
		return langue;
	}

	/** Setter pour l'attribut langue
	 * @param langue the langue sauvegarde la valeur dans langue the langue  
	 */
	public void setLangue(String langue) {
		this.langue = langue;
	}

	/** Getter pour l'attribut anneeSortie
	 * @return anneeSortie renvois anneeSortie 
	 */
	public String getAnneeSortie() {
		return anneeSortie;
	}

	/** Setter pour l'attribut anneeSortie
	 * @param string the anneeSortie sauvegarde la valeur dans anneeSortie the anneeSortie  
	 */
	public void setAnneeSortie(String string) {
		this.anneeSortie = string;
	}

	/** Getter pour l'attribut pay
	 * @return pay renvois pay 
	 */
	public Pays getPay() {
		return pay;
	}

	/** Setter pour l'attribut pay
	 * @param pay the pay sauvegarde la valeur dans pay the pay  
	 */
	public void setPay(Pays pay) {
		this.pay = pay;
	}

	/** Getter pour l'attribut acteurs
	 * @return acteurs renvois acteurs 
	 */
	public List<Acteurs> getActeurs() {
		return acteurs;
	}

	/** Setter pour l'attribut acteurs
	 * @param acteurs the acteurs sauvegarde la valeur dans acteurs the acteurs  
	 */
	public void setActeurs(List<Acteurs> acteurs) {
		this.acteurs = acteurs;
	}

	/** Getter pour l'attribut roles
	 * @return roles renvois roles 
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/** Setter pour l'attribut roles
	 * @param roles the roles sauvegarde la valeur dans roles the roles  
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/** Getter pour l'attribut lieu
	 * @return lieu renvois lieu 
	 */
	public List<Lieu> getLieu() {
		return lieu;
	}

	/** Setter pour l'attribut lieu
	 * @param lieu the lieu sauvegarde la valeur dans lieu the lieu  
	 */
	public void setLieu(List<Lieu> lieu) {
		this.lieu = lieu;
	}

	

	/** Getter pour l'attribut realisateurs
	 * @return realisateurs renvois realisateurs 
	 */
	public List<Realisateur> getRealisateurs() {
		return Realisateurs;
	}

	/** Setter pour l'attribut realisateurs
	 * @param realisateurs the realisateurs sauvegarde la valeur dans realisateurs the realisateurs  
	 */
	public void setRealisateurs(List<Realisateur> realisateurs) {
		Realisateurs = realisateurs;
	}

	/** Getter pour l'attribut genres
	 * @return genres renvois genres 
	 */
	public List<Genre> getGenres() {
		return genres;
	}

	/** Setter pour l'attribut genres
	 * @param genres the genres sauvegarde la valeur dans genres the genres  
	 */
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	
	
	
}
