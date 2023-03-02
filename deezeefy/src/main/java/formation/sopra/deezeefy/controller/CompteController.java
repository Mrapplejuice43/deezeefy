package formation.sopra.deezeefy.controller;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.deezeefy.controller.dto.AuthDTO;
import formation.sopra.deezeefy.model.Compte;
import formation.sopra.deezeefy.model.Views;
import formation.sopra.deezeefy.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@CrossOrigin(origins = {"*"})
@RequestMapping("/compte")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @GetMapping("/{id}")
    @JsonView(Views.ViewCompte.class)
    public Compte getById(@PathVariable("id") Integer id) {
        return compteService.findById(id);
    }

    @PostMapping("/auth")
    @JsonView(Views.ViewCompte.class)
    public Compte loginCompte(@RequestBody AuthDTO dto) {
        return compteService.findByLoginAndPassword(dto.getLogin(), dto.getPassword());
    }
}
