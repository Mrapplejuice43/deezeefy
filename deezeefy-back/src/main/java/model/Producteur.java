package model;

public class Producteur extends Artiste{

	private String nomLabel;
	
	public Producteur(int id, String login, String password, String email, String nom, String prenom, String pseudo,
			int ndAuditeur, long biographie, String nomLabel) {
		super(id, login, password, email, nom, prenom, pseudo, ndAuditeur, biographie);
		this.nomLabel = nomLabel;
	}

	public String getNomLabel() {
		return nomLabel;
	}

	public void setNomLabel(String nomLabel) {
		this.nomLabel = nomLabel;
	}

	@Override
	public String toString() {
		return "Producteur [nomLabel=" + nomLabel + ", id=" + id + ", login=" + login + ", password=" + password
				+ ", email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + "]";
	}
	
	
}
