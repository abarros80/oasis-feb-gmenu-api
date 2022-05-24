package oasis.feb.gestaomenu.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import oasis.feb.gestaomenu.service.ConjuntoService;
import oasis.feb.gestaomenu.exception.*;
import oasis.feb.gestaomenu.model.Conjunto;
import oasis.feb.gestaomenu.model.dto.ConjuntoDTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/conjuntos")
public class ConjuntoController {
	
	 @Autowired
	 private ConjuntoService service;
	 
    @GetMapping
    public ResponseEntity<List<ConjuntoDTO>> findByAll() {
    	List<Conjunto> list = service.findAll();
    	List<ConjuntoDTO> listDTO = list.stream().map(obj -> new ConjuntoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }	 

    @GetMapping("{id}")
    public ResponseEntity<Conjunto> findById(@PathVariable  long id) throws NewResourceNotFoundException{
    	Conjunto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Conjunto> create(@Valid @RequestBody Conjunto obj){
    	obj = service.create(obj);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();    	
        return ResponseEntity.created(uri).build();
    }
    
    @PutMapping("{id}")
    public ResponseEntity<ConjuntoDTO> update(@PathVariable  long id, @Valid @RequestBody ConjuntoDTO objDTO) throws NewResourceNotFoundException {
    	Conjunto newobj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new ConjuntoDTO(newobj));
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<ConjuntoDTO> delete(@PathVariable  long id) throws NewDataIntegrityViolationException, NewResourceNotFoundException{
    	service.delete(id);
    	return ResponseEntity.noContent().build();
    }
    
    


}
