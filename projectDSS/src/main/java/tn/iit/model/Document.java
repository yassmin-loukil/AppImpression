package tn.iit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class Document implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "nom_document")
	private String nomDocument;
	
	@Column(name = "id_matiere")
	private String idMatiere;

	public Document(int id, String nomDocument, String idMatiere) {
		super();
		this.id = id;
		this.nomDocument = nomDocument;
		this.idMatiere = idMatiere;
	}

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomDocument() {
		return nomDocument;
	}

	public void setNomDocument(String nomDocument) {
		this.nomDocument = nomDocument;
	}

	public String getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(String idMatiere) {
		this.idMatiere = idMatiere;
	}

}
