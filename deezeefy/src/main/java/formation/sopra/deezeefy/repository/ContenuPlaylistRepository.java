package formation.sopra.deezeefy.repository;

import formation.sopra.deezeefy.model.ContenuPlaylist;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ContenuPlaylistRepository extends JpaRepository<ContenuPlaylist, Integer> {
	
	
	@Query("select c from ContenuPlaylist c where c.playlistAssociee.id = :id")
	List<ContenuPlaylist> findByPlaylistAssocieeId(@Param("id") Integer id);

	@Transactional
	@Modifying
    void deleteAllByContenuAssocieAuteurId(Integer id);
}
