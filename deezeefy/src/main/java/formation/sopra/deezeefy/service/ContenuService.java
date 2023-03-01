package formation.sopra.deezeefy.service;

import formation.sopra.deezeefy.model.Contenu;
import formation.sopra.deezeefy.repository.ContenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ContenuService {

    @Autowired private ContenuRepository contenuRepository;
    public Contenu findById(Integer contenuId) {
        return contenuRepository.findById(contenuId).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }
}
