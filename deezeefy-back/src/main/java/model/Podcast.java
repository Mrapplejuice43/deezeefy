package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@DiscriminatorValue(value="Podcast")
public class Podcast extends Contenu {
	@Column(name="subject")
	@Enumerated(EnumType.STRING)
	private Sujet sujet;

	public Podcast() {
		super();
	}

	public Podcast(int idcontenu, String titre, int duree) {
		super(idcontenu, titre, duree);
		// TODO Auto-generated constructor stub
	}

	
	public Sujet getSujet() {
		return sujet;
	}

	public void setSujet(Sujet sujet) {
		this.sujet = sujet;
	}

	@Override
	public String toString() {
		return "Podcast [idcontenu=" + idcontenu + ", titre=" + titre + ", duree=" + duree + "]";
	}

	

}
