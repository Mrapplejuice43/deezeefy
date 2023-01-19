package model;

public class Admin  extends Compte{

	public Admin(int id, String login, String password, String email, String nom, String prenom, String pseudo) {
		super(id, login, password, email, nom, prenom, pseudo);
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + ", nom=" + nom
				+ ", prenom=" + prenom + ", pseudo=" + pseudo + "]";
	}

	
	
}
