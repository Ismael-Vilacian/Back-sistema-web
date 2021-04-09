package br.com.unialfa.ecomerce.locacao.domain;

import br.com.unialfa.ecomerce.carro.domain.carro;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class pedidoLocacaoId implements Serializable {

    @ManyToOne
    @JoinColumn(name="pedido_id")
    private locacao locacao;

    @ManyToOne
    @JoinColumn(name= "carro_id")
    private carro veiculo;

    public pedidoLocacaoId() {
    }

    public br.com.unialfa.ecomerce.locacao.domain.locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(br.com.unialfa.ecomerce.locacao.domain.locacao locacao) {
        this.locacao = locacao;
    }

    public carro getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(carro veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pedidoLocacaoId that = (pedidoLocacaoId) o;
        return Objects.equals(locacao, that.locacao) && Objects.equals(veiculo, that.veiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locacao, veiculo);
    }
}