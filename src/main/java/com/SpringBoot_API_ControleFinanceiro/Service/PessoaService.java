package com.SpringBoot_API_ControleFinanceiro.Service;

import com.SpringBoot_API_ControleFinanceiro.Entity.Pessoa;
import com.SpringBoot_API_ControleFinanceiro.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> findAll() {
        return this.repository.findAll();
    }

    public Pessoa findById(Integer id) {
        return this.repository.findById(id).orElseThrow();
    }

    public Pessoa save(Pessoa pessoa) {

        return this.repository.save(pessoa);
    }

    public Pessoa update(Pessoa pessoa) {
        return this.repository.save(pessoa);
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }
}
