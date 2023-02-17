package formation.sopra.deezeefy.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ContenuPlaylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.ViewBase.class)
    private Integer id;

    @Version
    @JsonView(Views.ViewBase.class)
    private Integer version;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonView(Views.ViewBase.class)
    private LocalDate dateAjout;

    @ManyToOne
    @JoinColumn(name = "contenu_id")
    @JsonView(Views.ViewContenuPlaylist.class)
    private Contenu contenuAssocie;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    @JsonView(Views.ViewContenuPlaylist.class)
    private Playlist playlistAssociee;

    public ContenuPlaylist() {}

    public ContenuPlaylist(LocalDate dateAjout) {
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

    public Contenu getContenuAssocie() {
        return contenuAssocie;
    }

    public void setContenuAssocie(Contenu contenuAssocie) {
        this.contenuAssocie = contenuAssocie;
    }

    public Playlist getPlaylistAssociee() {
        return playlistAssociee;
    }

    public void setPlaylistAssociee(Playlist playlistAssociee) {
        this.playlistAssociee = playlistAssociee;
    }

    @Override
    public String toString() {
        return "ContenuPlaylist{" +
                "id=" + id +
                ", version=" + version +
                ", dateAjout=" + dateAjout +
                '}';
    }
}
