package br.com.unialfa.ecomerce.carro.service;

import br.com.unialfa.ecomerce.carro.domain.carro;
import br.com.unialfa.ecomerce.carro.repositorio.carroRepositorio;
import br.com.unialfa.ecomerce.carro.validacoes.validacoesVeiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<carro> carroPorId(@PathVariable(name = "id") long id){
        return validacoesVeiculo.carroPorId(id);
    }

    @PostMapping(path = "/add")
    public void cadastrarCarro(@RequestBody carro carroVariavel){
        validacoesVeiculo.cadastrarVeiculo(carroVariavel);
    }

    @PutMapping(path = "/edit")
    public void editarCarro(@RequestBody carro carroVariavel){
        validacoesVeiculo.editarVeiculo(carroVariavel);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<?> deletarCarro(@RequestBody carro Carro ){
        try {
            validacoesVeiculo.deletarVeiculo(Carro.getId());
            System.out.println(Carro.getId());
            return new ResponseEntity<>(Carro, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(Carro, HttpStatus.BAD_REQUEST);
        }

    }
}
