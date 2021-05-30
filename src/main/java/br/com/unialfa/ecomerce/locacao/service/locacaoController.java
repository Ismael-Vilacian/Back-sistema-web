package br.com.unialfa.ecomerce.locacao.service;

import br.com.unialfa.ecomerce.cliente.domain.cliente;
import br.com.unialfa.ecomerce.locacao.domain.locacao;
import br.com.unialfa.ecomerce.locacao.repositorio.locacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/locacao")
public class locacaoController {

    @Autowired
    private locacaoRepositorio locacaoRepositorio;

    @GetMapping(path = "/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<locacao> listarLocacao(@PathVariable long idCliente){
        cliente Cliente = new cliente();
        Cliente.setIdUser((int) idCliente);
        return locacaoRepositorio.findByCliente(Cliente);
    }

    @PostMapping(path = "/add")
    public void cadastrarLocacao(@RequestBody locacao locacaoVariavel){
        locacaoRepositorio.save(locacaoVariavel);
    }

    @PutMapping(path = "/edit")
    public void editarLocacao(@RequestBody locacao locacaoVariavel){
        locacaoRepositorio.save(locacaoVariavel);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarLocacao(@PathVariable(name = "id") long id){
        locacaoRepositorio.deleteById(id);
    }
}
