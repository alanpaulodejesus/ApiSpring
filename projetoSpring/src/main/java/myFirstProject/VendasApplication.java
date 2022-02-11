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

            clientes.salvar(new Cliente("Alan"));
            clientes.salvar(new Cliente("Alan II"));


            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " Atualizado!");
                clientes.atualizar(c);
            });


            System.out.println("Buscando..");
            clientes.buscarPorNome("Alan").forEach(System.out::println);

            System.out.println("Deletando..");
            clientes.obterTodos().forEach(c->{
                clientes.deletar(c);
            });

            todosClientes = clientes.obterTodos();
            if(todosClientes.isEmpty()){
                System.out.println("Nenhum encontrado");
            }else {
                todosClientes.forEach(System.out::println);
            }


            /*
            Cliente cliente2 = new Cliente();
            cliente2.setNome("Alan II");
            clientes.salvar(cliente);
            */
        };
    }

    public static void main(String[] args) {
        SpringApplication.run( VendasApplication.class,args );
    }

}
