package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "history")
public class Historique {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ID;
	
	@Version
	private int version;
	@Column(name = "date_last_listenings")
	private LocalDate dateDerniereEcoute;
	@Column(name= "listenings")
	private int nombreEcoutes;
	@ManyToOne
	@JoinColumn(name ="account_id")
	private Compte compte;
	@ManyToOne
	@JoinColumn(name ="content_id")
	private Contenu contenu;
	
	public Historique() {
		super();
	}

	
	
	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public LocalDate getDateDerniereEcoute() {
		return dateDerniereEcoute;
	}

	public void setDateDerniereEcoute(LocalDate dateDerniereEcoute) {
		this.dateDerniereEcoute = dateDerniereEcoute;
	}

	public int getNombreEcoutes() {
		return nombreEcoutes;
	}

	public void setNombreEcoutes(int nombreEcoutes) {
		this.nombreEcoutes = nombreEcoutes;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Contenu getContenu() {
		return contenu;
	}

	public void setContenu(Contenu contenu) {
		this.contenu = contenu;
	}
	
	

}
