package oasis.feb.gestaomenu.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import oasis.feb.gestaomenu.model.Hotel;


@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "hoteis", path = "hoteis")
public interface HotelRepository extends JpaRepository<Hotel, Long> {
	
	// delete operations aren't exposed via rest
    @Override
    @RestResource(exported = false)
    void deleteById(Long id);
 
    @Override
    @RestResource(exported = false)
    void delete(Hotel hotel);
 
    // We don't expose this method via rest here as we want to extend the logic.
    @Override
    @RestResource(exported=false)
    Hotel save(Hotel hotel);


    //ID
    
    Optional<Hotel> findById(Long id);
    
    //ACTIVO
    
    Page<Hotel> findByActivoOrderByNome(boolean activo, Pageable pageable);
	
	//NOME -----------------------------------------------------------------------------------------
	
	Page<Hotel> findByNomeContainingIgnoreCaseAndActivoOrderByNome(String nome, boolean activo, Pageable pageable);
	
	//Page<Hotel>  findByNomeContainingIgnoreCaseAndActivo(String nome, boolean activo, Pageable pageable);

	//EMAIL -----------------------------------------------------------------------------------------
	
	Page<Hotel>  findByEmailContainingIgnoreCaseAndActivoOrderByNome(String email, boolean activo, Pageable pageable);
	
	//TELEFONE -----------------------------------------------------------------------------------------
	
	Page<Hotel>  findByTelefoneContainingIgnoreCaseAndActivoOrderByNome(String telefone, boolean activo, Pageable pageable);
	

	
	
	
	//RELAÇÔES ==========================
	
	//USER
	
	List<Hotel>  findByActivoAndUsersIdOrderByNome(boolean activo, Long id);
	
	
	
	

}
