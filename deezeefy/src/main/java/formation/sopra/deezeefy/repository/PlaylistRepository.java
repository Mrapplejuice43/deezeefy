package formation.sopra.deezeefy.repository;

import formation.sopra.deezeefy.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{
    
}
