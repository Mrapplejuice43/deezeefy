package formation.sopra.deezeefy.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "admin")
@JsonTypeName("admin")
public class Admin extends Compte {

    public Admin() {super();}

    public Admin(String login,String password,String email,String nom,String prenom,String pseudo) {
        this.setLogin(login);
        this.setPassword(password);
        this.setEmail(email);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setPseudo(pseudo);
    }

    @Override
    public String toString() {
        return String.format("Admin %d : %s '%s' %s", getId(), getNom(), getPseudo(), getPrenom());
    }
}
