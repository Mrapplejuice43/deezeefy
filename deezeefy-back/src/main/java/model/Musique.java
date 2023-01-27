package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@DiscriminatorValue(value="Music")
public class Musique extends Contenu {
	@Column(name="music_genre")
	@Enumerated(EnumType.STRING)
	private Genre genre;

	public Musique(int idcontenu, String titre, int duree) {
		super(idcontenu, titre, duree);
	}


	public Musique() {
		super();
	}



	public Genre getGenre() {
		return genre;
	}



	public void setGenre(Genre genre) {
		this.genre = genre;
	}



	@Override
	public String toString() {
		return "Musique [idcontenu=" + idcontenu + ", titre=" + titre + ", duree=" + duree + "]";
	}



}
