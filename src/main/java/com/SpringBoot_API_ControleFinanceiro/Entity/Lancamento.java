package com.SpringBoot_API_ControleFinanceiro.Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome="";
    @Column(nullable = false)
    private String descricao="";
    @Column(nullable = false)
    private Date data;
    @Column(nullable = false)
    private String tipo="";
    @Column(nullable = false)
    private String valor="";
    @Column(nullable = false)
    private String categoria="";

    public Lancamento(Long id, String nome, String descricao, Date data, String tipo, String valor, String categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.tipo = tipo;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Lancamento() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "LancamentoModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", tipo='" + tipo + '\'' +
                ", valor='" + valor + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
