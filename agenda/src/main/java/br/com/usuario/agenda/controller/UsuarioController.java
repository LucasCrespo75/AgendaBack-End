package br.com.usuario.agenda.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.view.RedirectView;

import br.com.usuario.agenda.config.SwaggerConfig;
import br.com.usuario.agenda.model.Usuario;
import br.com.usuario.agenda.repositorio.UsuarioRepositorio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import springfox.documentation.annotations.ApiIgnore;

@Api(tags = {SwaggerConfig.AGENDA_TAG})
@RestController
@RequestMapping({"/api"})
public class UsuarioController {
	
	//@ApiIgnore
	//@GetMapping()
	//public RedirectView redirectSwagger() {
	//return new RedirectView("/swagger-ui.html");
//	}
	
	private UsuarioRepositorio repositorio;
	
	public UsuarioController (UsuarioRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	
	//Listando tudo
	@ApiOperation(value="Listagem dos usuarios")
	@GetMapping(value="/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<?> findAll(){
		return repositorio.findAll();
	}
	
	//Find by id
	@ApiOperation(value="Buscando pelo email")
	@GetMapping(value = "/agenda/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> findByEmail(@PathVariable String email){
		return repositorio.findByEmail(email)
		.map(mapeando -> ResponseEntity.ok().body(mapeando))
		.orElse(ResponseEntity.notFound().build());
		
	}
	
	//craete 
	@ApiOperation(value="Criando um novo")
	@PostMapping(value="/agenda", produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario create(@RequestBody Usuario usuario) {
		return repositorio.save(usuario);
	}
	
	//update
	@ApiOperation(value="Atualizando um ja cadastrado")
	@PutMapping(value = "/usuarios/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Usuario> update(@PathVariable String email, @RequestBody Usuario usuario){
		return repositorio.findByEmail(email) 
				.map(mapeando -> {
					mapeando.setNome(usuario.getNome());
					mapeando.setEmail(usuario.getEmail());
					mapeando.setTelefone(usuario.getTelefone());
					
					Usuario update = repositorio.save(mapeando);
					
					return ResponseEntity.ok().body(update);
				}).orElse(ResponseEntity.notFound().build());
				
	}
	
	//deletando
	@ApiOperation(value="Deletando pelo ID")
	@DeleteMapping(path = "usuarios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deletando(@PathVariable Long id){
		return repositorio.findById(id)
				.map(mapeando ->{
					repositorio.deleteById(id);
					return ResponseEntity.ok().body("Deletado com sucesso");
				}).orElse(ResponseEntity.notFound().build());
	}

}
