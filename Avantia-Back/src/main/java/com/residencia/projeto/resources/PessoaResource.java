package com.residencia.projeto.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.residencia.projeto.dto.PessoaDTO;
import com.residencia.projeto.services.PessoaService;

@RestController
@RequestMapping (value = "/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService service; 
	
	@GetMapping
	public ResponseEntity<Page<PessoaDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){
		
		PageRequest pageRequest = PageRequest.of(page,linesPerPage, Direction.valueOf(direction), orderBy);
		Page<PessoaDTO> list = service.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<PessoaDTO> findById(@PathVariable long id){
		PessoaDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<PessoaDTO> insert(@RequestBody PessoaDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping (value = "/{id}")
	public ResponseEntity<PessoaDTO> update(@PathVariable long id, @RequestBody PessoaDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);	
	}
	
	@DeleteMapping (value = "/{id}")
	public ResponseEntity<PessoaDTO> delete(@PathVariable long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
