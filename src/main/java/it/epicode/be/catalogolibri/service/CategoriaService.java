package it.epicode.be.catalogolibri.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be.catalogolibri.model.Categoria;
import it.epicode.be.catalogolibri.model.Libro;
import it.epicode.be.catalogolibri.repository.CategoriaRepository;
import it.epicode.be.catalogolibri.repository.LibroRepository;
import it.epicode.be.catalogolibri.security.exceptions.CatalogoException;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	LibroRepository libroRepository;
	
	public Optional<Categoria> findById( Long id) {
		return categoriaRepository.findById(id);
	}
	
	public List<Categoria> findByNome(String nome) {
		return categoriaRepository.findByNome(nome);
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	

	public Categoria update(Long id, Categoria categoria) {
		Optional<Categoria> categoriaResult = categoriaRepository.findById(id);

		if (categoriaResult.isPresent()) {
			Categoria categoriaUpdate = categoriaResult.get();
			categoriaUpdate.setNome(categoria.getNome());
			categoriaRepository.save(categoriaUpdate);
			return categoriaUpdate;
		} else {
			throw new CatalogoException("Categoria non aggiornata");
		}

	}
	
	public void delete(Long id) {
        Categoria c = categoriaRepository.findById(id).get();
        List<Libro> listalibri = libroRepository.findByCategorieNome(c.getNome());
        for(Libro libro : listalibri) {
            libro.getCategorie().remove(c);
            libroRepository.save(libro);
        }
        categoriaRepository.deleteById(id);
    }


}
