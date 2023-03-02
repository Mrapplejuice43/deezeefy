package formation.sopra.deezeefy.repository;

import formation.sopra.deezeefy.model.Contenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;


public interface ContenuRepository extends JpaRepository<Contenu, Integer>{

    @Transactional
    @Modifying
    void deleteAllByAuteurId(Integer id);
}
