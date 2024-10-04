package com.SpringBoot_API_ControleFinanceiro.Service;

import com.SpringBoot_API_ControleFinanceiro.Entity.Grupo;
import com.SpringBoot_API_ControleFinanceiro.Entity.Lancamento;
import com.SpringBoot_API_ControleFinanceiro.Exception.FaultOfAssociation;
import com.SpringBoot_API_ControleFinanceiro.Exception.NotFoundBalance;
import com.SpringBoot_API_ControleFinanceiro.Repository.GrupoRepository;
import com.SpringBoot_API_ControleFinanceiro.Repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    public List<Lancamento> findAll() {
        return this.lancamentoRepository.findAll();
    }

    public Lancamento findById(Integer id) {
        return this.lancamentoRepository.findById(id).orElseThrow();
    }

    public String save(Lancamento lancamento) throws FaultOfAssociation {
        Grupo grupo = grupoRepository.findById(lancamento.getGrupo().getId())
                .orElseThrow(() -> new FaultOfAssociation("Grupo não encontrado"));

        if (grupo.getSaldo().compareTo(lancamento.getValor()) >= 0) {
            lancamentoRepository.save(lancamento);
            BigDecimal novoSaldo = grupo.getSaldo().subtract(lancamento.getValor());
            grupo.setSaldo(novoSaldo);
            // Atualiza o grupo
            grupoRepository.save(grupo);
            return "Lançamento salvo com sucesso!";
        } else {
            BigDecimal novoSaldo = grupo.getSaldo().subtract(lancamento.getValor());
            grupo.setSaldo(novoSaldo);
            // Atualiza o grupo
            grupoRepository.save(grupo);
            lancamentoRepository.save(lancamento);
            return "Saldo insuficiente no grupo, o saldo encontra-se negativo após está transação!";
        }
    }

    public String updateLancamento(Lancamento lancamento) throws NotFoundBalance {
        Grupo grupo = grupoRepository.findById(lancamento.getGrupo().getId())
                .orElseThrow(() -> new NotFoundBalance("Grupo não encontrado"));

        if (grupo.getSaldo().compareTo(lancamento.getValor()) >= 0) {
            lancamentoRepository.save(lancamento);
            BigDecimal novoSaldo = grupo.getSaldo().subtract(lancamento.getValor());
            grupo.setSaldo(novoSaldo);
            // Atualiza o grupo
            grupoRepository.save(grupo);
            return "Feito o update da dispesa com sucesso!";
        } else {
            BigDecimal novoSaldo = grupo.getSaldo().subtract(lancamento.getValor());
            grupo.setSaldo(novoSaldo);
            // Atualiza o grupo
            grupoRepository.save(grupo);
            lancamentoRepository.save(lancamento);
            return "Saldo insuficiente no grupo, o saldo encontra-se negativo após está transação!";
        }
    }

    public void delete(Integer id) {
        this.lancamentoRepository.deleteById(id);
    }
}
