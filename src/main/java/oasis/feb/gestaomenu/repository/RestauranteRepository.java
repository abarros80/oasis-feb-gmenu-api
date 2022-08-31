package oasis.feb.gestaomenu.repository;

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
	
	Page<Restaurante> findByNomeContainingIgnoreCaseAndActivoOrderByNome(String nome, boolean activo, Pageable pageable);
	
	//Page<Hotel>  findByNomeContainingIgnoreCaseAndActivo(String nome, boolean activo, Pageable pageable);
	
	//TELEFONE -----------------------------------------------------------------------------------------
	
	Optional<Restaurante> findByTelefoneIgnoreCase(String telefone);
	
	Page<Restaurante> findByTelefoneContainingIgnoreCaseAndActivoOrderByTelefone(String telefone, boolean activo, Pageable pageable);
	
	//NumeroInterno
	
	Optional<Restaurante> findByNumeroInternoIgnoreCase(String num);
	
	Page<Restaurante> findByNumeroInternoContainingIgnoreCaseAndActivoOrderByNumeroInterno(String num, boolean activo, Pageable pageable);
	
	//Horario
	
	Page<Restaurante> findByHorarioContainingIgnoreCaseAndActivoOrderByHorario(String horario, boolean activo, Pageable pageable);

	
	
	//RELAÇÔES ==========================
	
	//HOTEL
	
	Optional<Restaurante> findByIdAndActivoAndHotelIdAndActivo(Long rid, boolean ra, Long hid, boolean ha);

}
 