package formation.sopra.deezeefy.controller;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.deezeefy.model.Genre;
import formation.sopra.deezeefy.model.Musique;
import formation.sopra.deezeefy.model.Views;
import formation.sopra.deezeefy.service.MusiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/musique")
public class MusiqueController {

	@Autowired
	private MusiqueService musiqueService;

	@GetMapping("")
	@JsonView(Views.ViewMusique.class)
	public List<Musique> findAll() {
		return musiqueService.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewMusique.class)
	public Musique findById(@PathVariable Integer id) {
	return musiqueService.findById(id);
	}

	@GetMapping("/{id}/piste")
	@JsonView(Views.ViewMusiqueWithPiste.class)
	public Musique findByIdWithPiste(@PathVariable Integer id) {
		return musiqueService.findById(id);
	}
	
	@PostMapping("")
	@JsonView(Views.ViewMusique.class)
	public Musique create(@RequestBody Musique musique) {
	return musiqueService.create(musique);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewMusique.class)
	public Musique update(@RequestBody Musique musique, @PathVariable Integer id) {
		if(!id.equals(musique.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		if(!musiqueService.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return musiqueService.update(musique);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		musiqueService.deleteById(id);
	}
	
	@GetMapping("/rechercheTitre/{titre}")
	@JsonView(Views.ViewMusique.class)
	public List<Musique> findAllByTitre(@PathVariable String titre){
		return musiqueService.findAllByTitre(titre);
	}
	
	@GetMapping("/rechercheAuteur/{auteur}")
	@JsonView(Views.ViewMusique.class)
	public List<Musique> findAllByAuteur(@PathVariable String auteur){
		return musiqueService.findAllByAuteur(auteur);
	}
	
	@GetMapping("/rechercheGenre/{genre}")
	@JsonView(Views.ViewMusique.class)
	public List<Musique> findAllByGenre(@PathVariable String genre){
		Genre g = Genre.valueOf(genre);
		return musiqueService.findAllByGenre(g);
	}
	
}
