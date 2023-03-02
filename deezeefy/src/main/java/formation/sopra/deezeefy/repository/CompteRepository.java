package formation.sopra.deezeefy.repository;

import formation.sopra.deezeefy.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CompteRepository extends JpaRepository<Compte, Integer>{

    Optional<Compte> findByLoginAndPassword(String login, String password);
}
