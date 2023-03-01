package formation.sopra.deezeefy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.deezeefy.model.Artiste;


public interface ArtistRepository extends JpaRepository<Artiste, Integer>{
	
	
	public Optional<Artiste> findByLoginAndPassword(String login, String password);
    
}
