package formation.sopra.deezeefy.model;

import javax.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "content_type")
public abstract class Contenu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Version
    private Integer verison;
    private String titre;
    private Integer duree;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private Byte[] piste;

    @ManyToOne
    @JoinColumn(name = "artiste_id")
    private Artiste auteur;
    @OneToMany(mappedBy = "contenu")
    private List<CompteHistory> auditeurs;
    @OneToMany(mappedBy = "contenuAssocie")
    private List<ContenuPlaylist> listePlaylistAssociees;

    public Contenu() {}

    public Contenu(String titre, Integer duree, Byte[] piste) {
        this.titre = titre;
        this.duree = duree;
        this.piste = piste;
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

    public Byte[] getPiste() {
        return piste;
    }

    public void setPiste(Byte[] piste) {
        this.piste = piste;
    }

    public Artiste getAuteur() {
        return auteur;
    }

    public void setAuteur(Artiste auteur) {
        this.auteur = auteur;
    }

    public List<CompteHistory> getAuditeurs() {
        return auditeurs;
    }

    public void setAuditeurs(List<CompteHistory> auditeurs) {
        this.auditeurs = auditeurs;
    }

    public List<ContenuPlaylist> getListePlaylistAssociees() {
        return listePlaylistAssociees;
    }

    public void setListePlaylistAssociees(List<ContenuPlaylist> listePlaylistAssociees) {
        this.listePlaylistAssociees = listePlaylistAssociees;
    }
}
