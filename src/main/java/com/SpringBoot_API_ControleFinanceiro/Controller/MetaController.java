package com.SpringBoot_API_ControleFinanceiro.Controller;

import com.SpringBoot_API_ControleFinanceiro.Entity.Meta;
import com.SpringBoot_API_ControleFinanceiro.Exception.GoalsWasRegistred;
import com.SpringBoot_API_ControleFinanceiro.Service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/meta")
@CrossOrigin(origins = "http://localhost:4200")
public class MetaController {
    @Autowired
    private MetaService metaService;

    @GetMapping
    public List<Meta> finAll() {
        return metaService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Meta findById(@PathVariable Integer id) {
        return this.metaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Meta meta) {
        try {
            String saveMeta = String.valueOf(metaService.save(meta));
            return ResponseEntity.ok(saveMeta);
        } catch (GoalsWasRegistred e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno ao salvar a meta.");
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Meta meta) {
        try{
            String updateMeta = String.valueOf(metaService.update(meta));
            return ResponseEntity.ok(updateMeta);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno ao atualizar a meta.");
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id) {
        this.metaService.delete(id);
    }
}
