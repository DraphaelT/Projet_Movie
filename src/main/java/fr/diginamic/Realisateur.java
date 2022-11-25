package fr.diginamic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Realisateur")
public class Realisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "identite" , nullable = false/*, unique = true*/)
	private String identite;
	
	@Column(name = "url")
	private String url;

	/** Getter pour l'attribut id
	 * @return id renvois id 
	 */
	public Integer getId() {
		return id;
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
	
	
	
	
	
}
