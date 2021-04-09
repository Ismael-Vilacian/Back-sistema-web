package br.com.unialfa.ecomerce.cliente.service;

import br.com.unialfa.ecomerce.cliente.business.clienteBusiness;
import br.com.unialfa.ecomerce.cliente.domain.cliente;
import br.com.unialfa.ecomerce.cliente.repositorio.clienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/cliente")
public class clienteController {
    @Autowired
    private clienteRepositorio clienteRepositorio;
    @Autowired
    private clienteBusiness clienteBusiness;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<cliente> listarCliente(){

        return clienteBusiness.listarCliente();
    }

    @PostMapping(path = "/add")
    public void cadastrarCliente( @RequestBody cliente cliente ){

        clienteBusiness.cadastrarCliente(cliente);
    }

    @PutMapping(path = "/edit")
    public void editarCliente( @RequestBody cliente cliente ){

        clienteBusiness.editarCliente(cliente);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarCliente(@PathVariable(name = "id") long id){
        clienteBusiness.deletarCliente(id);
    }


}
