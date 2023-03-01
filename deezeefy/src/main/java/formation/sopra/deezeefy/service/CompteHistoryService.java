package formation.sopra.deezeefy.service;

import formation.sopra.deezeefy.exception.CompteHistoryException;
import formation.sopra.deezeefy.model.CompteHistory;
import formation.sopra.deezeefy.repository.CompteHistoryRepository;
import formation.sopra.deezeefy.repository.CompteRepository;
import formation.sopra.deezeefy.repository.ContenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CompteHistoryService {
    @Autowired private CompteHistoryRepository compteHistoryRepository;
    @Autowired private CompteService compteService;
    @Autowired private ContenuService contenuService;

    public CompteHistory findById(Integer id) {
        return compteHistoryRepository.findById(id).orElseThrow(() -> {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    public List<CompteHistory> findall() {
        return compteHistoryRepository.findAll();
    }

    public CompteHistory insert(CompteHistory compteHistory) {
        return compteHistoryRepository.save(compteHistory);
    }

    public CompteHistory update(CompteHistory compteHistory) {
        return compteHistoryRepository.save(compteHistory);
    }

    public void deleteById(Integer id) {
        compteHistoryRepository.deleteById(id);
    }

    public void delete(CompteHistory compteHistory) {
        deleteById(compteHistory.getId());
    }

    public boolean existById(Integer id) {
        return compteHistoryRepository.existsById(id);
    }

    public CompteHistory findByCompteIdAndContenuId(Integer compteId, Integer contenuId) {
        if(compteId < 0) {
            Optional<CompteHistory> chOpt =  compteHistoryRepository.findByCompteIdNullAndContenuId(contenuId);
            if(chOpt.isEmpty()) {
                CompteHistory ch = new CompteHistory();
                ch.setContenu(contenuService.findById(contenuId));
                return compteHistoryRepository.save(ch);
            } else {
                return chOpt.get();
            }
        } else {
            Optional<CompteHistory> chOpt = compteHistoryRepository.findByCompteIdAndContenuId(compteId, contenuId);
            if(chOpt.isEmpty()) {
                CompteHistory ch = new CompteHistory();
                ch.setCompte(compteService.findById(compteId));
                ch.setContenu(contenuService.findById(contenuId));
                return compteHistoryRepository.save(ch);
            } else {
                return chOpt.get();
            }
        }

    }

    public List<CompteHistory> findAllByCompteId(Integer compteId) {
        return compteHistoryRepository.findAllByCompteId(compteId);
    }
}
