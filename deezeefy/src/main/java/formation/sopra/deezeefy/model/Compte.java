package formation.sopra.deezeefy.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type")
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"login"}))
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Utilisateur.class, name = "user"),
        @JsonSubTypes.Type(value = Admin.class, name = "admin"),
        @JsonSubTypes.Type(value = Artiste.class, name = "artiste"),
})
public abstract class Compte {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.ViewBase.class)
    private Integer id;
    @Version
    @JsonView(Views.ViewBase.class)
    private Integer version;
    @JsonView(Views.ViewBase.class)
    private String login;
    @JsonView(Views.ViewBase.class)
    private String password;
    @JsonView(Views.ViewBase.class)
    private String email;
    @JsonView(Views.ViewBase.class)
    private String nom;
    @JsonView(Views.ViewBase.class)
    private String prenom;
    @JsonView(Views.ViewBase.class)
    private String pseudo;

    @OneToMany(mappedBy = "compte")
    @JsonView(Views.ViewCompteWithCompteHistory.class)
    private List<CompteHistory> ecoutes;

    @OneToMany(mappedBy = "createur")
    @JsonView(Views.ViewCompteWithPlaylistCrees.class)
    private List<Playlist> playlistCreees;

    @OneToMany(mappedBy = "follower")
    @JsonView(Views.ViewCompteWithListPlaylistSuivies.class)
    private List<PlaylistFollower> listePlaylistSuivies;

    @OneToMany(mappedBy = "follower")
    @JsonView(Views.ViewCompteWithListeComptesSuivis.class)
    private List<CompteFollower> listeComptesSuivis;

    @OneToMany(mappedBy = "compteSuivi")
    @JsonView(Views.ViewCompteWithListeFollowers.class)
    private List<CompteFollower> listeFollowers;
    
   

    public Compte() {}
    
    public Compte(String nom, String prenom) {
    	this.nom=nom;
    	this.prenom=prenom;
    }

    public Compte(String login,String password,String email,String nom,String prenom,String pseudo) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public List<CompteHistory> getEcoutes() {
        return ecoutes;
    }

    public void setEcoutes(List<CompteHistory> ecoutes) {
        this.ecoutes = ecoutes;
    }

    public List<Playlist> getPlaylistCreees() {
        return playlistCreees;
    }

    public void setPlaylistCreees(List<Playlist> playlistCreees) {
        this.playlistCreees = playlistCreees;
    }

    public List<PlaylistFollower> getListePlaylistSuivies() {
        return listePlaylistSuivies;
    }

    public void setListePlaylistSuivies(List<PlaylistFollower> listePlaylistSuivies) {
        this.listePlaylistSuivies = listePlaylistSuivies;
    }

    public List<CompteFollower> getListeComptesSuivis() {
        return listeComptesSuivis;
    }

    public void setListeComptesSuivis(List<CompteFollower> listeComptesSuivis) {
        this.listeComptesSuivis = listeComptesSuivis;
    }

    public List<CompteFollower> getListeFollowers() {
        return listeFollowers;
    }

    public void setListeFollowers(List<CompteFollower> listeFollowers) {
        this.listeFollowers = listeFollowers;
    }
}
