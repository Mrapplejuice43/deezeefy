package formation.sopra.deezeefy.controller;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.deezeefy.model.Podcast;
import formation.sopra.deezeefy.model.Views;
import formation.sopra.deezeefy.service.PodcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/podcast")
public class PodcastController {

	@Autowired
	private PodcastService podcastService;

	@GetMapping("")
	@JsonView(Views.ViewPodcast.class)
	public List<Podcast> findAll() {
		return podcastService.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPodcast.class)
	public Podcast findById(@PathVariable Integer id) {
	return podcastService.findById(id);
	}
	
	@PostMapping("")
	@JsonView(Views.ViewPodcast.class)
	public Podcast create(@RequestBody Podcast podcast) {
	return podcastService.create(podcast);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewPodcast.class)
	public Podcast update(@RequestBody Podcast podcast, @PathVariable Integer id) {
		if(!id.equals(podcast.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if(!podcastService.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return podcastService.update(podcast);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		podcastService.deleteById(id);
	}
}
