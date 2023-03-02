package formation.sopra.deezeefy.repository;

import formation.sopra.deezeefy.model.CompteHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CompteHistoryRepository extends JpaRepository<CompteHistory, Integer> {
    Optional<CompteHistory> findByCompteIdAndContenuId(Integer compteId, Integer contenuId);

    @Query("select distinct ch from CompteHistory ch where compte is null and contenu.id=:contenuId")
    Optional<CompteHistory> findByCompteIdNullAndContenuId(@Param("contenuId") Integer contenuId);

    List<CompteHistory> findAllByCompteId(Integer compteId);

    @Transactional
    @Modifying
    @Query("delete from CompteHistory ch where ch.contenu.id=:contenuId")
    void deleteByContenuId(@Param("contenuId") Integer contenuId);

    @Transactional
    @Modifying
    void deleteByCompteId(Integer id);

    @Transactional
    @Modifying
    void deleteAllByContenuAuteurId(Integer id);
}
