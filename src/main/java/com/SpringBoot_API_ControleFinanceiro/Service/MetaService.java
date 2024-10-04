package com.SpringBoot_API_ControleFinanceiro.Service;

import com.SpringBoot_API_ControleFinanceiro.Entity.Meta;
import com.SpringBoot_API_ControleFinanceiro.Exception.GoalsWasRegistred;
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

    public String save(Meta meta) throws GoalsWasRegistred {
        repository.save(meta);
        return "Meta salva com sucesso!";
    }

    public String update(Meta meta)throws GoalsWasRegistred {
        repository.save(meta);
        return "Meta alterada com sucesso!";
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }
}
