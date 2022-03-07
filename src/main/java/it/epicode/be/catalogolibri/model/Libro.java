package it.epicode.be.catalogolibri.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private Long id;
	@NotBlank
	private String titolo;
	@NotNull
	private int anno;
	@NotNull
	private double prezzo;
	@ManyToMany//(fetch=FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class,   property = "id")
	@JoinTable(name="libro_autore",
	joinColumns = @JoinColumn(name="libro_id", referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name="autore_id", referencedColumnName= "id"))
	private List<Autore> autori = new ArrayList<>();
	@ManyToMany//(fetch=FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class,   property = "id")
	@JoinTable(name="libro_categoria",
	joinColumns = @JoinColumn(name="libro_id", referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name="categoria_id", referencedColumnName= "id"))
	private List<Categoria> categorie = new ArrayList<>();
}
