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
@RequestMapping("/compteHistory")
public class CompteHistoryController {

    @Autowired private CompteHistoryService compteHistoryService;

    @GetMapping("/{id}")
    @JsonView(Views.ViewCompteHistory.class)
    public CompteHistory getById(@PathVariable Integer id) {
        return compteHistoryService.findById(id);
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
}
