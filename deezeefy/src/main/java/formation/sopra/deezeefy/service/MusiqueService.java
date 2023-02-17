package formation.sopra.deezeefy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.deezeefy.exception.IdException;
import formation.sopra.deezeefy.exception.MusiqueException;
import formation.sopra.deezeefy.model.Musique;
import formation.sopra.deezeefy.repository.MusiqueRepository;


@Service
public class MusiqueService {

	@Autowired
	private MusiqueRepository musiqueRepo;

	public Musique create(Musique musique) {
		if (musique.getId() != null) {
			throw new IdException();
		}
		return musiqueRepo.save(musique);
	}

	

	public Musique findById(Integer id) {
		return musiqueRepo.findById(id).orElseThrow(MusiqueException::new);
	}

	public boolean existsById (Integer id) {
		return musiqueRepo.existsById(id);
	}
	
	public Musique update(Musique musique) {
		
		Musique musiqueEnBase = findById(musique.getId());
		musiqueEnBase
				.setGenre(musique.getGenre() == null ? musiqueEnBase.getGenre() : musique.getGenre());
		musiqueEnBase.setTitre(musique.getTitre());
		musiqueEnBase.setDuree(musique.getDuree());
		musiqueEnBase.setPiste(musique.getPiste());
		musiqueEnBase.setVersion(musique.getVersion());
		

		return musiqueRepo.save(musiqueEnBase);
	}

	public List<Musique> findAll() {
		return musiqueRepo.findAll();
	}

	public void delete(Musique musique) {
		musiqueRepo.delete(musique);
	}

	public void deleteById(Integer id) {
		delete(findById(id));
	}
}
