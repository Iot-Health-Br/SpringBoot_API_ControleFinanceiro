package com.SpringBoot_API_ControleFinanceiro.Repository;

import com.SpringBoot_API_ControleFinanceiro.Entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByNome(String nome);
}