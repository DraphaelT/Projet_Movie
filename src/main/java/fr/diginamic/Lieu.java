package fr.diginamic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Lieu")
public class Lieu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ville" )
	private String ville;
	
	@Column(name = "etatDept")
	private String etatDept;
	
	@ManyToOne
	@JoinColumn(name="ID_Pays")
	private Pays tournage;

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

	/** Getter pour l'attribut ville
	 * @return ville renvois ville 
	 */
	public String getVille() {
		return ville;
	}

	/** Setter pour l'attribut ville
	 * @param ville the ville sauvegarde la valeur dans ville the ville  
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/** Getter pour l'attribut etatDept
	 * @return etatDept renvois etatDept 
	 */
	public String getEtatDept() {
		return etatDept;
	}

	/** Setter pour l'attribut etatDept
	 * @param etatDept the etatDept sauvegarde la valeur dans etatDept the etatDept  
	 */
	public void setEtatDept(String etatDept) {
		this.etatDept = etatDept;
	}

	/** Getter pour l'attribut tournage
	 * @return tournage renvois tournage 
	 */
	public Pays getTournage() {
		return tournage;
	}

	/** Setter pour l'attribut tournage
	 * @param tabString the tournage sauvegarde la valeur dans tournage the tournage  
	 */
	public void setTournage(Pays tabString) {
		this.tournage = tabString;
	}
	
	
}
