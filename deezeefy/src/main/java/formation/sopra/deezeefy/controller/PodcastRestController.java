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

import formation.sopra.deezeefy.model.Podcast;
import formation.sopra.deezeefy.model.Views;
import formation.sopra.deezeefy.service.PodcastService;

@RestController
@RequestMapping("/podcast")
public class PodcastRestController {
	@Autowired
	private PodcastService podcastService;

	@GetMapping("")
	@JsonView(Views.ViewPodcast.class)
	public List<Podcast> findAll() {
		List<Podcast> podcasts = podcastService.findAll();

		return podcasts;
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
		if(id != podcast.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		if(!podcastService.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		podcast = podcastService.update(podcast);
		
		return podcast;
	}
	

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		podcastService.deleteById(id);
	}
	
}
