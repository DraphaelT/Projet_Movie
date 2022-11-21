package fr.diginamic;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Lieu")
public class Pays {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom" , nullable = false, unique = true)
	private String nom;
	
	@Column(name = "url" , nullable = false, unique = true)
	private String url;
	
	@OneToMany(mappedBy = "lieux")
	private ArrayList<Lieu> lieux = new ArrayList<Lieu>();
	
	@OneToMany(mappedBy = "pay")
	private ArrayList<Films> filmsPays = new ArrayList<Films>();
	
	
	
}
