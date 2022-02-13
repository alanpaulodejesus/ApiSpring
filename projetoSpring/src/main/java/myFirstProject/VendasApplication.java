package myFirstProject;

import myFirstProject.domain.entity.Cliente;
import myFirstProject.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {

            clientes.save(new Cliente("Alfan"));
            clientes.save(new Cliente("Alfan II"));


            List<Cliente> result = clientes.encontraPorNome("Alan");
            result.forEach(System.out::println);


        };
    }

    public static void main(String[] args) {
        SpringApplication.run( VendasApplication.class,args );
    }

}
