package br.com.unialfa.ecomerce.cliente.service;

import br.com.unialfa.ecomerce.cliente.business.clienteBusiness;
import br.com.unialfa.ecomerce.cliente.domain.cliente;
import br.com.unialfa.ecomerce.cliente.repositorio.clienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


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

    @GetMapping(value = "/{idUser}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<cliente> clientePorid(@PathVariable(name = "idUser") int idUser){
        return clienteBusiness.clientePorId(idUser);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> cadastrarCliente(@RequestBody cliente cliente ){
        try {
            clienteBusiness.cadastrarCliente(cliente);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(cliente, HttpStatus.BAD_REQUEST);
        }

    }
    //@PutMapping(path = "/edit")
    //public ResponseEntity<?> editarCliente( @RequestBody cliente cliente ){
        //try {
            //clienteBusiness.editarCliente(cliente);
            //return new ResponseEntity<>(cliente, HttpStatus.OK);
        //}catch (Exception e){
          //  return new ResponseEntity<>(cliente, HttpStatus.BAD_REQUEST);
       // }
    //}
    @PutMapping(path = "/edit")
    public void editarCliente( @RequestBody cliente cliente ){
        clienteBusiness.editarCliente(cliente);
    }


    @PostMapping(path = "/delete")
    public ResponseEntity<?> deletarClientes(@RequestBody cliente cliente ){
        try {
            clienteBusiness.deletarCliente(cliente.getIdUser());
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(cliente, HttpStatus.BAD_REQUEST);
        }

    }

}
