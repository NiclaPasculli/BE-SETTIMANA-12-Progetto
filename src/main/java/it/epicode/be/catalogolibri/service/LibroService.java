package it.epicode.be.catalogolibri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be.catalogolibri.model.Libro;
import it.epicode.be.catalogolibri.repository.LibroRepository;
import it.epicode.be.catalogolibri.security.exceptions.CatalogoException;


@Service
public class LibroService {
	
	@Autowired
	LibroRepository libroRepository;
	
	public Optional<Libro> findById( Long id) {
		return libroRepository.findById(id);
	}
	
	public List<Libro> findByTitolo(String titolo) {
		return libroRepository.findByTitolo(titolo);
	}

	public List<Libro> findAll() {
		return libroRepository.findAll();
	}

	public Libro save(Libro libro) {
		return libroRepository.save(libro);
	}

	public Libro update(Long id, Libro libro) {
		Optional<Libro> libroResult = libroRepository.findById(id);

		if (libroResult.isPresent()) {
			Libro libroUpdate = libroResult.get();
			libroUpdate.setTitolo(libro.getTitolo());
			libroUpdate.setAnno(libro.getAnno());
			libroUpdate.setPrezzo(libro.getPrezzo());
			libroUpdate.setAutori(libro.getAutori());
			libroUpdate.setCategorie(libro.getCategorie());
			libroRepository.save(libroUpdate);
			return libroUpdate;
		} else {
			throw new CatalogoException("Libro non aggiornato");
		}

	}
	
	public void delete(Long id) {
		libroRepository.deleteById(id);
	}
	
	public List<Libro> findByAutori(String cognome){
		return libroRepository.findByAutoriCognome(cognome);
	}
	
	public List<Libro> findByCategorie(String nome){
		return libroRepository.findByCategorieNome(nome);
	}

}
