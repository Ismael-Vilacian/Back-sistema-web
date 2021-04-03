package br.com.unialfa.ecomerce;

import br.com.unialfa.ecomerce.carro.domain.carro;
import br.com.unialfa.ecomerce.carro.repositorio.carroRepositorio;
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

	@Autowired
	private  carroRepositorio carroRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(EcomerceApplication.class, args);

	}
	@Bean
	InitializingBean SendCarroDataBase(){
		carro car = new carro();
		car.setMarca("BMW");
		car.setModelo("GT");
		car.setCor("Azul");
		car.setPlaca("OTA3060");
		carroRepositorio.save(car);
		return null;
	}

	@Bean
	InitializingBean SendClienteDataBase(){
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
