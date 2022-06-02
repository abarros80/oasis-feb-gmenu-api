package oasis.feb.gestaomenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import oasis.feb.gestaomenu.model.RestauranteCardapio;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "restcardapios", path = "restcardapios")
public interface RestauranteCardapioRepository extends JpaRepository<RestauranteCardapio, Long> {

}
