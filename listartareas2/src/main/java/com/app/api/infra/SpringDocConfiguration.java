package com.app.api.infra;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Listado de Tareas")
                        .description("API Rest de la aplicación Listado de Tareas, que contiene las funcionalidades de CRUD de Tareas, así como programación y cancelación de tareas.")
                        .contact(new Contact()
                                .name("Leonardo Moya")
                                .email("leo.moya562@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://listado.tareas/api/licencia")));
    }

    @Bean
    public void message() {
        System.out.println("bearer is working");
    }
}
