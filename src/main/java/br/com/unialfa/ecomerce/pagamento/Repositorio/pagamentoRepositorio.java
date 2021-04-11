package br.com.unialfa.ecomerce.pagamento.Repositorio;

import br.com.unialfa.ecomerce.pagamento.domain.pagamento;
import org.springframework.data.repository.CrudRepository;

public interface pagamentoRepositorio extends CrudRepository<pagamento, Long> {
}
