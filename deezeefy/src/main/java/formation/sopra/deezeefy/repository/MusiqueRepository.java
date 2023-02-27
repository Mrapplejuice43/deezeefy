package formation.sopra.deezeefy.repository;

import formation.sopra.deezeefy.model.Genre;
import formation.sopra.deezeefy.model.Musique;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MusiqueRepository extends JpaRepository<Musique, Integer>{
    
	List<Musique> findByTitreContaining(String titre);
	
	List<Musique> findByAuteurNomContaining(String auteur);
	
	List<Musique> findByGenre(Genre genre);
}
