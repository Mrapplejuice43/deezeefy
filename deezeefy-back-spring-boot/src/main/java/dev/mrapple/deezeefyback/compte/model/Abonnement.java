package dev.mrapple.deezeefyback.compte.model;

public enum Abonnement {
    
    GRATUIT(0), ETUDIANT(5), PREMIUM(10);

    private final double prix;

    private Abonnement(double prix) {
        this.prix = prix;
    }

    public double getPrix() {
        return prix;
    }
}
