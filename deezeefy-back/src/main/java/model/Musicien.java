package model;

public class Musicien extends Artiste{

	public Musicien(int id, String login, String password, String email, String nom, String prenom, String pseudo,
			int ndAuditeur, long biographie) {
		super(id, login, password, email, nom, prenom, pseudo, ndAuditeur, biographie);
		
	}

	@Override
	public String toString() {
		return "Musicien [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + ", nom="
				+ nom + ", prenom=" + prenom + ", pseudo=" + pseudo + "]";
	}


}
