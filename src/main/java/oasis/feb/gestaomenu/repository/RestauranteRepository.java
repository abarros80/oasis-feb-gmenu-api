package oasis.feb.gestaomenu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import oasis.feb.gestaomenu.model.Restaurante;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "restaurantes", path = "restaurantes")
public interface RestauranteRepository  extends JpaRepository<Restaurante, Long> {


	// delete operations aren't exposed via rest
    @Override
    @RestResource(exported = false)
    void deleteById(Long id);
 
    @Override
    @RestResource(exported = false)
    void delete(Restaurante rest);
 
    // We don't expose this method via rest here as we want to extend the logic.
    @Override
    @RestResource(exported=false)
    Restaurante save(Restaurante rest);


    //ID
    
    Optional<Restaurante> findById(Long id);
    
    //ACTIVO
    
    Page<Restaurante> findByActivoOrderByNome(boolean activo, Pageable pageable);
     
	
	//NOME -----------------------------------------------------------------------------------------
    
    Optional<Restaurante> findByNomeIgnoreCase(String nome);
    
    Optional<Restaurante> findByNomeIgnoreCaseAndHotelId(String nome, Long hid);
	
	Page<Restaurante> findByNomeContainingIgnoreCaseAndActivoOrderByNome(String nome, boolean activo, Pageable pageable);
	
	Page<Restaurante> findByNomeContainingIgnoreCaseAndActivoAndHotelIdOrderByNome(String nome, boolean activo, Long hid, Pageable pageable);

	//Page<Hotel>  findByNomeContainingIgnoreCaseAndActivo(String nome, boolean activo, Pageable pageable);
	
	//TELEFONE -----------------------------------------------------------------------------------------
	
	Optional<Restaurante> findByTelefoneIgnoreCase(String telefone);
	
	Optional<Restaurante> findByTelefoneIgnoreCaseAndHotelId(String telefone, Long hid);
	
	Page<Restaurante> findByTelefoneContainingIgnoreCaseAndActivoOrderByTelefone(String telefone, boolean activo, Pageable pageable);
	
	Page<Restaurante> findByTelefoneContainingIgnoreCaseAndActivoAndHotelIdOrderByTelefone(String telefone, boolean activo, Long hid, Pageable pageable);
	
	//NumeroInterno
	
	Optional<Restaurante> findByNumeroInternoIgnoreCase(String num);
	
	Optional<Restaurante> findByNumeroInternoIgnoreCaseAndHotelId(String num, Long hid);
	
	Page<Restaurante> findByNumeroInternoContainingIgnoreCaseAndActivoOrderByNumeroInterno(String num, boolean activo, Pageable pageable);
	
	Page<Restaurante> findByNumeroInternoContainingIgnoreCaseAndActivoAndHotelIdOrderByNumeroInterno(String num, boolean activo, Long hid, Pageable pageable);
	
	//Horario
	
	Page<Restaurante> findByHorarioContainingIgnoreCaseAndActivoOrderByHorario(String horario, boolean activo, Pageable pageable);

	Page<Restaurante> findByHorarioContainingIgnoreCaseAndActivoAndHotelIdOrderByHorario(String horario, boolean activo, Long hid, Pageable pageable);

	
	
	//RELAÇÔES ==========================
	
	//HOTEL
	
	Page<Restaurante> findByHotelUsersId(Long uid, Pageable pageable);
	
	Page<Restaurante> findByHotelId(Long hid, Pageable pageable);
	
	Page<Restaurante> findByActivoAndHotelId(boolean ra, Long hid, Pageable pageable);
	
	//Page<Restaurante> findByActivoAndHotelIdOrderByNome(boolean ra, Long hid, Pageable pageable);
	
	List<Restaurante> findByActivoAndHotelIdOrderByNome(boolean ra, Long hid);

	
	Optional<Restaurante> findByIdAndActivoAndHotelIdAndActivo(Long rid, boolean ra, Long hid, boolean ha);

}
 