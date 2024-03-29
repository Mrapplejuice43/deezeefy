package formation.sopra.deezeefy.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "user")
@JsonTypeName("user")
public class Utilisateur extends Compte {

    @Enumerated(EnumType.STRING)
    @JsonView(Views.ViewBase.class)
    private Abonnement abonnement;
    @JsonView(Views.ViewBase.class)
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
    
    public Utilisateur()
    {
    	super();
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
