package br.com.unialfa.ecomerce.cliente.repositorio;

import br.com.unialfa.ecomerce.cliente.domain.cliente;
import org.springframework.data.repository.CrudRepository;

public interface clienteRepositorio extends CrudRepository<cliente, Long> {
}