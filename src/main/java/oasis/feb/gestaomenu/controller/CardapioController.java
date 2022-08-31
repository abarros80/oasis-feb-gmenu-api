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
import oasis.feb.gestaomenu.model.Cardapio;
import oasis.feb.gestaomenu.model.dto.CardapioReqDTO;
import oasis.feb.gestaomenu.service.CardapioService;


@CrossOrigin("*")
@RepositoryRestController
@BasePathAwareController
public class CardapioController {
	
	
	@Autowired
	private CardapioService cardapioService;
	
	
	
	//CREATE
	@ResponseBody
	@RequestMapping(value = "cardapios", path="cardapios", method = RequestMethod.POST, produces = 
	 "application/hal+json")
    public ResponseEntity<PersistentEntityResource>  create(@Valid @RequestBody CardapioReqDTO cardapioReqDTO, PersistentEntityResourceAssembler assembler){
		
		Cardapio createdCardapio = cardapioService.createFromDTO(cardapioReqDTO);
		    	
    	HttpHeaders headers = new HttpHeaders();
        if (createdCardapio != null && createdCardapio.getId() != null) {
            // Caso o hotel for inserido na BD 
            return new ResponseEntity<>(
            		assembler.toFullResource(createdCardapio),
                    headers,
                    HttpStatus.OK);
        } else {
            // Caso algum valor for NULL
        	return new ResponseEntity<>(
        			assembler.toFullResource(createdCardapio), HttpStatus.NO_CONTENT);
        }
    }
	
	
	//UPDATE
	@ResponseBody
	@RequestMapping(value = "cardapios/{id}", method = {RequestMethod.PATCH, RequestMethod.PUT}, produces = 
	 "application/hal+json")
    public ResponseEntity<PersistentEntityResource>  update(@PathVariable("id") Long id, 
    		@Valid @RequestBody CardapioReqDTO cardapioReqDTO, PersistentEntityResourceAssembler assembler) throws NewResourceNotFoundException {
		
		Cardapio updatedCardapio  = cardapioService.update(id, cardapioReqDTO);
		
		return new ResponseEntity<>(
        		assembler.toFullResource(updatedCardapio),
        		new HttpHeaders(),
                HttpStatus.OK);		
	}
	
	
	//DELETE
	@ResponseBody
	@RequestMapping(value = "cardapios/{id}", method = RequestMethod.DELETE, produces = 
	 "application/hal+json")
    //public ResponseEntity<PersistentEntityResource>  deleteById(@PathVariable("id") Long id, PersistentEntityResourceAssembler assembler) throws NewResourceNotFoundException {
    public  Map<String, Boolean>  deleteById(@PathVariable("id") Long id) throws NewResourceNotFoundException {
	
		
		cardapioService.deleteById(id);
		
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
		

	}
		

}
