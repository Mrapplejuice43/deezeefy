package formation.sopra.deezeefy.repository;

import formation.sopra.deezeefy.model.Musique;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MusiqueRepository extends JpaRepository<Musique, Integer>{
    
	@Query("select m from Musique m where m.titre=:t")
	List<Musique> findAllByTitre(@Param("t") String titre) ;
}
