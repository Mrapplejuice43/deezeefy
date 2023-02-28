package formation.sopra.deezeefy.controller;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.deezeefy.controller.dto.AuthDTO;
import formation.sopra.deezeefy.model.Artiste;
import formation.sopra.deezeefy.model.Utilisateur;
import formation.sopra.deezeefy.model.Views;
import formation.sopra.deezeefy.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("/utilisateur")
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;

	@GetMapping("")
	@JsonView(Views.ViewUtilistateur.class)
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewUtilistateur.class)
	public Utilisateur findById(@PathVariable Integer id) {
		return utilisateurService.findById(id);
	}

	@PostMapping("")
	@JsonView(Views.ViewUtilistateur.class)
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.create(utilisateur);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewUtilistateur.class)
	public Utilisateur update(@RequestBody Utilisateur utilisateur, @PathVariable Integer id) {
		if (!id.equals(utilisateur.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return utilisateurService.create(utilisateur);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		utilisateurService.deleteById(id);
	}

	@PostMapping("/auth")
	@JsonView(Views.ViewUtilistateur.class)
	public Utilisateur auth(@RequestBody AuthDTO authentification) {

		return utilisateurService.findByLoginAndPassword(authentification.getLogin(), authentification.getPassword());

	}
}
