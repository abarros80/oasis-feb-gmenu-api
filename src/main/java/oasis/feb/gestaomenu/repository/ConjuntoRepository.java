package oasis.feb.gestaomenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import oasis.feb.gestaomenu.model.Conjunto;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "conjuntos", path = "conjuntos")
public interface ConjuntoRepository  extends JpaRepository<Conjunto, Long>{

}
