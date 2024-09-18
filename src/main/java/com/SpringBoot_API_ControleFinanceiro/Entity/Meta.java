package com.SpringBoot_API_ControleFinanceiro.Entity;

import jakarta.persistence.*;

@Entity
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String tipo="";
    @Column(nullable = false)
    private String valor="";
}
