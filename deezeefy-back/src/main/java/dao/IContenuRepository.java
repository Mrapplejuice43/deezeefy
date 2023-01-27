package dao;

import model.Contenu;

public interface IContenuRepository extends IRepository<Contenu> {

		public Contenu findByTitre(String titre);
}
