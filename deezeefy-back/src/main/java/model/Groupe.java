package model;

public class Groupe extends Artiste{

	public Groupe(int id, String login, String password, String email, String nom, String prenom, String pseudo,
			int ndAuditeur, long biographie) {
		super(id, login, password, email, nom, prenom, pseudo, ndAuditeur, biographie);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Groupe [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + ", nom=" + nom
				+ ", prenom=" + prenom + ", pseudo=" + pseudo + "]";
	}



}
