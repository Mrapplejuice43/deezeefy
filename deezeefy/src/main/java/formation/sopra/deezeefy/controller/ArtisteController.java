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



import formation.sopra.deezeefy.model.Artiste;
import formation.sopra.deezeefy.service.ArtistService;

@RestController
@RequestMapping("/artiste")
public class ArtisteController {
	
	@Autowired
	private ArtistService artistService;
	
	@GetMapping("")
	public List<Artiste> findAll() {
		List<Artiste> artistes = artistService.findAll();

		return artistes;
	}

	@GetMapping("/{id}")
	public Artiste findById(@PathVariable Integer id) {
		Optional<Artiste> optArtiste = Optional.of(artistService.findById(id));

		if(optArtiste.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return optArtiste.get();
	}
	
	@PostMapping("")
	public Artiste create(@RequestBody Artiste artiste) {
		artiste = artistService.create(artiste);
		
		return artiste;
	}
	
	@PutMapping("/{id}")
	public Artiste update(@RequestBody Artiste artiste, @PathVariable Integer id) {
		if(id != artiste.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		artiste = artistService.create(artiste);
		
		return artiste;
	}
	
	@PatchMapping("/{id}")
	public Artiste partialUpdate(@PathVariable Integer id, @RequestBody Map<String, Object> fields) {
		Optional<Artiste>  optArtiste = Optional.of(artistService.findById(id));

		if (optArtiste.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		final Artiste artiste = optArtiste.get();

//		if(fields.containsKey("nom")) {
//			artiste.setNom((String) fields.get("nom"));
//		}
//		
//		if(fields.containsKey("prenom")) {
//			artiste.setPrenom((String) fields.get("prenom"));
//		}
//
//		if(fields.containsKey("email")) {
//			artiste.setEmail((String) fields.get("email"));
//		}

		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Artiste.class, key);
			if (field == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Propriété : " + key + "non trouvée");
			}
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, artiste, value);
		});

		return  artistService.create(artiste);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		artistService.deleteById(id);
	}
}
