package br.com.unialfa.ecomerce.cliente.service;

import br.com.unialfa.ecomerce.cliente.domain.cliente;
import br.com.unialfa.ecomerce.cliente.repositorio.clienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/cliente")
public class clienteController {
    @Autowired
    private clienteRepositorio clienteRepositorio;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<cliente> listarCliente(){

        return clienteRepositorio.findAll();
    }

    @PostMapping(path = "/add")
    public void cadastrarCliente( @RequestBody cliente cliente ){

        clienteRepositorio.save(cliente);
    }

    @PutMapping(path = "/edit")
    public void editarCliente( @RequestBody cliente cliente ){

        clienteRepositorio.save(cliente);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarCliente(@PathVariable(name = "id") long id){
        clienteRepositorio.findById(id);
    }


}
