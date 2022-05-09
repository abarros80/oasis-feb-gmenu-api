package oasis.feb.gestaomenu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import oasis.feb.gestaomenu.model.Conjunto;
import oasis.feb.gestaomenu.model.dto.ConjuntoDTO;
import oasis.feb.gestaomenu.repository.ConjuntoRepository;

import oasis.feb.gestaomenu.exception.*;

@Service
public class ConjuntoService {
	
	@Autowired
    private ConjuntoRepository repository;
	
	public Conjunto findById(Long id) throws NewResourceNotFoundException {
		return repository.findById(id)
                .orElseThrow(() -> new NewResourceNotFoundException("Conjunto não existe, id:" + id));	
	}
	
	public List<Conjunto> findAll(){
		return repository.findAll();
	}
	
	public Conjunto create(Conjunto obj){
		obj.setId(null);
		return repository.save(obj);
		
	}
	
	public Conjunto update(Long id, ConjuntoDTO objDto)  throws NewResourceNotFoundException {
		Conjunto obj = findById(id);
		
		obj.setActivo(objDto.getActivo());
		//Fazer para mais atributos
		//Fazer para mais atributos
		//Fazer para mais atributos
		//Fazer para mais atributos;
		
		return repository.save(obj);
		
	}
	
	public void delete(Long id)  throws NewDataIntegrityViolationException, NewResourceNotFoundException {
		findById(id);
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new NewDataIntegrityViolationException("Conjunto não pode ser removido! Possui filhos");
		}
	}
	
	

}
