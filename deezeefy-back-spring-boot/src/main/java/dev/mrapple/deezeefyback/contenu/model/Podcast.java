package dev.mrapple.deezeefyback.contenu.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

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
}
