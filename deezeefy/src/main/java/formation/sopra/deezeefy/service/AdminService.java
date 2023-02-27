package formation.sopra.deezeefy.service;

import formation.sopra.deezeefy.exception.CompteException;
import formation.sopra.deezeefy.model.Admin;
import formation.sopra.deezeefy.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminService {
	
	
	@Autowired
	private AdminRepository adminRepository;
	
	
	// creation Admin 
	
	public Admin create(Admin admin) {
		if(admin.getId() != null) {
			throw new CompteException("admin existe déjà");
		}
		return adminRepository.save(admin);
		
	}
	
	public Admin findById(Integer id) {
		if (id == null) {
			throw new CompteException();	
		}  
		
		return adminRepository.findById(id).orElseThrow(CompteException::new);
	}
	
	public Admin update(Admin admin){
		if(admin == null) {
			throw new CompteException("admin obligatoire pour modifier");		
		}	
		return adminRepository.save(admin);
	}
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}


	public void delete(Admin admin) {
		if(admin == null) {
			throw new CompteException("admin obligatoire pour supprimer");		
		}	
		adminRepository.delete(admin);
	}
	

	public void deleteById(Integer id) {
		if(id == null) {
			throw new CompteException("id est null");		
		}	
		adminRepository.deleteById(id);
	}
	
}
