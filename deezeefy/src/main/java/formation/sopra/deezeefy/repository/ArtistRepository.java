package formation.sopra.deezeefy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.deezeefy.model.Artiste;


public interface ArtistRepository extends JpaRepository<Artiste, Integer>{
    
}
