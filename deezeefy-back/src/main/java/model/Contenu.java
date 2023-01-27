package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="content")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public abstract class Contenu {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	protected int idcontenu;
	
	@Column(name= "title", length= 200)
	protected String titre;
	
	@Column(name = "time", length=4)
	protected int duree;
	
	@ManyToOne
	@JoinColumn(name = "artist_id")
	protected Artiste auteur;
	 
	
	
	
	public Contenu() {
		super();
	}


	public Contenu(int idcontenu, String titre, int duree) {
		super();
		this.idcontenu = idcontenu;
		this.titre = titre;
		this.duree = duree;
	}

	

	public Artiste getAuteur() {
		return auteur;
	}


	public void setAuteur(Artiste auteur) {
		this.auteur = auteur;
	}


	public int getIdcontenu() {
		return idcontenu;
	}


	public String getTitre() {
		return titre;
	}


	public int getDuree() {
		return duree;
	}


	public void setIdcontenu(int idcontenu) {
		this.idcontenu = idcontenu;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	@Override
	public String toString() {
		return "Contenu [idcontenu=" + idcontenu + ", titre=" + titre + ", duree=" + duree + "]";
	}



}
