package br.com.unialfa.ecomerce.carro.repositorio;

import br.com.unialfa.ecomerce.carro.domain.carro;
import org.springframework.data.repository.CrudRepository;

public interface carroRepositorio extends CrudRepository<carro, Long> {
}
