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
	
	@Column(name = "nom" , nullable = false, unique = true)
	private String nom;
	
	@ManyToOne
	@JoinColumn(name="ID_ACTEUR")
	private Acteurs acteur;
	
	@ManyToOne
	@JoinColumn(name="ID_FILM")
	private Films film;
}
