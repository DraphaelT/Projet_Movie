package DTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmDTO {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("pays")
	private PaysDTO pays;
	
	@JsonProperty("nom")
	private String nom;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("plot")
	private String resume;
	
	@JsonProperty("langue")
	private String langue;
	
	@JsonProperty("lieuTournage")
	private LieuDTO lieu;

	@JsonProperty("realisateurs")
	private List<RealisateurDTO> realis;
	
	@JsonProperty("castingPrincipal")
	private ArrayList<ActeurDTO> acteurPrincipals;
	
	@JsonProperty("anneeSortie")
	private String dateSortie;
	
	@JsonProperty("roles")
	private ArrayList<RoleDTO> roles;
	
	@JsonProperty("genres")
	private ArrayList<String> genres;
	
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

	/** Getter pour l'attribut pays
	 * @return pays renvois pays 
	 */
	public PaysDTO getPays() {
		return pays;
	}

	/** Setter pour l'attribut pays
	 * @param pays the pays sauvegarde la valeur dans pays the pays  
	 */
	public void setPays(PaysDTO pays) {
		this.pays = pays;
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

	/** Getter pour l'attribut resume
	 * @return resume renvois resume 
	 */
	public String getResume() {
		return resume;
	}

	/** Setter pour l'attribut resume
	 * @param resume the resume sauvegarde la valeur dans resume the resume  
	 */
	public void setResume(String resume) {
		this.resume = resume;
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

	/** Getter pour l'attribut lieu
	 * @return lieu renvois lieu 
	 */
	public LieuDTO getLieu() {
		return lieu;
	}

	/** Setter pour l'attribut lieu
	 * @param lieu the lieu sauvegarde la valeur dans lieu the lieu  
	 */
	public void setLieu(LieuDTO lieu) {
		this.lieu = lieu;
	}

	/** Getter pour l'attribut acteurPrincipals
	 * @return acteurPrincipals renvois acteurPrincipals 
	 */
	public ArrayList<ActeurDTO> getActeurPrincipals() {
		return acteurPrincipals;
	}

	/** Setter pour l'attribut acteurPrincipals
	 * @param acteurPrincipals the acteurPrincipals sauvegarde la valeur dans acteurPrincipals the acteurPrincipals  
	 */
	public void setActeurPrincipals(ArrayList<ActeurDTO> acteurPrincipals) {
		this.acteurPrincipals = acteurPrincipals;
	}

	/** Getter pour l'attribut dateSortie
	 * @return dateSortie renvois dateSortie 
	 */
	public String getDateSortie() {
		return dateSortie;
	}

	/** Setter pour l'attribut dateSortie
	 * @param dateSortie the dateSortie sauvegarde la valeur dans dateSortie the dateSortie  
	 */
	public void setDateSortie(String dateSortie) {
		this.dateSortie = dateSortie;
	}

	/** Getter pour l'attribut genres
	 * @return genres renvois genres 
	 */
	public ArrayList<String> getGenres() {
		return genres;
	}

	/** Setter pour l'attribut genres
	 * @param genres the genres sauvegarde la valeur dans genres the genres  
	 */
	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
	}

	
	
	/** Getter pour l'attribut realis
	 * @return realis renvois realis 
	 */
	public List<RealisateurDTO> getRealis() {
		return realis;
	}

	/** Setter pour l'attribut realis
	 * @param realis the realis sauvegarde la valeur dans realis the realis  
	 */
	public void setRealis(List<RealisateurDTO> realis) {
		this.realis = realis;
	}

	/** Getter pour l'attribut roles
	 * @return roles renvois roles 
	 */
	public ArrayList<RoleDTO> getRoles() {
		return roles;
	}

	/** Setter pour l'attribut roles
	 * @param roles the roles sauvegarde la valeur dans roles the roles  
	 */
	public void setRoles(ArrayList<RoleDTO> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "FilmDTO [id=" + id + ", pays=" + pays + ", nom=" + nom + ", url=" + url + ", resume=" + resume
				+ ", langue=" + langue + ", lieu=" + lieu + ", realis=" + realis + ", acteurPrincipals="
				+ acteurPrincipals + ", dateSortie=" + dateSortie + ", roles=" + roles + ", genres=" + genres + "]";
	}

	
}
