package formation.sopra.deezeefy.model;


import javax.persistence.*;

import java.time.LocalDate;

@Entity
public class CompteHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    private Integer verison;
    private LocalDate dateDerniereEcoute;
    private Integer nombreEcoutes;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;

    @ManyToOne
    @JoinColumn(name = "contenu_id")
    private Contenu contenu;

    public CompteHistory() {}

    public CompteHistory(LocalDate dateDerniereEcoute, Integer nombreEcoutes) {
        this.dateDerniereEcoute = dateDerniereEcoute;
        this.nombreEcoutes = nombreEcoutes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVerison() {
        return verison;
    }

    public void setVerison(Integer verison) {
        this.verison = verison;
    }

    public LocalDate getDateDerniereEcoute() {
        return dateDerniereEcoute;
    }

    public void setDateDerniereEcoute(LocalDate dateDerniereEcoute) {
        this.dateDerniereEcoute = dateDerniereEcoute;
    }

    public Integer getNombreEcoutes() {
        return nombreEcoutes;
    }

    public void setNombreEcoutes(Integer nombreEcoutes) {
        this.nombreEcoutes = nombreEcoutes;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Contenu getContenu() {
        return contenu;
    }

    public void setContenu(Contenu contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "CompteHistory{" +
                "id=" + id +
                ", verison=" + verison +
                ", dateDerniereEcoute=" + dateDerniereEcoute +
                ", nombreEcoutes=" + nombreEcoutes +
                '}';
    }
}
