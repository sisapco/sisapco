package co.com.sisapco;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import co.com.sisapco.dto.CopropiedadDTO;
import co.com.sisapco.util.ConvertCopropiedad;
import co.com.sisapco.util.CORSConfig;

@SpringBootApplication
public class SisapcoApplication extends SpringBootServletInitializer  {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(SisapcoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SisapcoApplication.class, args);
	}
	
	@Bean
	public CopropiedadDTO copropiedadDTO() {
		
		return new CopropiedadDTO();
	}
	
	/*@Bean
	public CORSConfig corsConfig() {
	      return new CORSConfig();
	}
	*/
	
}
