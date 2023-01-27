package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="admin")
public class Admin  extends Compte{
	
	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + ", nom=" + nom
				+ ", prenom=" + prenom + ", pseudo=" + pseudo + "]";
	}

	
	
}
