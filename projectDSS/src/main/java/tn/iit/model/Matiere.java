package tn.iit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "matieres")
public class Matiere implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column( name="id_enseignant")
	private int idEnseignant ;
 
	
	public int getIdEnseignant() {
		return idEnseignant;
	}

	public void setIdEnseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	@Column(name = "nom_matiere")
	private String nomMatiere;

	public Matiere(int id, String nomMatiere) {
		super();
		this.id = id;
		this.nomMatiere = nomMatiere;
	}

	public Matiere(int id,int idEnseignant, String nomMatiere) {
		super();
		this.id = id;
		this.idEnseignant = idEnseignant;
		this.nomMatiere = nomMatiere;
	}

	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomMatiere() {
		return nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

}
