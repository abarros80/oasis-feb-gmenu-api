package oasis.feb.gestaomenu.repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;

import oasis.feb.gestaomenu.model.Hotel;
import oasis.feb.gestaomenu.model.TipoItem;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "tipoitens", path = "tipoitens")
public interface TipoItemRepository extends JpaRepository<TipoItem, Long> {
	
	
	Optional<TipoItem> findById(long id);
	
	//Page<TipoItem>  findByActivoOrderByNome(boolean activo, Pageable pageable);
	
	List<TipoItem>  findByActivoOrderByNome(boolean activo);
			
	
	//NOME -----------------------------------------------------------------------------------------
	

	Optional<TipoItem> findByNomeIgnoreCaseOrderByNome(String nome);	
	
	Optional<TipoItem> findByNomeIgnoreCaseAndActivoOrderByNome(String nome, boolean activo);
	
	//Page<TipoItem>  findByNomeContainingIgnoreCaseAndActivo(String nome, boolean activo, Pageable pageable);
	
	List<TipoItem>  findByNomeContainingIgnoreCaseAndActivo(String nome, boolean activo);
	
	Boolean existsByNome(String nome);
	
	//DATA CADASTRO -----------------------------------------------------------------------------------------
	
	//Page<TipoItem> findByDataCadastroBetween(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal, Pageable pageable);



}