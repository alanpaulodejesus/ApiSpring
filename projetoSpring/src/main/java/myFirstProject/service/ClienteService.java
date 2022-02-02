package myFirstProject.service;

import myFirstProject.model.Cliente;
import myFirstProject.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    //@Autowired --> outra maneira correta poderia ser desconsiderando o construtor
    private ClientesRepository repository;

    @Autowired
    public ClienteService(ClientesRepository repository){
        this.repository=repository;
    }

    public void salvarCliente(Cliente cliente){
        validarCliente( cliente );
        //ClientesRepository clientesRepository = new ClientesRepository(); --> Acesso direto não é interessante se fazer, correto usar injeção de dependências via construtor
        repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){

    }
}
