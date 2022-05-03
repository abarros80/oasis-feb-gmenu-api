package oasis.feb.gestaomenu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import oasis.feb.gestaomenu.model.TipoItem;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "tipoitem", path = "tipoitem")
public interface TipoItemRepository extends JpaRepository<TipoItem, Long> {

}
