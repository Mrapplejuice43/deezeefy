package formation.sopra.deezeefy.service;

import formation.sopra.deezeefy.exception.CompteHistoryException;
import formation.sopra.deezeefy.model.CompteHistory;
import formation.sopra.deezeefy.repository.CompteHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteHistoryService {
    @Autowired private CompteHistoryRepository compteHistoryRepository;

    public CompteHistory findById(Integer id) {
        return compteHistoryRepository.findById(id).orElseThrow(() -> {
           throw new CompteHistoryException();
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
}
