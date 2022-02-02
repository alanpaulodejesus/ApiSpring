package myFirstProject.service;

import myFirstProject.model.Cliente;
import myFirstProject.repository.ClientesRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    public void salvarCliente(Cliente cliente){
        validarCliente( cliente );
        ClientesRepository clientesRepository = new ClientesRepository();
        clientesRepository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){

    }
}
