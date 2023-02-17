package formation.sopra.deezeefy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.deezeefy.model.Podcast;


public interface PodcastRepository extends JpaRepository<Podcast, Integer>{
    
}
