package model;

public class Musique extends Contenu {

	public Musique(int idcontenu, String titre, int duree) {
		super(idcontenu, titre, duree);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Musique [idcontenu=" + idcontenu + ", titre=" + titre + ", duree=" + duree + "]";
	}



}
