package oasis.feb.gestaomenu.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oasis.feb.gestaomenu.exception.NewResourceNotFoundException;

import oasis.feb.gestaomenu.model.Log;
import oasis.feb.gestaomenu.model.Restaurante;
import oasis.feb.gestaomenu.model.dto.RestauranteReqDTO;
import oasis.feb.gestaomenu.repository.RestauranteRepository;


@Service
public class RestauranteService {
	
	
	@Autowired
    private RestauranteRepository restauranteRepository;
	
	
	public Restaurante findById(Long id) throws NewResourceNotFoundException {
		return restauranteRepository.findById(id)
                .orElseThrow(() -> new NewResourceNotFoundException("Restaurante não existe, id:" + id));	
	}
	
	@Transactional
	public Restaurante create(Restaurante obj){
		obj.setId(null);
		return restauranteRepository.save(obj);
		
	}
	
	@Transactional
	public Restaurante createFromDTO(RestauranteReqDTO restauranteReqDTO){
		
		restauranteReqDTO.setId(null);
		Restaurante novoRestaurante = new Restaurante();
		
		//Não existe idUser no Restaurante
		BeanUtils.copyProperties(restauranteReqDTO, novoRestaurante, "idUser");
		
		//Log
		Log novoLog = new Log();
		novoLog.setDataCriacao(LocalDateTime.now());
		novoLog.setDataAlteracao(LocalDateTime.now());
		novoLog.setIdUserCriacao(restauranteReqDTO.getIdUser());
		novoLog.setIdUserAlteracao(restauranteReqDTO.getIdUser());
		novoRestaurante.setLog(novoLog);

		//Inseri Restaurante  na BD		
		return restauranteRepository.save(novoRestaurante);
		
	}
	
	@Transactional
	public Restaurante update(Long id, RestauranteReqDTO restauranteReqDTO)  throws NewResourceNotFoundException {
		
		Restaurante existenteRestaurante  = findById(id);
		
		Log novoLog = new Log();
		novoLog.setDataCriacao(existenteRestaurante.getLog().getDataCriacao());
		novoLog.setIdUserCriacao(existenteRestaurante.getLog().getIdUserCriacao());
		
		BeanUtils.copyProperties(restauranteReqDTO,existenteRestaurante, "idUser", "id");
		
		
		novoLog.setIdUserAlteracao(restauranteReqDTO.getIdUser());
		novoLog.setDataAlteracao(LocalDateTime.now());
		existenteRestaurante.setLog(novoLog);
		
		
		existenteRestaurante.setId(id);
		return restauranteRepository.save(existenteRestaurante);
		
		
	}
	
	@Transactional
	public void deleteById(Long id)  throws NewResourceNotFoundException {
		
		findById(id);
		
		restauranteRepository.deleteById(id);

				
	}
	

}
