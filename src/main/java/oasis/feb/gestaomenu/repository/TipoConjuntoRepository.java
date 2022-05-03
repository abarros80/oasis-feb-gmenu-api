package oasis.feb.gestaomenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import oasis.feb.gestaomenu.model.TipoConjunto;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "tipoconjuntos", path = "tipoconjuntos")
public interface TipoConjuntoRepository extends JpaRepository<TipoConjunto, Long>{

}