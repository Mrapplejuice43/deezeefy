package model;

import java.time.LocalDate;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="music_list")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public abstract class MusicList {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	protected int id;
	@Column(name="title")
	protected String titre;
	@Column(name="time")
	protected int duree; // seconde
	@Column(name="release_date")
	protected LocalDate date; //date de sortie
	@Column(name="number_track")
	protected int nbContenu ; //nombre de piste
	@Column(name="country")
	protected String pays;
	
	@ManyToOne
	@JoinColumn(name="author")
	protected Compte createur;
	@ManyToMany(mappedBy = "listeSuivies")
	protected List<Compte> followers;
	@ManyToMany
	@JoinTable(name="music_list_content", uniqueConstraints = @UniqueConstraint(columnNames  = {"music_List_id","content_id"}),
	joinColumns = @JoinColumn(name ="music_List_id")
	,inverseJoinColumns = @JoinColumn(name="content_id"))
	protected List<Contenu> contenus; 
	
	public MusicList() {
		super();
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


	public List<Compte> getFollowers() {
		return followers;
	}


	public void setFollowers(List<Compte> followers) {
		this.followers = followers;
	}


	public List<Contenu> getContenus() {
		return contenus;
	}


	public void setContenus(List<Contenu> contenus) {
		this.contenus = contenus;
	}



}
