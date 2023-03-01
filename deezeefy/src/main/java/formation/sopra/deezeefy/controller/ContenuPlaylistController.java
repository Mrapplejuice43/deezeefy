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

	@Autowired private ContenuPlaylistService contenuPlaylistService;

	@GetMapping("")
	@JsonView(Views.ViewContenuPlaylist.class)
	public List<ContenuPlaylist> findAll() {
		return contenuPlaylistService.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewContenuPlaylist.class)
	public ContenuPlaylist findById(@PathVariable Integer id) {
		return contenuPlaylistService.findById(id);
	}

	@PostMapping("")
	@JsonView(Views.ViewContenuPlaylist.class)
	public ContenuPlaylist create(@RequestBody ContenuPlaylist contenuPlaylist) {
		return contenuPlaylistService.create(contenuPlaylist);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewContenuPlaylist.class)
	public ContenuPlaylist update(@RequestBody ContenuPlaylist contenuPlaylist, @PathVariable Integer id) {
		if (!id.equals(contenuPlaylist.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return contenuPlaylistService.update(contenuPlaylist);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		contenuPlaylistService.deleteById(id);
	}
	
	@GetMapping("/playlistId/{id}")
	public List<ContenuPlaylist> findAllCPByIdP(@PathVariable Integer id){
		return contenuPlaylistService.findAllCPByIdP(id);
	} 
	
	
}
