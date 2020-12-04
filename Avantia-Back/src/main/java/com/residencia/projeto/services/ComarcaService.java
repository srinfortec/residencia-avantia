package com.residencia.projeto.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.residencia.projeto.dto.ComarcaDTO;
import com.residencia.projeto.entities.Comarca;
import com.residencia.projeto.repositories.ComarcaRepository;
import com.residencia.projeto.services.exceptions.DatabaseException;
import com.residencia.projeto.services.exceptions.ResourceNotFoundException;

@Service
public class ComarcaService {
	
	@Autowired
	private ComarcaRepository repository;
	
	@Transactional (readOnly = true)
	public Page<ComarcaDTO> findAllPaged(PageRequest pageRequest){
		Page<Comarca> list = repository.findAll(pageRequest);
		
		return list.map(x -> new ComarcaDTO (x));	
	}

	@Transactional (readOnly = true)
	public ComarcaDTO findById(long id) {
		Optional <Comarca> obj = repository.findById(id);
		Comarca entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ComarcaDTO(entity);
	}

	@Transactional
	public ComarcaDTO insert(ComarcaDTO dto) {
		Comarca entity = new Comarca();
		entity.setCidade(dto.getCidade());
		entity.setCompetencia(dto.getCompetencia());
		entity.setOrgaoJulgador(dto.getOrgaoJulgador());
		entity = repository.save(entity);
		return new ComarcaDTO(entity);
	}

	@Transactional
	public ComarcaDTO update(Long id, ComarcaDTO dto) {
		try {
			Comarca entity = repository.getOne(id);
			entity.setCidade(dto.getCidade());
			entity.setCompetencia(dto.getCompetencia());
			entity.setOrgaoJulgador(dto.getOrgaoJulgador());
			entity = repository.save(entity);
			return new ComarcaDTO(entity);
			}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

	public void delete(long id) {
		try {
		repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
			
		}
	}
}
