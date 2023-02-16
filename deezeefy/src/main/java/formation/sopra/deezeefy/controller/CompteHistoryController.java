package formation.sopra.deezeefy.controller;

import formation.sopra.deezeefy.model.CompteHistory;
import formation.sopra.deezeefy.repository.CompteHistoryRepository;
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

    private CompteHistoryRepository compteHistoryRepository;

    @GetMapping("/{id}")
    public CompteHistory getById(@PathVariable Integer id) {
        return compteHistoryService.findById(id);
    }

    @GetMapping("")
    public List<CompteHistory> getAll() {
        return compteHistoryService.findall();
    }

    @PostMapping("")
    public CompteHistory insert(@RequestBody CompteHistory compteHistory) {
        return compteHistoryService.insert(compteHistory);
    }

    @PutMapping("/{id}")
    public CompteHistory update(@RequestBody CompteHistory compteHistory, @PathVariable Integer id) {
        if(compteHistory.getId() == null || !compteHistory.getId().equals(id)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        return compteHistoryService.update(compteHistory);
    }
}
