package formation.sopra.deezeefy.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PlaylistFollower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.ViewBase.class)
    private Integer id;
    @Version
    @JsonView(Views.ViewBase.class)
    private Integer version;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonView(Views.ViewBase.class)
    private LocalDate dateFollow;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    @JsonView(Views.ViewPlaylistFollower.class)
    private Compte follower;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    @JsonView(Views.ViewPlaylistFollower.class)
    private Playlist playlistSuivie;

    public PlaylistFollower() {}

    public PlaylistFollower(LocalDate dateFollow) {
        this.dateFollow = dateFollow;
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

    public LocalDate getDateFollow() {
        return dateFollow;
    }

    public void setDateFollow(LocalDate dateFollow) {
        this.dateFollow = dateFollow;
    }

    public Compte getFollower() {
        return follower;
    }

    public void setFollower(Compte follower) {
        this.follower = follower;
    }

    public Playlist getPlaylistSuivie() {
        return playlistSuivie;
    }

    public void setPlaylistSuivie(Playlist playlistSuivie) {
        this.playlistSuivie = playlistSuivie;
    }
}
