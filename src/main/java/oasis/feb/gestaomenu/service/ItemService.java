package oasis.feb.gestaomenu.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oasis.feb.gestaomenu.exception.NewResourceNotFoundException;
import oasis.feb.gestaomenu.model.Item;
import oasis.feb.gestaomenu.model.Log;
import oasis.feb.gestaomenu.model.dto.ItemReqDTO;
import oasis.feb.gestaomenu.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
    private ItemRepository itemRepository;
	
	public Item findById(Long id) throws NewResourceNotFoundException {
		return itemRepository.findById(id)
                .orElseThrow(() -> new NewResourceNotFoundException("Item não existe, id:" + id));	
	}
	
	@Transactional
	public Item create(Item obj){
		obj.setId(null);
		return itemRepository.save(obj);
		
	}
	
	@Transactional
	public Item createFromDTO(ItemReqDTO itemReqDTO){
		
		itemReqDTO.setId(null);
		Item novoItem = new Item();
		
		//Não existe idUser no Item
		BeanUtils.copyProperties(itemReqDTO, novoItem, "idUser");
		
		//Log
		Log novoLog = new Log();
		novoLog.setDataCriacao(LocalDateTime.now());
		novoLog.setDataAlteracao(LocalDateTime.now());
		novoLog.setIdUserCriacao(itemReqDTO.getIdUser());
		novoLog.setIdUserAlteracao(itemReqDTO.getIdUser());
		novoItem.setLog(novoLog);

		//Inseri item na BD		
		return itemRepository.save(novoItem);
		
	}
	
	@Transactional
	public Item update(Long id, ItemReqDTO itemReqDTO)  throws NewResourceNotFoundException {
		
		Item existenteItem  = findById(id);
		
		Log novoLog = new Log();
		novoLog.setDataCriacao(existenteItem.getLog().getDataCriacao());
		novoLog.setIdUserCriacao(existenteItem.getLog().getIdUserCriacao());
		
		BeanUtils.copyProperties(itemReqDTO,existenteItem, "idUser", "id");
		
		
		novoLog.setIdUserAlteracao(itemReqDTO.getIdUser());
		novoLog.setDataAlteracao(LocalDateTime.now());
		existenteItem.setLog(novoLog);
		
		
		existenteItem.setId(id);
		return itemRepository.save(existenteItem);
		
		
	}

}
