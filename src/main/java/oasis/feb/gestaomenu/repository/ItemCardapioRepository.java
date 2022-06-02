package oasis.feb.gestaomenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import oasis.feb.gestaomenu.model.ItemCardapio;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "itemcardapios", path = "itemcardapios")
public interface ItemCardapioRepository  extends JpaRepository<ItemCardapio, Long> {

}
