package model;

public class Utilisateur extends Compte {

	private Abonnement abonnement;
	private boolean etudiant;
	private int tempsEcoute;
	
	
	
	public Utilisateur(int id, String login, String password, String email, String nom, String prenom, String pseudo,
			Abonnement abonnement, boolean etudiant, int tempsEcoute) {
		super(id, login, password, email, nom, prenom, pseudo);
		this.abonnement = abonnement;
		this.etudiant = etudiant;
		this.tempsEcoute = tempsEcoute;
	}
	
	public Abonnement getAbonnement() {
		return abonnement;
	}
	public void setAbonnement(Abonnement abonnement) {
		this.abonnement = abonnement;
	}
	public boolean isEtudiant() {
		return etudiant;
	}
	public void setEtudiant(boolean etudiant) {
		this.etudiant = etudiant;
	}
	public int getTempsEcoute() {
		return tempsEcoute;
	}
	public void setTempsEcoute(int tempsEcoute) {
		this.tempsEcoute = tempsEcoute;
	}

	@Override
	public String toString() {
		return "Utilisateur [abonnement=" + abonnement + ", etudiant=" + etudiant + ", tempsEcoute=" + tempsEcoute
				+ ", id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + ", nom=" + nom
				+ ", prenom=" + prenom + ", pseudo=" + pseudo + "]";
	}


}
