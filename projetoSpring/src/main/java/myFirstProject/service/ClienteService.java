package myFirstProject.service;

import myFirstProject.model.Cliente;
import myFirstProject.repository.ClientesRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClientesRepository repository;

    public ClienteService(ClientesRepository repository){
        this.repository=repository;
    }

    public void salvarCliente(Cliente cliente){
        validarCliente( cliente );
        //ClientesRepository clientesRepository = new ClientesRepository(); Acesso direto não é interessante se fazer
        repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){

    }
}
