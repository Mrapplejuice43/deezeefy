package model;

public class Rangement {
	private int ID;
	private int version;
	private Contenu contenu;
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
