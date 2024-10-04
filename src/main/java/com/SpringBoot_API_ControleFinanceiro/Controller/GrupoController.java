package com.SpringBoot_API_ControleFinanceiro.Controller;

import com.SpringBoot_API_ControleFinanceiro.Entity.Grupo;
import com.SpringBoot_API_ControleFinanceiro.Exception.GroupWasRegistred;
import com.SpringBoot_API_ControleFinanceiro.Service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/grupo")
@CrossOrigin(origins = "http://localhost:4200") // Permitir o CORS para o Angular
public class GrupoController {
    @Autowired
    private GrupoService grupoService;

    @GetMapping
    public List<Grupo> finAll() {
        return grupoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Grupo findById(@PathVariable Integer id) {
        return this.grupoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Grupo grupo) {
        try {
            String saveGrupo = grupoService.save(grupo);
            return ResponseEntity.ok(saveGrupo);
        } catch (GroupWasRegistred e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno ao salvar o grupo.");
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Grupo grupo) {
        try {
            String updateGrupo = grupoService.update(grupo);
            return ResponseEntity.ok(updateGrupo);
        } catch (GroupWasRegistred e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno ao fazer o update do grupo.");
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id) {
        this.grupoService.delete(id);
    }
}
