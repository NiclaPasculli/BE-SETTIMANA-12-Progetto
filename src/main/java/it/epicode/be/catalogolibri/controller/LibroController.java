package it.epicode.be.catalogolibri.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.epicode.be.catalogolibri.model.Libro;
import it.epicode.be.catalogolibri.service.LibroService;





@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearerAuth")
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	
	@GetMapping("/listalibri")
	@Operation(description = "visualizza lista dei libri")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public ResponseEntity<List<Libro>> findAll() {
		List<Libro> findAll = libroService.findAll();

		if (findAll != null) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping(path = "/libro")
	@Operation(description = "creazione di un nuovo libro")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Libro> save(@Valid @RequestBody Libro libro, BindingResult result) {
		Libro save = libroService.save(libro);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}
	
	@GetMapping(path = "/libro/{id}")
	@Operation(description = "visualizza libro dell'id indicato")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public ResponseEntity<Libro> findById(@PathVariable(required = true) Long id) {
		Optional<Libro> find = libroService.findById(id);

		if (find.isPresent()) {
			return new ResponseEntity<>(find.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(path = "/libro/{id}")
	@Operation(description = "modifica di un libro")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Libro> update(@PathVariable Long id, @Valid @RequestBody Libro libro, BindingResult result) {
		Libro save = libroService.update(id, libro);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@DeleteMapping(path = "/libro/{id}")
	@Operation(description = "cancellazione di un libro")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		libroService.delete(id);
		return new ResponseEntity<>("Libro cancellato", HttpStatus.OK);

	}
	
	@GetMapping(path="/libro/aut/{cognome}")
	@Operation(description = "ricerca di un libro attraverso il cognome di un autore")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public ResponseEntity<List<Libro>> findByAutoreCognome(@PathVariable(required = true) String cognome){
		List<Libro> findAut = libroService.findByAutori(cognome);
		if (findAut != null) {
			return new ResponseEntity<>(findAut, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path="/libro/cat/{nome}")
	@Operation(description = "ricerca di un libro attraverso il nome di una categoria")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public ResponseEntity<List<Libro>> findByCategoria(@PathVariable(required = true) String nome){
		List<Libro> findCat = libroService.findByCategorie(nome);
		if (findCat != null) {
			return new ResponseEntity<>(findCat, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
