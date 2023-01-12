package model;

import java.time.LocalDate;

public abstract class MusicList {
	
	protected Compte compte;
	protected int id;
	

	protected String titre;
	protected int duree; // seconde
	protected LocalDate date;
	protected int nbContenu ;
	protected Contenu contenu; // 
	protected String pays;
	

	public MusicList(Compte compte, int id, String titre, int duree, LocalDate date, int nbContenu, Contenu contenu,
			String pays) {
		super();
		this.compte = compte;
		this.id = id;
		this.titre = titre;
		this.duree = duree;
		this.date = date;
		this.nbContenu = nbContenu;
		this.contenu = contenu;
		this.pays = pays;
	}



	public MusicList() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Compte getCompte() {
		return compte;
	}


	public void setCompte(Compte compte) {
		this.compte = compte;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public int getNbContenu() {
		return nbContenu;
	}


	public void setNbContenu(int nbContenu) {
		this.nbContenu = nbContenu;
	}


	public Contenu getContenu() {
		return contenu;
	}


	public void setContenu(Contenu contenu) {
		this.contenu = contenu;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}



}
