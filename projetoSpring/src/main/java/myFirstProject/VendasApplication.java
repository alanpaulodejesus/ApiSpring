package myFirstProject;

import myFirstProject.domain.entity.Cliente;
import myFirstProject.domain.entity.Pedido;
import myFirstProject.domain.repository.Clientes;
import myFirstProject.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes,
                                  @Autowired Pedidos pedidos
    ){
        return args -> {

            //clientes.save(new Cliente("Alfan"));
            System.out.println("SALVANDO CLIENTE..");
            Cliente nome= new Cliente("Alan");
            clientes.save(nome);

            Pedido p = new Pedido();
            p.setCliente(nome);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);

            Cliente cliente = clientes.findClienteFetchPedidos(nome.getId());
            System.out.println(cliente);
            System.out.println(cliente.getPedidos());


        };
    }

    public static void main(String[] args) {
        SpringApplication.run( VendasApplication.class,args );
    }

}
