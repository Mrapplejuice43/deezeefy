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

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.deezeefy.model.ContenuPlaylist;
import formation.sopra.deezeefy.repository.ContenuPlaylistRepository;


@RestController
@RequestMapping("/contenuPlaylist")
public class ContenuPlaylistRestController {
	@Autowired
	private ContenuPlaylistRepository contenuPlaylistRepository;

	@GetMapping("")
	//@JsonView(Views.ViewContenuPlaylist.class)
	public List<ContenuPlaylist> findAll() {
		List<ContenuPlaylist> contenuPlaylists = contenuPlaylistRepository.findAll();

		return contenuPlaylists;
	}

	@GetMapping("/{id}")
	//@JsonView(Views.ViewContenuPlaylist.class)
	public ContenuPlaylist findById(@PathVariable Integer id) {
		Optional<ContenuPlaylist> optContenuPlaylist = contenuPlaylistRepository.findById(id);

		if (optContenuPlaylist.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optContenuPlaylist.get();
	}

	@PostMapping("")
	//@JsonView(Views.ViewContenuPlaylist.class)
	public ContenuPlaylist create(@RequestBody ContenuPlaylist contenuPlaylist) {
		contenuPlaylist = contenuPlaylistRepository.save(contenuPlaylist);

		return contenuPlaylist;
	}

	@PutMapping("/{id}")
	//@JsonView(Views.ViewContenuPlaylist.class)
	public ContenuPlaylist update(@RequestBody ContenuPlaylist contenuPlaylist, @PathVariable Integer id) {
		if (id != contenuPlaylist.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!contenuPlaylistRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		contenuPlaylist = contenuPlaylistRepository.save(contenuPlaylist);

		return contenuPlaylist;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		contenuPlaylistRepository.deleteById(id);
	}

}
