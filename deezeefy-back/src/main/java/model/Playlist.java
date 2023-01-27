package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table(name="playlist")
public class Playlist {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Version
	private int version;
	
	@Column(name="title")
	private String titre;
	@Column(name="time")
	private int duree; // seconde
	@Column(name="release_date")
	private LocalDate date; //date de sortie
	@Column(name="number_track")
	private int nbContenu ; //nombre de piste
	@Column(name="country")
	private String pays;
	@Column(name="type_playlist")
	@Enumerated(EnumType.STRING)
	private TypePlaylist typePlaylist;
	
	@ManyToOne
	@JoinColumn(name="author")
	private Compte createur;
	
	@OneToMany(mappedBy = "playlistSuivie")
	private List<Follow> listeFollow;
	
	@OneToMany(mappedBy = "playlist")
	private List<Rangement> contenuAssocie;
	
	public Playlist() {
		super();
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public TypePlaylist getTypePlaylist() {
		return typePlaylist;
	}


	public void setTypePlaylist(TypePlaylist typePlaylist) {
		this.typePlaylist = typePlaylist;
	}


	public List<Follow> getListeFollow() {
		return listeFollow;
	}


	public void setListeFollow(List<Follow> listeFollow) {
		this.listeFollow = listeFollow;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public int getNbContenu() {
		return nbContenu;
	}


	public void setNbContenu(int nbContenu) {
		this.nbContenu = nbContenu;
	}


	
	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	public Compte getCreateur() {
		return createur;
	}


	public void setCreateur(Compte createur) {
		this.createur = createur;
	}




}
