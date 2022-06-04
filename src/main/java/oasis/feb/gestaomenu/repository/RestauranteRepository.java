package oasis.feb.gestaomenu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import oasis.feb.gestaomenu.model.Hotel;
import oasis.feb.gestaomenu.model.Restaurante;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "restaurantes", path = "restaurantes")
public interface RestauranteRepository  extends JpaRepository<Restaurante, Long> {
	
	Optional<Restaurante> findByIdAndActivoAndHotelIdAndActivo(Long rid, boolean ra, Long hid, boolean ha);

}
 