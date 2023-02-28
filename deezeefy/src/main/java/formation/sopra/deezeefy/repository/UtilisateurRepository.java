package formation.sopra.deezeefy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.deezeefy.model.Utilisateur;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{

	Optional<Utilisateur> findByLoginAndPassword(String login, String password);
    
}
