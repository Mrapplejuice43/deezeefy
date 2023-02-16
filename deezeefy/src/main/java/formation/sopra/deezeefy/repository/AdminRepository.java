package formation.sopra.deezeefy.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.deezeefy.model.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer>{
    
}
