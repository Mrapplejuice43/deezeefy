package formation.sopra.deezeefy.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "music")
public class Musique extends Contenu{

    @Enumerated(EnumType.STRING)
    @JsonView(Views.ViewMusique.class)
    private Genre genre;
    
    public Musique() {}

    public Musique(String titre, Integer duree, Byte[] piste, Genre genre) {
        setTitre(titre);
        setDuree(duree);
        setPiste(piste);
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("Musique : %s (%d s)", getTitre(), getDuree());
    }

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
}
