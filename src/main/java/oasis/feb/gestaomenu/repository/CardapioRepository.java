package oasis.feb.gestaomenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import oasis.feb.gestaomenu.model.Cardapio;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "cardapios", path = "cardapios")
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {

}
