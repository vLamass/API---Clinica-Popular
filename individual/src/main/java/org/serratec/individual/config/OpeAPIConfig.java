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
        contato.setEmail("viniciuslamas@gmail.com");
        contato.setName("Vinicius Lamas");
        contato.url("https://github.com/vLamass");

        License apacheLicense = new License()
            .name("Apache License 2.0")
            .url("\"https://www.apache.org/licenses/LICENSE-2.0\"");
        

        Info info = new Info()
        .title("Clínica Popular")  
        .version("1.0")
        .contact(contato)
        .description("Documentação da API do sistema")
        .termsOfService("")
        .license(apacheLicense);

        return new OpenAPI().info(info);

    }
}