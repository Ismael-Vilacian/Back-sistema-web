package br.com.unialfa.ecomerce.pagamento.service;


import br.com.unialfa.ecomerce.pagamento.Repositorio.*;
import br.com.unialfa.ecomerce.pagamento.domain.pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/pagamento")
public class pagamentoController {
    @Autowired
    private pagamentoRepositorio pagamentoRepositorio;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<pagamento> listarPagamentos(){

        return pagamentoRepositorio.findAll();
    }

    @PostMapping(path = "/add")
    public void cadastrarPagamento( @RequestBody pagamento pagamento ){

        pagamentoRepositorio.save(pagamento);
    }

    @PutMapping(path = "/edit")
    public void editarPagamento( @RequestBody pagamento pagamento ){

        pagamentoRepositorio.save(pagamento);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarPagamento(@PathVariable(name = "id") long id){
        pagamentoRepositorio.findById(id);
    }


}