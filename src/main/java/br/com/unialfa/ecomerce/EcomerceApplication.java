package br.com.unialfa.ecomerce;

import br.com.unialfa.ecomerce.cliente.domain.cliente;
import br.com.unialfa.ecomerce.cliente.repositorio.clienteRepositorio;
import br.com.unialfa.ecomerce.cliente.service.clienteController;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class EcomerceApplication {

	@Autowired
	private  clienteRepositorio clienteRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(EcomerceApplication.class, args);

	}

	@Bean
	InitializingBean SendDataBase(){
		cliente cli = new cliente();
		cli.setNome("Ismael Gomes");
		cli.setCpf("111.111.111-11");
		cli.setSexo('M');
		cli.setVersao(1);
		cli.setDataNascimento(LocalDate.now());
		clienteRepositorio.save(cli);
		return null;
	}

}
