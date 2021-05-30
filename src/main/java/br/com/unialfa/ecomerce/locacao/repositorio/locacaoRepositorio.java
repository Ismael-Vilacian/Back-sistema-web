package br.com.unialfa.ecomerce.locacao.repositorio;

import br.com.unialfa.ecomerce.cliente.domain.cliente;
import br.com.unialfa.ecomerce.locacao.domain.locacao;
import org.springframework.data.repository.CrudRepository;

public interface locacaoRepositorio extends CrudRepository<locacao, Long> {
    public Iterable<locacao> findByCliente(cliente Cliente);
}
