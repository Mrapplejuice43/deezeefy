package formation.sopra.deezeefy.controller;

import formation.sopra.deezeefy.model.CompteFollower;
import formation.sopra.deezeefy.repository.CompteFollowerRepository;
import formation.sopra.deezeefy.service.CompteFollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/compteFollower")
public class CompteFollowerController {

    @Autowired private CompteFollowerService compteFollowerService;

    private CompteFollowerRepository compteFollowerRepository;

    @GetMapping("/{id}")
    public CompteFollower getById(@PathVariable Integer id) {
        return compteFollowerService.findById(id);
    }

    @GetMapping("")
    public List<CompteFollower> getAll() {
        return compteFollowerService.findall();
    }

    @PostMapping("")
    public CompteFollower insert(@RequestBody CompteFollower compteFollower) {
        return compteFollowerService.insert(compteFollower);
    }

    @PutMapping("/{id}")
    public CompteFollower update(@RequestBody CompteFollower compteFollower, @PathVariable Integer id) {
        if(compteFollower.getId() == null || !compteFollower.getId().equals(id)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        return compteFollowerService.update(compteFollower);
    }
}
