package formation.sopra.deezeefy.service;

import formation.sopra.deezeefy.model.Compte;
import formation.sopra.deezeefy.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CompteService {

    @Autowired private CompteRepository compteRepository;
    public Compte findById(Integer compteId) {
        return compteRepository.findById(compteId).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }
}
