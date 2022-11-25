package DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NaissanceDTO {
	
	@JsonDeserialize(using = CDate.class)
	private Date dateNaissance;
	
	@JsonProperty("lieuNaissance")
	private String lieuNaissance;

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

	/** Getter pour l'attribut lieuNaissance
	 * @return lieuNaissance renvois lieuNaissance 
	 */
	public String getLieuNaissance() {
		return lieuNaissance;
	}

	/** Setter pour l'attribut lieuNaissance
	 * @param lieuNaissance the lieuNaissance sauvegarde la valeur dans lieuNaissance the lieuNaissance  
	 */
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	@Override
	public String toString() {
		return "NaissanceDTO [dateNaissance=" + dateNaissance + ", lieuNaissance=" + lieuNaissance + "]";
	}
	
	
}
