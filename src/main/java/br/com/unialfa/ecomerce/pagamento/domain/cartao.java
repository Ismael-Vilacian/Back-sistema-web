package br.com.unialfa.ecomerce.pagamento.domain;

import br.com.unialfa.ecomerce.pagamento.domain.pagamento;

import javax.persistence.*;
import java.util.List;

@Entity
public class cartao {
    private int numeroCartão;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToMany
    private List<pagamento> pagamento;

    public cartao() {
    }


    public int getNumeroCartão() {
        return numeroCartão;
    }

    public void setNumeroCartão(int numeroCartão) {
        this.numeroCartão = numeroCartão;
    }

    public List<br.com.unialfa.ecomerce.pagamento.domain.pagamento> getPagamento() {
        return pagamento;
    }

    public void setPagamento(List<br.com.unialfa.ecomerce.pagamento.domain.pagamento> pagamento) {
        this.pagamento = pagamento;
    }
}
