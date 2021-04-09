package br.com.unialfa.ecomerce.carro.service;

import br.com.unialfa.ecomerce.carro.domain.carro;
import br.com.unialfa.ecomerce.carro.repositorio.carroRepositorio;
import br.com.unialfa.ecomerce.carro.validacoes.validacoesVeiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/carro")
public class carroController {

    @Autowired
    private carroRepositorio carroRepositorio;

    @Autowired
    private validacoesVeiculo validacoesVeiculo;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<carro> listarCarros(){
        return validacoesVeiculo.listarVeiculos();
    }

    @PostMapping(path = "/add")
    public void cadastrarCarro(@RequestBody carro carroVariavel){
        validacoesVeiculo.cadastrarVeiculo(carroVariavel);
    }

    @PutMapping(path = "/edit")
    public void editarCarro(@RequestBody carro carroVariavel){
        validacoesVeiculo.editarVeiculo(carroVariavel);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarCarro(@PathVariable(name = "id") long id){
        validacoesVeiculo.deletarVeiculo(id);
    }

}
