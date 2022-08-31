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
    
    List<Cardapio> findByActivoAndItemCardapioCardapioIdAndItemCardapioCardapioActivo(boolean itactivo, Long cid, boolean cactivo);
    
    //CODIGOREDUZIDO
    
    Page<Cardapio> findByCodigoReduzidoContainingIgnoreCaseAndActivoOrderByCodigoReduzido(String codigo, boolean activo, Pageable pageable);
	
	//NOME PT -----------------------------------------------------------------------------------------
	
	Page<Cardapio> findByNomePtContainingIgnoreCaseAndActivoOrderByNomePt(String nome, boolean activo, Pageable pageable);
	
	//NOME ING -----------------------------------------------------------------------------------------
	
	Page<Cardapio> findByNomeIngContainingIgnoreCaseAndActivoOrderByNomeIng(String nome, boolean activo, Pageable pageable);
	
	//NOME FR -----------------------------------------------------------------------------------------
	
	Page<Cardapio> findByNomeFrContainingIgnoreCaseAndActivoOrderByNomeFr(String nome, boolean activo, Pageable pageable);
	
	
	//RELAÇÔES ==========================
	
	//RESTAURANTE_CARDAPIO
	
	
	List<Cardapio>  findByActivoAndRestauranteCardapioRestauranteIdAndRestauranteCardapioRestauranteActivo(boolean activo, Long rid, boolean ractivo);

	
	List<Cardapio>  findByActivoAndRestauranteCardapioRestauranteIdAndRestauranteCardapioRestauranteActivoAndRestauranteCardapioCardapioIdAndRestauranteCardapioCardapioActivo(boolean activo, Long rid, boolean ractivo, Long cid, boolean cactivo);

}
