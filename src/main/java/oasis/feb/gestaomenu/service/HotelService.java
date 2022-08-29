package oasis.feb.gestaomenu.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oasis.feb.gestaomenu.exception.NewResourceNotFoundException;
import oasis.feb.gestaomenu.model.Hotel;
import oasis.feb.gestaomenu.model.Log;
import oasis.feb.gestaomenu.model.dto.HotelReqDTO;
import oasis.feb.gestaomenu.repository.HotelRepository;


@Service
public class HotelService {
	
	@Autowired
    private HotelRepository hotelRepository;
	
	
	public Hotel findById(Long id) throws NewResourceNotFoundException {
		return hotelRepository.findById(id)
                .orElseThrow(() -> new NewResourceNotFoundException("Hotel não existe, id:" + id));	
	}
	
	@Transactional
	public Hotel create(Hotel obj){
		obj.setId(null);
		return hotelRepository.save(obj);
		
	}
	
	@Transactional
	public Hotel createFromDTO(HotelReqDTO hotelReqDTO){
		
		hotelReqDTO.setId(null);
		Hotel novoHotel = new Hotel();
		
		//Não existe idUser no Hotel
		BeanUtils.copyProperties(hotelReqDTO, novoHotel, "idUser");
		
		//Log
		Log novoLog = new Log();
		novoLog.setDataCriacao(LocalDateTime.now());
		novoLog.setDataAlteracao(LocalDateTime.now());
		novoLog.setIdUserCriacao(hotelReqDTO.getIdUser());
		novoLog.setIdUserAlteracao(hotelReqDTO.getIdUser());
		novoHotel.setLog(novoLog);

		//Inseri hotel  na BD		
		return hotelRepository.save(novoHotel);
		
	}
	
	@Transactional
	public Hotel update(Long id, HotelReqDTO hotelReqDTO)  throws NewResourceNotFoundException {
		
		Hotel existenteHotel  = findById(id);
		
		Log novoLog = new Log();
		novoLog.setDataCriacao(existenteHotel.getLog().getDataCriacao());
		novoLog.setIdUserCriacao(existenteHotel.getLog().getIdUserCriacao());
		
		BeanUtils.copyProperties(hotelReqDTO,existenteHotel, "idUser", "id");
		
		
		novoLog.setIdUserAlteracao(hotelReqDTO.getIdUser());
		novoLog.setDataAlteracao(LocalDateTime.now());
		existenteHotel.setLog(novoLog);
		
		
		existenteHotel.setId(id);
		return hotelRepository.save(existenteHotel);
		
		
	}

}
