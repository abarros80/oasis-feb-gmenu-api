package oasis.feb.gestaomenu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import oasis.feb.gestaomenu.exception.NewResourceNotFoundException;
import oasis.feb.gestaomenu.model.Restaurante;
import oasis.feb.gestaomenu.model.dto.RestauranteReqDTO;
import oasis.feb.gestaomenu.service.RestauranteService;


@CrossOrigin("*")
@RepositoryRestController
@BasePathAwareController
public class RestauranteController {
	
	
	@Autowired
	private RestauranteService restauranteService;
	
	
	
	//CREATE
	@ResponseBody
	@RequestMapping(value = "restaurantes", path="restaurantes", method = RequestMethod.POST, produces = 
	 "application/hal+json")
    public ResponseEntity<PersistentEntityResource>  create(@Valid @RequestBody RestauranteReqDTO restauranteReqDTO, PersistentEntityResourceAssembler assembler){
		
		Restaurante createdRestaurante = restauranteService.createFromDTO(restauranteReqDTO);
		    	
    	HttpHeaders headers = new HttpHeaders();
        if (createdRestaurante != null && createdRestaurante.getId() != null) {
            // Caso o restaurante for inserido na BD 
            return new ResponseEntity<>(
            		assembler.toFullResource(createdRestaurante),
                    headers,
                    HttpStatus.OK);
        } else {
            // Caso algum valor for NULL
        	return new ResponseEntity<>(
        			assembler.toFullResource(createdRestaurante), HttpStatus.NO_CONTENT);
        }
    }
	
	
	//UPDATE
	@ResponseBody
	@RequestMapping(value = "restaurantes/{id}", method = {RequestMethod.PATCH, RequestMethod.PUT}, produces = 
	 "application/hal+json")
    public ResponseEntity<PersistentEntityResource>  update(@PathVariable("id") Long id, 
    		@Valid @RequestBody RestauranteReqDTO restauranteReqDTO, PersistentEntityResourceAssembler assembler) throws NewResourceNotFoundException {
		
		Restaurante updatedItem  = restauranteService.update(id, restauranteReqDTO);
		
		return new ResponseEntity<>(
        		assembler.toFullResource(updatedItem),
        		new HttpHeaders(),
                HttpStatus.OK);		
	}
	
	
	//DELETE
	@ResponseBody
	@RequestMapping(value = "restaurantes/{id}", method = RequestMethod.DELETE, produces = 
	 "application/hal+json")
    //public ResponseEntity<PersistentEntityResource>  deleteById(@PathVariable("id") Long id, PersistentEntityResourceAssembler assembler) throws NewResourceNotFoundException {
    public  Map<String, Boolean>  deleteById(@PathVariable("id") Long id) throws NewResourceNotFoundException {
	
		
		restauranteService.deleteById(id);
		
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
		

	}
	

}
