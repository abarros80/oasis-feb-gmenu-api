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
import oasis.feb.gestaomenu.model.TipoItem;
import oasis.feb.gestaomenu.model.dto.TipoItemReqDTO;
import oasis.feb.gestaomenu.service.TipoItemService;

@CrossOrigin("*")
@RepositoryRestController
@BasePathAwareController
public class TipoItemController {
	
	
	
	@Autowired
	private TipoItemService tipoItemService;
	
	
	
	//CREATE
	@ResponseBody
	@RequestMapping(value = "tipoItems", path="tipoItems", method = RequestMethod.POST, produces = 
	 "application/hal+json")
    public ResponseEntity<PersistentEntityResource>  create(@Valid @RequestBody TipoItemReqDTO tipoItemReqDTO, PersistentEntityResourceAssembler assembler){
		
		TipoItem createdTipoItem = tipoItemService.createFromDTO(tipoItemReqDTO);
		    	
    	HttpHeaders headers = new HttpHeaders();
        if (createdTipoItem != null && createdTipoItem.getId() != null) {
            // Caso o tipoItem for inserido na BD 
            return new ResponseEntity<>(
            		assembler.toFullResource(createdTipoItem),
                    headers,
                    HttpStatus.OK);
        } else {
            // Caso algum valor for NULL
        	return new ResponseEntity<>(
        			assembler.toFullResource(createdTipoItem), HttpStatus.NO_CONTENT);
        }
    }
	
	
	//UPDATE
	@ResponseBody
	@RequestMapping(value = "tipoItems/{id}", method = {RequestMethod.PATCH, RequestMethod.PUT}, produces = 
	 "application/hal+json")
    public ResponseEntity<PersistentEntityResource>  update(@PathVariable("id") Long id, 
    		@Valid @RequestBody TipoItemReqDTO tipoItemReqDTO, PersistentEntityResourceAssembler assembler) throws NewResourceNotFoundException {
		
		TipoItem updatedItem  = tipoItemService.update(id, tipoItemReqDTO);
		
		return new ResponseEntity<>(
        		assembler.toFullResource(updatedItem),
        		new HttpHeaders(),
                HttpStatus.OK);		
	}
	
	
	//DELETE
	@ResponseBody
	@RequestMapping(value = "tipoItems/{id}", method = RequestMethod.DELETE, produces = 
	 "application/hal+json")
    //public ResponseEntity<PersistentEntityResource>  deleteById(@PathVariable("id") Long id, PersistentEntityResourceAssembler assembler) throws NewResourceNotFoundException {
    public  Map<String, Boolean>  deleteById(@PathVariable("id") Long id) throws NewResourceNotFoundException {
	
		
		tipoItemService.deleteById(id);
		
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
		

	}
		

}
