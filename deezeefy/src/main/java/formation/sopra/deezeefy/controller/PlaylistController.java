package formation.sopra.deezeefy.controller;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.deezeefy.model.Playlist;
import formation.sopra.deezeefy.model.TypePlaylist;
import formation.sopra.deezeefy.model.Views;
import formation.sopra.deezeefy.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/playlist")
public class PlaylistController {

	@Autowired	private PlaylistService playlistService;

	@GetMapping("")
	@JsonView(Views.ViewPlaylist.class)
	public List<Playlist> findAll() {
		return playlistService.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPlaylist.class)
	public Playlist findById(@PathVariable Integer id) {
		return playlistService.findById(id);
	}

	@PostMapping("")
	@JsonView(Views.ViewPlaylist.class)
	public Playlist create(@RequestBody Playlist playlist) {
		
		return playlistService.create(playlist);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewPlaylist.class)
	public Playlist update(@RequestBody Playlist playlist, @PathVariable Integer id) {
		if (!id.equals(playlist.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return playlistService.update(playlist);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		playlistService.deleteById(id);
	}
}
