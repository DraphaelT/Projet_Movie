package DTO;

import java.util.ArrayList;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActeurDTO {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("identite")
	private String identite;
	
	@JsonProperty("naissance")
	private NaissanceDTO naissance;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("height")
	private String height;
	
	@JsonProperty("roles")
	private ArrayList<String> role = new ArrayList<String>();


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
	public ArrayList<String> getRole() {
		return role;
	}

	/** Setter pour l'attribut roles
	 * @param roles the roles sauvegarde la valeur dans roles the roles  
	 */
	public void setRoles(ArrayList<String> role) {
		this.role = role;
	}

	/** Getter pour l'attribut naissance
	 * @return naissance renvois naissance 
	 */
	public NaissanceDTO getNaissance() {
		return naissance;
	}

	/** Setter pour l'attribut naissance
	 * @param naissance the naissance sauvegarde la valeur dans naissance the naissance  
	 */
	public void setNaissance(NaissanceDTO naissance) {
		this.naissance = naissance;
	}

	@Override
	public String toString() {
		return "ActeurDTO [id=" + id + ", identite=" + identite + ", naissance=" + naissance + ", url=" + url
				+ ", height=" + height + ", role=" + role + "]";
	}

	

	
	
}
