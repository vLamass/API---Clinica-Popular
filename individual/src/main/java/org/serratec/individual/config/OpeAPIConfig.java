package org.serratec.individual.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;



@Configuration
public class OpeAPIConfig {

    @Bean
    public OpenAPI myOpenAPI(){

        Contact contato  = new Contact();
        contato.setEmail("email");
        contato.setName("name");
        contato.url("url");

        License apacheLicense = new License()
            .name("Apache License")
            .url("site");
        

        Info info = new Info()
        .title("")  
        .version("1.0")
        .contact(contato)
        .description("")
        .termsOfService("")
        .license(apacheLicense);

        return new OpenAPI().info(info);

    }
}