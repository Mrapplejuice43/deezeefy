package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="playlist")
public class Playlist extends MusicList{
	


	public Playlist() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Playlist [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
