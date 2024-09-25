package com.SpringBoot_API_ControleFinanceiro.Service;

import com.SpringBoot_API_ControleFinanceiro.Entity.Lancamento;
import com.SpringBoot_API_ControleFinanceiro.Exception.NotFoundBalance;
import com.SpringBoot_API_ControleFinanceiro.Repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository repository;

    public List<Lancamento> findAll() {
        return this.repository.findAll();
    }

    public Lancamento findById(Integer id) {
        return this.repository.findById(id).orElseThrow();
    }

    public Lancamento save(Lancamento lancamento) {return this.repository.save(lancamento);}

    public Lancamento update(Lancamento lancamento) {return this.repository.save(lancamento);}

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }
}
