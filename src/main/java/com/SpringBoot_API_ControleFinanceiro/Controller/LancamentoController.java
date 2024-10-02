package com.SpringBoot_API_ControleFinanceiro.Controller;

import com.SpringBoot_API_ControleFinanceiro.Entity.Lancamento;
import com.SpringBoot_API_ControleFinanceiro.Exception.FaultOfAssociation;
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
    public ResponseEntity<String> save(@RequestBody Lancamento lancamento) {
        try {
            String saveLancamento = String.valueOf(service.save(lancamento));
            return ResponseEntity.ok(saveLancamento);
        } catch (FaultOfAssociation e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno ao atualizar o lançamento.");
        }
    }


    @PutMapping
    public ResponseEntity<String> update(@RequestBody Lancamento lancamento) {
        try {
            String updatedLancamento = String.valueOf(service.updateLancamento(lancamento));
            return ResponseEntity.ok(updatedLancamento);
        } catch (NotFoundBalance e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno ao atualizar o lançamento.");
        }
    }





    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id) {
        this.service.delete(id);
    }
}
