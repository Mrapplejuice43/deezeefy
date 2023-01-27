package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="compilation")
public class Compilation extends MusicList{
	
	
	public Compilation() {
		// TODO Auto-generated constructor stub
	}
	
}
