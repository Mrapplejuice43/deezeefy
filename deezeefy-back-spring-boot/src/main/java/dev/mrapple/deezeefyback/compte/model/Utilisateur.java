package dev.mrapple.deezeefyback.compte.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "user")
public class Utilisateur extends Compte {

    @Enumerated(EnumType.STRING)
    private Abonnement abonnement;
    private Integer tempsEcoute;

    public Utilisateur(String login,String password,String email,String nom,String prenom,String pseudo, Abonnement abonnement, Integer tempsEcoute) {
        this.setLogin(login);
        this.setPassword(password);
        this.setEmail(email);
        this.setNom(prenom);
        this.setPrenom(prenom);
        this.setPseudo(pseudo);
        this.abonnement = abonnement;
        this.tempsEcoute = tempsEcoute;
    }

    public Abonnement getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }

    public Integer getTempsEcoute() {
        return tempsEcoute;
    }

    public void setTempsEcoute(Integer tempsEcoute) {
        this.tempsEcoute = tempsEcoute;
    }

    @Override
    public String toString() {
        return String.format("Utilisateur %d : %s '%s' %s w/ tpsEcoute = %d s", getId(), getNom(), getPseudo(), getPrenom(), getTempsEcoute());
    }
    
}
