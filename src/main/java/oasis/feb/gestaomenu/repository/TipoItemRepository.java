package oasis.feb.gestaomenu.repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;

import oasis.feb.gestaomenu.model.TipoItem;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "tipoitens", path = "tipoitens")
public interface TipoItemRepository extends JpaRepository<TipoItem, Long> {
	
	
	// delete operations aren't exposed via rest
	// They are exposed in Controller.
    @Override
    @RestResource(exported = false)
    void deleteById(Long id);
 
    @Override
    @RestResource(exported = false)
    void delete(TipoItem titem);
 
    // We don't expose this method via rest here as we want to extend the logic.
    // It is exposed in Controller.
    @Override
    @RestResource(exported=false)
    TipoItem save(TipoItem titem);
    
    
	
	//ID
	
	Optional<TipoItem> findById(long id);
	
	//ACTIVO
	
	List<TipoItem>  findByActivoOrderByNome(boolean activo);
	
	//Page<TipoItem>  findByActivoOrderByNome(boolean activo, Pageable pageable);
				
	
	//NOME -----------------------------------------------------------------------------------------
	

	Optional<TipoItem> findByNomeIgnoreCase(String nome);	
	
	Optional<TipoItem> findByNomeIgnoreCaseAndActivo(String nome, boolean activo);
	
	//Page<TipoItem>  findByNomeContainingIgnoreCaseAndActivo(String nome, boolean activo, Pageable pageable);
	
	List<TipoItem>  findByNomeContainingIgnoreCaseAndActivo(String nome, boolean activo);
	
	Boolean existsByNome(String nome);
	
	//DATA CADASTRO -----------------------------------------------------------------------------------------
	
	//Page<TipoItem> findByDataCadastroBetween(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal, Pageable pageable);



}