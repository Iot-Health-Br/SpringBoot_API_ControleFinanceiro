package com.SpringBoot_API_ControleFinanceiro.Repository;

import com.SpringBoot_API_ControleFinanceiro.Entity.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {
}
