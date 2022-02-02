package myFirstProject.repository;

import myFirstProject.model.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public class ClientesRepository {
    public void persistir(Cliente cliente) {
        //acessa base e salva cliente
    }
}
