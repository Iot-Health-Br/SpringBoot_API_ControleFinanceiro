package com.SpringBoot_API_ControleFinanceiro.Service;

import com.SpringBoot_API_ControleFinanceiro.Entity.Meta;
import com.SpringBoot_API_ControleFinanceiro.Repository.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaService {
    @Autowired
    private MetaRepository repository;

    public List<Meta> findAll() {
        return this.repository.findAll();
    }

    public Meta findById(Integer id) {
        return this.repository.findById(id).orElseThrow();
    }

    public Meta save(Meta meta) {

        return this.repository.save(meta);
    }

    public Meta update(Meta meta) {
        return this.repository.save(meta);
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }
}
