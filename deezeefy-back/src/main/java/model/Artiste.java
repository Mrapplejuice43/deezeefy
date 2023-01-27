package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="artist")
public class Artiste extends Compte {
	
	@Column(name = "listener_number", length = 10)
	private int ndAuditeur;
	
	@Column(name = "biography", length = 400)
	private long biographie;
	
	
	
	public Artiste(int id, String login, String password, String email, String nom, String prenom, String pseudo,
			int ndAuditeur, long biographie) {
		super(id, login, password, email, nom, prenom, pseudo);
		this.ndAuditeur = ndAuditeur;
		this.biographie = biographie;
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
