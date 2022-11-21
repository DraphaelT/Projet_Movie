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
	
	@Column(name = "ville" , nullable = false, unique = true)
	private String ville;
	
	@Column(name = "etatDept" , nullable = false, unique = true)
	private String etatDept;
	
	@ManyToOne
	@JoinColumn(name="ID_Pays")
	private Pays tournage;
}
