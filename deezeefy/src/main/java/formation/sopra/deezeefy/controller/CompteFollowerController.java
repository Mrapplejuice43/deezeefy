package formation.sopra.deezeefy.controller;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.deezeefy.model.CompteFollower;
import formation.sopra.deezeefy.model.Views;
import formation.sopra.deezeefy.service.CompteFollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/compteFollower")
public class CompteFollowerController {

    @Autowired private CompteFollowerService compteFollowerService;

    @GetMapping("/{id}")
    @JsonView(Views.ViewCompteFollower.class)
    public CompteFollower getById(@PathVariable Integer id) {
        return compteFollowerService.findById(id);
    }

    @GetMapping("")
    @JsonView(Views.ViewCompteFollower.class)
    public List<CompteFollower> getAll() {
        return compteFollowerService.findall();
    }

    @PostMapping("")
    @JsonView(Views.ViewCompteFollower.class)
    public CompteFollower insert(@RequestBody CompteFollower compteFollower) {
        return compteFollowerService.insert(compteFollower);
    }

    @PutMapping("/{id}")
    @JsonView(Views.ViewCompteFollower.class)
    public CompteFollower update(@RequestBody CompteFollower compteFollower, @PathVariable Integer id) {
        if(compteFollower.getId() == null || !compteFollower.getId().equals(id)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return compteFollowerService.update(compteFollower);
    }

    @DeleteMapping("/{id}")
    public void update(@PathVariable Integer id) {
        if(!compteFollowerService.existById(id)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        compteFollowerService.deleteById(id);
    }
}
