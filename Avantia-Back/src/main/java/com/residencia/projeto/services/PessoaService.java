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
import com.residencia.projeto.repositories.PessoaRepository;
import com.residencia.projeto.repositories.ProcessoRepository;
import com.residencia.projeto.services.exceptions.DatabaseException;
import com.residencia.projeto.services.exceptions.ResourceNotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private ProcessoRepository processoRepository;
	
	@Transactional (readOnly = true)
	public Page<PessoaDTO> findAllPaged(PageRequest pageRequest){
		Page<Pessoa> list = repository.findAll(pageRequest);
		
		return list.map(x -> new PessoaDTO (x));	
	}

	@Transactional (readOnly = true)
	public PessoaDTO findById(long id) {
		Optional <Pessoa> obj = repository.findById(id);
		Pessoa entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new PessoaDTO(entity, entity.getProcessos());
	}

	@Transactional
	public PessoaDTO insert(PessoaDTO dto) {
		Pessoa entity = new Pessoa();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new PessoaDTO(entity);
	}

	private void copyDtoToEntity(PessoaDTO dto, Pessoa entity) {
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());
		entity.setFiliacao(dto.getFiliacao());
		entity.setFotoUrl1(dto.getFotoUrl1());
		entity.setFotoUrl2(dto.getFotoUrl2());
		entity.setFotoUrl3(dto.getFotoUrl3());
		entity.setFotoUrl4(dto.getFotoUrl4());
		entity.setFotoUrl5(dto.getFotoUrl5());
		
		entity.getProcessos().clear();
		//for(ProcessoDTO pDto : dto.getProcessos());
			//Processo processo = processoRepository.getOne(pDto.getId());
			//entity.getProcessos().add(processo);
	}

	@Transactional
	public PessoaDTO update(Long id, PessoaDTO dto) {
		try {
			Pessoa entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new PessoaDTO(entity);
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
