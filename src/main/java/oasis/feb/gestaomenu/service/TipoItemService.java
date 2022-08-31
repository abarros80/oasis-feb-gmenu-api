package oasis.feb.gestaomenu.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oasis.feb.gestaomenu.exception.NewResourceNotFoundException;
import oasis.feb.gestaomenu.model.Log;
import oasis.feb.gestaomenu.model.TipoItem;
import oasis.feb.gestaomenu.model.dto.TipoItemReqDTO;
import oasis.feb.gestaomenu.repository.TipoItemRepository;


@Service
public class TipoItemService {

	
	@Autowired
    private TipoItemRepository tipoItemRepository;
	
	
	public TipoItem findById(Long id) throws NewResourceNotFoundException {
		return tipoItemRepository.findById(id)
                .orElseThrow(() -> new NewResourceNotFoundException("TipoItem não existe, id:" + id));	
	}
	
	@Transactional
	public TipoItem create(TipoItem obj){
		obj.setId(null);
		return tipoItemRepository.save(obj);
		
	}
	
	@Transactional
	public TipoItem createFromDTO(TipoItemReqDTO tipoItemReqDTO){
		
		tipoItemReqDTO.setId(null);
		TipoItem novoTipoItem = new TipoItem();
		
		//Não existe idUser no Cardapio
		BeanUtils.copyProperties(tipoItemReqDTO, novoTipoItem, "idUser");
		
		//Log
		Log novoLog = new Log();
		novoLog.setDataCriacao(LocalDateTime.now());
		novoLog.setDataAlteracao(LocalDateTime.now());
		novoLog.setIdUserCriacao(tipoItemReqDTO.getIdUser());
		novoLog.setIdUserAlteracao(tipoItemReqDTO.getIdUser());
		novoTipoItem.setLog(novoLog);

		//Inseri TipoItem  na BD		
		return tipoItemRepository.save(novoTipoItem);
		
	}
	
	@Transactional
	public TipoItem update(Long id, TipoItemReqDTO tipoItemReqDTO)  throws NewResourceNotFoundException {
		
		TipoItem existenteTipoItem  = findById(id);
		
		Log novoLog = new Log();
		novoLog.setDataCriacao(existenteTipoItem.getLog().getDataCriacao());
		novoLog.setIdUserCriacao(existenteTipoItem.getLog().getIdUserCriacao());
		
		BeanUtils.copyProperties(tipoItemReqDTO,existenteTipoItem, "idUser", "id");
		
		
		novoLog.setIdUserAlteracao(tipoItemReqDTO.getIdUser());
		novoLog.setDataAlteracao(LocalDateTime.now());
		existenteTipoItem.setLog(novoLog);
		
		
		existenteTipoItem.setId(id);
		return tipoItemRepository.save(existenteTipoItem);
		
		
	}
	
	@Transactional
	public void deleteById(Long id)  throws NewResourceNotFoundException {
		
		findById(id);
		
		tipoItemRepository.deleteById(id);

				
	}	
	
	
}
