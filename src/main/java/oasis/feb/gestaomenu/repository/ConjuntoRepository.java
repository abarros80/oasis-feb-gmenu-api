package oasis.feb.gestaomenu.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

import oasis.feb.gestaomenu.model.Conjunto;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "conjuntos", path = "conjuntos")
public interface ConjuntoRepository  extends JpaRepository<Conjunto, Long>{

	
	//NOME -----------------------------------------------------------------------------------------
	
	Optional<Conjunto> findByNomeOrderByNome(String nome);

	Optional<Conjunto> findByNomeIgnoreCaseOrderByNome(String nome);	
	
	Optional<Conjunto> findByNomeIgnoreCaseAndActivoOrderByNome(String nome, boolean activo);
	
	Page<Conjunto>  findByNomeContainingIgnoreCaseAndActivo(String nome, boolean activo, Pageable pageable);
	
	Boolean existsByNome(String nome);


	//DESC PT -----------------------------------------------------------------------------------------
	
	Page<Conjunto>  findByDescPtContainingIgnoreCaseAndActivo(String descPt, boolean activo, Pageable pageable);
	
	//DESC ING -----------------------------------------------------------------------------------------
	
	Page<Conjunto>  findByDescIngContainingIgnoreCaseAndActivo(String descIng, boolean activo, Pageable pageable);
	
	//DESC FR -----------------------------------------------------------------------------------------
	
	Page<Conjunto>  findByDescFrContainingIgnoreCaseAndActivo(String descFr, boolean activo, Pageable pageable);
	
	//TIPO CONJUNTO -----------------------------------------------------------------------------------------

	long countByTipoConjuntoId(long id);
	
	long countByTipoConjuntoNome(String nome);
	
	Page<Conjunto>  findByTipoConjuntoId(Long id, Pageable pageable);
	
	Page<Conjunto>  findByTipoConjuntoIdAndActivo(Long id, boolean activo, Pageable pageable);
	
	Page<Conjunto>  findByTipoConjuntoNomeContainingIgnoreCaseAndActivo(String nome, boolean activo, Pageable pageable);
	
	
	//DATA CADASTRO -----------------------------------------------------------------------------------------
	
	Page<Conjunto> findByDataCadastroBetween(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal, Pageable pageable);





}
