package oasis.feb.gestaomenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


import oasis.feb.gestaomenu.model.*;

@SpringBootApplication
@EnableJpaAuditing // por causa de @CreatedDate
public class GestaomenuApplication  implements RepositoryRestConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(GestaomenuApplication.class, args);
	}
	
	
	@PostConstruct
    private void init() {
       System.out.println("TESTE ADILSON BARROS");  
    }
	
	@Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        config.exposeIdsFor(Hotel.class);
        config.exposeIdsFor(Restaurante.class);
        config.exposeIdsFor(Cardapio.class);
        config.exposeIdsFor(Item.class);
        config.exposeIdsFor(TipoItem.class);
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(Role.class);
 
	}

}
