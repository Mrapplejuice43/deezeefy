package formation.sopra.deezeefy.model;


import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CompteHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.ViewBase.class)
    private Integer id;

    @Version
    @JsonView(Views.ViewBase.class)
    private Integer verison;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonView(Views.ViewBase.class)
    private LocalDate dateDerniereEcoute;

    @JsonView(Views.ViewBase.class)
    private Integer nombreEcoutes;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    @JsonView(Views.ViewCompteHistory.class)
    private Compte compte;

    @ManyToOne
    @JoinColumn(name = "contenu_id")
    @JsonView(Views.ViewCompteHistory.class)
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
