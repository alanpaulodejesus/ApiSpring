package myFirstProject.domain.repository;

import myFirstProject.domain.entity.Cliente;
import myFirstProject.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

    List<Pedido>findByCliente(Cliente cliente);
}
