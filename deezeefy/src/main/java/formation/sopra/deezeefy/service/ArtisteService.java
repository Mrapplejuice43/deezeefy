package formation.sopra.deezeefy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.deezeefy.exception.CompteException;

import formation.sopra.deezeefy.model.Artiste;
import formation.sopra.deezeefy.repository.ArtistRepository;

@Service
public class ArtisteService {
	@Autowired
	private ArtistRepository artisteRepository;
	
	
	// creation Admin 
	
	public Artiste create(Artiste artiste) {
		if(artiste.getId() != null) {
			throw new CompteException("artiste existe déjà");
		}
		return artiste;	
		
	}
	
	public Artiste findById(Integer id) {
		if (id == null) {
			throw new CompteException();	
		}  
		
		return  artisteRepository.findById(id).orElseThrow(CompteException::new);
	}
	
	public Artiste update(Artiste artiste){
		if(artiste == null) {
			throw new CompteException("artiste obligatoire pour modifier");		
		}	
		return artisteRepository.save(artiste);
	}
	public List<Artiste> findAll() {
		return artisteRepository.findAll();
	}


	public void delete(Artiste artiste) {
		if(artiste == null) {
			throw new CompteException("artiste obligatoire pour supprimer");		
		}	
		artisteRepository.delete(artiste);
	}
	

	public void deleteById(Integer id) {
		if(id == null) {
			throw new CompteException("id est null");		
		}	
		artisteRepository.deleteById(id);
	}
	
}
