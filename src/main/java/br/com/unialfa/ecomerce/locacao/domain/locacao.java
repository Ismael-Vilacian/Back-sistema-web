package br.com.unialfa.ecomerce.locacao.domain;

import br.com.unialfa.ecomerce.cliente.domain.cliente;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class locacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate dataPedido;
    private double valorTotal;

    @Column(nullable = false)
    private double valorAluguel;


    @ManyToOne
    private cliente cliente;

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

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }
}
