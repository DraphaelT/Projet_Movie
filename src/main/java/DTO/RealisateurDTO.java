package DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RealisateurDTO {
	
	@JsonProperty("identite")
	private String identiteRea;
	
	@JsonProperty("url")
	private String urlRea;

	/** Getter pour l'attribut identite
	 * @return identite renvois identite 
	 */
	public String getIdentite() {
		return identiteRea;
	}

	/** Setter pour l'attribut identite
	 * @param identite the identite sauvegarde la valeur dans identite the identite  
	 */
	public void setIdentite(String identite) {
		this.identiteRea = identite;
	}

	/** Getter pour l'attribut url
	 * @return url renvois url 
	 */
	public String getUrl() {
		return urlRea;
	}

	/** Setter pour l'attribut url
	 * @param url the url sauvegarde la valeur dans url the url  
	 */
	public void setUrl(String url) {
		this.urlRea = url;
	}

	@Override
	public String toString() {
		return "RealisateurDTO [identite=" + identiteRea + ", url=" + urlRea + "]";
	}
	
	
	
}
