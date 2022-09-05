package oasis.feb.gestaomenu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import oasis.feb.gestaomenu.model.Cardapio;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "cardapios", path = "cardapios")
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
	
	// delete operations aren't exposed via rest
	// They are exposed in Controller.
    @Override
    @RestResource(exported = false)
    void deleteById(Long id);
 
    @Override
    @RestResource(exported = false)
    void delete(Cardapio item);
 
    // We don't expose this method via rest here as we want to extend the logic.
    // It is exposed in Controller.
    @Override
    @RestResource(exported=false)
    Cardapio save(Cardapio item);
    
    
    //ID
    
    Optional<Cardapio> findById(Long id);
    
    //ACTIVO
    
    Page<Cardapio> findByActivo(boolean activo, Pageable pageable);
    
    Page<Cardapio> findByActivoAndHotelId(boolean activo, Long hid, Pageable pageable);
    
	Page<Cardapio>  findByActivoAndHotelIdAndRestauranteCardapioRestauranteId(boolean activo, Long hid, Long rid, Pageable pageable);
    
    List<Cardapio> findByActivoAndItemCardapioCardapioIdAndItemCardapioCardapioActivoOrderByNomePt(boolean activo, Long cid, boolean cactivo);
    
    //CODIGOREDUZIDO
    
    Page<Cardapio> findByCodigoReduzidoContainingIgnoreCaseAndActivo(String codigo, boolean activo, Pageable pageable);
    
    Page<Cardapio> findByCodigoReduzidoContainingIgnoreCaseAndActivoAndHotelId(String codigo, boolean activo, Long hid, Pageable pageable);

    Page<Cardapio> findByCodigoReduzidoContainingIgnoreCaseAndActivoAndHotelIdAndRestauranteCardapioRestauranteId(String codigo, boolean activo, Long hid, Long rid, Pageable pageable);

    
	//NOME PT -----------------------------------------------------------------------------------------
	
	Page<Cardapio> findByNomePtContainingIgnoreCaseAndActivo(String nome, boolean activo, Pageable pageable);
	
	Page<Cardapio> findByNomePtContainingIgnoreCaseAndActivoAndHotelId(String nome, boolean activo, Long hid, Pageable pageable);
	
	Page<Cardapio> findByNomePtContainingIgnoreCaseAndActivoAndHotelIdAndRestauranteCardapioRestauranteId(String nome, boolean activo, Long hid, Long rid, Pageable pageable);

	
	//NOME ING -----------------------------------------------------------------------------------------
	
	Page<Cardapio> findByNomeIngContainingIgnoreCaseAndActivo(String nome, boolean activo, Pageable pageable);
	
	Page<Cardapio> findByNomeIngContainingIgnoreCaseAndActivoAndHotelId(String nome, boolean activo, Long hid, Pageable pageable);

	Page<Cardapio> findByNomeIngContainingIgnoreCaseAndActivoAndHotelIdAndRestauranteCardapioRestauranteId(String nome, boolean activo, Long hid, Long rid, Pageable pageable);

	
	//NOME FR -----------------------------------------------------------------------------------------
	
	Page<Cardapio> findByNomeFrContainingIgnoreCaseAndActivo(String nome, boolean activo, Pageable pageable);
	
	Page<Cardapio> findByNomeFrContainingIgnoreCaseAndActivoAndHotelId(String nome, boolean activo, Long hid, Pageable pageable);
	
	Page<Cardapio> findByNomeFrContainingIgnoreCaseAndActivoAndHotelIdAndRestauranteCardapioRestauranteId(String nome, boolean activo, Long hid, Long rid, Pageable pageable);

	
	
	//RELAÇÔES ==========================
	
	//HOTEL
	
	Page<Cardapio> findByHotelUsersId(Long uid, Pageable pageable);
	
	Page<Cardapio> findByHotelId(Long hid, Pageable pageable);
	
	Page<Cardapio>  findByHotelIdAndRestauranteCardapioRestauranteId(Long hid, Long rid, Pageable pageable);
	
	Optional<Cardapio> findByIdAndActivoAndHotelIdAndActivo(Long rid, boolean ra, Long hid, boolean ha);
	
	
	
	//RESTAURANTE_CARDAPIO
	

	
	Page<Cardapio>  findByActivoAndHotelIdAndRestauranteCardapioRestauranteIdAndRestauranteCardapioRestauranteActivo(boolean activo, Long hid, Long rid, boolean ractivo, Pageable pageable);
	
	Page<Cardapio>  findByActivoAndHotelIdAndRestauranteCardapioRestauranteIdAndRestauranteCardapioRestauranteActivoAndRestauranteCardapioCardapioIdAndRestauranteCardapioCardapioActivo(boolean activo, Long hid, Long rid, boolean ractivo, Long cid, boolean cactivo, Pageable pageable);


	
	List<Cardapio>  findByActivoAndRestauranteCardapioRestauranteIdAndRestauranteCardapioRestauranteActivo(boolean activo, Long rid, boolean ractivo);
	
	List<Cardapio>  findByActivoAndRestauranteCardapioRestauranteIdAndRestauranteCardapioRestauranteActivoAndRestauranteCardapioCardapioIdAndRestauranteCardapioCardapioActivo(boolean activo, Long rid, boolean ractivo, Long cid, boolean cactivo);

}
