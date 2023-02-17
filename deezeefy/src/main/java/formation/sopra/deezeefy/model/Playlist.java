package formation.sopra.deezeefy.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Playlist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.ViewBase.class)
    private Integer id;

    @Version
    @JsonView(Views.ViewBase.class)
    private Integer version;

    @JsonView(Views.ViewBase.class)
    private String titre;

    @JsonView(Views.ViewBase.class)
    private Integer duree;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonView(Views.ViewBase.class)
    private LocalDate dateCreation;

    @JsonView(Views.ViewBase.class)
    private Integer nbContenu;

    @Enumerated(EnumType.STRING)
    @JsonView(Views.ViewBase.class)
    private TypePlaylist typePlaylist;

    @ManyToOne
    @JoinColumn(name = "createur_id")
    @JsonView(Views.ViewPlaylist.class)
    private Compte createur;

    @OneToMany(mappedBy = "playlistSuivie")
    @JsonView(Views.ViewPlaylistWithListeFollowers.class)
    private List<PlaylistFollower> listeFollower;

    @OneToMany(mappedBy = "playlistAssociee")
    @JsonView(Views.ViewPlaylistWithListeContenuAssocie.class)
    private List<ContenuPlaylist> listeContenuAssocie;

    public Playlist() {}

    public Playlist(String titre, Integer duree, LocalDate dateCreation, Integer nbContenu, TypePlaylist typePlaylist) {
        this.titre = titre;
        this.duree = duree;
        this.dateCreation = dateCreation;
        this.nbContenu = nbContenu;
        this.typePlaylist = typePlaylist;
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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }
    
    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Integer getNbContenu() {
        return nbContenu;
    }

    public void setNbContenu(Integer nbContenu) {
        this.nbContenu = nbContenu;
    }

    public TypePlaylist getTypePlaylist() {
        return typePlaylist;
    }

    public void setTypePlaylist(TypePlaylist typePlaylist) {
        this.typePlaylist = typePlaylist;
    }

    public Compte getCreateur() {
        return createur;
    }

    public void setCreateur(Compte createur) {
        this.createur = createur;
    }

    public List<PlaylistFollower> getListeFollower() {
        return listeFollower;
    }

    public void setListeFollower(List<PlaylistFollower> listeFollower) {
        this.listeFollower = listeFollower;
    }

    public List<ContenuPlaylist> getListeContenuAssocie() {
        return listeContenuAssocie;
    }

    public void setListeContenuAssocie(List<ContenuPlaylist> listeContenuAssocie) {
        this.listeContenuAssocie = listeContenuAssocie;
    }

    @Override
    public String toString() {
        return String.format("Playlist %s : %d content for %d s", titre, nbContenu, duree);
    }
}
