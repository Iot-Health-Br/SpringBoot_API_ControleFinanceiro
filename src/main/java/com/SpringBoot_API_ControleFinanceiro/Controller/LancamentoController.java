package com.SpringBoot_API_ControleFinanceiro.Controller;

import com.SpringBoot_API_ControleFinanceiro.Entity.Lancamento;
import com.SpringBoot_API_ControleFinanceiro.Exception.NotFoundBalance;
import com.SpringBoot_API_ControleFinanceiro.Service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lancamento")
public class LancamentoController {
    @Autowired
    private LancamentoService service;

    @GetMapping
    public List<Lancamento> finAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Lancamento findById(@PathVariable Integer id) {
        return this.service.findById(id);
    }

    @PostMapping
    public Lancamento save(@RequestBody Lancamento lancamento) {
        return this.service.save(lancamento);
    }

    @PutMapping
    public Lancamento update(@RequestBody Lancamento lancamento) {return this.service.update(lancamento);}

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id) {
        this.service.delete(id);
    }
}
