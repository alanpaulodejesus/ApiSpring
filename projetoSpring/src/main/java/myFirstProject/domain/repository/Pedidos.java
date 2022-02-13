package myFirstProject.domain.repository;

import myFirstProject.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
}
