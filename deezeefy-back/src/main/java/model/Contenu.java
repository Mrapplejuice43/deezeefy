package model;

public abstract class Contenu {

	protected int idcontenu;
	protected String titre;
	protected int duree;
	 
	
	public Contenu(int idcontenu, String titre, int duree) {
		super();
		this.idcontenu = idcontenu;
		this.titre = titre;
		this.duree = duree;
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
