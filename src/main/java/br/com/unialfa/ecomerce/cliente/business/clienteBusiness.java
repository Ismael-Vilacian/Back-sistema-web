package br.com.unialfa.ecomerce.cliente.business;

import br.com.unialfa.ecomerce.cliente.domain.cliente;
import br.com.unialfa.ecomerce.cliente.repositorio.clienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Optional;

import java.util.InputMismatchException;

@Service
public class clienteBusiness {

    @Autowired
    private clienteRepositorio clienteRepositorio;

    public Iterable<cliente> listarCliente()
    {
        return clienteRepositorio.findAll();
    }

    public Optional<cliente> clientePorId(long id)
    {
        return clienteRepositorio.findById(id);
    }

    public void cadastrarCliente( cliente cliente ) {
        if (validaCpf(cliente.getCpf())) {
            clienteRepositorio.save(cliente);
        } else{
            System.err.println("CPF invalido");
            //throw new Exception(Exception e);
        }
    }

    public void editarCliente( cliente cliente ){

        clienteRepositorio.save(cliente);
    }

    public @ResponseBody
    void deletarCliente( long id){
        clienteRepositorio.deleteById(id);
    }

    public static boolean validaCpf(String CPF){
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);

        char digit10, digit11;
        int sm, r, num, peso;

        try {

            sm = 0;
            peso = 10;
            for (int i=0; i<9; i++) {

                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                digit10 = '0';
            else digit10 = (char)(r + 48);

            sm = 0;
            peso = 11;
            for(int i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                digit11 = '0';
            else digit11 = (char)(r + 48);

            if ((digit10 == CPF.charAt(9)) && (digit11 == CPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }
}