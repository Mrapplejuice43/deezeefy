package dao;

import model.Compte;

public interface ICompteRepository extends IRepository<Compte>{
	
	public Compte findByNomDeCompte(String nomDeCompte);
}
