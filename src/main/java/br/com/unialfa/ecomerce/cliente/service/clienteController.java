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
    private clienteRepositorio clienteRep;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<cliente> listarCliente(){
        return clienteRep.findAll();
    }

    @PostMapping(path = "/add")
    public void cadastrarCliente(@RequestBody cliente clienteVariavel){
        clienteRep.save(clienteVariavel);
    }

    @PutMapping(path = "/edit")
    public void editarCliente(@RequestBody cliente clienteVariavel){
        clienteRep.save(clienteVariavel);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarCliente(@PathVariable(name = "id") long id){
        clienteRep.deleteById(id);
    }
}
