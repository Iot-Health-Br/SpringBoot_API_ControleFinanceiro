package com.SpringBoot_API_ControleFinanceiro.Repository;

import com.SpringBoot_API_ControleFinanceiro.Entity.Meta;
import com.SpringBoot_API_ControleFinanceiro.Entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Integer> {
}