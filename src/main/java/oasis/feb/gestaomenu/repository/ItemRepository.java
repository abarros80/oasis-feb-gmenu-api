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

import oasis.feb.gestaomenu.model.Item;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "itens", path = "itens")
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	
	// delete operations aren't exposed via rest
	// They are exposed in Controller.
    @Override
    @RestResource(exported = false)
    void deleteById(Long id);
 
    @Override
    @RestResource(exported = false)
    void delete(Item item);
 
    // We don't expose this method via rest here as we want to extend the logic.
    // It is exposed in Controller.
    @Override
    @RestResource(exported=false)
    Item save(Item item);
	
	
	
	List<Item> findByActivoAndItemCardapioCardapioIdAndItemCardapioCardapioActivo(boolean itactivo, Long cid, boolean cactivo);
	
	//NOME -----------------------------------------------------------------------------------------
	
	Page<Item> findByNomePtContainingIgnoreCaseAndActivoOrderByNomePt(String nome, boolean activo, Pageable pageable);
	
	Page<Item> findByActivoOrderByNomePt(boolean activo, Pageable pageable);
	
	/*
	Optional<Item> findByNomeOrderByNome(String nome);

	Optional<Item> findByNomeIgnoreCaseOrderByNome(String nome);	
	
	Optional<Item> findByNomeIgnoreCaseAndActivoOrderByNome(String nome, boolean activo);
	
	Page<Item>  findByNomeContainingIgnoreCaseAndActivo(String nome, boolean activo, Pageable pageable);
	
	Boolean existsByNome(String nome);
	
	//PAI  -----------------------------------------------------------------------------------------
	
	long countByPaiId(Long id); 
	
	Page<Item> findByPaiId(Long id, Pageable pageable); 

	Page<Item> findByPaiIdAndActivo(Long id,  boolean activo, Pageable pageable);
	
	long countByPaiNome(Long id); 
	
	Page<Item> findByPaiNome(String nome, Pageable pageable); 

	Page<Item> findByPaiNomeAndActivo(String nome, boolean activo, Pageable pageable); 
	
	*/

	//DESC PT -----------------------------------------------------------------------------------------
	
	Page<Item>  findByDescPtContainingIgnoreCaseAndActivo(String descPt, boolean activo, Pageable pageable);
	
	//DESC ING -----------------------------------------------------------------------------------------
	
	Page<Item>  findByDescIngContainingIgnoreCaseAndActivo(String descIng, boolean activo, Pageable pageable);
	
	//DESC FR -----------------------------------------------------------------------------------------
	
	Page<Item>  findByDescFrContainingIgnoreCaseAndActivo(String descFr, boolean activo, Pageable pageable);
	
	//TIPO ITEM -----------------------------------------------------------------------------------------

	long countByTipoItemId(long id);
	
	long countByTipoItemNome(String nome);
	
	Page<Item>  findByTipoItemId(Long id, Pageable pageable);
	
	Page<Item>  findByTipoItemIdAndActivo(Long id, boolean activo, Pageable pageable);
	
	Page<Item>  findByTipoItemNomeContainingIgnoreCaseAndActivo(String nome, boolean activo, Pageable pageable);
	
	
	//DATA CADASTRO -----------------------------------------------------------------------------------------
	
	//Page<Item> findByLogDataCriacaoBetween(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal, Pageable pageable);



}
