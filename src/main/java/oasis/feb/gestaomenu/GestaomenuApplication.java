package oasis.feb.gestaomenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
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
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration restconfig, CorsRegistry cors) {

		//Expoem ID
		restconfig.exposeIdsFor(Hotel.class);
		restconfig.exposeIdsFor(Restaurante.class);
		restconfig.exposeIdsFor(Cardapio.class);
		restconfig.exposeIdsFor(Item.class);
		restconfig.exposeIdsFor(TipoItem.class);
		restconfig.exposeIdsFor(User.class);
		restconfig.exposeIdsFor(Role.class);
		
		/*
		ExposureConfiguration config = restconfig.getExposureConfiguration();
        config.forDomainType(Item.class).withItemExposure((metadata, httpMethods) ->
          httpMethods.disable(HttpMethod.POST));
          */
		
		
 
	}

}
