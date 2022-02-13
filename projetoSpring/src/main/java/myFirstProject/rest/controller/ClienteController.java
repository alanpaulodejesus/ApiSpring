package myFirstProject.rest.controller;

import myFirstProject.domain.entity.Cliente;
import myFirstProject.domain.repository.Clientes;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClienteController {

    private Clientes clientes;

    public ClienteController(Clientes clientes) {
        this.clientes = clientes;
    }

    @GetMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity getClienteById(@PathVariable Integer id){
        Optional<Cliente>cliente=clientes.findById(id);
        if (cliente.isPresent()){
            return ResponseEntity.ok(cliente.get()); //==> Retorna Cliente com status ok
        }

        return ResponseEntity.notFound().build();
    }

    /*
    @RequestMapping(
            value = "/hello/{nome}",
            method = RequestMethod.GET
    )
    @ResponseBody
    public String helloCliente(@PathVariable("nome") String nomeCliente){
        return String.format("Hello %s ", nomeCliente);
    }
     */

}
