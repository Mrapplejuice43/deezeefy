package model;

import java.time.LocalDate;

public class Historique {
	
	private int ID;
	private int version;
	private LocalDate dateDerniereEcoute;
	private int nombreEcoutes;
	private Compte compte;
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
