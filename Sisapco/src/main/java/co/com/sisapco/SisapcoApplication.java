package co.com.sisapco;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import co.com.sisapco.dto.CopropiedadDTO;
import co.com.sisapco.util.ConvertCopropiedad;

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
	

}
