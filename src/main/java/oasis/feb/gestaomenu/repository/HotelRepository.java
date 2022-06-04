package oasis.feb.gestaomenu.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import oasis.feb.gestaomenu.model.Hotel;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "hotels", path = "hotels")
public interface HotelRepository extends JpaRepository<Hotel, Long> {
	
	Optional<Hotel> findById(long id);
	
	Page<Hotel>  findByNomeContainingIgnoreCaseAndActivo(String nome, boolean activo, Pageable pageable);

}
