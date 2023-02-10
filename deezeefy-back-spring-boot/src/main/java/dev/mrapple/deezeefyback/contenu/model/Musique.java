package dev.mrapple.deezeefyback.contenu.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

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
