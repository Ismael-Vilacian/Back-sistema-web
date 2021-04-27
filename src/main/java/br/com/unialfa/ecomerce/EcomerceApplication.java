package br.com.unialfa.ecomerce;

import br.com.unialfa.ecomerce.administrador.domain.adm;
import br.com.unialfa.ecomerce.administrador.repositorio.admRepositorio;
import br.com.unialfa.ecomerce.carro.domain.carro;
import br.com.unialfa.ecomerce.carro.repositorio.carroRepositorio;
import br.com.unialfa.ecomerce.cliente.domain.cliente;
import br.com.unialfa.ecomerce.cliente.repositorio.clienteRepositorio;
import br.com.unialfa.ecomerce.cliente.service.clienteController;
import br.com.unialfa.ecomerce.locacao.domain.locacao;
import br.com.unialfa.ecomerce.locacao.repositorio.locacaoRepositorio;
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

	@Autowired
	private admRepositorio admRepositorio;

	@Autowired
	private locacaoRepositorio locacaoRepositorio;

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

	@Bean
	InitializingBean SendCarDataBase(){
		carro car = new carro();
		car.setMarca("BMW");
		car.setModelo("GT");
		car.setCor("Azul");
		car.setPlaca("OTA3060");
		car.setAnoVeiculo("2021");
		car.setValorDiaria(130.00);
		carroRepositorio.save(car);
		return null;
	}

	@Bean
	InitializingBean SendAdmDataBase(){
		adm admAcesso = new adm();
		admAcesso.setNome("Ismael");
		admRepositorio.save(admAcesso);
		return null;
	}


	@Bean
	InitializingBean SendLocacaoDataBase(){
		locacao locacaoR = new locacao();
		locacaoR.setValorTotal(550.00);
		locacaoR.setDataPedido(LocalDate.now());
		locacaoR.setCliente(null);
		locacaoRepositorio.save(locacaoR);
		return null;
	}

}
