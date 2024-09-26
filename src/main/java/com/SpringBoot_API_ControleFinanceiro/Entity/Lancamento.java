package com.SpringBoot_API_ControleFinanceiro.Entity;

import com.SpringBoot_API_ControleFinanceiro.Enums.CategoriaEnum;
import com.SpringBoot_API_ControleFinanceiro.Enums.TipoLancamentoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private BigDecimal valor;

    //Enum Tipo de Lançamento
    @Enumerated(EnumType.STRING)
    private TipoLancamentoEnum tipo;

    //Enum Categoria de Lançamento
    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;

    //Relacionamento de Lançamento com grupo
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    public Lancamento(Long id, String nome, String descricao, Date data, BigDecimal valor, TipoLancamentoEnum tipo, CategoriaEnum categoria, Grupo grupo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
        this.grupo = grupo;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoLancamentoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamentoEnum tipo) {
        this.tipo = tipo;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
