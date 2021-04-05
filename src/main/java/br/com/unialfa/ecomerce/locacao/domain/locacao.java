package br.com.unialfa.ecomerce.locacao.domain;

import br.com.unialfa.ecomerce.cliente.domain.cliente;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class locacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate dataPedido;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;

    @Column(nullable = false)
    private BigDecimal valorAluguel;

    @ManyToOne
    private cliente clienteVar;

    public locacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(BigDecimal valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public cliente getClienteVar() {
        return clienteVar;
    }

    public void setClienteVar(cliente clienteVar) {
        this.clienteVar = clienteVar;
    }
}
