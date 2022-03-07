package it.epicode.be.catalogolibri;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.epicode.be.catalogolibri.model.Autore;
import it.epicode.be.catalogolibri.model.Categoria;

@SpringBootTest
@AutoConfigureMockMvc
public class CatalogoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * EndPoint di viasualizzazione lista dei libri testato senza autentificazione
	 * 
	 */
	@Test
	@WithAnonymousUser
	public void listaLibriWhenUtenteIsAnonymous() throws Exception {
		this.mockMvc.perform(get("/api/listalibri")).andExpect(status().isUnauthorized());
	}
	
	/**
	 * EndPoint di viasualizzazione lista dei libri testato con autentificazione
	 * 
	 */
	@Test
	@WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
	public void listaLibriWhenUtenteMockIsAuthenticated() throws Exception {
		this.mockMvc.perform(get("/api/listalibri")).andExpect(status().isOk());
	}
	
	/**
	 * EndPoint di viasualizzazione lista degli autori testato senza autentificazione
	 * 
	 */
	@Test
	@WithAnonymousUser
	public void listaAutoriWhenUtenteIsAnonymous() throws Exception {
		this.mockMvc.perform(get("/api/listaautori")).andExpect(status().isUnauthorized());
	}
	
	/**
	 * EndPoint di viasualizzazione lista degli autori testato con autentificazione
	 * 
	 */
	@Test
	@WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
	public void listaAutoriWhenUtenteMockIsAuthenticated() throws Exception {
		this.mockMvc.perform(get("/api/listaautori")).andExpect(status().isOk());
	}
	
	/**
	 * EndPoint di creazione di un autore testato senza autentificazione
	 * 
	 */

	@Test
	public void addNewAutoreWhenUtenteIsAnonymous() throws Exception {
		Autore autore = new Autore();
		autore.setId(1L);
		autore.setNome("Mario");
		autore.setCognome("Rossi");
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(autore);
		MvcResult result = mockMvc.perform(post("/api/autore").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isUnauthorized()).andReturn();

	}

	/*@Test
	@WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
	public void addNewCategoriaWhenUtenteMockIsAuthenticated() throws Exception {
		Categoria categoria = new Categoria();
		categoria.setId(1l);
		categoria.setNome("Romanzo");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(categoria);
		MvcResult result = mockMvc.perform(post("/api/categoria").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isCreated())
				.andExpect(content().json("{'nome':'Romanzo'}"))
				.andReturn();

	}*/

}
