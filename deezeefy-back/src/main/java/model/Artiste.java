package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="artist")
public class Artiste extends Compte {
	
	@Column(name = "listener_number", length = 10)
	private int ndAuditeur;
	
	@Column(name = "biography", length = 400)
	private long biographie;
	
	@OneToMany(mappedBy="auteur")
	private List<Contenu> listContenu;
	
	public Artiste() {
		super();
	}

	public Artiste(int id, String login, String password, String email, String nom, String prenom, String pseudo,
			int ndAuditeur, long biographie) {
		super(id, login, password, email, nom, prenom, pseudo);
		this.ndAuditeur = ndAuditeur;
		this.biographie = biographie;
	}
	
	
	
	public List<Contenu> getListContenu() {
		return listContenu;
	}

	public void setListContenu(List<Contenu> listContenu) {
		this.listContenu = listContenu;
	}

	public int getNdAuditeur() {
		return ndAuditeur;
	}
	public void setNdAuditeur(int ndAuditeur) {
		this.ndAuditeur = ndAuditeur;
	}
	public long getBiographie() {
		return biographie;
	}
	public void setBiographie(long biographie) {
		this.biographie = biographie;
	}
	
	
	
}
