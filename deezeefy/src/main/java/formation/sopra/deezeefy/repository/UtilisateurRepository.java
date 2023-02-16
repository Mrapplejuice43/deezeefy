package formation.sopra.deezeefy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.deezeefy.model.Utilisateur;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{
    
}
