package myFirstProject;

import myFirstProject.domain.enty.Cliente;
import myFirstProject.domain.repositorio.Clientes;
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


            boolean existe = clientes.existsByNome("Alan");
            System.out.println("Existe o: "+existe);


        };
    }

    public static void main(String[] args) {
        SpringApplication.run( VendasApplication.class,args );
    }

}
