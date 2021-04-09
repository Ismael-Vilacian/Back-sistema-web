package br.com.unialfa.ecomerce.locacao.domain;
import br.com.unialfa.ecomerce.carro.domain.carro;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class pedidoLocacao implements Serializable {

    @EmbeddedId
    private pedidoLocacaoId id;

    @Column(nullable = false)
    private int quantidade;

    public pedidoLocacao() {
    }

    public pedidoLocacao(locacao locacao, carro veiculo, int quantidade) {
        this.id = new pedidoLocacaoId();
        this.quantidade = quantidade;
        id.setLocacao(locacao);
        id.setVeiculo(veiculo);
    }

    public pedidoLocacaoId getId() {
        return id;
    }

    public void setId(pedidoLocacaoId id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pedidoLocacao that = (pedidoLocacao) o;
        return quantidade == that.quantidade && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantidade);
    }
}

