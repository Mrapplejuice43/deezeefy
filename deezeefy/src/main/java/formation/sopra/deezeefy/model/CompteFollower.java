package formation.sopra.deezeefy.model;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
public class CompteFollower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    private Integer version;
    private LocalDate dateAjout;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private Compte follower;

    @ManyToOne
    @JoinColumn(name = "compteSuivi_id")
    private Compte compteSuivi;

    public CompteFollower() {}

    public CompteFollower(LocalDate dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDate getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDate dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Compte getFollower() {
        return follower;
    }

    public void setFollower(Compte follower) {
        this.follower = follower;
    }

    public Compte getCompteSuivi() {
        return compteSuivi;
    }

    public void setCompteSuivi(Compte compteSuivi) {
        this.compteSuivi = compteSuivi;
    }

    @Override
    public String toString() {
        return "CompteFollower{" +
                "id=" + id +
                ", version=" + version +
                ", dateAjout=" + dateAjout +
                '}';
    }
}
