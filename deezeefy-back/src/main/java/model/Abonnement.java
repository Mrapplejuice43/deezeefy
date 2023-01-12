package model;

public enum Abonnement {

	Gratuit(0), Etudiant(5), Perso(10);
	
	private double prix;
	
	private Abonnement(double prix) {
		this.prix = prix;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
}
