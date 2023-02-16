package formation.sopra.deezeefy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import formation.sopra.deezeefy.exception.PlaylistException;
import formation.sopra.deezeefy.model.Playlist;
import formation.sopra.deezeefy.repository.PlaylistRepository;


@Service
public class PlaylistService {

	@Autowired
	private PlaylistRepository playlistRepo;

	public Playlist create(Playlist playlist) {
		return playlistRepo.save(playlist);
	}

	public Playlist update(Playlist playlist) {
		return playlistRepo.save(playlist);
	}
	// suppression
	public void delete(Playlist playlist) {
		playlistRepo.delete(playlist);
	}

	public void delete(Integer id) {
		playlistRepo.deleteById(id);
	}

	// remontees =>select
	public List<Playlist> findAll() {
		return playlistRepo.findAll();
	}

	public Playlist findById(Integer id) {
		return playlistRepo.findById(id).orElseThrow(()->{new PlaylistException();});
	}


}
