package it.epicode.be.catalogolibri.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.mapping.Array;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private Long id;
	private String nome;
	/*@ManyToMany
	@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class,   property = "id")
	@JoinTable(name="categoria_libro",
	joinColumns = @JoinColumn(name="categoria_id", referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name="libro_id", referencedColumnName= "id"))
	private List<Libro> libri = new ArrayList<>();*/

}
