package com.eltonfernandesdev.nexo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Nexo",
                version = "v1.0.0",
                contact = @Contact(
                        name = "Elton Fernandes",
                        email = "eltonfernandes.ef47@gmail.com"
                ),
                description = "Sistema de gestão de pequenos negócios"
        )
)
public class OpenApiConfiguration {

}
