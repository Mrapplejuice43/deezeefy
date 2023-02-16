package formation.sopra.deezeefy.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;



import formation.sopra.deezeefy.model.Admin;
import formation.sopra.deezeefy.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("")
	public List<Admin> findAll() {
		List<Admin> admins = adminService.findAll();

		return admins;
	}

	@GetMapping("/{id}")
	public Admin findById(@PathVariable Integer id) {
		Optional<Admin> optAdmin = adminService.findById(id);

		if(optAdmin.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return optAdmin.get();
	}
	
	@PostMapping("")
	public Admin create(@RequestBody Admin admin) {
		admin = adminService.create(admin);
		
		return admin;
	}
	
	@PutMapping("/{id}")
	public Admin update(@RequestBody Admin admin, @PathVariable Integer id) {
		if(id != admin.getId()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		admin = adminService.create(admin);
		
		return admin;
	}
	
	@PatchMapping("/{id}")
	public Admin partialUpdate(@PathVariable Integer id, @RequestBody Map<String, Object> fields) {
		Optional<Admin>  optAdmin = adminService.findById(id);

		if (optAdmin.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		final Admin admin = optAdmin.get();

//		if(fields.containsKey("nom")) {
//			admin.setNom((String) fields.get("nom"));
//		}
//		
//		if(fields.containsKey("prenom")) {
//			admin.setPrenom((String) fields.get("prenom"));
//		}
//
//		if(fields.containsKey("email")) {
//			admin.setEmail((String) fields.get("email"));
//		}

		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Admin.class, key);
			if (field == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Propriété : " + key + "non trouvée");
			}
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, admin, value);
		});

		return  adminService.create(admin);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		adminService.deleteById(id);
	}
}
