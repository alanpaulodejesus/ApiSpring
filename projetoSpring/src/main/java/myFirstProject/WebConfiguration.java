package myFirstProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import sun.tools.jar.CommandLine;

@Configuration
@Development// --> Executa apenas em ambiente de development se config em properties para de development
public class WebConfiguration {

    @Bean(name="applicationName")
    public String applicationName(){
        return "Sistema de Vendas";
    }

    @Bean
    public CommandLineRunner executa(){
        return args -> {
            System.out.println("Rodando apenas em Desenvolvimento");
        };
    }
}
