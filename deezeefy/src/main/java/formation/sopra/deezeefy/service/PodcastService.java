package formation.sopra.deezeefy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.deezeefy.exception.IdException;
import formation.sopra.deezeefy.exception.PodcastException;
import formation.sopra.deezeefy.model.Podcast;
import formation.sopra.deezeefy.repository.PodcastRepository;


@Service
public class PodcastService {

	@Autowired
	private PodcastRepository podcastRepo;

	public Podcast create(Podcast podcast) {
		if (podcast.getId() != null) {
			throw new IdException();
		}
		return podcastRepo.save(podcast);
	}

	

	public Podcast findById(Integer id) {
		return podcastRepo.findById(id).orElseThrow(PodcastException::new);
	}

	public boolean existsById (Integer id) {
		return podcastRepo.existsById(id);
	}
	
	public Podcast update(Podcast podcast) {
		
		Podcast podcastEnBase = findById(podcast.getId());
		podcastEnBase
				.setSujet(podcast.getSujet() == null ? podcastEnBase.getSujet() : podcast.getSujet());
		podcastEnBase.setTitre(podcast.getTitre());
		podcastEnBase.setDuree(podcast.getDuree());
		podcastEnBase.setPiste(podcast.getPiste());
		podcastEnBase.setVersion(podcast.getVersion());
		

		return podcastRepo.save(podcastEnBase);
	}

	public List<Podcast> findAll() {
		return podcastRepo.findAll();
	}

	public void delete(Podcast podcast) {
		podcastRepo.delete(podcast);
	}

	public void deleteById(Integer id) {
		delete(findById(id));
	}
}
