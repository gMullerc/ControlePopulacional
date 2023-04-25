package br.com.magnasistemas.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components())
				.info(new Info().title("Gestão de pessoas API").description(
						"API Rest Gestão de pessoas, contendo as funcionalidades de CRUD de Cidadão e de Profissionais")
						.contact(new Contact().name("Guilherme Muller").email("gmuller@magnasistemas.com")));

	}
}
