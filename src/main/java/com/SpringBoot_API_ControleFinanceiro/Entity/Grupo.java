package com.SpringBoot_API_ControleFinanceiro.Entity;

import jakarta.persistence.*;

@Entity
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(nullable = false)
    private String nome="";
    @Column(nullable = false)
    private String descricao="";
    @Column(nullable = false)
    private String saldo="";

    public Grupo(Long id, String nome, String descricao, String saldo) {
        Id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.saldo = saldo;
    }

    public Grupo() {

    }

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "Id=" + Id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", saldo='" + saldo + '\'' +
                '}';
    }
}
