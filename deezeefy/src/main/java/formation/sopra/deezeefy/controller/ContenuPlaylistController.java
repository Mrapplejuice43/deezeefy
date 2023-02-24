package formation.sopra.deezeefy.controller;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.deezeefy.model.ContenuPlaylist;
import formation.sopra.deezeefy.model.Views;
import formation.sopra.deezeefy.service.ContenuPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/contenuPlaylist")
public class ContenuPlaylistController {

	@Autowired private ContenuPlaylistService contenuContenuPlaylistService;

	@GetMapping("")
	@JsonView(Views.ViewContenuPlaylist.class)
	public List<ContenuPlaylist> findAll() {
		return contenuContenuPlaylistService.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewContenuPlaylist.class)
	public ContenuPlaylist findById(@PathVariable Integer id) {
		return contenuContenuPlaylistService.findById(id);
	}

	@PostMapping("")
	@JsonView(Views.ViewContenuPlaylist.class)
	public ContenuPlaylist create(@RequestBody ContenuPlaylist contenuContenuPlaylist) {
		return contenuContenuPlaylistService.create(contenuContenuPlaylist);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewContenuPlaylist.class)
	public ContenuPlaylist update(@RequestBody ContenuPlaylist contenuContenuPlaylist, @PathVariable Integer id) {
		if (!id.equals(contenuContenuPlaylist.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return contenuContenuPlaylistService.update(contenuContenuPlaylist);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		contenuContenuPlaylistService.deleteById(id);
	}
}
