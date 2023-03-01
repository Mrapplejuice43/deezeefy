package formation.sopra.deezeefy.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "content_type")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Musique.class, name = "musique"),
        @JsonSubTypes.Type(value = Podcast.class, name = "podcast")
})
public abstract class Contenu {
    
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

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @JsonView(Views.ViewMusiqueWithPiste.class)
    private Byte[] piste;

    @ManyToOne
    @JoinColumn(name = "artiste_id")
    @JsonView(Views.ViewContenu.class)
    private Artiste auteur;

    @OneToMany(mappedBy = "contenu")
    @JsonView(Views.ViewContenuWithAuditeurs.class)
    private List<CompteHistory> auditeurs;

    @OneToMany(mappedBy = "contenuAssocie")
    @JsonView(Views.ViewContenuWithPlaylistAssociees.class)
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
