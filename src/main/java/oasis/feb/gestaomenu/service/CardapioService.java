package oasis.feb.gestaomenu.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oasis.feb.gestaomenu.exception.NewResourceNotFoundException;
import oasis.feb.gestaomenu.model.Cardapio;
import oasis.feb.gestaomenu.model.Log;
import oasis.feb.gestaomenu.model.dto.CardapioReqDTO;
import oasis.feb.gestaomenu.repository.CardapioRepository;

@Service
public class CardapioService {
	
	@Autowired
    private CardapioRepository cardapioRepository;
	
	
	public Cardapio findById(Long id) throws NewResourceNotFoundException {
		return cardapioRepository.findById(id)
                .orElseThrow(() -> new NewResourceNotFoundException("Cardapio não existe, id:" + id));	
	}
	
	@Transactional
	public Cardapio create(Cardapio obj){
		obj.setId(null);
		return cardapioRepository.save(obj);
	}
	
	@Transactional
	public Cardapio createFromDTO(CardapioReqDTO cardapioReqDTO){
		
		cardapioReqDTO.setId(null);
		Cardapio novoCardapio = new Cardapio();
		
		//Não existe idUser no Cardapio
		BeanUtils.copyProperties(cardapioReqDTO, novoCardapio, "idUser");
		
		//Log
		Log novoLog = new Log();
		novoLog.setDataCriacao(LocalDateTime.now());
		novoLog.setDataAlteracao(LocalDateTime.now());
		novoLog.setIdUserCriacao(cardapioReqDTO.getIdUser());
		novoLog.setIdUserAlteracao(cardapioReqDTO.getIdUser());
		novoCardapio.setLog(novoLog);

		//Inseri Cardapio  na BD		
		return cardapioRepository.save(novoCardapio);
		
	}
	
	@Transactional
	public Cardapio update(Long id, CardapioReqDTO cardapioReqDTO)  throws NewResourceNotFoundException {
		
		Cardapio existenteCardapio  = findById(id);
		
		Log novoLog = new Log();
		novoLog.setDataCriacao(existenteCardapio.getLog().getDataCriacao());
		novoLog.setIdUserCriacao(existenteCardapio.getLog().getIdUserCriacao());
		
		BeanUtils.copyProperties(cardapioReqDTO,existenteCardapio, "idUser", "id");
		
		
		novoLog.setIdUserAlteracao(cardapioReqDTO.getIdUser());
		novoLog.setDataAlteracao(LocalDateTime.now());
		existenteCardapio.setLog(novoLog);
		
		
		existenteCardapio.setId(id);
		return cardapioRepository.save(existenteCardapio);
		
		
	}
	
	@Transactional
	public void deleteById(Long id)  throws NewResourceNotFoundException {
		
		findById(id);
		
		cardapioRepository.deleteById(id);

				
	}	

}
