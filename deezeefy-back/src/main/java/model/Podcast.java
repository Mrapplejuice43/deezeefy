package model;

public class Podcast extends Contenu {

	public Podcast(int idcontenu, String titre, int duree) {
		super(idcontenu, titre, duree);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Podcast [idcontenu=" + idcontenu + ", titre=" + titre + ", duree=" + duree + "]";
	}

	

}
