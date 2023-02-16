package formation.sopra.deezeefy.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "music")
public class Musique extends Contenu{

    @Enumerated(EnumType.STRING)
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
}
