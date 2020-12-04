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

import com.residencia.projeto.dto.PessoaDTO;
import com.residencia.projeto.dto.ProcessoDTO;
import com.residencia.projeto.entities.Pessoa;
import com.residencia.projeto.entities.Processo;
import com.residencia.projeto.repositories.ProcessoRepository;
import com.residencia.projeto.services.exceptions.DatabaseException;
import com.residencia.projeto.services.exceptions.ResourceNotFoundException;

@Service
public class ProcessoService {
	
	@Autowired
	private ProcessoRepository repository;
	
	@Transactional (readOnly = true)
	public Page<ProcessoDTO> findAllPaged(PageRequest pageRequest){
		Page<Processo> list = repository.findAll(pageRequest);
		
		return list.map(x -> new ProcessoDTO (x));	
	}

	@Transactional (readOnly = true)
	public ProcessoDTO findById(long id) {
		Optional <Processo> obj = repository.findById(id);
		Processo entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ProcessoDTO(entity);
	}

	@Transactional
	public ProcessoDTO insert(ProcessoDTO dto) {
		Processo entity = new Processo();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ProcessoDTO(entity);
	}

	private void copyDtoToEntity(ProcessoDTO dto, Processo entity) {
		entity.setAssunto(dto.getAssunto());
		entity.setNumeroProcesso(dto.getNumeroProcesso());
		entity.getPessoas().clear();
		//for(PessoaDTO peDto : dto.getPessoas());
			//Pessoa pessoa = pessoaRepository.getOne(peDto.getId());
			//entity.getPessoas().add(pessoa);
	}

	@Transactional
	public ProcessoDTO update(Long id, ProcessoDTO dto) {
		try {
			Processo entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ProcessoDTO(entity);
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
