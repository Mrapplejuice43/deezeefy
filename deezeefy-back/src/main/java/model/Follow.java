package model;

public class Follow {
	
	private int ID;
	private int version;
	private Playlist playlistSuivie;
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
