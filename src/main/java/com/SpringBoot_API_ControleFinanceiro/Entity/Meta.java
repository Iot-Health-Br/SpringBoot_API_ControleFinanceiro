package com.SpringBoot_API_ControleFinanceiro.Entity;

import com.SpringBoot_API_ControleFinanceiro.Enums.CategoriaEnum;
import com.SpringBoot_API_ControleFinanceiro.Enums.TipoLancamentoEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String meta="";

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private String descricao="";

    @Enumerated(EnumType.STRING)
    private TipoLancamentoEnum tipo;

    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;

    public Meta(Long id, String meta, BigDecimal valor, String descricao, TipoLancamentoEnum tipo, CategoriaEnum categoria) {
        this.id = id;
        this.meta = meta;
        this.valor = valor;
        this.descricao = descricao;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public Meta() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
}
