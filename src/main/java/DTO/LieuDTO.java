package DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LieuDTO {

	@JsonProperty("ville")
	private String nom;
	
	@JsonProperty("etatDept")
	private String etat;
	
	@JsonProperty("pays")
	private String pays;

	/** Setter pour l'attribut nom
	 * @param nom the nom sauvegarde la valeur dans nom the nom  
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Setter pour l'attribut etat
	 * @param etat the etat sauvegarde la valeur dans etat the etat  
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}

	/** Setter pour l'attribut pays
	 * @param pays the pays sauvegarde la valeur dans pays the pays  
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}
	

	/** Getter pour l'attribut nom
	 * @return nom renvois nom 
	 */
	public String getNom() {
		return nom;
	}

	/** Getter pour l'attribut etat
	 * @return etat renvois etat 
	 */
	public String getEtat() {
		return etat;
	}

	/** Getter pour l'attribut pays
	 * @return pays renvois pays 
	 */
	public String getPays() {
		return pays;
	}

	@Override
	public String toString() {
		return "LieuDTO [nom=" + nom + ", etat=" + etat + ", pays=" + pays + "]";
	}
	
	
}
