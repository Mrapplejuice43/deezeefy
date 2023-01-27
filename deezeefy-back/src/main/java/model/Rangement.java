package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="storage")
public class Rangement {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ID;
	
	@Version
	private int version;
	
	@ManyToOne
	@JoinColumn(name ="content")
	private Contenu contenu;
	
	@ManyToOne
	@JoinColumn(name ="playlist")
	private Playlist playlist;
	
	public Rangement() {
		super();
	}

	
	
	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Contenu getContenu() {
		return contenu;
	}

	public void setContenu(Contenu contenu) {
		this.contenu = contenu;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
	
	
}
