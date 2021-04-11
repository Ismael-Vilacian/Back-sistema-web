package br.com.unialfa.ecomerce.pagamento.domain;

import br.com.unialfa.ecomerce.pagamento.domain.cartao;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class pagamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPagamento;

    @ManyToOne
    private br.com.unialfa.ecomerce.pagamento.domain.cartao cartao;

    @OneToOne
    private boleto boleto;

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public br.com.unialfa.ecomerce.pagamento.domain.cartao getCartao() {
        return cartao;
    }

    public void setCartao(br.com.unialfa.ecomerce.pagamento.domain.cartao cartao) {
        this.cartao = cartao;
    }
}
