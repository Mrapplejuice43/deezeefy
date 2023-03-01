package formation.sopra.deezeefy.repository;

import formation.sopra.deezeefy.model.ContenuPlaylist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContenuPlaylistRepository extends JpaRepository<ContenuPlaylist, Integer> {
	
	List<ContenuPlaylist>  findByPlaylistAssocieeId(Integer id);
}
