package formation.sopra.deezeefy.controller;

import com.fasterxml.jackson.annotation.JsonView;
import formation.sopra.deezeefy.model.Admin;
import formation.sopra.deezeefy.model.Views;
import formation.sopra.deezeefy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired private AdminService adminService;
	
	@GetMapping("")
	@JsonView(Views.ViewAdmin.class)
	public List<Admin> findAll() {
		return adminService.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewAdmin.class)
	public Admin findById(@PathVariable Integer id) {
		return adminService.findById(id);
	}
	
	@PostMapping("")
	@JsonView(Views.ViewAdmin.class)
	public Admin create(@RequestBody Admin admin) {
		return adminService.create(admin);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewAdmin.class)
	public Admin update(@RequestBody Admin admin, @PathVariable Integer id) {
		if(!id.equals(admin.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		return adminService.update(admin);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		adminService.deleteById(id);
	}
}
