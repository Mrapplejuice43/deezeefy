package dev.mrapple.deezeefyback.playlistFollower;

import dev.mrapple.deezeefyback.compte.model.Compte;
import dev.mrapple.deezeefyback.playlist.model.Playlist;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class PlaylistFollower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    private Integer version;
    private LocalDate dateFollow;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private Compte follower;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
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
