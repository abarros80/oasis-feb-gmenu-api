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
import oasis.feb.gestaomenu.model.Hotel;
import oasis.feb.gestaomenu.model.dto.HotelReqDTO;
import oasis.feb.gestaomenu.service.HotelService;


@CrossOrigin("*")
@RepositoryRestController
@BasePathAwareController
public class hotelController{
	
	@Autowired
	private HotelService hotelService;
	
	
	
	//CREATE
	@ResponseBody
	@RequestMapping(value = "hoteis", path="hoteis", method = RequestMethod.POST, produces = 
	 "application/hal+json")
    public ResponseEntity<PersistentEntityResource>  create(@Valid @RequestBody HotelReqDTO hotelReqDTO, PersistentEntityResourceAssembler assembler){
		
		Hotel createdHotel = hotelService.createFromDTO(hotelReqDTO);
		    	
    	HttpHeaders headers = new HttpHeaders();
        if (createdHotel != null && createdHotel.getId() != null) {
            // Caso o hotel for inserido na BD 
            return new ResponseEntity<>(
            		assembler.toFullResource(createdHotel),
                    headers,
                    HttpStatus.OK);
        } else {
            // Caso algum valor for NULL
        	return new ResponseEntity<>(
        			assembler.toFullResource(createdHotel), HttpStatus.NO_CONTENT);
        }
    }
	
	
	//UPDATE
	@ResponseBody
	@RequestMapping(value = "hoteis/{id}", method = {RequestMethod.PATCH, RequestMethod.PUT}, produces = 
	 "application/hal+json")
    public ResponseEntity<PersistentEntityResource>  update(@PathVariable("id") Long id, 
    		@Valid @RequestBody HotelReqDTO hotelReqDTO, PersistentEntityResourceAssembler assembler) throws NewResourceNotFoundException {
		
		Hotel updatedItem  = hotelService.update(id, hotelReqDTO);
		
		return new ResponseEntity<>(
        		assembler.toFullResource(updatedItem),
        		new HttpHeaders(),
                HttpStatus.OK);		
	}
	
}
