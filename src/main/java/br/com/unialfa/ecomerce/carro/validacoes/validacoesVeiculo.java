package br.com.unialfa.ecomerce.carro.validacoes;

import br.com.unialfa.ecomerce.carro.domain.carro;
import br.com.unialfa.ecomerce.carro.repositorio.carroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

@Service
public class validacoesVeiculo {
    @Autowired
    private carroRepositorio carroRepositorio;

    public Iterable<carro> listarVeiculos() {
        return carroRepositorio.findAll();
    }

    public void cadastrarVeiculo(carro carro) {
        carroRepositorio.save(carro);
        /*if (validaVeiculo(carro.getPlaca())) {
            carroRepositorio.save(carro);
        } else {
            System.out.println("Placa Invalida");
        }
        */
    }

    public void editarVeiculo( carro carro ){
        carroRepositorio.save(carro);
    }

    public @ResponseBody
    void deletarVeiculo(long id){
        carroRepositorio.deleteById(id);
    }

    //Verificar se a placa está no formato correto (AAA0A000)
    public static boolean validaVeiculo(String placa) {
        try {
            String [] characterAndNumber = new String [7];
            int [] number = new int[3];
            char []  character = new char[4];

            //Metodo separa a String em caractere
            List<String> partes = new ArrayList<String>();
            for (int i = 0; i < 7; i++) {
                partes.add(placa.substring(i, Math.min(i + 1, placa.length())));
                characterAndNumber[i] = partes.get(i);
            }
            character[0] = placa.charAt(0);
            character[1] = placa.charAt(1);
            character[2] = placa.charAt(2);
            character[4] = placa.charAt(2);
            number [0] = Integer.parseInt(characterAndNumber[3]);
            number [1] = Integer.parseInt(characterAndNumber[5]);
            number [2] = Integer.parseInt(characterAndNumber[6]);
            return true;
        } catch (InputMismatchException erro) {
            return false;
        }

    }
}

