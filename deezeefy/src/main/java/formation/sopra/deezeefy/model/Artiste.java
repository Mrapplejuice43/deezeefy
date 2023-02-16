package formation.sopra.deezeefy.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
@DiscriminatorValue(value = "artist")
public class Artiste extends Compte {
    
    private Integer nbAuditeur;
    private String biographie;

    @OneToMany(mappedBy = "auteur")
    private List<Contenu> listeContenu;

    public Artiste() {}

    public Artiste(String login,String password,String email,String nom,String prenom,String pseudo, Integer nbAuditeur, String biographie) {
        this.setLogin(login);
        this.setPassword(password);
        this.setEmail(email);
        this.setNom(prenom);
        this.setPrenom(prenom);
        this.setPseudo(pseudo);
        this.nbAuditeur = nbAuditeur;
        this.biographie = biographie;
    }

    public Integer getNbAuditeur() {
        return nbAuditeur;
    }

    public void setNbAuditeur(Integer nbAuditeur) {
        this.nbAuditeur = nbAuditeur;
    }

    public String getBiographie() {
        return biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }

    public List<Contenu> getListeContenu() {
        return listeContenu;
    }

    public void setListeContenu(List<Contenu> listeContenu) {
        this.listeContenu = listeContenu;
    }

    @Override
    public String toString() {
        return String.format("Artiste %d : %s '%s' %s w/ %d auditeurs", getId(), getNom(), getPseudo(), getPrenom(), getNbAuditeur());
    }
}
