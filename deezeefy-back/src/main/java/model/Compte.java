package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
@Table(name = "account")
public abstract class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@Version
	protected int version;
	
	@Column
	protected String login; 
	@Column
	protected String password;
	@Column
	protected String email; 
	
	@Column(name ="LastName")
	protected String nom; 
	
	@Column(name = "name")
	protected String prenom; 
	
	@Column
	protected String pseudo; 
	
	@OneToMany(mappedBy = "createur")
	protected List<Playlist> listeCrees = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "follower")
	protected List<Follow> listeFollowed = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "compte")
	protected List<Historique> ecoutes;
	
	public Compte(int id, String login, String password, String email, String nom, String prenom, String pseudo) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
	}



	public Compte() {
		super();
	}



	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	public List<Follow> getListeFollowed() {
		return listeFollowed;
	}



	public void setListeFollowed(List<Follow> listeFollowed) {
		this.listeFollowed = listeFollowed;
	}



	public List<Historique> getEcoutes() {
		return ecoutes;
	}



	public void setEcoutes(List<Historique> ecoutes) {
		this.ecoutes = ecoutes;
	}



	public List<Playlist> getListeCrees() {
		return listeCrees;
	}



	public void setListeCrees(List<Playlist> listeCrees) {
		this.listeCrees = listeCrees;
	}




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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





}
