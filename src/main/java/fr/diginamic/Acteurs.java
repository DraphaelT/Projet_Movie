package fr.diginamic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="Acteurs")
public class Acteurs {

	@Id
	private String id;
	
	@Column(name = "identite" , nullable = false)
	private String identite;
	
	@Column(name = "height")
	private String height;
	
	@Column(name = "url")
	private String url;
	
	@OneToMany(mappedBy = "acteur")
	private List<Role> roles = new ArrayList<Role>();
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "dateNaissance")
	private Date dateNaissance;
	
	@OneToOne
	private Lieu naissance;

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

	/** Getter pour l'attribut identite
	 * @return identite renvois identite 
	 */
	public String getIdentite() {
		return identite;
	}

	/** Setter pour l'attribut identite
	 * @param identite the identite sauvegarde la valeur dans identite the identite  
	 */
	public void setIdentite(String identite) {
		this.identite = identite;
	}

	/** Getter pour l'attribut height
	 * @return height renvois height 
	 */
	public String getHeight() {
		return height;
	}

	/** Setter pour l'attribut height
	 * @param height the height sauvegarde la valeur dans height the height  
	 */
	public void setHeight(String height) {
		this.height = height;
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

	/** Getter pour l'attribut dateNaissance
	 * @return dateNaissance renvois dateNaissance 
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/** Setter pour l'attribut dateNaissance
	 * @param dateNaissance the dateNaissance sauvegarde la valeur dans dateNaissance the dateNaissance  
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/** Getter pour l'attribut naissance
	 * @return naissance renvois naissance 
	 */
	public Lieu getNaissance() {
		return naissance;
	}

	/** Setter pour l'attribut naissance
	 * @param naissance the naissance sauvegarde la valeur dans naissance the naissance  
	 */
	public void setNaissance(Lieu naissance) {
		this.naissance = naissance;
	}
	
	
}
