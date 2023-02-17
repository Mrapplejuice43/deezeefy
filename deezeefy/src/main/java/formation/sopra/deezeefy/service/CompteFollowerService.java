package formation.sopra.deezeefy.service;

import formation.sopra.deezeefy.exception.CompteFollowerException;
import formation.sopra.deezeefy.model.CompteFollower;
import formation.sopra.deezeefy.repository.CompteFollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteFollowerService {
    @Autowired private CompteFollowerRepository compteFollowerRepository;

    public CompteFollower findById(Integer id) {
        return compteFollowerRepository.findById(id).orElseThrow(() -> {
           throw new CompteFollowerException();
        });
    }

    public List<CompteFollower> findall() {
        return compteFollowerRepository.findAll();
    }

    public CompteFollower insert(CompteFollower compteFollower) {
        return compteFollowerRepository.save(compteFollower);
    }

    public CompteFollower update(CompteFollower compteFollower) {
        return compteFollowerRepository.save(compteFollower);
    }

    public void deleteById(Integer id) {
        compteFollowerRepository.deleteById(id);
    }

    public void delete(CompteFollower compteFollower) {
        deleteById(compteFollower.getId());
    }

    public boolean existById(Integer id) {
        return compteFollowerRepository.existsById(id);
    }
}
