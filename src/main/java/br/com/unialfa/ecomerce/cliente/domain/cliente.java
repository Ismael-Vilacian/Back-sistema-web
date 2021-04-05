package br.com.unialfa.ecomerce.cliente.domain;

import br.com.unialfa.ecomerce.locacao.domain.locacao;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;
    private String nome;
    @Column(unique = true)
    private String cpf;
    private char sexo;
    private LocalDate dataNascimento;
    private int versao;

    @OneToMany
    private List<locacao> locacao;

    public cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }

    public List<br.com.unialfa.ecomerce.locacao.domain.locacao> getLocacao() {
        return locacao;
    }

    public void setLocacao(List<br.com.unialfa.ecomerce.locacao.domain.locacao> locacao) {
        this.locacao = locacao;
    }
}
