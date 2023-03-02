package formation.sopra.deezeefy.controller;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.deezeefy.model.Contenu;
import formation.sopra.deezeefy.model.Views;
import formation.sopra.deezeefy.repository.ContenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/contenu")
public class ContenuController {

    @Autowired
    private ContenuRepository contenuRepository;

    @GetMapping("")
    @JsonView(Views.ViewBase.class)
    public List<Contenu> findAll() {
        return contenuRepository.findAll();
    }

    @PostMapping("")
    @JsonView(Views.ViewBase.class)
    public Contenu save(@RequestBody Contenu c) {
        return contenuRepository.save(c);
    }

    @DeleteMapping("/artiste/{id}")
    public void deleteAllByAuteurId(@PathVariable Integer id) {
        contenuRepository.deleteAllByAuteurId(id);
    }
}
