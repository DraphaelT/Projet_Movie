package DTO;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleDTO {

	@JsonProperty("characterName")
	private String nom;
	
	@JsonProperty("acteur")
	private ActeurDTO acteur;

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

	/** Getter pour l'attribut acteurs
	 * @return acteurs renvois acteurs 
	 */
	public ActeurDTO getActeur() {
		return acteur;
	}

	/** Setter pour l'attribut acteurs
	 * @param acteurs the acteurs sauvegarde la valeur dans acteurs the acteurs  
	 */
	public void setActeur(ActeurDTO acteur) {
		this.acteur = acteur;
	}

	@Override
	public String toString() {
		return "RoleDTO [nom=" + nom + ", acteurs=" + acteur + "]";
	}
	
	
}
