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
    public void cadastrarCliente(@RequestBody cliente clienteVariavel){
        clienteRepositorio.save(clienteVariavel);
    }

    @PutMapping(path = "/edit")
    public void editarCliente(@RequestBody cliente clienteVariavel){
        clienteRepositorio.save(clienteVariavel);
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody void deletarcliente(@PathVariable(name = "id") long id){
        clienteRepositorio.deleteById(id);
    }


}
