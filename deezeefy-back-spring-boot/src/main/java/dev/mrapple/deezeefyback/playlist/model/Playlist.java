package dev.mrapple.deezeefyback.playlist.model;

import java.time.LocalDate;
import java.util.List;

import dev.mrapple.deezeefyback.compte.model.Compte;
import dev.mrapple.deezeefyback.contenuPlaylist.ContenuPlaylist;
import dev.mrapple.deezeefyback.playlistFollower.PlaylistFollower;
import jakarta.persistence.*;

@Entity
public class Playlist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    private Integer version;
    private String titre;
    private Integer duree;
    private LocalDate dateCreation;
    private Integer nbContenu;
    @Enumerated(EnumType.STRING)
    private TypePlaylist typePlaylist;

    @ManyToOne
    @JoinColumn(name = "createur_id")
    private Compte createur;
    @OneToMany(mappedBy = "playlistSuivie")
    private List<PlaylistFollower> listeFollower;
    @OneToMany(mappedBy = "playlistAssociee")
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
