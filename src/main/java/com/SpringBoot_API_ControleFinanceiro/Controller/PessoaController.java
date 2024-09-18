package com.SpringBoot_API_ControleFinanceiro.Controller;

import com.SpringBoot_API_ControleFinanceiro.Entity.Pessoa;
import com.SpringBoot_API_ControleFinanceiro.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public List<Pessoa> finAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Pessoa findById(@PathVariable Integer id) {
        return this.service.findById(id);
    }

    @PostMapping
    public Pessoa save(@RequestBody Pessoa pessoa) {
        return this.service.save(pessoa);
    }

    @PutMapping
    public Pessoa update(@RequestBody Pessoa pessoa) {
        return this.service.update(pessoa);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id) {
        this.service.delete(id);
    }
}
