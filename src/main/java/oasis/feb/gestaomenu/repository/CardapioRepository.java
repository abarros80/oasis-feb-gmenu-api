package oasis.feb.gestaomenu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import oasis.feb.gestaomenu.model.Cardapio;
import oasis.feb.gestaomenu.model.Hotel;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "cardapios", path = "cardapios")
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
	
	List<Cardapio>  findByActivoAndRestauranteCardapioRestauranteIdAndRestauranteCardapioRestauranteActivo(boolean activo, Long rid, boolean ractivo);

	
	List<Cardapio>  findByActivoAndRestauranteCardapioRestauranteIdAndRestauranteCardapioRestauranteActivoAndRestauranteCardapioCardapioIdAndRestauranteCardapioCardapioActivo(boolean activo, Long rid, boolean ractivo, Long cid, boolean cactivo);

}
