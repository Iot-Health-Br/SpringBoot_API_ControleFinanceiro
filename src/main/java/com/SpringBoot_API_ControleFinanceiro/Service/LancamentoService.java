package com.SpringBoot_API_ControleFinanceiro.Service;

import com.SpringBoot_API_ControleFinanceiro.Entity.Grupo;
import com.SpringBoot_API_ControleFinanceiro.Entity.Lancamento;
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

    public Lancamento save(Lancamento lancamento) {return this.lancamentoRepository.save(lancamento);}

    public String update(Lancamento lancamento) throws NotFoundBalance {
        // Busca o grupo relacionado ao lançamento
        Grupo grupo = lancamento.getGrupo();

        if (grupo == null) {
            throw new NotFoundBalance("Grupo não encontrado para o lançamento.");
        }

        // Verifica se o saldo do grupo é maior que o valor do lançamento
        BigDecimal saldoGrupo = grupo.getSaldo();
        BigDecimal valorLancamento = new BigDecimal(String.valueOf(lancamento.getValor()));

        if (saldoGrupo.compareTo(valorLancamento) >= 0) {
            // Se o saldo for suficiente, realiza o update
            lancamentoRepository.save(lancamento);
            return "Lançamento atualizado com sucesso!";
        } else {
            // Se o saldo for insuficiente, retorna mensagem de erro
            throw new NotFoundBalance("Saldo do grupo insuficiente para o lançamento.");
        }
    }

    public Lancamento updateLancamento(Lancamento lancamento) throws NotFoundBalance {
        Grupo grupo = grupoRepository.findById(lancamento.getGrupo().getId())
                .orElseThrow(() -> new NotFoundBalance("Grupo não encontrado"));

        if (grupo.getSaldo().compareTo(lancamento.getValor()) >= 0) {
            return this.lancamentoRepository.save(lancamento);
        } else {
            throw new NotFoundBalance("Saldo insuficiente no grupo para realizar o lançamento");
        }
    }

    public void delete(Integer id) {
        this.lancamentoRepository.deleteById(id);
    }
}
