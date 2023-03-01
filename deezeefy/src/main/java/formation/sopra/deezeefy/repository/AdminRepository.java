package formation.sopra.deezeefy.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.deezeefy.model.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	public Optional<Admin> findByLoginAndPassword(String login, String password);
    
}
