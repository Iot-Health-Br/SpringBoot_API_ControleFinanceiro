package com.SpringBoot_API_ControleFinanceiro.Controller;

import com.SpringBoot_API_ControleFinanceiro.Entity.Pessoa;
import com.SpringBoot_API_ControleFinanceiro.Exception.UserWasRegistred;
import com.SpringBoot_API_ControleFinanceiro.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pessoas")
@CrossOrigin(origins = "http://localhost:4200") // Permitir o CORS para o Angular
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
    public ResponseEntity<String> save(@RequestBody Pessoa pessoa) {
        try {
            // Captura a mensagem de retorno do serviço
            String resultado = String.valueOf(service.save(pessoa));
            return ResponseEntity.ok(resultado);
        } catch (UserWasRegistred e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno ao salvar a pessoa.");
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Pessoa pessoa) {
        try {
            String resultado = String.valueOf(service.update(pessoa));
            return ResponseEntity.ok(resultado);
        } catch (UserWasRegistred e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar a pessoa.");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno ao atualizar a pessoa.");
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id) {
        this.service.delete(id);
    }
}
