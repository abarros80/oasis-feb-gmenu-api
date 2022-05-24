package oasis.feb.gestaomenu.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;

import oasis.feb.gestaomenu.model.TipoConjunto;

@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "tipoconjuntos", path = "tipoconjuntos")
public interface TipoConjuntoRepository extends JpaRepository<TipoConjunto, Long>{
	
	//NOME -----------------------------------------------------------------------------------------
	
	Optional<TipoConjunto> findByNomeOrderByNome(String nome);

	Optional<TipoConjunto> findByNomeIgnoreCaseOrderByNome(String nome);	
	
	Optional<TipoConjunto> findByNomeIgnoreCaseAndActivoOrderByNome(String nome, boolean activo);
	
	Page<TipoConjunto>  findByNomeContainingIgnoreCaseAndActivo(String nome, boolean activo, Pageable pageable);
	
	Boolean existsByNome(String nome);
	
	//DATA CADASTRO -----------------------------------------------------------------------------------------
	
	Page<TipoConjunto> findByDataCadastroBetween(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal, Pageable pageable);


}