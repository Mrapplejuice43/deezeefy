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
@Table(name="follow")
public class Follow {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ID;
	
	@Version
	private int version;
	
	@ManyToOne
	@JoinColumn(name="playlist_followed")
	private Playlist playlistSuivie;
	
	@ManyToOne
	@JoinColumn(name="follower")
	private Compte follower;
	
	public Follow() {
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
	public Playlist getPlaylistSuivie() {
		return playlistSuivie;
	}
	public void setPlaylistSuivie(Playlist playlistSuivie) {
		this.playlistSuivie = playlistSuivie;
	}
	public Compte getFollower() {
		return follower;
	}
	public void setFollower(Compte follower) {
		this.follower = follower;
	}
	
	

}
