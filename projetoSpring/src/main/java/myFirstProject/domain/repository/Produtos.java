package myFirstProject.domain.repository;

import myFirstProject.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
