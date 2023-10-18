package com.devsu.serviciocliente.infrastructure.common;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@EnableSwagger2
@Configuration
public class SwaggerConfig {

//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).securitySchemes(Arrays.asList(apiKey())).select()
//				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any()).build()
//				.apiInfo(apiEndPointinfo());
//	}
//
//	private ApiKey apiKey() {
//		return new ApiKey("JWT", "Authorization", "header");
//	}
//
//	private ApiInfo apiEndPointinfo() {
//		return new ApiInfoBuilder().title("Api de banco")
//				.description("Servicios para la consulta de Clientes, Movimientos, Cuentas ").license("MIT").version("1.0.0")
//				.licenseUrl("https://opensource.org/faq#osd").build();
//	}
    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiEndPointinfo())
                .externalDocs(new ExternalDocumentation()
                        .description("SpringCLientes Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }

    private Info apiEndPointinfo() {
        return new Info().title("DEVSU banco Clientes")
                        .description("Spring bank application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")); 
    }
}
