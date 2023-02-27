package formation.sopra.deezeefy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.deezeefy.exception.CompteException;
import formation.sopra.deezeefy.model.Utilisateur;
import formation.sopra.deezeefy.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	public Utilisateur create(Utilisateur utilisateur) {
		if(utilisateur.getId() != null) {
			throw new CompteException("utilisateur existe déjà");
		}
		return utilisateurRepository.save(utilisateur);	
		
	}
	
	public Utilisateur findById(Integer id) {
		if (id == null) {
			throw new CompteException();	
		}  
		
		return  utilisateurRepository.findById(id).orElseThrow(CompteException::new);
	}
	
	public Utilisateur update(Utilisateur utilisateur){
		if(utilisateur == null) {
			throw new CompteException("utilisateur obligatoire pour modifier");		
		}	
		return utilisateurRepository.save(utilisateur);
	}
	public List<Utilisateur> findAll() {
		return utilisateurRepository.findAll();
	}


	public void delete(Utilisateur utilisateur) {
		if(utilisateur == null) {
			throw new CompteException("utilisateur obligatoire pour supprimer");		
		}	
		utilisateurRepository.delete(utilisateur);
	}
	

	public void deleteById(Integer id) {
		if(id == null) {
			throw new CompteException("id est null");		
		}	
		utilisateurRepository.deleteById(id);;
	}
}
