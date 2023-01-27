package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="album")
public class Album  extends MusicList{
	@Column(name="type_album")
	private String type;// album single, ep
	


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
