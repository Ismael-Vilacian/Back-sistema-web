package br.com.unialfa.ecomerce.administrador.service;

import br.com.unialfa.ecomerce.administrador.domain.adm;
import br.com.unialfa.ecomerce.administrador.repositorio.admRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/adm")
public class admController {

    @Autowired
    private admRepositorio admRepositorio;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<adm> admRepositorio(){
        return admRepositorio.findAll();
    }

    @PostMapping(path = "/add")
    public void cadastrarAdm(@RequestBody adm admVariavel){
        admRepositorio.save(admVariavel);
    }

    @PutMapping(path = "/edit")
    public void editarAdm(@RequestBody adm admVariavel){
        admRepositorio.save(admVariavel);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarAdm(@PathVariable(name = "id") long id){
        admRepositorio.deleteById(id);
    }
}
