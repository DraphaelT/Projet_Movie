package fr.diginamic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom" , nullable = false)
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="ID_ACTEUR")
	private Acteurs acteur;

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

	/** Getter pour l'attribut acteur
	 * @return acteur renvois acteur 
	 */
	public Acteurs getActeur() {
		return acteur;
	}

	/** Setter pour l'attribut acteur
	 * @param acteur the acteur sauvegarde la valeur dans acteur the acteur  
	 */
	public void setActeur(Acteurs acteur) {
		this.acteur = acteur;
	}
	
	
	
}
