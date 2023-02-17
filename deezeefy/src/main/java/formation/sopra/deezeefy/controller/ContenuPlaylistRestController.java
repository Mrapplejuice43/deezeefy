package formation.sopra.deezeefy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import formation.sopra.deezeefy.model.ContenuPlaylist;
import formation.sopra.deezeefy.service.ContenuPlaylistService;


@RestController
@RequestMapping("/contenuContenuPlaylist")
public class ContenuPlaylistRestController {
	@Autowired
	private ContenuPlaylistService contenuContenuPlaylistService;

	@GetMapping("")
	//@JsonView(Views.ViewContenuPlaylist.class)
	public List<ContenuPlaylist> findAll() {
		List<ContenuPlaylist> contenuContenuPlaylists = contenuContenuPlaylistService.findAll();

		return contenuContenuPlaylists;
	}

	@GetMapping("/{id}")
	//@JsonView(Views.ViewContenuPlaylist.class)
	public ContenuPlaylist findById(@PathVariable Integer id) {
		ContenuPlaylist contenuContenuPlaylist = contenuContenuPlaylistService.findById(id);

		return contenuContenuPlaylist;
	}

	@PostMapping("")
	//@JsonView(Views.ViewContenuPlaylist.class)
	public ContenuPlaylist create(@RequestBody ContenuPlaylist contenuContenuPlaylist) {
		contenuContenuPlaylist = contenuContenuPlaylistService.create(contenuContenuPlaylist);

		return contenuContenuPlaylist;
	}

	@PutMapping("/{id}")
	//@JsonView(Views.ViewContenuPlaylist.class)
	public ContenuPlaylist update(@RequestBody ContenuPlaylist contenuContenuPlaylist, @PathVariable Integer id) {
		if (id != contenuContenuPlaylist.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}


		contenuContenuPlaylist = contenuContenuPlaylistService.update(contenuContenuPlaylist);

		return contenuContenuPlaylist;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		contenuContenuPlaylistService.deleteById(id);
	}

}
