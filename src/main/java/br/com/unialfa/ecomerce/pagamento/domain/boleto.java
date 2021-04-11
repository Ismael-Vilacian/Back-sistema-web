package br.com.unialfa.ecomerce.pagamento.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String codigoBarras;
    private LocalDate vencimento;

    @OneToOne
    private pagamento pagamento;

    public boleto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public br.com.unialfa.ecomerce.pagamento.domain.pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(br.com.unialfa.ecomerce.pagamento.domain.pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
