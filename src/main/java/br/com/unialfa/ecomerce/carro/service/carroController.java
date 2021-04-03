package br.com.unialfa.ecomerce.carro.service;

import br.com.unialfa.ecomerce.carro.domain.carro;
import br.com.unialfa.ecomerce.carro.repositorio.carroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/carro")
public class carroController {

    @Autowired
    private carroRepositorio carroRepositorio;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<carro> cadastrarCarros(){
        return carroRepositorio.findAll();
    }

    @PostMapping(path = "/add")
    public void cadastrarCarro(@RequestBody carro carroVariavel){
        carroRepositorio.save(carroVariavel);
    }

    @PutMapping(path = "/edit")
    public void editarCarro(@RequestBody carro carroVariavel){
        carroRepositorio.save(carroVariavel);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarCarro(@PathVariable(name = "id") long id){
        carroRepositorio.deleteById(id);
    }

}
