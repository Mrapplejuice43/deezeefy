package dev.mrapple.deezeefyback.compte.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "admin")
public class Admin extends Compte {

    public Admin() {super();}

    public Admin(String login,String password,String email,String nom,String prenom,String pseudo) {
        this.setLogin(login);
        this.setPassword(password);
        this.setEmail(email);
        this.setNom(prenom);
        this.setPrenom(prenom);
        this.setPseudo(pseudo);
    }

    @Override
    public String toString() {
        return String.format("Admin %d : %s '%s' %s", getId(), getNom(), getPseudo(), getPrenom());
    }
}
