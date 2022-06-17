package tn.iit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "demandetirage")
public class DemandeTirage implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "date")
	private String date;
	
	@Column(name = "nombre_copie")
	private int nombreCopie;
	
	@Column(name = "id_enseignant")
	private int id_Enseignant;
	
	@Column(name = "id_document")
	private int idDocument;

	public DemandeTirage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemandeTirage( String date, int nombreCopie, int id_Enseignant, int idDocument) {
		super();
		this.date = date;
		this.nombreCopie = nombreCopie;
		this.id_Enseignant = id_Enseignant;
		this.idDocument = idDocument;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNombreCopie() {
		return nombreCopie;
	}

	public void setNombreCopie(int nombreCopie) {
		this.nombreCopie = nombreCopie;
	}

	public int getId_Enseignant() {
		return id_Enseignant;
	}

	public void setId_Enseignant(int id_Enseignant) {
		this.id_Enseignant = id_Enseignant;
	}

	public int getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(int idDocument) {
		this.idDocument = idDocument;
	}
	
	
	


}
