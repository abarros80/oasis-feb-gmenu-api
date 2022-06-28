package oasis.feb.gestaomenu.controller;

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
import oasis.feb.gestaomenu.model.Item;
import oasis.feb.gestaomenu.model.dto.ItemReqDTO;
import oasis.feb.gestaomenu.service.ItemService;

@CrossOrigin("*")
@RepositoryRestController
@BasePathAwareController
public class ItemController{
	
	@Autowired
	private ItemService itemService;
	
	
	
	
	//CREATE
	@ResponseBody
	@RequestMapping(value = "itens", path="itens", method = RequestMethod.POST, produces = 
	 "application/hal+json")
    public ResponseEntity<PersistentEntityResource>  create(@Valid @RequestBody ItemReqDTO itemReqDTO, PersistentEntityResourceAssembler assembler){
		
		Item createdItem = itemService.createFromDTO(itemReqDTO);
		    	
    	HttpHeaders headers = new HttpHeaders();
        if (createdItem != null && createdItem.getId() != null) {
            // Caso o item for inserido na BD 
            return new ResponseEntity<>(
            		assembler.toFullResource(createdItem),
                    headers,
                    HttpStatus.OK);
        } else {
            // Caso algum valor for NULL
        	return new ResponseEntity<>(
        			assembler.toFullResource(createdItem), HttpStatus.NO_CONTENT);
        }
    }
	
	
	//UPDATE
	@ResponseBody
	@RequestMapping(value = "itens/{id}", method = {RequestMethod.PATCH, RequestMethod.PUT}, produces = 
	 "application/hal+json")
    public ResponseEntity<PersistentEntityResource>  update(@PathVariable("id") Long id, 
    		@Valid @RequestBody ItemReqDTO itemReqDTO, PersistentEntityResourceAssembler assembler) throws NewResourceNotFoundException {
		
		Item updatedItem  = itemService.update(id, itemReqDTO);
		
		return new ResponseEntity<>(
        		assembler.toFullResource(updatedItem),
        		new HttpHeaders(),
                HttpStatus.OK);		
	}
	
}
