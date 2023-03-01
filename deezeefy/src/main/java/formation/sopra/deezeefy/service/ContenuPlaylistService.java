package formation.sopra.deezeefy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.deezeefy.exception.ContenuPlaylistException;
import formation.sopra.deezeefy.model.ContenuPlaylist;
import formation.sopra.deezeefy.repository.ContenuPlaylistRepository;


@Service
public class ContenuPlaylistService {

	@Autowired
	private ContenuPlaylistRepository contenuPlaylistRepo;

	public ContenuPlaylist create(ContenuPlaylist contenuPlaylist) {
		return contenuPlaylistRepo.save(contenuPlaylist);
	}

	public ContenuPlaylist update(ContenuPlaylist contenuPlaylist) {
		return contenuPlaylistRepo.save(contenuPlaylist);
	}
	// suppression
	public void delete(ContenuPlaylist contenuPlaylist) {
		contenuPlaylistRepo.deleteById(contenuPlaylist.getId());
	}

	public void deleteById(Integer id) {
		contenuPlaylistRepo.deleteById(id);
	}

	// remontees =>select
	public List<ContenuPlaylist> findAll() {
		return contenuPlaylistRepo.findAll();
	}

	public ContenuPlaylist findById(Integer id) {
		return contenuPlaylistRepo.findById(id).orElseThrow(()->{throw new ContenuPlaylistException();});
	}

	public List<ContenuPlaylist>  findAllCPByIdP(Integer id) {
		System.out.println("test service");
		return contenuPlaylistRepo.findByPlaylistAssocieeId(id);
	}
}
