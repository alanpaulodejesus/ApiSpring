package myFirstProject.domain.repositorio;

import myFirstProject.domain.enty.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


public interface Clientes extends JpaRepository<Cliente,Integer> {

    List <Cliente> findByNomeLike (String nome);

    boolean existsByNome(String nome);

}
