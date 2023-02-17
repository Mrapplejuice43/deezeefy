package formation.sopra.deezeefy.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "podcast")
public class Podcast extends Contenu{
    
    @Enumerated(EnumType.STRING)
    private Sujet sujet;

    public Podcast() {}

    public Podcast(String titre, Integer duree, Byte[] piste, Sujet sujet) {
        setTitre(titre);
        setDuree(duree);
        setPiste(piste);
        this.sujet = sujet;
    }

    @Override
    public String toString() {
        return String.format("Podcast : %s (%d s)", getTitre(), getDuree());
    }

	public Sujet getSujet() {
		return sujet;
	}

	public void setSujet(Sujet sujet) {
		this.sujet = sujet;
	}
}
