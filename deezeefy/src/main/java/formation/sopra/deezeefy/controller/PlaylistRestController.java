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

import formation.sopra.deezeefy.model.Playlist;
import formation.sopra.deezeefy.repository.PlaylistRepository;
import formation.sopra.deezeefy.service.PlaylistService;


@RestController
@RequestMapping("/playlist")
public class PlaylistRestController {
	@Autowired
	private PlaylistService playlistService;

	@GetMapping("")
	//@JsonView(Views.ViewPlaylist.class)
	public List<Playlist> findAll() {
		List<Playlist> playlists = playlistService.findAll();

		return playlists;
	}

	@GetMapping("/{id}")
	//@JsonView(Views.ViewPlaylist.class)
	public Playlist findById(@PathVariable Integer id) {
		Playlist playlist = playlistService.findById(id);

		if (playlist.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return playlist;
	}

	@PostMapping("")
	//@JsonView(Views.ViewPlaylist.class)
	public Playlist create(@RequestBody Playlist playlist) {
		playlist = playlistService.create(playlist);

		return playlist;
	}

	@PutMapping("/{id}")
	//@JsonView(Views.ViewPlaylist.class)
	public Playlist update(@RequestBody Playlist playlist, @PathVariable Integer id) {
		if (id != playlist.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (!playlistService.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		playlist = playlistService.update(playlist);

		return playlist;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		playlistService.delete(id);
	}

}
