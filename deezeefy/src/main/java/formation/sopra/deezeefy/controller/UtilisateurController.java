package formation.sopra.deezeefy.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;



import formation.sopra.deezeefy.model.Utilisateur;
import formation.sopra.deezeefy.service.UtilisateurService;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@GetMapping("")
	public List<Utilisateur> findAll() {
		List<Utilisateur> utilisateurs = utilisateurService.findAll();

		return utilisateurs;
	}

	@GetMapping("/{id}")
	public Utilisateur findById(@PathVariable Integer id) {
		Optional<Utilisateur> optUtilisateur = Optional.of(utilisateurService.findById(id));

		if(optUtilisateur.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return optUtilisateur.get();
	}
	
	@PostMapping("")
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		utilisateur = utilisateurService.create(utilisateur);
		
		return utilisateur;
	}
	
	@PutMapping("/{id}")
	public Utilisateur update(@RequestBody Utilisateur utilisateur, @PathVariable Integer id) {
		if(id != utilisateur.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		utilisateur = utilisateurService.create(utilisateur);
		
		return utilisateur;
	}
	
	@PatchMapping("/{id}")
	public Utilisateur partialUpdate(@PathVariable Integer id, @RequestBody Map<String, Object> fields) {
		Optional<Utilisateur>  optUtilisateur = Optional.of(utilisateurService.findById(id));

		if (optUtilisateur.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		final Utilisateur utilisateur = optUtilisateur.get();

//		if(fields.containsKey("nom")) {
//			utilisateur.setNom((String) fields.get("nom"));
//		}
//		
//		if(fields.containsKey("prenom")) {
//			utilisateur.setPrenom((String) fields.get("prenom"));
//		}
//
//		if(fields.containsKey("email")) {
//			utilisateur.setEmail((String) fields.get("email"));
//		}

		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Utilisateur.class, key);
			if (field == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Propriété : " + key + "non trouvée");
			}
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, utilisateur, value);
		});

		return  utilisateurService.create(utilisateur);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		utilisateurService.deleteById(id);
	}
}
