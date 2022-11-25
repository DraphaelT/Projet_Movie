package fr.diginamic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Pays")
public class Pays {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "url")
	private String url;
	
	@OneToMany(mappedBy = "tournage")
	private List<Lieu> lieux = new ArrayList<Lieu>();
	
	@OneToMany(mappedBy = "pay")
	private List<Films> filmsPays = new ArrayList<Films>();

	/** Getter pour l'attribut id
	 * @return id renvois id 
	 */
	public Integer getId() {
		return id;
	}

	/** Setter pour l'attribut id
	 * @param id the id sauvegarde la valeur dans id the id  
	 */
	public void setId(Integer id) {
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

	/** Getter pour l'attribut url
	 * @return url renvois url 
	 */
	public String getUrl() {
		return url;
	}

	/** Setter pour l'attribut url
	 * @param url the url sauvegarde la valeur dans url the url  
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/** Getter pour l'attribut lieux
	 * @return lieux renvois lieux 
	 */
	public List<Lieu> getLieux() {
		return lieux;
	}

	/** Setter pour l'attribut lieux
	 * @param lieux the lieux sauvegarde la valeur dans lieux the lieux  
	 */
	public void setLieux(List<Lieu> lieux) {
		this.lieux = lieux;
	}

	/** Getter pour l'attribut filmsPays
	 * @return filmsPays renvois filmsPays 
	 */
	public List<Films> getFilmsPays() {
		return filmsPays;
	}

	/** Setter pour l'attribut filmsPays
	 * @param filmsPays the filmsPays sauvegarde la valeur dans filmsPays the filmsPays  
	 */
	public void setFilmsPays(List<Films> filmsPays) {
		this.filmsPays = filmsPays;
	}
	
	
	
}
