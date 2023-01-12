package model;

import java.time.LocalDate;

public class Album  extends MusicList{
	
	private String type;// album single, ep
	
	
	
	

	public Album(Compte compte, int id, String titre, int duree, LocalDate date, int nbContenu, Contenu contenu,
			String pays, String type) {
		super(compte, id, titre, duree, date, nbContenu, contenu, pays);
		this.type = type;
	}





	public Album() {
		// TODO Auto-generated constructor stub
	}





	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
	}





	@Override
	public String toString() {
		return "Album [type=" + type + "]";
	}

}
