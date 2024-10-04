package com.SpringBoot_API_ControleFinanceiro.Repository;

import com.SpringBoot_API_ControleFinanceiro.Entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
    Optional<Grupo> findById(Long id);
}