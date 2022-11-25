package DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaysDTO {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("nom")
	private String nom;
	
	@JsonProperty("url")
	private String url;

	/** Getter pour l'attribut id
	 * @return id renvois id 
	 */
	public String getId() {
		return id;
	}

	/** Getter pour l'attribut nom
	 * @return nom renvois nom 
	 */
	public String getNom() {
		return nom;
	}

	/** Getter pour l'attribut url
	 * @return url renvois url 
	 */
	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "PaysDTO [id=" + id + ", nom=" + nom + ", url=" + url + "]";
	}
	
	
}
