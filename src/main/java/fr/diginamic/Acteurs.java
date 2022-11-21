package fr.diginamic;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Additifs")
public class Acteurs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "identite" , nullable = false, unique = true)
	private String identite;
	
	@Column(name = "height")
	private int height;
	
	@Column(name = "url")
	private String url;
	
	@OneToMany(mappedBy = "acteur")
	private ArrayList<Role> roles = new ArrayList<Role>();
	
	@OneToOne
	private Lieu naissance;
}
