package formation.sopra.deezeefy.repository;

import formation.sopra.deezeefy.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository extends JpaRepository<Compte, Integer>{
    
}
