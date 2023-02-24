package formation.sopra.deezeefy.controller;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.deezeefy.model.Artiste;
import formation.sopra.deezeefy.model.Views;
import formation.sopra.deezeefy.service.ArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/artiste")
public class ArtisteController {
	
	@Autowired private ArtisteService artisteService;
	
	@GetMapping("")
	@JsonView(Views.ViewArtiste.class)
	public List<Artiste> findAll() {
		return artisteService.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewArtiste.class)
	public Artiste findById(@PathVariable Integer id) {
		return artisteService.findById(id);
	}
	
	@PostMapping("")
	@JsonView(Views.ViewArtiste.class)
	public Artiste create(@RequestBody Artiste artiste) {
		return artisteService.create(artiste);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewArtiste.class)
	public Artiste update(@RequestBody Artiste artiste, @PathVariable Integer id) {
		if(!id.equals(artiste.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		return artisteService.create(artiste);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		artisteService.deleteById(id);
	}
}
