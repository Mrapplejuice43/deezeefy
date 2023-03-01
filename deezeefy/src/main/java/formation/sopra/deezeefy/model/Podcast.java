package formation.sopra.deezeefy.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "podcast")
@JsonTypeName("podcast")
public class Podcast extends Contenu{
    
    @Enumerated(EnumType.STRING)
    @JsonView(Views.ViewPodcast.class)
    private Sujet sujet;

    public Podcast() {}

    public Podcast(String titre, Integer duree, Byte[] piste, Sujet sujet) {
        setTitre(titre);
        setDuree(duree);
        setPiste(piste);
        this.sujet = sujet;
    }

    public Sujet getSujet() {
        return sujet;
    }

    public void setSujet(Sujet sujet) {
        this.sujet = sujet;
    }

    @Override
    public String toString() {
        return String.format("Podcast : %s (%d s)", getTitre(), getDuree());
    }
}
