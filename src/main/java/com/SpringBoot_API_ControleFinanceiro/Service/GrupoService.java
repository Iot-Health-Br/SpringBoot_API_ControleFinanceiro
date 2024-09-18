package com.SpringBoot_API_ControleFinanceiro.Service;

import com.SpringBoot_API_ControleFinanceiro.Entity.Grupo;
import com.SpringBoot_API_ControleFinanceiro.Repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {
    @Autowired
    private GrupoRepository grupoRepository;

    public List<Grupo> findAll() {
        return this.grupoRepository.findAll();
    }

    public Grupo findById(Integer id) {
        return this.grupoRepository.findById(id).orElseThrow();
    }

    public Grupo save(Grupo grupo) {

        return this.grupoRepository.save(grupo);
    }

    public Grupo update(Grupo grupo) {
        return this.grupoRepository.save(grupo);
    }

    public void delete(Integer id) {
        this.grupoRepository.deleteById(id);
    }
}
