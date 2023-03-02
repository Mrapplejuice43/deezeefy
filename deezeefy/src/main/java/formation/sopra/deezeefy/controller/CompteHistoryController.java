package formation.sopra.deezeefy.controller;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.deezeefy.model.CompteHistory;
import formation.sopra.deezeefy.model.Views;
import formation.sopra.deezeefy.service.CompteHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/compteHistory")
public class CompteHistoryController {

    @Autowired private CompteHistoryService compteHistoryService;

    @GetMapping("/{id}")
    @JsonView(Views.ViewCompteHistory.class)
    public CompteHistory getById(@PathVariable Integer id) {
        return compteHistoryService.findById(id);
    }

    @GetMapping("/{compteId}/{contenuId}")
    @JsonView(Views.ViewCompteHistory.class)
    public CompteHistory getByCompteIdAndContenuId(@PathVariable("compteId") Integer compteId, @PathVariable("contenuId") Integer contenuId) {
        return compteHistoryService.findByCompteIdAndContenuId(compteId, contenuId);
    }

    @GetMapping("/compte/{compteId}")
    @JsonView(Views.ViewCompteHistory.class)
    public List<CompteHistory> getAllByCompteId(@PathVariable("compteId") Integer compteId) {
        return compteHistoryService.findAllByCompteId(compteId);
    }

    @GetMapping("")
    @JsonView(Views.ViewCompteHistory.class)
    public List<CompteHistory> getAll() {
        return compteHistoryService.findall();
    }

    @PostMapping("")
    @JsonView(Views.ViewCompteHistory.class)
    public CompteHistory insert(@RequestBody CompteHistory compteHistory) {
        return compteHistoryService.insert(compteHistory);
    }

    @PutMapping("/{id}")
    @JsonView(Views.ViewCompteHistory.class)
    public CompteHistory update(@RequestBody CompteHistory compteHistory, @PathVariable Integer id) {
        if(compteHistory.getId() == null || !compteHistory.getId().equals(id)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return compteHistoryService.update(compteHistory);
    }

    @DeleteMapping("/{id}")
    public void update(@PathVariable Integer id) {
        if(!compteHistoryService.existById(id)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        compteHistoryService.deleteById(id);
    }

    @DeleteMapping("/musique/{id}")
    public void deleteAllByContenuId(@PathVariable Integer id) {
        compteHistoryService.deleteAllByContenuId(id);
    }

    @DeleteMapping("/compte/{id}")
    public void deleteAllByCompteId(@PathVariable Integer id) {
        compteHistoryService.deleteAllByCompteId(id);
    }

    @DeleteMapping("/artiste/{id}")
    public void deleteAllByContenuArtisteId(@PathVariable Integer id) {
        compteHistoryService.deleteAllByContenuArtisteId(id);
    }
}
